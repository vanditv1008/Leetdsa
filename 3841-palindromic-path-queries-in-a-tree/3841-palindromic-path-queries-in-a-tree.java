import java.util.*;

class Solution {
    int LOG;
    int timer;
    int[] tin, tout, depth;
    int[][] up;
    List<Integer>[] graph;
    Fenwick bit;

    public List<Boolean> palindromePath(
            int n, int[][] edges, String s, String[] queries) {

        LOG = 1;
        while ((1 << LOG) <= n) {
            LOG++;
        }

        graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] e : edges) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }

        tin = new int[n];
        tout = new int[n];
        depth = new int[n];
        up = new int[LOG][n];

        // Iterative DFS
        int[] nodeStack = new int[n];
        int[] parentStack = new int[n];
        int[] nextEdge = new int[n];

        int top = 0;
        nodeStack[0] = 0;
        parentStack[0] = -1;

        timer = 0;
        tin[0] = ++timer;

        while (top >= 0) {
            int u = nodeStack[top];

            if (nextEdge[top] < graph[u].size()) {
                int v = graph[u].get(nextEdge[top]++);

                if (v == parentStack[top]) {
                    continue;
                }

                depth[v] = depth[u] + 1;
                up[0][v] = u;

                for (int j = 1; j < LOG; j++) {
                    up[j][v] = up[j - 1][up[j - 1][v]];
                }

                nodeStack[++top] = v;
                parentStack[top] = u;
                nextEdge[top] = 0;
                tin[v] = ++timer;
            } else {
                tout[u] = timer;
                top--;
            }
        }

        bit = new Fenwick(n + 1);
        char[] chars = s.toCharArray();

        // Initialize character masks
        for (int u = 0; u < n; u++) {
            int mask = 1 << (chars[u] - 'a');

            bit.update(tin[u], mask);
            bit.update(tout[u] + 1, mask);
        }

        List<Boolean> result = new ArrayList<>();

        for (String query : queries) {
            String[] p = query.split(" ");

            if (p[0].equals("update")) {
                int u = Integer.parseInt(p[1]);
                char c = p[2].charAt(0);

                if (chars[u] != c) {
                    int oldMask = 1 << (chars[u] - 'a');
                    int newMask = 1 << (c - 'a');
                    int change = oldMask ^ newMask;

                    bit.update(tin[u], change);
                    bit.update(tout[u] + 1, change);

                    chars[u] = c;
                }
            } else {
                int u = Integer.parseInt(p[1]);
                int v = Integer.parseInt(p[2]);

                int lca = getLCA(u, v);

                int mask = bit.query(tin[u])
                         ^ bit.query(tin[v])
                         ^ (1 << (chars[lca] - 'a'));

                result.add((mask & (mask - 1)) == 0);
            }
        }

        return result;
    }

    int getLCA(int u, int v) {
        if (depth[u] < depth[v]) {
            int temp = u;
            u = v;
            v = temp;
        }

        int diff = depth[u] - depth[v];

        for (int j = 0; j < LOG; j++) {
            if ((diff & (1 << j)) != 0) {
                u = up[j][u];
            }
        }

        if (u == v) {
            return u;
        }

        for (int j = LOG - 1; j >= 0; j--) {
            if (up[j][u] != up[j][v]) {
                u = up[j][u];
                v = up[j][v];
            }
        }

        return up[0][u];
    }

    static class Fenwick {
        int[] tree;
        int n;

        Fenwick(int n) {
            this.n = n;
            tree = new int[n + 1];
        }

        void update(int i, int value) {
            while (i <= n) {
                tree[i] ^= value;
                i += i & -i;
            }
        }

        int query(int i) {
            int result = 0;

            while (i > 0) {
                result ^= tree[i];
                i -= i & -i;
            }

            return result;
        }
    }
}