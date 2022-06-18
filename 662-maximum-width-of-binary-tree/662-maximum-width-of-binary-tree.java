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
    private class Pair{
        TreeNode node;
        int index;
        Pair(TreeNode node,int index){
            this.node = node;
            this.index = index;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }
        
        int width = 0;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root,0));
        
        while(!q.isEmpty()){
            int n = q.size();
            int minIndex = 0,maxIndex = 0;
            
            for(int i=0;i<n;i++){
                Pair curr = q.poll();
                if(i == 0){
                    minIndex = curr.index;
                }
                
                if(i == n-1){
                    maxIndex = curr.index;
                }
                
                if(curr.node.left != null){
                    q.add(new Pair(curr.node.left,2*curr.index+1));
                }
                
                if(curr.node.right != null){
                    q.add(new Pair(curr.node.right, 2*curr.index+2));
                }
            }
            
            width = Math.max(width, maxIndex - minIndex + 1);
        }
        return width;
    }
}