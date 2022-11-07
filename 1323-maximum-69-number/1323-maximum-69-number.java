class Solution {
    public int maximum69Number (int num) {
        StringBuilder ans = new StringBuilder();
        boolean reversed = false;
        String str = num+"";
        for(int i=0;i<str.length();i++){
            if(str.charAt(i) == '6' && !reversed){
                ans.append("9");
                reversed = true;
            }else{
                ans.append(str.charAt(i));
            }
        }
        return Integer.parseInt(new String(ans));
    }
}