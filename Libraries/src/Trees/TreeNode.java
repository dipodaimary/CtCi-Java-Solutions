package Trees;

public class TreeNode {
    public int data;
    public TreeNode leftChild;
    public TreeNode rightChild;
    public TreeNode parent;
    public int size = 0;

    public TreeNode(int d) {
        data = d;
        size = 1;
    }

    public void setLeftChild(TreeNode left) {
        this.leftChild = left;
        if (left != null) {
            left.parent = this;
        }
    }

    public void setRightChild(TreeNode right) {
        this.rightChild = right;
        if (right != null) {
            right.parent = this;
        }
    }

    public void insertInOrder(int d) {
        if (d <= this.data) {
            if (this.leftChild == null) {
                this.leftChild = new TreeNode(d);
            } else {
                this.leftChild.insertInOrder(d);
            }
        }
        if (d > this.data) {
            if (this.rightChild == null) {
                this.rightChild = new TreeNode(d);
            } else {
                this.rightChild.insertInOrder(d);
            }
        }
        size++;
    }

    public int size() {
        return size;
    }

    public int height() {
        int leftHeight = leftChild != null ? leftChild.height() : 0;
        int rightHeight = rightChild != null ? rightChild.height() : 0;
        return 1 + Math.max(leftHeight, rightHeight);
    }

    public boolean isBST() {
        if (leftChild != null) {
            if (data < leftChild.data || !leftChild.isBST()) {
                return false;
            }
        }
        if (rightChild != null) {
            if (data > rightChild.data || !rightChild.isBST()) {
                return false;
            }
        }
        return true;
    }

    public TreeNode find(int d) {
        if (d == data) {
            return this;
        }
        if (d < data) {
            leftChild.find(d);
        }
        if (d > data) {
            rightChild.find(d);
        }
        return null;
    }

    public static TreeNode createMinBST(int[] arr) {
        return createMinBST(arr, 0, arr.length - 1);
    }

    private static TreeNode createMinBST(int[] arr, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(arr[mid]);
        root.leftChild = createMinBST(arr, start, mid - 1);
        root.rightChild = createMinBST(arr, mid + 1, end);
        return root;
    }

    public static void printInOrder(TreeNode root) {
        if (root.leftChild != null) {
            printInOrder(root.leftChild);
        }
        System.out.println(root.data);
        if (root.rightChild != null) {
            printInOrder(root.rightChild);
        }
    }
}
