class Solution {
    public String reverseWords(String s) {
        char[] ch = s.toCharArray();
        int i = 0;
        while(i<ch.length){
            if(ch[i]!=' '){
                int j = i;
                while(j+1<ch.length && ch[j+1]!=' '){
                    j++;
                }
                reverse(ch,i,j);
                i = j;
            }
            i++;
        }
        return new String(ch);
    }
    private void reverse(char[] ch,int i,int j){
        char temp;
        while(i<j){
            temp = ch[i];
            ch[i] = ch[j];
            ch[j] = temp;
            i++;
            j--;
        }
    }
}