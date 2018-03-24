package Library;

public class TreeNode {
    private int data;
    private TreeNode left;
    private TreeNode right;
    private TreeNode parent;
    private int size = 0;

    public TreeNode(int d) {
        this.data = d;
    }

    public void setLeft(TreeNode n) {
        this.left = n;
        if (left != null) {
            left.parent = this;
        }
    }

    public void setRight(TreeNode n) {
        this.right = n;
        if (right != null) {
            right.parent = this;
        }
    }

    public void insertInOrder(int d) {
        if (d <= this.data) {
            if (left != null) {
                left.insertInOrder(d);
            } else {
                left = new TreeNode(d);
            }
        } else if (d > this.data) {
            if (right != null) {
                right.insertInOrder(d);
            } else {
                right = new TreeNode(d);
            }
        }
        size++;
    }

    public int size() {
        return size;
    }

    public boolean isBST() {
        if (left != null) {
            if (left.data >= this.data || !left.isBST()) {
                return false;
            } else if (right.data < this.data || !right.isBST()) {
                return false;
            }
        }
        return true;
    }

    public int height() {
        int leftHeight = left != null ? left.height() : 0;
        int rightHeight = right != null ? right.height() : 0;
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public TreeNode find(int d) {
        if (d == this.data) {
            return this;
        } else if (d < this.data) {
            return left != null ? left.find(d) : null;
        } else if (d > this.data) {
            return right != null ? right.find(d) : null;
        }
        return null;
    }

    public TreeNode createMinBST(int[] arr) {
        return createMinBST(arr, 0, arr.length - 1);
    }

    private TreeNode createMinBST(int[] arr, int start, int end) {
        if (end < start) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(arr[mid]);
        root.left = createMinBST(arr, 0, mid - 1);
        root.right = createMinBST(arr, mid + 1, end);
        return root;
    }

    public int getData() {
        return data;
    }

    public TreeNode getLeft() {
        return left;
    }

    public TreeNode getRight() {
        return right;
    }

    public TreeNode getParent() {
        return parent;
    }

    public int getSize() {
        return size;
    }
}
