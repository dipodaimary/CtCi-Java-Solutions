package Chapter4_2;

import Library.TreeNode;

import java.util.Random;

import static Library.TreeNode.createMinBST;


public class Test {
    public static void main(String[] args) {
        Random r = new Random();
        int[] arr = new int[10];
        for (int i = 0; i < 10; i++) {
            arr[i] = Math.abs(r.nextInt()) % 100;
        }
        TreeNode root = createMinBST(arr);
        inOrder(root);
    }

    public static void inOrder(TreeNode root) {
        if (root.left != null) inOrder(root.left);
        System.out.print(root.data);
        System.out.print(" ");
        if (root.right != null) inOrder(root.right);
    }
}
