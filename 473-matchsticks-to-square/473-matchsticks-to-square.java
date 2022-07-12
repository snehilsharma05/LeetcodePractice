class Solution {
    public boolean makesquare(int[] matchsticks) {
        int n = matchsticks.length;
        if(n<4){
            return false;
        }
        
        int peri = 0;
        for(int num:matchsticks){
            peri += num;
        }
        
        if(peri % 4 != 0){
            return false;
        }
        
        //sort in descending order
        Arrays.sort(matchsticks); //optimization2
        reverse(matchsticks); //if length of a matchstick is > side possible for square, then not possible to form square
        
        int target = peri/4;
        int[] sides = new int[4];
        
        return makeSquareHelper(0,sides,target,matchsticks);
    }
    
    private boolean makeSquareHelper(int index,int[] sides,int target,int[] matchsticks){
        if(index == matchsticks.length){
            return sides[0] == sides[1] && sides[1] == sides[2] && sides[2] == sides[3];
        }
        
        for(int j=0;j<4;j++){
            if(sides[j] + matchsticks[index]>target){ //optimization1
                continue;
            }
            
            sides[j] += matchsticks[index];
            if(makeSquareHelper(index+1,sides,target,matchsticks)){
                return true;
            }
            sides[j] -= matchsticks[index];
        }
        
        return false;
    }
    
    private void reverse(int[] matchsticks){
        int n = matchsticks.length,temp;
        for(int i=0;i<n/2;i++){
            temp = matchsticks[i];
            matchsticks[i] = matchsticks[n-1-i];
            matchsticks[n-1-i] = temp;
        }
    }
}