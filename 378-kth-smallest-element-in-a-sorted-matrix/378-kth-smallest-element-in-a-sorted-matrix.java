class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int[] row:matrix){
            for(int val:row){
                pq.add(val);
                if(pq.size()>k){
                    pq.poll();
                }
            }
        }
        return pq.peek();
    }
}