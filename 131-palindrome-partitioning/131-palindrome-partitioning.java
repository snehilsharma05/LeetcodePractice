class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> psf = new ArrayList<>();
        cutAndStore(0,s,psf,ans);
        return ans;
    }
    private void cutAndStore(int index, String s, List<String> psf, List<List<String>> ans){
        if(index == s.length()){
            ans.add(new ArrayList<>(psf));
            return;
        }
        
        for(int cut=index;cut<s.length();cut++){
            String s2Check = s.substring(index,cut+1);
            if(isPallindrome(s2Check)){
                psf.add(s2Check);
                cutAndStore(cut+1,s,psf,ans);
                psf.remove(psf.size()-1);
            }
        }
    }
    private boolean isPallindrome(String str){
        int start = 0,end = str.length()-1;
        while(start<end){
            if(str.charAt(start) != str.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    
}