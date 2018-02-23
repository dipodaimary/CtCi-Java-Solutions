package Chapter4_2;

import Library.TreeNode;

import java.util.Random;

public class isSubTree {
    public static void main(String[] args) {
        Random r = new Random();
        int[] arr1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] arr2 = {2, 3, 4, 5, 6, 7, 8};
        TreeNode root1 = TreeNode.createMinBST(arr1);
        TreeNode root2 = TreeNode.createMinBST(arr2);
        System.out.println(containsTree(root1, root2));

    }

    public static boolean containsTree(TreeNode node1, TreeNode node2) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        getOrderString(node1, sb1);
        getOrderString(node2, sb2);
        System.out.println(sb1.toString());
        System.out.println(sb2.toString());
        return sb1.indexOf(sb2.toString()) != -1;
    }

    private static void getOrderString(TreeNode node1, StringBuilder sb1) {
        if (node1 == null) {
            sb1.append('X');
            return;
        }
        sb1.append(node1.data + " ");
        getOrderString(node1.left, sb1);
        getOrderString(node1.right, sb1);
    }
}
