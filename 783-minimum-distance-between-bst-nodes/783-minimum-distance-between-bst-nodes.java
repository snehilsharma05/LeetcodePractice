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
     private class Ans{
        TreeNode prev = null;
        int min = Integer.MAX_VALUE;
    }
    public int minDiffInBST(TreeNode root) {
        Ans ans = new Ans();
        findMinDiff(root,ans);
        return ans.min;
    }
    
    private void findMinDiff(TreeNode root,Ans ans){
        if(root == null){
            return;
        }
        
        findMinDiff(root.left,ans);
        
        if(ans.prev != null){
            ans.min = Math.min(ans.min,root.val - ans.prev.val);
        }
        ans.prev = root;
        
        findMinDiff(root.right,ans);
    }
}