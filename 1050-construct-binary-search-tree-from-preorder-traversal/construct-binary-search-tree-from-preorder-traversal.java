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
    TreeNode bst(int[] i, int[] preorder, int ub) {
        if(i[0] == preorder.length || preorder[i[0]] > ub) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[i[0]++]);
        root.left = bst(i, preorder, root.val);
        root.right = bst(i, preorder, ub);
        return root;
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        return bst(new int[]{0}, preorder, Integer.MAX_VALUE);
    }
}