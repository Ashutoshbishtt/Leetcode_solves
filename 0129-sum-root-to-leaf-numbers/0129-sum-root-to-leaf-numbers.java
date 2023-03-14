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
    int sum;
    public int sumNumbers(TreeNode root) {
        sum=0;
        solve(root,0);
        return sum;
    }
    public void solve(TreeNode node,int s){
        if(node==null) return;
        s=s*10+node.val;
        if(node.left==null && node.right==null){
            sum+=s;
            return;
        }
        solve(node.left,s);
        solve(node.right,s);
    }
}