class TrieNode{
    Map<Character,TrieNode> next = new HashMap<>();
    int depth;
}
class Solution {
    public int minimumLengthEncoding(String[] words) {
        TrieNode root = new TrieNode();
        List<TrieNode> leaves = new ArrayList<>();
        Set<String> noDupWords = new HashSet<>(Arrays.asList(words));
        
        for(String word:noDupWords){
            TrieNode curr = root;
            for(int i=word.length()-1;i>=0;i--){
                char ch = word.charAt(i);
                if(!curr.next.containsKey(ch)){
                    curr.next.put(ch,new TrieNode());
                }
                
                curr = curr.next.get(ch);
            }
            
            curr.depth = word.length()+1;
            leaves.add(curr);
        }
        
        int length = 0;
        for(TrieNode leaf:leaves){
            if(leaf.next.isEmpty()){
                length += leaf.depth;
            }
        }
        return length;
    }
}