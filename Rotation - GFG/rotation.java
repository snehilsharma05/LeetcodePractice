//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            int ans = new Solution().findKRotation(a, n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    int findKRotation(int arr[], int n) {
        int k = n;
        int minVal = Integer.MAX_VALUE;
        int low = 0, high = n-1;
        while(low<=high){
            int mid = (low+high)>>1;
            if(arr[low]<=arr[mid]){
                if(arr[low]<minVal){
                    k = low;
                    minVal = arr[low];
                }
                low = mid+1;
            }else if(arr[mid]<=arr[high]){
                if(arr[mid]<minVal){
                    k = mid;
                    minVal = arr[mid];
                }
                high = mid-1;
            }
        }
        return k;
    }
}