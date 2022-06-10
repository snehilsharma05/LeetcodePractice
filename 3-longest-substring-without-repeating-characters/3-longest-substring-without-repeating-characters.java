class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int left = 0,right = 0;
        Map<Character,Integer> map = new HashMap<>();
        
        while(right < s.length()){
            char ch = s.charAt(right);
            if(map.containsKey(ch)){
                left = Math.max(left,map.get(ch)+1);
            }
            
            map.put(ch,right);
            maxLength = Math.max(maxLength,right - left + 1);
            right++;
        }
        return maxLength;
    }
}