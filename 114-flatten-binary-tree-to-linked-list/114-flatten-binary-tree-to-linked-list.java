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
    private class Prev{
        TreeNode prev = null;
    }
    public void flatten(TreeNode root) {
        if(root == null){
            return;
        }
        
        Prev prev = new Prev();
        flattenHelper(root,prev);
    }
    
    private void flattenHelper(TreeNode root, Prev prev){
        if(root == null){
            return;
        }
        
        flattenHelper(root.right,prev);
        flattenHelper(root.left,prev);
        
        root.right = prev.prev;
        root.left = null;
        prev.prev = root;
    }
        
}