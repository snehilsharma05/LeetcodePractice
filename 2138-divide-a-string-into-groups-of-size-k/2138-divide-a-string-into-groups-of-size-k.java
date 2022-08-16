class Solution {
    public String[] divideString(String s, int k, char fill) {
        int len = s.length();
        String[] ans;
        int expectedLength = 0;
        if(len % k == 0){
            expectedLength = len/k;
        }else{
            expectedLength = len/k + 1;
        }
        ans = new String[expectedLength];
        
        int index = 0;
        for(int i=0;i<len;i+=k){
            if(i+k<=len){
                ans[index++] = s.substring(i,i+k);
            }
        }
        
        if(index == expectedLength){
            return ans;
        }else{
            int requiredRemainingLength = k - (s.length() % k);
            String remain = "";
            for(int count = 1;count<=requiredRemainingLength;count++){
                remain += fill;
            }
            ans[index++] = s.substring(s.length() - (s.length() % k)) + remain;
        }
        return ans;
    }
}