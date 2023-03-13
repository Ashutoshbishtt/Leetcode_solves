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
    public boolean isSymmetric(TreeNode root) {
       return getAns(root.left , root.right);
    }
    
    private static boolean getAns(TreeNode left , TreeNode right){
        if(left == null && right ==null)return true;
        if(left==null || right == null)return false;
        if(left.val!=right.val){
            return false;
        }
        
        boolean one = getAns(left.left,right.right);
        boolean two = getAns(left.right,right.left);
        
        return one && two;
    }
}