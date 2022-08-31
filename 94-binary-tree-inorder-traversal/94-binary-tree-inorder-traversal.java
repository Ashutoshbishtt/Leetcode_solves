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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        
        TreeNode node=root;
        
        while(true){
            if(node!=null){
                st.add(node);
                node=node.left;
            }else{
                if(st.isEmpty()){
                    break;
                }
                node = st.pop();
                ans.add(node.val);
                node=node.right;
            }
        }
        return ans;
    }
}