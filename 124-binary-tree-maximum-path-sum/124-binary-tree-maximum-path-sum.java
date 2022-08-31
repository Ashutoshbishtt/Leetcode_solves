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
    public int maxPathSum(TreeNode root) {
        if(root==null)return 0;
        if(root.left==null && root.right == null)return root.val;
        int[] maxSum = new int[1];
        maxSum[0] = Integer.MIN_VALUE;

        bringMeTheMaxSum(root,maxSum);
        
        return maxSum[0];
    }
    
    private int bringMeTheMaxSum(TreeNode root,int[] max){
        
        if(root==null)return 0;
        
        int leftSum = Math.max(0,bringMeTheMaxSum(root.left,max));
        int rightSum = Math.max(0,bringMeTheMaxSum(root.right,max));
        
        max[0]=Math.max(root.val+leftSum+rightSum,max[0]);
        
        return Math.max(leftSum+root.val,rightSum+root.val);
    }
}