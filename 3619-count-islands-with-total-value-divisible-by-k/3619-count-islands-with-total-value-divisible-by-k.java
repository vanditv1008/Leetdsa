class Solution {
    public int countIslands(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] > 0) {
                    // Find the total value of the current island
                    long islandSum = dfs(grid, i, j);
                    
                    // Check if the total value is divisible by k
                    if (islandSum % k == 0) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    private long dfs(int[][] grid, int r, int c) {
        int m = grid.length;
        int n = grid[0].length;

        // Boundary check and water/visited check
        if (r < 0 || r >= m || c < 0 || c >= n || grid[r][c] == 0) {
            return 0;
        }

        long sum = grid[r][c];
        // Mark the current cell as visited by setting it to 0
        grid[r][c] = 0;

        // Traverse all 4 directions (Up, Down, Left, Right)
        sum += dfs(grid, r + 1, c);
        sum += dfs(grid, r - 1, c);
        sum += dfs(grid, r, c + 1);
        sum += dfs(grid, r, c - 1);

        return sum;
    }
}