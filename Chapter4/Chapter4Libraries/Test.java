package Chapter4Libraries;
import java.util.Random;
import Chapter4Libraries.TreeNode;

public class Test {
    public static void main(String[] args) {
        Random r = new Random();
        int[] array = new int[10];
        for (int i = 0; i < 10; i++) {
            array[i] = r.nextInt() % 100;
        }
        TreeNode root = TreeNode.createMinimalBST(array);
        InOrderTraversal(root);
    }

    public static void InOrderTraversal(TreeNode node) {
        InOrderTraversal(node.left);
        System.out.print(node.data);
        System.out.print("-");
        InOrderTraversal(node.right);
    }
}
