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
        int data;
        int depth;
        Pair(int data,int depth){
            this.data = data;
            this.depth = depth;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Map<Integer,List<Pair>> map = new TreeMap<>();
        store(root,0,0,map);
        
        List<List<Integer>> ans = new ArrayList<>();
        for(int key:map.keySet()){
            List<Pair> vertical = map.get(key);
            Collections.sort(vertical,(p1,p2)->{
                if(p1.depth != p2.depth){
                    return p1.depth - p2.depth;
                }else{
                    return p1.data - p2.data;
                }
            });
            
            List<Integer> list = new ArrayList<>();
            for(Pair p : vertical){
                list.add(p.data);
            }
            
            ans.add(list);
        }
        return ans;
    }
    
    private void store(TreeNode root, int hd, int depth, Map<Integer,List<Pair>> map){
        if(root == null){
            return;
        }
        
        List<Pair> vertical = map.get(hd);
        if(vertical == null){
            vertical = new ArrayList<>();
        }
        vertical.add(new Pair(root.val,depth));
        map.put(hd,vertical);
        
        store(root.left,hd-1,depth+1,map);
        store(root.right,hd+1,depth+1,map);
    }
}