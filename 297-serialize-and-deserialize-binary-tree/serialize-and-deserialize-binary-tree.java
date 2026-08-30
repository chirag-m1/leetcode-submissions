/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()) {
            TreeNode node = q.poll();
            if(node == null) {
                sb.append("n ");
                continue;
            }
            else {
                sb.append(node.val + " ");
            }
            q.offer(node.left);
            q.offer(node.right);
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null || data.length() == 0 || data.startsWith("n")) {
            return null;
        } 

        String[] nodes = data.split(" ");
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        q.offer(root);
        int i = 1;
        while(!q.isEmpty() && i < nodes.length - 1) {
            TreeNode node = q.poll();
            if(!nodes[i].equals("n")) {
                TreeNode left = new TreeNode(Integer.parseInt(nodes[i]));
                node.left = left;
                q.offer(left);
            }
            i++;
            if(i < nodes.length && !nodes[i].equals("n")) {
                TreeNode right = new TreeNode(Integer.parseInt(nodes[i]));
                node.right = right;
                q.offer(right);
            }
            i++;
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));