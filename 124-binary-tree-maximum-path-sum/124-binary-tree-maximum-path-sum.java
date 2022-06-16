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
    private class Result{
        int res = Integer.MIN_VALUE;
    }
    public int maxPathSum(TreeNode root) {
        Result res = new Result();
        
        maxPathSum(root,res);
        return res.res;
    }
    
    private int maxPathSum(TreeNode root,Result res){
        if(root == null){
            return 0;
        }
        
        int lSum = maxPathSum(root.left,res);
        int rSum = maxPathSum(root.right,res);
        
        int maxStraight = Math.max(root.val,root.val + Math.max(lSum,rSum));
        res.res = Math.max(res.res,Math.max(lSum+rSum+root.val,maxStraight));
        
        return maxStraight;
    }
}