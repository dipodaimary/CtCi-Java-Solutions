package Chapter4;

import static Chapter4.MinTree.CreateMinBST;

public class CheckBalance2 {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        TreeNode root = CreateMinBST(array);
        System.out.println(isBalanced(root));
    }

    public static boolean isBalanced(TreeNode node) {
        return CheckHeight(node) != Integer.MIN_VALUE;
    }

    public static int CheckHeight(TreeNode root) {
        if (root == null) {
            return -1;
        }
        int leftHeight = CheckHeight(root.getLeft());
        if (leftHeight == Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        int rightHeight = CheckHeight(root.getRight());
        if (rightHeight == Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        int diffHeight = leftHeight - rightHeight;
        if (Math.abs(diffHeight) > 1) {
            return Integer.MIN_VALUE;
        } else {
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }
}
