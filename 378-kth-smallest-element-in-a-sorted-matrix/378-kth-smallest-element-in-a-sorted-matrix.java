class Solution {
    private class Node{
        int row,col;
        Node(int row,int col){
            this.row = row;
            this.col = col;
        }
    }
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        PriorityQueue<Node> pq = new PriorityQueue<>((n1,n2)->matrix[n1.row][n1.col] - matrix[n2.row][n2.col]);
        for(int i=0;i<n;i++){
            pq.add(new Node(i,0));
        }
        
        int count = 0;
        while(!pq.isEmpty()){
            Node node = pq.poll();
            count++;
            
            if(count == k){
                return matrix[node.row][node.col];
            }
            
            node.col++;
            if(node.col<n){
                pq.add(node);
            }
        }
        return -1;
    }
}