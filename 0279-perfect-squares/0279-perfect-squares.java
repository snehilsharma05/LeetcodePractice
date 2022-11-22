class Solution {
    public int numSquares(int n) {
        int[] countSqs = new int[n+1];
        Arrays.fill(countSqs, (int)1e9);
        countSqs[0] = 0;
        for(int num = 1;num<=n; num++){
            for(int sqNum=1;sqNum*sqNum<=num;sqNum++){
                if(num>=sqNum * sqNum){
                    countSqs[num] = Math.min(countSqs[num], 1 + countSqs[num - sqNum*sqNum]);
                }
            }
        }
        return countSqs[n];
    }
}