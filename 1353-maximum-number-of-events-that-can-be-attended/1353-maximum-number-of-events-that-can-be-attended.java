class Solution {
    public int maxEvents(int[][] events) {
        int attended = 0;
        Arrays.sort(events,(e1,e2)->e1[0] - e2[0]); //sort based on start time
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int index = 0, n = events.length;
        for(int day = 1;day<=100000;day++){
            while(!pq.isEmpty() && pq.peek() < day){ //poll out the events which we were supposed to do on some previous days
                pq.poll();
            }
            
            while(index < n && day == events[index][0]){
                pq.add(events[index++][1]); //add ending time, we'll greedily choose the events in which end time is less
            }
            
            if(!pq.isEmpty()){
                pq.poll();
                attended++;
            }
        }
        return attended;
    }
}