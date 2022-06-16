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
        int res = 0;
    }
    public int diameterOfBinaryTree(TreeNode root) {
        Result res = new Result();
        height(root,res);
        return res.res;
    }
    private int height(TreeNode root,Result res){
        if(root == null){
            return 0;
        }
        
        int lh = height(root.left,res);
        int rh = height(root.right,res);
        res.res = Math.max(res.res,lh+rh);
        return 1 + Math.max(lh,rh);
    }
}