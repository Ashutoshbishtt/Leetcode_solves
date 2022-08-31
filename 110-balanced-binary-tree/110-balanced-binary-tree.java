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
    public boolean isBalanced(TreeNode root) {
        if(root==null)return true;

        boolean left = isBalanced(root.left);
        boolean right = isBalanced(root.right);
        
        if(left ==false || right == false)return false;
        else{
            int leftHeight=height(root.left);
            int rightHeight=height(root.right);
            
            if(Math.abs(leftHeight-rightHeight)>1){
                return false;
            }
            return true;   
        }
    }
    private int height(TreeNode root){
        if(root==null)return 0;
        
        int leftH=height(root.left);
        int rightH=height(root.right);
        
        return 1+Math.max(leftH,rightH);
    }
}