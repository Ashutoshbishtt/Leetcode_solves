/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Nod{
    TreeNode node;
    int index;
    Nod(TreeNode node,int index){
        this.node = node;
        this.index=index;
    }
}
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        int ans=0;
        Queue<Nod> q = new LinkedList<>();
        q.offer(new Nod(root,0));
        while(!q.isEmpty()){
            int size = q.size();
            int minMinus = q.peek().index;
            int start = 0;
            int end = 0;
            
            for(int i = 0 ; i < size ; i++){
                TreeNode front = q.peek().node;
                int index = q.peek().index-minMinus;
                if(i==0)start=index;
                if(i==size-1)end=index;
                if(q.peek().node.left!=null){
                    q.offer(new Nod(q.peek().node.left,index*2+1));
                }
                if(q.peek().node.right!=null){
                    q.offer(new Nod(q.peek().node.right,index*2+2));
                }
                q.poll();
            }
            ans = Math.max(ans,end-start+1);
        }
        return ans;
    }
}