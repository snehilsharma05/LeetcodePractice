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
    
    enum State{I_NEED_CAMERA, I_AM_CAMERA, I_AM_COVERED};
    
    private static class Result{
        int cameras = 0;
    }
    public int minCameraCover(TreeNode root) {
        if(root == null){
            return 0;
        }
        
        Result res = new Result();
        
        State state = getState(root,res);
        if(state == State.I_NEED_CAMERA){ //edge case for root, if we received that I need camera, means root needs camera,
            res.cameras++;                // we need to increment count
        }
        return res.cameras;
    }
    
    private State getState(TreeNode root,Result res){
        if(root == null){
            return State.I_AM_COVERED;
        }
        
        State leftChild = getState(root.left,res);
        State rightChild = getState(root.right,res);
        
        if(leftChild == State.I_NEED_CAMERA || rightChild == State.I_NEED_CAMERA){
            res.cameras++;
            return State.I_AM_CAMERA;
        }
        
        if(leftChild == State.I_AM_CAMERA || rightChild == State.I_AM_CAMERA){
            return State.I_AM_COVERED;
        }
        
        return State.I_NEED_CAMERA;
    }
}