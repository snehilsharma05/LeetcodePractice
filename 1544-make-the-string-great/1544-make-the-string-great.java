class Solution {
    public String makeGood(String s) {
        while(s.length()>=2){
            StringBuilder temp = new StringBuilder();
            for(int i=0;i<s.length();i++){
                if(i+1<s.length() && Math.abs(s.charAt(i) - s.charAt(i+1)) == 32){
                    i++;
                }else{
                    temp.append(s.charAt(i));
                }
            }
            if(s.length() == temp.length()){
                break;
            }
            //System.out.println(temp);
            s = new String(temp);
        }
        return s;
    }
}