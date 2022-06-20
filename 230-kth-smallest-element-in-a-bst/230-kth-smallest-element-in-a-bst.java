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
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> in = new ArrayList<>();
        storeInorder(root,in);
        return in.get(k-1);
    }
    private void storeInorder(TreeNode root,List<Integer> in){
        if(root == null){
            return;
        }
        
        storeInorder(root.left,in);
        in.add(root.val);
        storeInorder(root.right,in);
    }
}