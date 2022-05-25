class Solution {
    public int maxEnvelopes(int[][] E) {
        Arrays.sort(E, (a,b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int[] dp = new int[E.length]; //dp will be maintained by us sorted
        int ans = 0;
        for (int[] env : E) {
            int height = env[1];
            int left = Arrays.binarySearch(dp, 0, ans, height);//in given array, from [0...index], find the value height
            if (left < 0) left = -left - 1;
            if (left == ans) ans++;
            dp[left] = height;
        }
        return ans;
    }
}