class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        if(startFuel >= target){
            return 0;
        }
        
        int index = 0, n = stations.length, steps = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); //max heap, always choose the station with
        int maxDistance = startFuel;                                                //max fuel
        while(maxDistance < target){
            while(index < n && stations[index][0]<=maxDistance){ //add all stations which we can cover with current fuel
                pq.add(stations[index++][1]);
            }
            
            if(pq.isEmpty()){
                return -1;
            }
            
            maxDistance += pq.poll(); //we chose the station which has the highest fuel
            steps++;
        }
        return steps;
    }
}