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
    public static TreeNode creation(int[] nums,int st,int end){
        if(st>end){
            return null;
        }
        int mid=st+(end-st)/2;
        TreeNode root=new TreeNode(nums[mid]);
        root.left=creation(nums,st,mid-1);
        root.right=creation(nums,mid+1,end);
        return root;
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root=creation(nums,0,nums.length-1);
        return root;
    }
}