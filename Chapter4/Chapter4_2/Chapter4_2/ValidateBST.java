package Chapter4_2;

import Library.TreeNode;

public class ValidateBST {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        TreeNode root = TreeNode.createMinBST(arr);
        System.out.println(isBST(root));
    }

    public static boolean isBST(TreeNode root) {
        return isBST(root, null, null);
    }

    private static boolean isBST(TreeNode root, Integer min, Integer max) {
        if (root == null) {
            return true;
        }
        if ((min != null && root.data <= min) || (max != null && root.data > max)) {
            return false;
        }
        if (!isBST(root.left, min, root.data) || !isBST(root.right, root.data, max)) {
            return false;
        }
        return true;
    }
}
