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
class Pair {
    TreeNode node;
    int num;
    Pair(TreeNode node, int num) {
        this.node = node;
        this.num = num;
    }
}
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 1));
        int maxWidth = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            int mini = q.peek().num;
            int first = 0, last = 0;
            for(int i = 0; i < size; i++) {
                Pair p = q.poll();
                int cur_i = p.num - mini;
                if(i == 0) {
                    first = p.num;
                }
                if(i == size - 1) {
                    last = p.num;
                }
                if(p.node.left != null) {
                    q.offer(new Pair(p.node.left, 2 * cur_i + 1));
                }
                if(p.node.right != null) {
                    q.offer(new Pair(p.node.right, 2 * cur_i + 2));
                }
            }
            maxWidth = Math.max(maxWidth, last - first + 1);
        }
        return maxWidth;
    }
}