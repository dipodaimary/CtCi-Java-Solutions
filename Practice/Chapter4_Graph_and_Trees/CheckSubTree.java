package Trees_and_Graphs;

import Library.TreeNode;

public class CheckSubTree {
    public boolean containTree(TreeNode t1, TreeNode t2) {
        StringBuilder string1 = new StringBuilder();
        StringBuilder string2 = new StringBuilder();
        getOrderString(t1, string1);
        getOrderString(t2, string2);
        return string1.indexOf(string2.toString()) != -1;
    }

    private void getOrderString(TreeNode t, StringBuilder sb) {
        if (t == null) {
            sb.append("X");
            return;
        }
        sb.append(t.getData());
        getOrderString(t.getLeft(), sb);
        getOrderString(t.getRight(), sb);
    }
}
