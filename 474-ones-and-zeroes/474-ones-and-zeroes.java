class Solution {
    private class Pair{
        String str;
        int zeros;
        int ones;
        Pair(String str,int zeros,int ones){
            this.str = str;
            this.zeros = zeros;
            this.ones = ones;
        }
    }
    
    public int findMaxForm(String[] strs, int m, int n) {
        List<Pair> list = new ArrayList<>();
        for(String s:strs){
            addToList(s,list);
        }
        
        int[][][] dp = new int[list.size()+1][m+1][n+1];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                for(int k=0;k<dp[0][0].length;k++){
                    dp[i][j][k] = -1;
                }
            }
        }
        
        return compute(0,m,n,list,dp);
    }
    
    private int compute(int index,int zerosAvailable, int onesAvailable, List<Pair> list,int[][][] dp){
        if(index == list.size() || (onesAvailable == 0 && zerosAvailable == 0)){
            return 0;
        }
        if(dp[index][zerosAvailable][onesAvailable] != -1){
            return dp[index][zerosAvailable][onesAvailable];
        }
                
        if(list.get(index).zeros > zerosAvailable || list.get(index).ones > onesAvailable){
            return dp[index][zerosAvailable][onesAvailable] = compute(index+1,zerosAvailable,onesAvailable,list,dp);
        }
        
        int lengthIncludeThisIndexString = 1 + compute(index + 1, zerosAvailable - list.get(index).zeros,
                                                            onesAvailable - list.get(index).ones, list,dp);
        
        int lengthExcludeThisIndexString = compute(index+1,zerosAvailable,onesAvailable,list,dp);
        
        
        return dp[index][zerosAvailable][onesAvailable] = Math.max(lengthIncludeThisIndexString,lengthExcludeThisIndexString);
    }
    
    
    private void addToList(String s,List<Pair> list){
        int zeros = 0,ones = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '0'){
                zeros++;
            }else{
                ones++;
            }
        }
        list.add(new Pair(s,zeros,ones));
    }
}