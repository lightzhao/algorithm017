import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class InorderTraversal {


    public static void main(String[] args) {

    }


    public List<Integer> inorderRecursion(TreeNode root) {
        if (root == null)
            return Collections.emptyList();
        List<Integer> list = new LinkedList<>();
        inorderResu(root, list);
        return list;
    }

    public List<Integer> inorderTranversal(TreeNode root) {
        if (root == null)
            return Collections.emptyList();
        Stack<TreeNode> stack = new Stack<>();
        List rs = new LinkedList();
        while (!stack.empty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            rs.add(root.val);
            root = root.right;
        }
        return rs;
    }


    public void inorderResu(TreeNode root, List<Integer> list) {
        inorderResu(root.left, list);
        list.add(root.val);
        inorderResu(root.right, list);
    }


    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
