class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] magCount = new int[26];
        for(int i=0;i<magazine.length();i++){
            char ch = magazine.charAt(i);
            magCount[ch-'a']++;
        }
        
        for(int i=0;i<ransomNote.length();i++){
            char ch = ransomNote.charAt(i);
            if(magCount[ch-'a']>0){
                magCount[ch-'a']--;
            }else{
                return false;
            }
        }
        return true;
    }
}