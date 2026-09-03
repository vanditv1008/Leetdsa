class Solution {
    static class Info {
        int diam;
        int ht;
        public Info(int diam, int ht) {
            this.diam = diam;
            this.ht = ht;
        }
    }

    public int diameterOfBinaryTree(TreeNode root) {
        return diam(root).diam; // Fixed field name access
    }

    // Added (TreeNode root) to the method signature
    public static Info diam(TreeNode root) {
        if (root == null) {
            return new Info(0, 0);
        }

        Info ldiam = diam(root.left);
        Info rdiam = diam(root.right);

        // Uses ldiam.ht + rdiam.ht to count edges instead of nodes
        int maxdiam = Math.max(ldiam.diam, Math.max(rdiam.diam, ldiam.ht + rdiam.ht));
        int ht = Math.max(ldiam.ht, rdiam.ht) + 1;

        return new Info(maxdiam, ht);
    }
}