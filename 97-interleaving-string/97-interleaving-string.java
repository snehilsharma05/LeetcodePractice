class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length()+s2.length() != s3.length()){
            return false;
        }
        Map<String,Boolean> map = new HashMap<>();
        return isInterleave(0,0,0,s1,s2,s3,map);
    }
    
    private boolean isInterleave(int p1,int p2,int p3,String s1, String s2, String s3, Map<String,Boolean> map){
        if(p3 == s3.length()){
            return p1 == s1.length() && p2 == s2.length();
        }
        
        String key = p1 + "*" + p2 + "*" + p3;
        
        if(map.containsKey(key)){
            return map.get(key);
        }
        
        if(p1 == s1.length()){
            map.put(key,s2.charAt(p2) == s3.charAt(p3) ? isInterleave(p1,p2+1,p3+1,s1,s2,s3,map) : false);
            return map.get(key);
        }
        
        if(p2 == s2.length()){
            map.put(key,s1.charAt(p1) == s3.charAt(p3) ? isInterleave(p1+1,p2,p3+1,s1,s2,s3,map) : false);
            return map.get(key);
        }
        
        Boolean wayOne = false,wayTwo = false;
        
        if(s1.charAt(p1) == s3.charAt(p3)){
            wayOne = isInterleave(p1+1,p2,p3+1,s1,s2,s3,map);
        }
        
        if(s2.charAt(p2) == s3.charAt(p3)){
            wayTwo = isInterleave(p1,p2+1,p3+1,s1,s2,s3,map);
        }
        
        map.put(key, wayOne || wayTwo);
        return map.get(key);
    }
}