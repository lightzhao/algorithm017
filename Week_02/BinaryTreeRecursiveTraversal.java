import java.util.LinkedList;
import java.util.List;

/**
 * 树的三种遍历
 * 前序：根左右
 * 中序：左根右
 * 后续：左右根
 */
public class BinaryTreeRecursiveTraversal {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {

        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t4 = new TreeNode(4);
        t4.left = t1;
        t4.right = t2;

        TreeNode t7 = new TreeNode(7);
        TreeNode t8 = new TreeNode(8);
        TreeNode t6 = new TreeNode(6);
        t6.left = t7;
        t6.right = t8;


        TreeNode root = new TreeNode(5);
        root.left = t4;
        root.right = t6;

        List<Integer> res = new LinkedList<>();
//        preorder(root, res);
//        inorder(root, res);
        postorder(root, res);
        for (int r : res) {
            System.out.print(r + ",");
        }

    }

    /**
     * 5 4 1 2 6 7 8
     * 前序
     *
     * @param treeNode
     * @param res
     */
    public static void preorder(TreeNode treeNode, List<Integer> res) {
        if (treeNode == null)
            return;
        res.add(treeNode.val);
        preorder(treeNode.left, res);
        preorder(treeNode.right, res);
    }

    /**
     * 1 4 2 5 7 6 8
     * 中序
     *
     * @param treeNode
     * @param res
     */
    public static void inorder(TreeNode treeNode, List<Integer> res) {
        if (treeNode == null)
            return;
        inorder(treeNode.left, res);
        res.add(treeNode.val);
        inorder(treeNode.right, res);
    }

    /**
     * 后序
     *
     * @param treeNode
     * @param res
     */
    public static void postorder(TreeNode treeNode, List<Integer> res) {
        if (treeNode == null)
            return;
        postorder(treeNode.left, res);
        postorder(treeNode.right, res);
        res.add(treeNode.val);
    }


}

