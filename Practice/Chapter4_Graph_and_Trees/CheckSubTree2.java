package Trees_and_Graphs;

import Library.TreeNode;

//Alternative approach
public class CheckSubTree2 {
    boolean containsTree(TreeNode t1, TreeNode t2) {
        if (t2 == null) {
            return true;
        }
        return subTree(t1, t2);
    }

    private boolean subTree(TreeNode r1, TreeNode r2) {
        if (r1 == null) {
            return false;//big tree empty subtree still not found
        } else if (r1.getData() == r2.getData() && matchTree(r1, r2)) {
            return true;
        }
        return subTree(r1.getLeft(), r2) || subTree(r1.getRight(), r2);
    }

    private boolean matchTree(TreeNode r1, TreeNode r2) {
        if ((r1 == null) && (r2 == null)) {
            return true; //nothing in the left subtree
        } else if (r1 == null || r2 == null) {
            return false;//exactly one tree is empty therefore the trees does not match
        } else if (r1.getData() != r2.getData()) {
            return false;//data does not match
        } else {
            return matchTree(r1.getLeft(), r2.getLeft()) && matchTree(r1.getRight(), r2.getRight());
        }
    }
}