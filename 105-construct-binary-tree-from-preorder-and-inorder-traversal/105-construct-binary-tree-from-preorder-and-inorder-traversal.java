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
        Map<Integer,Integer> inMap = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            inMap.put(inorder[i],i);
        }
        
        int n = inorder.length;
        Index index = new Index();
        return buildTree(preorder,index,0,n-1,inMap);
    }
    
    private TreeNode buildTree(int[] preorder,Index index,int low,int high,Map<Integer,Integer> inMap){
        if(low>high || index.index>=preorder.length){
            return null;
        }
        
        TreeNode node = new TreeNode(preorder[index.index++]);
        
        int indexInInorder = inMap.get(node.val);
        node.left = buildTree(preorder,index,low,indexInInorder-1,inMap);
        node.right = buildTree(preorder,index,indexInInorder+1,high,inMap);
        
        return node;
    }
}