class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> all = new ArrayList<>();
        
        for(String word : wordDict){
            if(!s.startsWith(word))continue;
            
            if(s.length()==word.length()){
                all.add(word);
                continue;
            }
            
            for(String next : wordBreak(s.substring(word.length()),wordDict))
                all.add(word+" "+next);
        }
        return all;
    }
}