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
    
    public int goodNodes(TreeNode root) {
        return countNodes(root,(int)-1e9);
    }
    
    private int countNodes(TreeNode root, int maxSoFar){
        if(root == null){
            return 0;
        }
        
        int count = 0;
        if(root.val>=maxSoFar){
            count++;
        }
        
        return count + countNodes(root.left,Math.max(maxSoFar,root.val)) + countNodes(root.right,Math.max(maxSoFar,root.val));
    }
}