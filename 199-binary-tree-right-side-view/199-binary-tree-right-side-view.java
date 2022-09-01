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
    public List<Integer> rightSideView(TreeNode root) {
         ArrayList<Integer> ans = new ArrayList<Integer>();
        return rightSideViewHelper(root,0,ans);
    }
    private List<Integer> rightSideViewHelper(TreeNode root , int height,ArrayList<Integer> ans){
        if(root==null)return ans;
        
        if(ans.size()==height)ans.add(root.val);
        if(root.right!=null)rightSideViewHelper(root.right,height+1,ans);
        if(root.left!=null)rightSideViewHelper(root.left,height+1,ans);
        
        return ans;
    }
}