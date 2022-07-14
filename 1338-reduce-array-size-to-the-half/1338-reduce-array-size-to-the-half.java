class Solution {
    public int minSetSize(int[] arr) {
        int n = arr.length;
        
        //store freq of each num
        Map<Integer,Integer> map = new HashMap<>();
        for(int num:arr){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        
        //count how many numbers are there with given frequency 'i'
        int[] freq = new int[n+1]; //index 'i' will be the frequency
        
        for(int num:map.keySet()){
            int count = map.get(num);
            freq[count]++; //we got a number with freq = count
        }
        
        int minSetElements = 0;
        int stepsTaken = 0;
        for(int i=n;i>0;i--){
            
            while(freq[i]>0){
                stepsTaken += i;
                minSetElements++;
                freq[i]--; //we used one element stored in freq array
                if(stepsTaken >= n/2){
                    return minSetElements;
                }
            }
            
        }
        return minSetElements;
    }
}