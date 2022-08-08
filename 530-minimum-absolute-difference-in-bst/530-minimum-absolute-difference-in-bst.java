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
    public int getMinimumDifference(TreeNode root) {
        if(root == null){
            return -1;
        }
        
        int min = Integer.MAX_VALUE;
        List<Integer> in = new ArrayList<>();
        inorder(root,in);
        
        for(int i=1;i<in.size();i++){
            min = Math.min(min,in.get(i) - in.get(i-1));
        }
        return min;
    }
    
    private void inorder(TreeNode root,List<Integer> in){
        if(root == null){
            return;
        }
        
        inorder(root.left,in);
        in.add(root.val);
        inorder(root.right,in);
    }
}