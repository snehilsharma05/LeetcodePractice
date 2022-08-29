class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0, n = s.length();
        int j=0,i=0;
        Set<Character> set = new HashSet<>();
        while(j<n){
            char ch = s.charAt(j);
            if(set.contains(ch)){
                while(set.contains(ch)){
                    set.remove(s.charAt(i));
                    i++;
                }
            }
            
            set.add(ch);
            maxLength = Math.max(maxLength,set.size());
            j++;
        }
        return maxLength;
    }
}