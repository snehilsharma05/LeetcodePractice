class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0, n = s.length();
        for(int i=0;i<n;i++){
            Set<Character> currSubstringChars = new HashSet<>();
            for(int j=i;j<n;j++){
                char ch = s.charAt(j);
                if(currSubstringChars.contains(ch)){
                    break;
                }
                currSubstringChars.add(ch);
            }
            maxLength = Math.max(maxLength, currSubstringChars.size());
        }
        return maxLength;
    }
}