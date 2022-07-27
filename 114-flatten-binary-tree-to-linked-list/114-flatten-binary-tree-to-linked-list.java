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
    private TreeNode prev = null;
    public void flatten(TreeNode root) {
        flattenHelper(root);
    }
    private void flattenHelper(TreeNode root){
        if(root == null){
            return;
        }
        
        flattenHelper(root.right);
        flattenHelper(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }
}