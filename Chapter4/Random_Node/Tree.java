package Random_Node;

import java.util.Random;

public class Tree {
    TreeNode root = null;

    public void insertInOrder(int d) {
        if (root == null) {
            root = new TreeNode(d);
        } else {
            root.insertInOrder(d);
        }
    }

    public int size() {
        return root == null ? 0 : root.size();
    }

    public TreeNode getRandomNode() {
        if (root == null) {
            return null;
        }
        Random r = new Random();
        int i = r.nextInt(size());
        return root.getIthNode(i);
    }
}
