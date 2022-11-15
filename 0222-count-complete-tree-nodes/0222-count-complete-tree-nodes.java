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
    private class Count{
        int count = 0;
    }
    public int countNodes(TreeNode root) {
        Count count = new Count();
        store(root,count);
        return count.count;
    }
    
    private void store(TreeNode root, Count count){
        if(root == null){
            return;
        }
        
        count.count++;
        store(root.left,count);
        store(root.right,count);
    }
}