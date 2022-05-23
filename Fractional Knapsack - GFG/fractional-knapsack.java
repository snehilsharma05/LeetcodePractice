// { Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}

class GfG {
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int w = Integer.parseInt(inputLine[1]);
            Item[] arr = new Item[n];
            inputLine = br.readLine().trim().split(" ");
            for(int i=0, k=0; i<n; i++){
                arr[i] = new Item(Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]));
            }
            System.out.println(String.format("%.2f", new Solution().fractionalKnapsack(w, arr, n)));
        }
    }
}// } Driver Code Ends


/*
class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}
*/

class Solution
{
    //Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(int W, Item arr[], int n) 
    {
        // Your code here
        Arrays.sort(arr,(i1,i2)->{
            double vpw1 = (double)i1.value/(double)i1.weight;
            double vpw2 = (double)i2.value/(double)i2.weight;
            
            if(vpw2 > vpw1){
                return 1;
            }else if(vpw2 < vpw1){
                return -1;
            }
            return 0;
        });
        
        double value = 0;
        int currWt = 0;
        for(int i=0;i<n;i++){
            if(currWt + arr[i].weight <= W){
                currWt += arr[i].weight;
                value += arr[i].value;
            }else{
                int remain = W - currWt;
                double fraction = ((double)arr[i].value/(double)arr[i].weight) * remain;
                value += fraction;
                break;
            }
        }
        return value;
    }
}