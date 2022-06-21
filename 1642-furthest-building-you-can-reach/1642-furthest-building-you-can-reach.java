class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int n = heights.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>(); //maintain k largest buildings where you used ladders, k = no. of ladders
        //try to use ladders on k largest building till curr index
        for(int i=0;i<n-1;i++){
            int diff = heights[i+1] - heights[i];
            if(diff > 0){
                
                if(pq.size()<ladders){
                    pq.add(diff);
                }else{
                    //optimize the ladders use, by using bricks where we used ladders
                    int bricksReqd = diff;
                    if(pq.size()>0 && pq.peek() < diff){ //we have used some ladder previously, where we could have used bricks
                        bricksReqd = pq.poll();
                        pq.add(diff);
                    }
                    
                    if(bricks - bricksReqd >= 0){
                        bricks -= bricksReqd;
                    }else{
                        return i;
                    }
                }
            }
        }
        
        return n-1;
    }
}