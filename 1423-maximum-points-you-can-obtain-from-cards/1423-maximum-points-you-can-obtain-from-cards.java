class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int sum = 0;
        
        int[] sumFromFront = new int[n+1];
        for(int i=0;i<n;i++){
            sum += cardPoints[i];
            sumFromFront[i+1] = sum;
        }
        
        sum = 0;
        int[] sumFromBehind = new int[n+1];
        for(int i=n-1;i>=0;i--){
            sum += cardPoints[i];
            sumFromBehind[n-i] = sum;
        }
        
        //System.out.println("Front-->");
//         for(int i=0;i<=n;i++){
//             System.out.print(sumFromFront[i]+" ");
//         }
//         System.out.println();
        
//         System.out.println("Behind-->");
//         for(int i=0;i<=n;i++){
//             System.out.print(sumFromBehind[i]+" ");
//         }
        
        //System.out.println();
        int ans = 0;
        for(int part=0;part<=k;part++){
            ans = Math.max(ans,sumFromFront[part] + sumFromBehind[k-part]);
        }
        return ans;
    }
    
}