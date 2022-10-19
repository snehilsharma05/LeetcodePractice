class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String,Integer> frequency = new HashMap<>();
        for(String word:words){
            frequency.put(word,frequency.getOrDefault(word,0)+1);
        }
        
        PriorityQueue<String> pq = new PriorityQueue<>((word1,word2)->{
            if(frequency.get(word1) != frequency.get(word2)){
                return frequency.get(word1) - frequency.get(word2);
            }else{
                return word2.compareTo(word1);
            }
        });
        
        pq.addAll(frequency.keySet());
        
        while(pq.size()>k){
            pq.poll();
        }
        
        List<String> ans = new ArrayList<>();
        while(pq.size()>0){
            ans.add(pq.poll());
        }
        Collections.reverse(ans);
        return ans;
    }
}