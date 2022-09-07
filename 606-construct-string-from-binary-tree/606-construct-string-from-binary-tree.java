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
    public String tree2str(TreeNode root) {
        StringBuilder ans = new StringBuilder();
        tree2str(root,ans);
        return ans.toString();
    }
    
    private void tree2str(TreeNode root, StringBuilder ans){
        ans.append(root.val);
        if(root.left == null && root.right == null){
            return;
        }
        
        if(root.left != null){
            ans.append("(");
            tree2str(root.left,ans);
            ans.append(")");
        }
        
        if(root.right != null){
            if(root.left == null){
               ans.append("()"); 
            }
            ans.append("(");
            tree2str(root.right,ans);
            ans.append(")");
        }
    }
}