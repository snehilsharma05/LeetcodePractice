class Solution {
    public int minimumLengthEncoding(String[] words) {
        Set<String> set = new HashSet<>();
        for(String word:words){
            set.add(word);
        }
        
        for(String word:words){
            for(int i=1;i<word.length();i++){
                set.remove(word.substring(i)); //remove all suffixes from set
            }
        }
        
        int length = 0;
        for(String word:set){
            length += word.length() + 1; //1 for #
        }
        
        return length;
    }
}