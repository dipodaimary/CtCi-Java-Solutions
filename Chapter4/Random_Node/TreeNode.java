package Random_Node;

import java.util.Random;

public class TreeNode {
    public int data;
    public TreeNode left;
    public TreeNode right;
    private int size = 0;

    public TreeNode(int d) {
        data = d;
    }

    public void insertInOrder(int d) {
        if (d < this.data) {
            if (left == null) {
                left = new TreeNode(d);
            } else {
                left.insertInOrder(d);
            }
        }
        if (d > this.data) {
            if (right == null) {
                right = new TreeNode(d);
            } else {
                right.insertInOrder(d);
            }
        }
        size++;
    }

    public int size() {
        return size;
    }

    public TreeNode find(int d) {
        if (d == data) {
            return this;
        }
        if (d < this.data) {
            if (left == null) {
                return null;
            }
            left.find(d);
        }
        if (d > data) {
            if (right == null) {
                return null;
            }
            right.find(d);
        }
        return null;
    }

    public TreeNode getIthNode(int i) {
        int leftSize = left == null ? 0 : left.size();
        if (i < leftSize) {
            return left.getIthNode(i);
        } else if (i == leftSize) {
            return this;
        } else {
            return right.getIthNode(i - (leftSize + 1));
        }
    }

    public TreeNode getRandomNode() {
        int leftSize = left == null ? 0 : left.size();
        Random r = new Random();
        int i = r.nextInt(size);
        if (i < leftSize) {
            return left.getRandomNode();
        } else if (i == leftSize) {
            return this;
        } else {
            return right.getRandomNode();
        }
    }
}
