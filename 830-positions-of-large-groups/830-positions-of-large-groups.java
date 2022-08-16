class Solution {
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> ans = new ArrayList<>();
        int count = 1;
        for(int i=1;i<=s.length();i++){
            if(i < s.length() && s.charAt(i) == s.charAt(i-1)){
                count++;
            }else{
                if(count>=3){
                    List<Integer> interval = new ArrayList<>();
                    interval.add(i - count);
                    interval.add(i-1);
                    ans.add(interval);
                }
                count = 1;
            }
        }
        return ans;
    }
}