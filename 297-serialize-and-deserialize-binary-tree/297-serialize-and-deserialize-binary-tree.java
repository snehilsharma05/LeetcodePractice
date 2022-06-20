/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null){
            return "";
        }
        StringBuilder data = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            if(curr == null){
                data.append("n ");
                continue;
            }
            
            data.append(curr.val + " ");
            q.add(curr.left);
            q.add(curr.right);
        }
        return data.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == "")return null;
        String[] values = data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        int index = 1;
        while(index < values.length){
            TreeNode curr = q.poll();
            if(!values[index].equals("n")){
                TreeNode left = new TreeNode(Integer.parseInt(values[index]));
                curr.left = left;
                q.add(left);
                
            }
            index++;
            
            if(!values[index].equals("n")){
                TreeNode right = new TreeNode(Integer.parseInt(values[index]));
                curr.right = right;
                q.add(right);
                
            }
            index++;
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));