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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth<0)return root;
        if(depth==1){
            TreeNode node = new TreeNode(val);
            node.left = root;
            return node;
        }
        helper(root,val,depth);
        return root;
    }
    
    private void helper(TreeNode root , int val , int depth){
        if(root==null)return;
        
        if(depth==2){
            TreeNode left = new TreeNode(val);
            TreeNode right = new TreeNode(val);
            TreeNode l = root.left;
            TreeNode r = root.right;
            
            root.left = left;
            root.right = right;
            
            left.left = l;
            right.right = r;
    }else{
            helper(root.left,val,depth-1);
            helper(root.right,val,depth-1);
        }
    }
}