package Chapter4Libraries;

public class TreeNode {
    public int data;
    public TreeNode left;
    public TreeNode right;
    public TreeNode parent;
    private int size = 0;

    public TreeNode(int d) {
        data = d;
        size = 1;
    }

    private void setLeftChild(TreeNode left) {
        this.left = left;
        if (left != null) {
            left.parent = this;
        }
    }

    private void setRightChild(TreeNode right) {
        this.right = right;
        if (right != null) {
            right.parent = this;
        }
    }

    public void insertInOrder(int d) {
        if (d <= this.data) {
            if (this.left == null) {
                setLeftChild(new TreeNode(d));
            } else {
                left.insertInOrder(d);
            }
            if (d > data) {
                if (right == null) {
                    setRightChild(new TreeNode(d));
                } else {
                    right.insertInOrder(d);
                }
            }
        }
        size++;
    }

    public boolean isBST() {
        if (left != null) {
            if (data < left.data || !left.isBST()) {
                return false;
            }
        }
        if (right != null) {
            if (data > right.data || !right.isBST()) {
                return false;
            }
        }
        return true;
    }

    public int getHeight() {
        int leftHeight = left != null ? left.getHeight() : 0;
        int rightHeight = right != null ? right.getHeight() : 0;
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public TreeNode find(int d) {
        if (data == d) {
            return this;
        } else if (d <= this.data) {
            return this.left != null ? left.find(d) : null;
        } else if (d > this.data) {
            return this.right != null ? right.find(d) : null;
        }
        return null;
    }

    public static TreeNode createMinimalBST(int array[]) {
        return createMinimalBST(array, 0, array.length - 1);
    }

    private static TreeNode createMinimalBST(int[] array, int start, int end) {
        if (end < start) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(array[mid]);
        root.setLeftChild(createMinimalBST(array, 0, mid - 1));
        root.setRightChild(createMinimalBST(array, mid + 1, end));
        return root;
    }
}
