class Solution {
    public int removePalindromeSub(String s) {
        if(s.length() == 0){
            return 0;
        }
        
        StringBuilder rev = new StringBuilder();
        for(int i=s.length()-1;i>=0;i--){
            rev.append(s.charAt(i));
        }
        
        if(s.equals(new String(rev))){ //whole string is pallindrome, can be removed in 1 operation
            return 1;
        }else{
            return 2; //in 1st step remove all 'a' and then in 2nd step remove all 'b'
        }
    }
}