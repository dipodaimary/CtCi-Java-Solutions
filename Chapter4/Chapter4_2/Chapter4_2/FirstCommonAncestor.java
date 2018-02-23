package Chapter4_2;

import Library.TreeNode;

public class FirstCommonAncestor {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        TreeNode root = TreeNode.createMinBST(arr);
        System.out.println(root.right.data);
        System.out.println(root.left.left.data);
        System.out.println(root.right.left.data);
        System.out.println(commonAncestor(root.left.left, root.left.right).data);
    }

    public static TreeNode commonAncestor(TreeNode p, TreeNode q) {
        int delta = depth(p) - depth(q);
        TreeNode first = delta > 0 ? q : p;
        TreeNode second = delta <= 0 ? p : q;
        second = goUpBy(second, Math.abs(delta));
        while (first != null && second != null && first != second) {
            first = first.parent;
            second = second.parent;
        }
        return (first == null || second == null) ? null : first;
    }

    public static int depth(TreeNode node) {
        int depth = 0;
        while (node != null) {
            node = node.parent;
            depth++;
        }
        return depth;
    }

    public static TreeNode goUpBy(TreeNode node, int delta) {
        while (node != null && delta > 0) {
            node = node.parent;
            delta--;
        }
        return node;
    }
}
