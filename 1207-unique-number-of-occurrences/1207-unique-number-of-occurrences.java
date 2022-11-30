class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer,Integer> map = new HashMap<>();
        
        for(int num:arr){
            map.put(num, map.getOrDefault(num,0)+1);    
        }
        
        //dekho jo values bnii hain, woh saari unique hain? kaise? jitne unique numbers hain, utni uniuqe values honi chahiye
        return map.size() == new HashSet<>(map.values()).size();
    }
}