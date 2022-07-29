class Solution {
    // noramlize a string to a standart pattern... pat:- "abb" --> normalized array [0,1,1] where a-->0, b-->1
    //when string "mee" came for matching, its normalization will be [0,1,1] where m-->0, e-->1
    
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> ans = new ArrayList<>();
        int[] pNormal = normalize(pattern);
        for(String word:words){
            if(Arrays.equals(normalize(word),pNormal)){
                ans.add(word);
            }
        }
        return ans;
    }
    
    private int[] normalize(String word){
        int n = word.length();
        int[] arr = new int[n];
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            map.putIfAbsent(word.charAt(i),map.size()); //we are putting map size if word not avaialble in map (new int value for char)
            arr[i] = map.get(word.charAt(i));
        }
        return arr;
    }
}