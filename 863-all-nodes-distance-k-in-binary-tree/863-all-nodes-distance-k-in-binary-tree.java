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
        
        Map<TreeNode,TreeNode> parents = makeParents(root);
        return nodesWithDistanceK(target,parents,k);
        
    }
    
    private Map<TreeNode,TreeNode> makeParents(TreeNode root){
        Map<TreeNode,TreeNode> parents = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            if(curr.left != null){
                parents.put(curr.left, curr);
                q.add(curr.left);
            }
            
            if(curr.right != null){
                parents.put(curr.right,curr);
                q.add(curr.right);
            }
        }
        return parents;
    }
    
    private List<Integer> nodesWithDistanceK(TreeNode target, Map<TreeNode,TreeNode> parents, int k){
        int currDist = 0;
        Queue<TreeNode> q = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();
        
        q.add(target);
        visited.add(target);
        
        while(!q.isEmpty()){
            
            if(currDist == k){
                break;
            }
            
            currDist++;
            int n = q.size();
            
            while(n-->0){
                TreeNode curr = q.poll();
                if(curr.left != null && !visited.contains(curr.left)){
                    q.add(curr.left);
                    visited.add(curr.left);
                }
                
                if(curr.right != null && !visited.contains(curr.right)){
                    q.add(curr.right);
                    visited.add(curr.right);
                }
                
                if(parents.containsKey(curr) && !visited.contains(parents.get(curr))){
                    q.add(parents.get(curr));
                    visited.add(parents.get(curr));
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