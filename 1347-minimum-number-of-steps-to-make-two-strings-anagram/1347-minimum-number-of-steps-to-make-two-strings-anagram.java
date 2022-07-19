class Solution {
    public int minSteps(String s, String t) {
        if(s.length() != t.length()){
            return -1;
        }
        
        Map<Character,Integer> sMap = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            sMap.put(ch,sMap.getOrDefault(ch,0)+1);
        }
        
        Map<Character,Integer> tMap = new HashMap<>();
        for(int i=0;i<t.length();i++){
            char ch = t.charAt(i);
            tMap.put(ch,tMap.getOrDefault(ch,0)+1);
        }
        
        int count = 0;
        for(char key:tMap.keySet()){
            if(sMap.containsKey(key)){
                if(sMap.get(key) < tMap.get(key)){
                    count += (tMap.get(key) - sMap.get(key));
                }
            }else{
                count += tMap.get(key);
            }
        }
        return count;
    }
}