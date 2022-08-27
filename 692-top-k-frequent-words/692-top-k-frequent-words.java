class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String,Integer> map = new HashMap<>();
        for(String word:words){
            map.put(word,map.getOrDefault(word,0)+1);
        }
        
        PriorityQueue<String> pq = new PriorityQueue<>((s1,s2)->{
            if(map.get(s1) != map.get(s2)){
                return map.get(s1) - map.get(s2);
            }else{
                return s2.compareTo(s1);
            }
        });
        
        for(String word:map.keySet()){
            pq.add(word);
            if(pq.size()>k){
                pq.poll();
            }
        }
        
        List<String> ans = new ArrayList<>();
        while(pq.size()>0){
            ans.add(pq.poll());
        }
        
         Collections.reverse(ans);
        
        return ans;
    }
}