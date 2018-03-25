package Trees_and_Graphs;

import Library.TreeNode;

import java.util.HashMap;

public class pathsWithSumOptimized {
    int countPathsWithSum(TreeNode root, int targetSum) {
        return countPathsWithSum(root, targetSum, 0, new HashMap<Integer, Integer>());
    }

    private int countPathsWithSum(TreeNode node, int targetSum, int runningSum, HashMap<Integer, Integer> pathCount) {
        if (node == null) return 0;//base case
        /*
        count paths with sum ending at current node
         */
        runningSum += node.getData();
        int sum = runningSum - targetSum;
        int totalPaths = pathCount.getOrDefault(sum, 0);
        /*
        If running sum equals targetSum, then one additional path starts at root
        add in this path
         */
        if (runningSum == targetSum) {
            totalPaths++;
        }
        /*
        Increment pathCount, recurse, then decrement pathCount
         */
        incrementHashTable(pathCount, runningSum, 1);//Increment pathCount
        totalPaths += countPathsWithSum(node.getLeft(), targetSum, runningSum, pathCount);
        totalPaths += countPathsWithSum(node.getRight(), targetSum, runningSum, pathCount);
        incrementHashTable(pathCount, runningSum, -1);
        return totalPaths;
    }

    private void incrementHashTable(HashMap<Integer, Integer> hashTable, int key, int delta) {
        int newCount = hashTable.getOrDefault(key, 0) + delta;
        if (newCount == 0) {
            /*
            remove when zero to reduce space usage
             */
            hashTable.remove(key);
        } else {
            hashTable.put(key, newCount);
        }
    }
}
