/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        Queue<Node> q = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();
        if(root==null)return ans;
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> sAns = new ArrayList<>();
            for(int i = 0 ; i < size ; i++){
                Node front = q.poll();
                for(Node el : front.children){
                    q.add(el);
                }
                sAns.add(front.val);
            }
            ans.add(sAns);
        }
        return ans;
    }
}