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
    int findLeftHeight(TreeNode node) {
        int count = 0;
        while(node.left != null) {
            node = node.left;
            count++;
        }
        return count;
    }

    int findRightHeight(TreeNode node) {
        int count = 0;
        while(node.right != null) {
            node = node.right;
            count++;
        }
        return count;
    }

    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        
        int lh = findLeftHeight(root);
        int rh = findRightHeight(root);
        
        if(lh == rh) {
            System.out.println("lh "+ lh);
            return (2<<lh) - 1;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}