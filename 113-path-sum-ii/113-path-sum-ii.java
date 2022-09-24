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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }
        storePaths(root,targetSum,new ArrayList<Integer>(),ans);
        return ans;
    }
    private void storePaths(TreeNode root,int targetSum,List<Integer> psf, List<List<Integer>> ans){
        if(root==null)
            return;
        
        psf.add(root.val);
        if(targetSum-root.val==0 && root.left==null && root.right==null){
            ans.add(new ArrayList<>(psf));
        }
        storePaths(root.left,targetSum - root.val,psf,ans);
        storePaths(root.right,targetSum - root.val,psf,ans);
        psf.remove(psf.size()-1);
    }
}