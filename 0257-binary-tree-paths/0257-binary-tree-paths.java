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
    public List<String> binaryTreePaths(TreeNode root) {
       List<String> ans = new ArrayList<>();
        List<String> path = new ArrayList<>();

        solve(root, ans,path);

        return ans;

    }
    public static void solve(TreeNode root,List<String> ans,List<String> path){
        if(root==null)return;
        path.add(String.valueOf(root.val));
        if(root.left==null && root.right==null){
            ans.add(String.join("->",path));
        }
        solve(root.left,ans,path);
        solve(root.right,ans,path);
        path.remove(path.size()-1);
        
    } 
}