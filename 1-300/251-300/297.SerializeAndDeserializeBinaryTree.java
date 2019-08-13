297. Serialize and Deserialize Binary Tree
Hard

Serialization is the process of converting a data structure or object into a sequence of bits 
so that it can be stored in a file or memory buffer, or transmitted across a network connection link 
to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary tree.
There is no restriction on how your serialization/deserialization algorithm should work. 
You just need to ensure that a binary tree can be serialized to a string 
and this string can be deserialized to the original tree structure.

Example: 
You may serialize the following tree:

    1
   / \
  2   3
     / \
    4   5

as "[1,2,3,null,null,4,5]"
Clarification: The above format is the same as how LeetCode serializes a binary tree.
You do not necessarily need to follow this format, 
so please be creative and come up with different approaches yourself.

Note: Do not use class member/global/static variables to store states. 
Your serialize and deserialize algorithms should be stateless.

Accepted 204,241 Submissions 486,103

Answer:
//两种方法都要掌握，一种iterative，一种recursive
public class Codec {
    public String serialize(TreeNode root) {
        if(root == null) return "";
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node == null) {
                sb.append("null ");
            } else {
                queue.offer(node.left);
                queue.offer(node.right);
                sb.append(node.val + " ");
            }
        }
        return sb.toString();
    }

    public TreeNode deserialize(String data) {
        if (data == "") return null;
        String[] values = data.split(" ");
        TreeNode root = new TreeNode(Integer.valueOf(values[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        for(int i = 1; i < values.length; i++){
            TreeNode node = queue.poll();
            if(!values[i].equals("null")) {
                TreeNode left = new TreeNode(Integer.valueOf(values[i]));
                node.left = left;
                queue.offer(left);
            }
            //之前按照一对一对加进来的，所以这里不会溢出
            i++;
            if(!values[i].equals("null")) {
                TreeNode right = new TreeNode(Integer.valueOf(values[i]));
                node.right = right;
                queue.offer(right);
            }
        }
        return root;
    }
}


public class Codec {
    public String serialize(TreeNode root) {
        return serial(new StringBuilder(), root).toString();
    }
    
    private StringBuilder serial(StringBuilder str, TreeNode root) {
        if (root == null) return str.append("null");
        str.append(root.val).append(" ");
        serial(str, root.left).append(" ");
        serial(str, root.right);
        return str;
    }

    public TreeNode deserialize(String data) {
        return deserial(new LinkedList<>(Arrays.asList(data.split(" "))));
    }
    
    private TreeNode deserial(Queue<String> q) {
        String val = q.poll();
        if ("null".equals(val)) return null;
        TreeNode root = new TreeNode(Integer.valueOf(val));
        root.left = deserial(q);
        root.right = deserial(q);
        return root;
    }
}
