package Trees_and_Graphs;

public class CheckBalanced {
    static class TreeNode {
        private int data;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int d) {
            this.data = d;
            this.left = null;
            this.right = null;
        }

        public void setLeft(TreeNode left) {
            this.left = left;
        }

        public void setRight(TreeNode right) {
            this.right = right;
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
    }

    public int getHeight(TreeNode root) {
        if (root == null) {
            return -1;
        }
        return Math.max(getHeight(root.getLeft()), getHeight(root.getRight())) + 1;
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int heightDiff = getHeight(root.getLeft()) - getHeight(root.getRight());
        if (Math.abs(heightDiff) > 1) {
            return false;
        } else {
            return isBalanced(root.getLeft()) && isBalanced(root.getRight());
        }
    }
}
