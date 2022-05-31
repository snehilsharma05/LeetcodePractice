class Solution {
    public boolean hasAllCodes(String s, int k) {
        Set<String> seen = new HashSet<>();
        
        int maxSize = 1<<k;
        for(int i=0;i<=s.length()-k && seen.size()<maxSize;i++){
            seen.add(s.substring(i,i+k));
        }
        
        return seen.size() == maxSize;
    }
}