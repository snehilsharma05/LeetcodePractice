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
    class Result{
        int res = 0;
    }
    public int diameterOfBinaryTree(TreeNode root) {
        Result res = new Result();
        diaHelper(root,res);
        return res.res;
    }
    
    private int diaHelper(TreeNode root,Result res){
        if(root == null){
            return 0;
        }
        
        int leftHeight = diaHelper(root.left,res);
        int rightHeight = diaHelper(root.right,res);
        
        res.res = Math.max(res.res,leftHeight+rightHeight);
        
        return Math.max(leftHeight,rightHeight)+1;
    }
}