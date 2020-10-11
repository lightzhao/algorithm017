import java.util.*;


/**
 * N叉树的前序遍历
 */
public class TreePreorder {


    static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }


    public static List<Integer> preorder(Node root) {

        if (root == null) {
            return Collections.emptyList();
        }
        Stack<Node> stack = new Stack<>();
        LinkedList<Integer> rs = new LinkedList<>();
        stack.push(root);
        while (!stack.empty()) {
            Node node = stack.pop();
            rs.add(node.val);
            Collections.reverse(node.children);
            for (Node item : node.children) {
                stack.push(item);
            }
        }
        return rs;
    }


    public static void main(String[] args) {
        Node n5 = new Node(5, Collections.emptyList());
        Node n2 = new Node(2, Collections.emptyList());
        Node n4 = new Node(4, Collections.emptyList());
        Node n6 = new Node(6, Collections.emptyList());
        List<Node> n3Child = new ArrayList<>();
        n3Child.add(n5);
        n3Child.add(n6);
        Node n3 = new Node(3, n3Child);
        List<Node> n1Child = new ArrayList<>();
        n1Child.add(n3);
        n1Child.add(n2);
        n1Child.add(n4);
        Node root = new Node(1, n1Child);

        // [1,3,5,6,2,4]。
        List<Integer> res = preorder(root);
        for (int i : res) {
            System.out.print(i + ",");
        }
    }
}
