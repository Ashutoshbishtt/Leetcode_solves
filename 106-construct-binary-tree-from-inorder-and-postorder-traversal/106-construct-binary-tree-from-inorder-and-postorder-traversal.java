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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder==null || postorder==null || inorder.length!=postorder.length){
            return null;
        }
        
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        
        return buildTreeHelper(inorder,0,inorder.length-1,postorder,0,postorder.length-1,map);
    }
    private static TreeNode buildTreeHelper(int[] inorder, int is , int ie, int[] postorder,int ps , int pe , HashMap<Integer,Integer> map){
        
        if(is>ie || ps>pe ) return null;
        
        TreeNode root = new TreeNode(postorder[pe]);
        int ri = map.get(postorder[pe]);
        
        root.left=buildTreeHelper(inorder,is,ri-1,postorder,ps,ps+ri-1-is,map);
        root.right=buildTreeHelper(inorder,ri+1,ie,postorder,ri+ps-is,pe-1,map);
        return root;
    }
    
}