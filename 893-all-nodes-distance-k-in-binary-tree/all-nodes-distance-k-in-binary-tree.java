/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    void findNodesDFS(TreeNode node, int k, ArrayList<Integer> ans, HashSet<TreeNode> visited, HashMap<TreeNode, TreeNode> parent) {
        if(node == null || visited.contains(node) || k < 0) {
            return;
        }
        visited.add(node);


        if(k == 0) {
            ans.add(node.val);
            return;
        }
        TreeNode par = parent.get(node);
        if(par != null) {
            findNodesDFS(par, k-1, ans, visited, parent);
        }
        if(node.left != null) {
            findNodesDFS(node.left, k-1, ans, visited, parent);
        }
        if(node.right != null) {
            findNodesDFS(node.right, k-1, ans, visited, parent);
        }
    }
    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        HashMap<TreeNode, TreeNode> parent = new HashMap<>();
        parent.put(root, null);

        while(!q.isEmpty()) {
            TreeNode node = q.poll();
            if(node.left != null) {
                q.offer(node.left);
                parent.put(node.left, node);
            }
            if(node.right != null) {
                q.offer(node.right);
                parent.put(node.right, node);
            }
        }   

        ArrayList<Integer> ans = new ArrayList<>();
        HashSet<TreeNode> visited = new HashSet<>();
        findNodesDFS(target, k, ans, visited, parent);
        return ans;
    }
}