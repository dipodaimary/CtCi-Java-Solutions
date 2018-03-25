package Trees_and_Graphs;

import Library.TreeNode;

public class PathsWithSum {
    public int countPathsWithSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        /*
        Count paths with sum starting from the root
         */
        int pathsFromRoot = countPathsWithSumFromNode(root, targetSum, 0);
        /*
        Try nodes on the left and right
         */
        int pathsOnLeft = countPathsWithSum(root.getLeft(), targetSum);
        int pathsOnRight = countPathsWithSum(root.getRight(), targetSum);
        return pathsFromRoot + pathsOnLeft + pathsOnRight;
    }

    /*
    Returns the number of paths with this sum starting from this node
     */
    private int countPathsWithSumFromNode(TreeNode node, int targetSum, int currentSum) {
        if (node == null) return 0;
        currentSum += node.getData();
        int totalPaths = 0;
        if (currentSum == targetSum) {
            totalPaths++;
        }
        totalPaths += countPathsWithSumFromNode(node.getLeft(), targetSum, currentSum);
        totalPaths += countPathsWithSumFromNode(node.getRight(), targetSum, currentSum);
        return totalPaths;
    }
}
