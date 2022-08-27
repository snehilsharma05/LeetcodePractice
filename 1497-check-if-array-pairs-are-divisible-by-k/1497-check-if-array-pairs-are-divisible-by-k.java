class Solution {
    public boolean canArrange(int[] arr, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int val:arr){
            int rem = val % k;
            if(rem < 0){
                rem += k;
            }
            map.put(rem,map.getOrDefault(rem,0)+1);
        }
        
        for(int val:arr){
            int rem = val % k;
            if(rem < 0){
                rem += k;
            }
            
            if(rem == 0){
                if(map.get(rem) % 2 != 0){
                    return false;
                }
            }else if(2 * rem == k){
                if(map.get(rem) % 2 != 0){
                    return false;
                }
            }else{
                int f1 = map.get(rem);
                int f2 = map.getOrDefault(k - rem,0);
                if(f1 != f2){
                    return false;
                }
            }
        }
        return true;
    }
}