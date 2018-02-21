package Chapter4;

import static Chapter4.MinTree.CreateMinBST;
import static Chapter4.MinTree.inOrder;

public class CheckBalance {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        TreeNode root = CreateMinBST(array);
        System.out.println(root);
        inOrder(root);
        System.out.println(isBalanceRecursive(root));
    }

    public static boolean isBalanceRecursive(TreeNode root) {
        if (root == null) {
            return true;
        }
        int heightDiff = getHeight(root.getLeft()) - getHeight(root.getRight());
        if (Math.abs(heightDiff) > 1) {
            return false;
        } else {
            return isBalanceRecursive(root.getRight()) && isBalanceRecursive(root.getLeft());
        }
    }

    public static int getHeight(TreeNode root) {
        if (root == null) {
            return -1;
        }
        return Math.max(getHeight(root.getLeft()), getHeight(root.getRight())) + 1;
    }
}
