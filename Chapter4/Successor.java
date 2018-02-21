package Chapter4;

public class Successor {
    public static void main(String[] args) {

    }

    public static TreeNode successor(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.getRight() != null) {
            return leftMostChild(root.getRight());
        } else {
            TreeNode q = n;
            TreeNode x = q.parent;
            while (x != null && x.getLeft() != q) {
                q = x;
                x = x.parent;
            }
            return x;
        }
    }

    private static TreeNode leftMostChild(TreeNode n) {
        if (n == null) {
            return null;
        }
        while (n.getLeft() != null) {
            n = n.getLeft();
        }
        return n;
    }
}