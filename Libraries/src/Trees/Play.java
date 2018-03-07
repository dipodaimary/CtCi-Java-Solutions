package Trees;

public class Play {
    public static void main(String[] args) {
        int a[] = {1, 2, 3, 4, 5, 6, 7, 8};
        TreeNode root = TreeNode.createMinBST(a);
        TreeNode.printInOrder(root);
    }
}