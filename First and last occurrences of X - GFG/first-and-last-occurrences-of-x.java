//{ Driver Code Starts
//Initial Template for Java

//Initial Template for Java
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            String inputLine[] = br.readLine().trim().split(" "); 
            int n = Integer.parseInt(inputLine[0]); 
            int x = Integer.parseInt(inputLine[1]);
            
            int arr[] = new int[(int)(n)];
            
            String inputLine1[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine1[i]);
            }
            
            Solution obj = new Solution();
            ArrayList<Integer> ans = obj.firstAndLast(arr, n, x); 
            
            for (Integer val: ans) 
                System.out.print(val+" "); 
            System.out.println();
        }
    } 
} 
            



// } Driver Code Ends


//User function Template for Java
class Solution{
    public ArrayList<Integer> firstAndLast(int arr[], int n, int x){
        // Code here
        ArrayList<Integer> ans = new ArrayList<>();
        boolean found = false;
        int first = findOccur(arr,n, x, true);
        ans.add(first);
        if(first == -1){
            return ans;
        }
        int last = findOccur(arr, n, x, false);
        ans.add(last);
        return ans;
    }
    
    private int findOccur(int[] arr, int n, int x, boolean first){
        int low = 0, high = n-1, ans = -1;
        while(low<=high){
            int mid = (low+high)>>1;
            if(arr[mid] == x){
                ans = mid;
                if(first){
                    high = mid-1;
                } else {
                    low = mid+1;
                }
            } else if(arr[mid] > x){
                    high = mid-1;
            } else{
                low = mid+1;
            }
        }
        return ans;
    }
}
