/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null || root.val==p.val || root.val==q.val ){
            return root;
        }
        TreeNode lefttree=lowestCommonAncestor(root.left,p,q);
        TreeNode righttree=lowestCommonAncestor(root.right,p,q);
        if(righttree==null){
            return lefttree;
        }
        if(lefttree==null){
            return righttree;
        }
        return root;
    }
}