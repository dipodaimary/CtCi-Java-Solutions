package Preparation.CapTech.PrintTreeNodesWithOnlyLeftNodes;

public class PrintNodes {
    public static void main(String[] args) {
        TreeNode[] nodes = new TreeNode[5];
        for (int i = 0; i < 5; i++) {
            nodes[i] = new TreeNode(i);
        }
        nodes[0].leftChild = nodes[1];
        nodes[2].leftChild = nodes[3];
        nodes[2].rightChild = nodes[4];
        System.out.println(countNodes(nodes[0]));
    }

    public static int countNodes(TreeNode root) {
        int count = 0;
        //base case
        if (root.leftChild == null || root.rightChild == null) {
            return count;
        }
        if (root.leftChild != null) {
            count++;
        }
        count += countNodes(root.leftChild);
        count += countNodes(root.rightChild);
        return count;
    }
}
