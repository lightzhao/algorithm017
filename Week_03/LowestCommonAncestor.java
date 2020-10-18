import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LowestCommonAncestor {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    Map<Integer, TreeNode> parentMap = new HashMap<>();
    Set<Integer> visited = new HashSet<>();


    private void dfs(TreeNode treeNode) {
        if (treeNode.left != null) {
            parentMap.put(treeNode.left.val, treeNode);
            dfs(treeNode.left);
        }
        if (treeNode.right != null) {
            parentMap.put(treeNode.right.val, treeNode);
            dfs(treeNode.right);
        }
    }


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root);
        while (p != null) {
            visited.add(p.val);
            p = parentMap.get(p.val);
        }

        while (q != null) {
            if (visited.contains(q.val)) {
                return q;
            }
            q = parentMap.get(q.val);
        }
        return null;
    }
}
