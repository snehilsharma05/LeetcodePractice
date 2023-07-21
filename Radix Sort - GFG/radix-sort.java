//{ Driver Code Starts
//Initial Template for Java


import java.util.*;
import java.io.*;
import java.lang.*;

class Driver
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            int n = Integer.parseInt(read.readLine());
            String str[] = read.readLine().trim().split(" ");
            
            int arr[] = new int[n];
            for(int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(str[i]);
                
            Solution obj = new Solution();
            obj.radixSort(arr, n);
            for(int i = 0; i < n; i++)
                System.out.print(arr[i] + " ");
                
            System.out.println();
        }
    }
}


// } Driver Code Ends


//User function Template for Java


class Solution
{
    static void radixSort(int arr[], int n) 
    { 
        int maxNum = Integer.MIN_VALUE;
        for(int val:arr){
            maxNum = Math.max(maxNum, val);
        }
        
        int exp = 1;
        while(exp<=maxNum){
            countSort(arr, n, exp);
            exp = exp * 10;
        }
    } 
    
    private static void countSort(int[] arr, int n, int exp){
        int[] ans = new int[n];
        
        int[] freq = new int[10];
        for(int num:arr){
            freq[num/exp%10]++;
        }
        
        for(int i=1;i<10;i++){
            freq[i] += freq[i-1];
        }
        
        for(int i=n-1;i>=0;i--){
            int num = arr[i];
            ans[freq[num/exp%10]-1] = num;
            freq[num/exp%10]--;
        }
        for(int i=0;i<n;i++) {
            arr[i] = ans[i];
        }
    }
}

