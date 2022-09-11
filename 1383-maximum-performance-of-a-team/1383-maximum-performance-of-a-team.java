class Solution {
    private class Pair{
        int speed;
        int efficiency;
        Pair(int speed,int efficiency){
            this.speed = speed;
            this.efficiency = efficiency;
        }
    }
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int mod = (int)(1e9+7);
        Pair[] pairs = new Pair[n];
        for(int i=0;i<n;i++){
            pairs[i] = new Pair(speed[i],efficiency[i]);
        }
        
        Arrays.sort(pairs,(p1,p2) -> p2.efficiency - p1.efficiency); //sort in descending order on basis of efficiency, so that
                                                                    //as we move in array, we get min efficiency always at curr
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        long sum = 0, ans = 0;
        for(Pair p: pairs){
            sum += p.speed;
            pq.add(p.speed);
            
            if(pq.size() > k){ //remove smallest speed from pq
                sum -= pq.poll();
            }
            
            ans = Math.max(ans, sum * p.efficiency); // we are sure that p.efficiency is smallest efficiency till curr index
        }
        return (int)(ans % mod);
    }
}