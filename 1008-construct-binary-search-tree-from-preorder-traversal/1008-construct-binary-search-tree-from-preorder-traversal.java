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
    public TreeNode bstFromPreorder(int[] preorder) {
        Index index = new Index();
        return buildTree(index,preorder,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
    
    private TreeNode buildTree(Index index,int[] preorder,int min,int max){
        if(index.index>=preorder.length){
            return null;
        }
        
        TreeNode curr = null;
        if(preorder[index.index]>min && preorder[index.index]<max){
            curr = new TreeNode(preorder[index.index++]);
            curr.left = buildTree(index,preorder,min,curr.val);
            curr.right = buildTree(index,preorder,curr.val,max);
        }
        return curr;
    }
}