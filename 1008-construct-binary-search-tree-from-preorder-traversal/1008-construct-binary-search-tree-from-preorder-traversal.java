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
        int n = preorder.length;
        Index index = new Index();
        return formTree(index,Integer.MIN_VALUE,Integer.MAX_VALUE,preorder);
    }
    
    private TreeNode formTree(Index index, int min,int max,int[] preorder){
        if(index.index >= preorder.length){
            return null;
        }
        
        TreeNode node = null;
        if(preorder[index.index]>min && preorder[index.index]<max){
            node = new TreeNode(preorder[index.index++]);
            node.left = formTree(index,min,node.val,preorder);
            node.right = formTree(index,node.val,max,preorder);
        }
        return node;
    }
}