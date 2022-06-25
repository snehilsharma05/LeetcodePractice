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
    private class Index{
        int index = 0;
    }
    public void recoverTree(TreeNode root) {
        if(root == null){
            return;
        }
        
        List<Integer> inorder = new ArrayList<>();
        storeInorder(root,inorder);
        Collections.sort(inorder);
        
        Index index = new Index();
        backToTree(root,inorder,index);
    }
    private void storeInorder(TreeNode root,List<Integer> inorder){
        if(root == null){
            return;
        }
        
        storeInorder(root.left,inorder);
        inorder.add(root.val);
        storeInorder(root.right,inorder);
    }
    
    private void backToTree(TreeNode root,List<Integer> inorder,Index index){
        if(root == null){
            return;
        }
        
        backToTree(root.left,inorder,index);
        root.val = inorder.get(index.index++);
        backToTree(root.right,inorder,index);
    }
}