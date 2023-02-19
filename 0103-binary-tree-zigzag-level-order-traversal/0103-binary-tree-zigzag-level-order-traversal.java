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
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root==null)return ans;
        q.offer(root);
        boolean posOrNeg=false;
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> subAns = new ArrayList<>(size);
            
            for(int i = 0 ; i < size ; i++){
                TreeNode front = q.peek();
                if(front.left!=null)q.offer(front.left);
                if(front.right!=null)q.offer(front.right);
                if(posOrNeg==false)subAns.add(q.poll().val);
                else subAns.add(0,q.poll().val);
            }
            if(posOrNeg==false)posOrNeg=true;
            else posOrNeg=false;
            ans.add(subAns);
        }
        return ans;
    }
}