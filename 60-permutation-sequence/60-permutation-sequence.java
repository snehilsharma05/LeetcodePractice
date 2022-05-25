class Solution {
    public String getPermutation(int n, int k) { //n = 4, k=17, total !n = 24 available permutations
        int fact = 1;
        List<Integer> numbers = new ArrayList<>();
        for(int i=1;i<n;i++){ //for input [1,2,3,4], we need to divide 24 permutations in size of 6 (!3) each
            fact = fact * i;
            numbers.add(i);
        }
        numbers.add(n); //numbers array should have all numbers from [1..4]
        
        String ans = "";
        k = k-1; //for 0 based indexing k=17, we actually need to find 16th permutation
        
        while(true){
            ans = ans + numbers.get(k/fact);
            numbers.remove(k/fact);
            
            if(numbers.size()==0){
                break;
            }
            
            k = k % fact;
            fact = fact / numbers.size();
        }
        return ans;
    }
}