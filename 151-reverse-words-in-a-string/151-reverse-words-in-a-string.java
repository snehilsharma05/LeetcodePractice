class Solution {
    public String reverseWords(String s) {
        String temp;
        s = s.trim();
        String[] str = s.split(" ");
        int n = str.length;
        for(int i=0;i<n/2;i++){
            temp = str[i];
            str[i] = str[n-1-i];
            str[n-1-i] = temp;
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            if(str[i].length()>0){
                sb.append(str[i]);
                if(i<n-1){
                    sb.append(" ");
                }
            }
        }
        return new String(sb);
    }
}