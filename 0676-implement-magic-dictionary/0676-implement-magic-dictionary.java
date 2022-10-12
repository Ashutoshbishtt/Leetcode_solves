class MagicDictionary {

    class TrieNode{
        boolean isWord;
        TrieNode[] children;
        
        public TrieNode(){
            isWord = false;
            children = new TrieNode[26];
        }
    }
    TrieNode root;
    public MagicDictionary() {
        root = new TrieNode();
    }
    
    public void buildDict(String[] dictionary) {
        for(String word : dictionary){
            TrieNode temp = root;
            int len = word.length();
            for(int i = 0 ; i < len ; i++){
                char c = word.charAt(i);
                if(temp.children[c-'a']==null)temp.children[c-'a'] = new TrieNode();
                temp = temp.children[c-'a'];
            }
            temp.isWord = true;
        }
    }
    
    public boolean search(String word) {
        TrieNode temp = root;
        int len = word.length();
        for(int i = 0; i < len ; i++){
            char c = word.charAt(i);
            for(int j = 0 ; j < 26 ; j++){
                if((char)(j+'a')==c || temp.children[j]==null)continue;
                if(helper(temp.children[j],word,i+1))return true;
            }
            if(temp.children[c-'a']==null)return false;
            temp = temp.children[c-'a'];
        }
        return false;
    }
    private boolean helper(TrieNode temp , String word , int index){
        int len = word.length();
        for(int i = index ; i<len ; i++){
            char c = word.charAt(i);
            if(temp.children[c-'a']==null)return false;
            temp=temp.children[c-'a'];
        }
        return temp.isWord;
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dictionary);
 * boolean param_2 = obj.search(searchWord);
 */