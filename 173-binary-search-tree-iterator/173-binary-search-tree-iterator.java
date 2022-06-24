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
class BSTIterator {
    private Stack<TreeNode> s;
    public BSTIterator(TreeNode root) {
        s = new Stack<>();
        pushAll(root);
    }
    
    public int next() {
        if(hasNext()){
            TreeNode curr = s.pop();
            pushAll(curr.right);
            return curr.val;
        }else{
            return -1;
        }
    }
    
    public boolean hasNext() {
        return !s.isEmpty();
    }
    
    private void pushAll(TreeNode root){
        while(root != null){
            s.push(root);
            root = root.left;
        }
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */