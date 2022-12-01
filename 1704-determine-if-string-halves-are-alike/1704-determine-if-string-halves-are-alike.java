class Solution {
    public boolean halvesAreAlike(String s) {
        int n = s.length();
        int h1 = 0, h2 = 0;
        Set<Character> set = new HashSet<>(Arrays.asList('a','e','i','o','u','A','E','I','O','U'));
        for(int i=0;i<n/2;i++){
            if(set.contains(s.charAt(i))){
                h1++;
            }
        }
        
        for(int i=n/2;i<n;i++){
            if(set.contains(s.charAt(i))){
                h2++;
            }
        }
        return h1 == h2;
    }
}