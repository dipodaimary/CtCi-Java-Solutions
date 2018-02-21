package Chapter4;

import static Chapter4.MinTree.CreateMinBST;

public class CheckBSTMaxMin {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        TreeNode root = CreateMinBST(array);
        System.out.println(isBST(root));
    }

    public static boolean isBST(TreeNode root) {
        return isBST(root, null, null);
    }

    private static boolean isBST(TreeNode root, Integer min, Integer max) {
        if (root == null) {
            return true;
        }
        if ((min != null && root.getData() <= min) || (max != null && root.getData() > max)) {
            return false;
        }
        if (!isBST(root.getLeft(), min, root.getData()) || (!isBST(root.getRight(), root.getData(), max))) {
            return false;
        }
        return true;
    }
}
