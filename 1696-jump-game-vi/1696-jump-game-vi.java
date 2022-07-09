class Solution {
    public int maxResult(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> q = new ArrayDeque<>();
        int[] dp = new int[n];
        dp[n-1] = nums[n-1];
        
        q.addLast(n-1);
        
        for(int i=n-2;i>=0;i--){
            if(q.peekFirst() - i >k){
                q.pollFirst();
            }
            
            dp[i] = nums[i] + dp[q.peekFirst()];
            while(!q.isEmpty() && dp[q.peekLast()] < dp[i]){
                q.pollLast();
            }
            q.add(i);
        }
        
        return dp[0];
    }
}