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
class BSTIterator{
    private Stack<TreeNode> s;
    private boolean reverse;
    
    BSTIterator(TreeNode root,boolean reverse){
        this.reverse = reverse;
        s = new Stack<>();
        pushAll(root);
    }
    
    public boolean hasNext(){
        return !s.isEmpty();
    }
    
    public int next(){
            TreeNode curr = s.pop();
            if(reverse){
                pushAll(curr.left);
            }else{
                pushAll(curr.right);
            }
            
            return curr.val;
       
    }
    
    private void pushAll(TreeNode root){
        while(root != null){
            s.push(root);
            if(reverse){
                root = root.right;
            }else{
                root = root.left;
            }
        }
    }
}
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        if(root == null){
            return false;
        }
        
        BSTIterator start = new BSTIterator(root,false);
        BSTIterator end = new BSTIterator(root,true);
        
        int val1 = start.next(),val2 = end.next();
        while(val1<val2){
            if(val1 + val2 == k){
                return true;
            }else if(val1 + val2 > k){
                val2 = end.next();
            }else{
                val1 = start.next();
            }
        }
        return false;
    }
}