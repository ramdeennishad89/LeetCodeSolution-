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
    public TreeNode recoverFromPreorder(String S) {
         Stack<TreeNode> stack = new Stack<>();
        int i = 0;
        while (i < S.length()) {
            int level = 0;
            while (i < S.length() && S.charAt(i) == '-') {
                level++;
                i++;
            }
            int val = 0;
            while (i < S.length() && Character.isDigit(S.charAt(i))) {
                val = val * 10 + (S.charAt(i) - '0');
                i++;
            }
            TreeNode node = new TreeNode(val);
            while (stack.size() > level) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                TreeNode parent = stack.peek();
                if (parent.left == null) {
                    parent.left = node;
                } else {
                    parent.right = node;
                }
            }
            stack.push(node);
        }
        return stack.isEmpty() ? null : stack.get(0);
    }
}