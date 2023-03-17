class Trie {
    Trie[] children;
    boolean isEnd;

    public Trie() {
        this.children = new Trie[26];
    }

    public void insert(String word) {
        Trie curr = this;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (curr.children[index] == null) curr.children[index] = new Trie();

            curr = curr.children[index];
        }
        curr.isEnd = true;
    }

    public boolean search(String word) {
        Trie curr = this;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (curr.children[index] == null) return false;
            curr = curr.children[index];
        }

        return curr.isEnd;
    }

    public boolean startsWith(String word) {
        Trie curr = this;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';

            if (curr.children[index] == null) return false;

            curr = curr.children[index];
        }

        return true;
    }
}
/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
/*




 */
