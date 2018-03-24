package Trees_and_Graphs;

public class MinTree {
    public void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        TreeNode n = createMinBST(arr);
        inOrder(n);
    }

    class TreeNode {
        private int data;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

        public void setLeft(TreeNode n) {
            this.left = n;
        }

        public void setRight(TreeNode n) {
            this.right = n;
        }

        public TreeNode getLeft() {
            return left;
        }

        public TreeNode getRight() {
            return right;
        }

        public int getData() {
            return this.data;
        }
    }

    public TreeNode createMinBST(int[] arr) {
        return createMinBST(arr, 0, arr.length - 1);
    }

    private TreeNode createMinBST(int[] arr, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode temp = new TreeNode(arr[mid]);
        temp.setLeft(createMinBST(arr, start, mid - 1));
        temp.setRight(createMinBST(arr, mid + 1, end));
        return temp;
    }

    public static void inOrder(TreeNode n) {
        if (n.getLeft() != null) {
            inOrder(n.getLeft());
        }
        System.out.println(n.getData());
        if (n.getRight() != null) {
            inOrder(n.getRight());
        }
    }
}
