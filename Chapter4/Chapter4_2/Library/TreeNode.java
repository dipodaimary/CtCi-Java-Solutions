package Library;

public class TreeNode {
    public int data;
    public TreeNode left;
    public TreeNode right;
    public TreeNode parent;
    private int size;

    public TreeNode(int d) {
        this.data = d;
        this.size = 1;
    }

    public void setLeftChild(TreeNode node) {
        left = node;
        if (node != null) {
            node.parent = this;
        }
    }

    public void setRightChild(TreeNode node) {
        right = node;
        if (node != null) {
            node.parent = this;
        }
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
        int leftHeight = this.left != null ? left.getHeight() : 0;
        int rightHeight = this.right != null ? right.getHeight() : 0;
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public void insertInOrder(int d) {
        if (d < this.data) {
            if (this.left != null) {
                this.left.insertInOrder(d);
            } else {
                left = new TreeNode(d);
            }
            if (d > this.data) {
                if (this.right != null) {
                    this.right.insertInOrder(d);
                } else {
                    right = new TreeNode(d);
                }
            }
        }
    }

    public int getSize() {
        return size;
    }

    public TreeNode find(int d) {
        if (d == data) {
            return this;
        }
        if (d < data) {
            if (left != null) {
                left.find(d);
            }
        }
        if (d > data) {
            if (right != null) {
                right.find(d);
            }
        }
        return null;
    }

    public static TreeNode createMinBST(int[] arr) {
        int length = arr.length;
        TreeNode root = createMinBST(arr, 0, length - 1);
        return root;
    }

    private static TreeNode createMinBST(int[] arr, int start, int end) {
        if (end < start) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(arr[mid]);
        root.left = createMinBST(arr, start, mid - 1);
        root.right = createMinBST(arr, mid + 1, end);
        return root;
    }
}
