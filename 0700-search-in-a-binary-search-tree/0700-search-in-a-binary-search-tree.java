class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        TreeNode curr = root;
        
        while (curr != null && curr.val != val) {
            if (val < curr.val) {
                curr = curr.left;  // Target is smaller -> go left
            } else {
                curr = curr.right; // Target is larger -> go right
            }
        }
        
        return curr;
    }
}