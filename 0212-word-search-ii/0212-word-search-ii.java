class Node {
    HashMap<Character, Node> children;
    boolean isEnd;
    String word;
    Node() {
        this.children = new HashMap<>();
        this.isEnd = false;
        this.word = null;
    }
}
class Trie {
    Node root;
    Trie() {
        this.root = new Node();
    }
    
    public void insert(String word) {
        Node curr = this.root;
        for(char ch : word.toCharArray()) {
            if(!curr.children.containsKey(ch))
                curr.children.put(ch, new Node());
            curr = curr.children.get(ch);
        }
        curr.isEnd = true;
        curr.word = word;
    }
}

class Solution {
    
    public List<String> findWords(char[][] board, String[] words) {
        
        List<String> result = new ArrayList<>();
        
        Trie trie = new Trie();
        for(String word : words) {
            trie.insert(word);
        }
        
        Node curr = trie.root;
        int rows = board.length, cols = board[0].length;
		
        for(int i=0;i<rows;i++) {
            for(int j=0;j<cols;j++) {
                if(curr.children.containsKey(board[i][j])) {
                    dfs(board, curr, rows, cols, i, j, result);
                }
            }
        }
        return result;
    }
    private void dfs(char[][]board, Node curr, int rows, int cols, int i, int j, List<String> result) {
	
        if(curr!=null && curr.isEnd && curr.word!=null) {
            result.add(curr.word);
            // there could be multiple paths in matrix that yield to same word, hence, remove 
            curr.word = null;
        }
		
        boolean isCurrentCellSafe = isSafe(board, curr, rows, cols, i, j);
        
        if(isCurrentCellSafe) {
            char org = board[i][j];
            board[i][j] = '*';
            dfs(board, curr.children.get(org), rows, cols, i-1, j, result);
            dfs(board, curr.children.get(org), rows, cols, i+1, j, result);
            dfs(board, curr.children.get(org), rows, cols, i, j-1, result);
            dfs(board, curr.children.get(org), rows, cols, i, j+1, result);
            board[i][j] = org;
        }
    }
    private boolean isSafe(char[][]board, Node curr, int rows, int cols, int i, int j) {
        if(i>=0 && i<rows && j>=0 && j<cols && curr!=null && curr.children.containsKey(board[i][j]))
            return true;
        return false;
    }
}
