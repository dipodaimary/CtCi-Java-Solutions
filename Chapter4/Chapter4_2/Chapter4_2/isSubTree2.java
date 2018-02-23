package Chapter4_2;

import Library.TreeNode;

public class isSubTree2 {
    public static void main(String[] args) {

    }

    public static boolean containsTree(TreeNode t1, TreeNode t2) {
        if (t2 == null) {
            return true;
        }
        return subtree(t1, t2);
    }

    private static boolean subtree(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return false;
        } else if (t1.data == t2.data && matchTree(t1, t2)) {
            return true;
        }
        return subtree(t1.left, t2) || subtree(t1.right, t2);
    }

    private static boolean matchTree(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        } else if (t1 == null || t2 == null) {
            return false;
        } else if (t1.data != t2.data) {
            return false;
        } else {
            return matchTree(t1.left, t2.left) && matchTree(t1.right, t2.right);
        }
    }
}
