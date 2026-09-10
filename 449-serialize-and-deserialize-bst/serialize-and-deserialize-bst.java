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
        if(root == null) {
            return "";
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty()) {
            TreeNode node = q.poll();
            if(node == null) {
                sb.append("n ");
                continue;
            }
            sb.append(node.val + " ");
            q.offer(node.left);
            q.offer(node.right);
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.isEmpty()) return null;

        Queue<TreeNode> q = new LinkedList<>();
        String[] nodes = data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        q.offer(root);
        
        int i = 1;
        while(i < nodes.length && !q.isEmpty()) {
            TreeNode node = q.poll();
            if(!nodes[i].equals("n")) {
                node.left = new TreeNode(Integer.parseInt(nodes[i]));
                q.offer(node.left);
            }

            i++;

            if(i < nodes.length && !nodes[i].equals("n")) {
                node.right = new TreeNode(Integer.parseInt(nodes[i]));
                q.offer(node.right);
            }
            i++;
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;