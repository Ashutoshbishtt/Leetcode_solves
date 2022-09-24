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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        getAns(root,targetSum,0,ans,new ArrayList<>());
        return ans;
    }
    private void getAns(TreeNode root, int target , int sum , List<List<Integer>> ans , List<Integer> subAns){
        if(root==null)return;
        sum+=root.val;
        if(sum==target){
            if(root.left==null && root.right==null){
                subAns.add(root.val);
                ans.add(new ArrayList<>(subAns));
                subAns.remove(subAns.size()-1);
                return;
            }
        }
        subAns.add(root.val);
        getAns(root.left,target,sum,ans,subAns);
        getAns(root.right,target,sum,ans,subAns);
        subAns.remove(subAns.size()-1);
        
    }
}