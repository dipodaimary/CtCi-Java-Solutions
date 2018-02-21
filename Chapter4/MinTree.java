package Chapter4;

public class MinTree {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        TreeNode root = CreateMinBST(array);
        System.out.println(root);
        inOrder(root);
    }

    public static TreeNode CreateMinBST(int[] arr) {
        return CreateMinBST(arr, 0, arr.length - 1);
    }

    private static TreeNode CreateMinBST(int[] arr, int i, int length) {
        if (i > length) {
            return null;
        }
        int mid = (i + length) / 2;
        TreeNode temp = new TreeNode(arr[mid]);
        temp.setLeft(CreateMinBST(arr, i, mid - 1));
        temp.setRight(CreateMinBST(arr, mid + 1, length));
        return temp;
    }

    public static void inOrder(TreeNode root) {
        if (root.getLeft() != null) {
            inOrder(root.getLeft());
        }
        System.out.println(root.getData());
        if (root.getRight() != null) {
            inOrder(root.getRight());
        }
    }
}


class TreeNode {
    private int data;
    TreeNode left;
    TreeNode right;

    public TreeNode(int x) {
        this.data = x;
        this.left = null;
        this.right = null;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public int getData() {
        return data;
    }

    public TreeNode getLeft() {
        return left;
    }

    public TreeNode getRight() {
        return right;
    }
}