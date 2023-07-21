//{ Driver Code Starts
import java.util.*;
import java.lang.*;

class CountSort
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            long n = sc.nextLong();
            String arr = "";
            arr = sc.next();
            Solution obj = new Solution();
            System.out.println(obj.countSort(arr));
        }
    }
}

// } Driver Code Ends


class Solution
{
    //Function to arrange all letters of a string in lexicographical 
    //order using Counting Sort.
    public static String countSort(String arr)
    {
        // code here
        int n = arr.length();
        int[] freq = new int[26];
        for(int i=0;i<n;i++){
            char ch = arr.charAt(i);
            freq[ch-'a']++;
        }
        
        for(int i=1;i<26;i++){
            freq[i] += freq[i-1];
        }
        
        char[] ans = new char[n];
        for(int i=n-1;i>=0;i--){
            char ch = arr.charAt(i);
            ans[freq[ch-'a'] - 1] = ch;
            freq[ch-'a']--;
        }
        return new String(ans);
    }
}