class WordFilter {
    private Map<String,Integer> map = new LinkedHashMap<>();
    public WordFilter(String[] words) {
        for(int index = 0;index<words.length;index++){
            String word = words[index];
            for(int i=0;i<word.length();i++){
                for(int j=0;j<word.length();j++){
                    String prefix = word.substring(0,i+1);
                    String suffix = word.substring(j);
                    
                    String preSuf = prefix + "#" + suffix;
                    map.put(preSuf,index);
                }
            }
        }
        
        System.out.println(map);
    }
    
    public int f(String prefix, String suffix) {
        String preSuf = prefix + "#" + suffix;
        return map.getOrDefault(preSuf,-1);
    }
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(prefix,suffix);
 */