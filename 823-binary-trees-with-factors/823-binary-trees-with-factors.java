class Solution {
    public int numFactoredBinaryTrees(int[] arr) {
        int n = arr.length;
        long count = 0L;
        long MOD = (long)1e9+7;
        Map<Integer,Long> map = new HashMap<>(); 
        
        Arrays.sort(arr); //sort the array first
        for(int i=0;i<n;i++){
            map.put(arr[i],1L); //1 way is always there for every number present in array
            for(int j=0;j<i;j++){
                if(arr[i]%arr[j] == 0){ //if previous number of array divides current number completely, 
                                        //then multiply ways(nums[j])*ways(nums[i]/nums[j])
                    
                    map.put(arr[i], map.get(arr[i]) + (map.get(arr[j]) * map.getOrDefault(arr[i]/arr[j], 0L)));
                }
            }
            count = count + (map.get(arr[i])%MOD);
        }
        return (int)(count%MOD);
    }
}