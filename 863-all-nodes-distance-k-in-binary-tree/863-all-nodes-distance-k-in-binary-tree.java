/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        if(root == null){
            return new ArrayList<>();
        }
        
        Map<Integer,TreeNode> parents = makeParents(root);
        return nodesWithDistanceK(target,parents,k);
        
    }
    
    private Map<Integer,TreeNode> makeParents(TreeNode root){
        Map<Integer,TreeNode> parents = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            if(curr.left != null){
                parents.put(curr.left.val, curr);
                q.add(curr.left);
            }
            
            if(curr.right != null){
                parents.put(curr.right.val,curr);
                q.add(curr.right);
            }
        }
        return parents;
    }
    
    private List<Integer> nodesWithDistanceK(TreeNode target, Map<Integer,TreeNode> parents, int k){
        int currDist = 0;
        Queue<TreeNode> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        
        q.add(target);
        visited.add(target.val);
        
        while(!q.isEmpty()){
            
            if(currDist == k){
                break;
            }
            
            currDist++;
            int n = q.size();
            
            while(n-->0){
                TreeNode curr = q.poll();
                if(curr.left != null && !visited.contains(curr.left.val)){
                    q.add(curr.left);
                    visited.add(curr.left.val);
                }
                
                if(curr.right != null && !visited.contains(curr.right.val)){
                    q.add(curr.right);
                    visited.add(curr.right.val);
                }
                
                if(parents.containsKey(curr.val) && !visited.contains(parents.get(curr.val).val)){
                    q.add(parents.get(curr.val));
                    visited.add(parents.get(curr.val).val);
                }
            }
        }
        
        List<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()){
            ans.add(q.poll().val);
        }
        return ans;
    }
    
    
}