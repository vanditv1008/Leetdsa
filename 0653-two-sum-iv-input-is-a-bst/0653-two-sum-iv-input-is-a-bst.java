/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public static boolean makepairs(TreeNode root1,TreeNode root2,int k){
        if(root1==null){
            return false;
        }
        int required=k-root1.val;
        int found=search(root2,required,root1);
        if(found!=-1){
            return true;
        }
        if(makepairs(root1.left,root2,k)){
            return true;
        }
        if(makepairs(root1.right,root2,k)){
        return true;
        }
        return false;
    }
    public static int search(TreeNode root2,int required,TreeNode current){
        if(root2==null){
            return -1;
        }
        if(root2==current){
            int left = search(root2.left, required, current);
            if(left != -1){
                return left;
            }
            return search(root2.right, required, current);
        }
        if(root2.val==required){
            return root2.val;
        }else if(root2.val>required){
            return search(root2.left,required,current);
        }else{
            return search(root2.right,required,current);
        }
    }
    public boolean findTarget(TreeNode root, int k) {
        return makepairs(root,root,k);
    }
}