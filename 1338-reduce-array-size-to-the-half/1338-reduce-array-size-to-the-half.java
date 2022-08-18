class Solution {
    public int minSetSize(int[] arr) {
        int n = arr.length;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        
        int[] freq = new int[n+1];
        for(int key:map.keySet()){
            int count = map.get(key);
            freq[count]++;
        }
        
        int elementsReqd = 0;
        int steps = 0;
        for(int i=n;i>0;i--){
            while(freq[i]>0){
                steps += i;
                elementsReqd++;
                freq[i]--;
                if(steps>=n/2){
                    return elementsReqd;
                }
            }
        }
        return elementsReqd;
    }
}