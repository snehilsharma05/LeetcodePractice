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
        int n = preorder.length;
        Index index = new Index();
        Map<Integer,Integer> inMap = new HashMap<>();
        for(int i=0;i<n;i++){
            inMap.put(inorder[i],i);
        }
        
        return buildTree(0,n-1,preorder,index,inMap);
    }
    
    private TreeNode buildTree(int start,int end,int[] preorder,Index index,Map<Integer,Integer> inMap){
        if(start>end || index.index>=preorder.length){
            return null;
        }
        
        TreeNode node = new TreeNode(preorder[index.index++]);
        int indexInInorder = inMap.get(node.val);
        node.left = buildTree(start,indexInInorder-1,preorder,index,inMap);
        node.right = buildTree(indexInInorder+1,end,preorder,index,inMap);
        return node;
    }
}