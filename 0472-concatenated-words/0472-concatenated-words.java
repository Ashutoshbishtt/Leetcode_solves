class Solution {
    private Set<String>seen;
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        seen = new HashSet<>(List.of(words));
        List<String> concat = new ArrayList<>();
        for(String word : words){
            if(backtrack(word,0))concat.add(word);
        }
        return concat;
    }
    private boolean backtrack(String word , int count){
        if(word.length()==0 && count>=2)return true;
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < word.length() ; i++){
            sb.append(word.charAt(i));
            if(seen.contains(sb.toString()) && backtrack(word.substring(i+1),count+1))return true;
        } 
        return false;
    }
}