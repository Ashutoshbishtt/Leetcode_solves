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

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        Map<String, Integer> frequency = new HashMap<>();
        List<TreeNode> result = new ArrayList<>();
        findDuplicates(root, frequency, result);
        return result;
    }

    private String findDuplicates(TreeNode node, Map<String, Integer> frequency, List<TreeNode> result) {
        if (node == null) {
            return "#";
        }

        String leftIdentifier = findDuplicates(node.left, frequency, result);
        String rightIdentifier = findDuplicates(node.right, frequency, result);

        String identifier = node.val + "," + leftIdentifier + "," + rightIdentifier;
        frequency.put(identifier, frequency.getOrDefault(identifier, 0) + 1);

        if (frequency.get(identifier) == 2) {
            result.add(node);
        }

        return identifier;
    }
}
