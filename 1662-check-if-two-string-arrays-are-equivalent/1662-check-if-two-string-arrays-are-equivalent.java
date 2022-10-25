class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        String concat1 = getConcat(word1);
        String concat2 = getConcat(word2);
        return concat1.equals(concat2);
    }
    
    private String getConcat(String[] arr){
        StringBuilder sb = new StringBuilder();
        for(String word:arr){
            sb.append(word);
        }
        
        return new String(sb);
    }
}