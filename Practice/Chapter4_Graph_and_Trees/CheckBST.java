package Trees_and_Graphs;

public class CheckBST {
    static class TreeNode {
        private int data;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int d) {
            this.data = d;
            this.left = null;
            this.right = null;
        }

        public TreeNode getLeft() {
            return left;
        }

        public int getData() {
            return data;
        }

        public TreeNode getRight() {
            return right;
        }

        public void setLeft(TreeNode left) {
            this.left = left;
        }

        public void setRight(TreeNode right) {
            this.right = right;
        }
    }

    public boolean checkBST(TreeNode root) {
        return checkBST(root, null, null);
    }

    private boolean checkBST(TreeNode root, Integer min, Integer max) {
        if (root == null) {
            return true;
        }
        if ((min != null && root.getData() <= min) || (max != null && root.getData() > max)) {
            return false;
        }
        if (!checkBST(root.getLeft(), min, root.getData()) || !checkBST(root.getRight(), root.getData(), max)) {
            return false;
        }
        return true;
    }
}

