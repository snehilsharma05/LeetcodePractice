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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Index index = new Index();
        Map<Integer,Integer> inMap = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            inMap.put(inorder[i],i);
        }
        return formTree(0,preorder.length-1,index,preorder,inMap);
    }
    
    private TreeNode formTree(int low,int high,Index index,int[] preorder,Map<Integer,Integer> inMap){
        if(low>high || index.index>=preorder.length){
            return null;
        }
        
        TreeNode node = new TreeNode(preorder[index.index++]);
        int inIndex = inMap.get(node.val);
        node.left = formTree(low,inIndex-1,index,preorder,inMap);
        node.right = formTree(inIndex+1,high,index,preorder,inMap);
        return node;
    }
}