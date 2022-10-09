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
    public boolean findTarget(TreeNode root, int k) {
        HashSet<Integer> hash = new HashSet<>();
        
        return findTarget(root,k,hash);
    }
    
    private boolean findTarget(TreeNode root , int k , HashSet<Integer> hash){
        if(root==null) return false;
        
        if(hash.contains(k-root.val)){
            return true;
        }
        
        hash.add(root.val);
        return findTarget(root.left,k,hash) || findTarget(root.right,k,hash);
    }
}