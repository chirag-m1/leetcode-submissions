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
    TreeNode buildTree(int[] preorder, int ps, int pe, int is, int ie, Map<Integer, Integer> map) {
        if(ps > pe || is > ie) return null;

        TreeNode root = new TreeNode(preorder[ps]);
        int rootIndex = map.get(root.val);
        int lc = rootIndex - is;
        
        root.left = buildTree(preorder, ps + 1, ps + lc, is, rootIndex - 1, map);
        root.right = buildTree(preorder, ps + lc + 1, pe, rootIndex + 1, ie, map);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(preorder, 0, preorder.length - 1, 0, inorder.length - 1, map);
    }
}