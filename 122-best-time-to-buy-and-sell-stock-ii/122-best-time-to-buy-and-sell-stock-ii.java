class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length+1][2];
        for(int index=prices.length-1;index>=0;index--){
                dp[index][1] = Math.max(-prices[index] + dp[index+1][0], 
                                             0 + dp[index+1][1]);
                
                dp[index][0] = Math.max(+prices[index] + dp[index+1][1],
                                             0 + dp[index+1][0]);
            }
        return dp[0][1];
        //return maxProfit(0,prices,true,dp); //give me the max profit when starting on day 0 and you are allowed to buy the stock
    }
    
    private int maxProfit(int index,int[] prices,boolean allowedToBuy,int[][] dp){
        if(index == prices.length){ //can't make any profit if prices array traversed
            return 0;
        }
        if(dp[index][allowedToBuy == true ? 1:0] != -1){
            return dp[index][allowedToBuy == true ? 1 : 0];
        }
        if(allowedToBuy){ //then buy on current day and next day you are not allowed to buy, or don't buy today and move to next index
            return dp[index][allowedToBuy == true ? 1 : 0] = Math.max(
                                -prices[index] + maxProfit(index+1,prices,false,dp), //we bought, next day we are not allowed to buy
                                0 + maxProfit(index+1,prices,true,dp) //we skipped buying on current day
                            );
            
        }else{ //we are not allowed to buy, we'll try to sell and earn profit, or don't sell today and move to next index
            return dp[index][allowedToBuy == true ? 1 : 0] = Math.max(
                                +prices[index] + maxProfit(index+1,prices,true,dp), //we sold on curr day, earned profit and allowed to buy next day
                                0 + maxProfit(index+1,prices,false,dp) //we dskipped curr day to sell, next day we'll not be allowed to buy
                            );
        }
    }
}