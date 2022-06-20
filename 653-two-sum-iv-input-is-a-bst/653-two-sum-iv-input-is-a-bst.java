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
    public boolean findTarget(TreeNode root, int k) {
        if(root == null){
            return false;
        }
        
        List<Integer> in = new ArrayList<>();
        storeInorder(root,in);
        
        int low = 0,high = in.size()-1;
        while(low<high){
            int sum = in.get(low) + in.get(high);
            if(sum == k){
                return true;
            }
            if(sum > k){
                high--;
            }else{
                low++;
            }
        }
        return false;
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