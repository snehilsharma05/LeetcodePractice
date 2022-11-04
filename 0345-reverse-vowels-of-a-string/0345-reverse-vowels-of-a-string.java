class Solution {
    public String reverseVowels(String s) {
        Set<Character> set = new HashSet<>(Arrays.asList('a','e','i','o','u','A','E','I','O','U'));
        List<Character> list = new ArrayList<>();
        for(int i=s.length()-1;i>=0;i--){
            char ch = s.charAt(i);
            if(set.contains(ch)){
                list.add(ch);
            }
        }
        
        int index = 0;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(set.contains(ch)){
                sb.append(list.get(index++));
            }else{
                sb.append(ch);
            }
        }
        return new String(sb);
    }
}