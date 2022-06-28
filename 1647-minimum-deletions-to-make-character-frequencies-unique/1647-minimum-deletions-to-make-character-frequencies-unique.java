class Solution {
    public int minDeletions(String s) {
        int count = 0;
        int[] freq = new int[26];
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            freq[ch-'a']++;
        }
        
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<26;i++){
            if(freq[i]>0){
                if(set.contains(freq[i])){
                    while(set.contains(freq[i]) && freq[i]>0){
                        freq[i]--;
                        count++;
                    }
                }
                set.add(freq[i]);
            }
        }
        return count;
    }
}