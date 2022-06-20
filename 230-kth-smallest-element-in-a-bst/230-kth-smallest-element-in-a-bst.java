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
        int count = 0;
        int small = -1;
    }
    public int kthSmallest(TreeNode root, int k) {
        Result res = new Result();
        storeInorder(root,res,k);
        return res.small;
    }
    private void storeInorder(TreeNode root,Result res,int k){
        if(root == null){
            return;
        }
        
        storeInorder(root.left,res,k);
        
        res.count++;
        if(res.count == k){
            res.small = root.val;
            return;
        }
        
        storeInorder(root.right,res,k);
    }
}