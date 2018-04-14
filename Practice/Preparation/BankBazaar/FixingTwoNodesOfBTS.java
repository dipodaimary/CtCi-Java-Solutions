package Preparation.BankBazaar;

public class FixingTwoNodesOfBTS {
    public static void main(String[] args) {
        /*   6
            / \
           10  2
          / \ / \
         1  3 7 12

        10 and 2 are swapped
        */

        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(10);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(12);
        root.right.left = new TreeNode(7);

        System.out.println("Inorder Traversal" +
                " of the original tree");
        FixingTwoNodesOfBTS tree = new FixingTwoNodesOfBTS();
        tree.printInorder(root);

        tree.correctBST(root);

        System.out.println("\nInorder Traversal" +
                " of the fixed tree");
        tree.printInorder(root);
    }

    TreeNode first, middle, last, prev;

    void correctBST(TreeNode root) {
        //Initialize pointers for correctBSTUtil
        first = middle = last = prev = null;
        //set the pointers to find out two nodes
        correctBSTUtil(root);
        //Fix or correct the tree
        if (first != null && last != null) {
            first.data = first.data ^ last.data;
            last.data = first.data ^ last.data;
            first.data = first.data ^ last.data;
        } else if (first != null && middle != null) {
            first.data = first.data ^ middle.data;
            middle.data = first.data ^ middle.data;
            first.data = first.data ^ middle.data;
        }
    }

    /*This function does inorder traversal to find out the two swapped nodes.
    It sets three pointers, first, middle and last. If the swapped nodes are
    adjacent to each other, then first and middle contain the resultant nodes
    Else, first and last contain the resultant nodes*/
    private void correctBSTUtil(TreeNode root) {
        if (root != null) {
            //Recur the left subtree
            if (root.left != null)
                correctBSTUtil(root.left);
        }
        /*
        If this node is less than the previous node than it is violating the BST rule
         */
        if (prev != null && root.data < prev.data) {
            /*
            If this is the first violation, mark these nodes as first and middle
             */
            if (first == null) {
                first = prev;
                middle = root;
            } else {
                last = root;
            }
        }
        //Mark this node as prev
        prev = root;
        //Recur for the right subtree
        if (root.right != null)
            correctBSTUtil(root.right);
    }

    /* A utility function to print
    Inoder traversal */
    void printInorder(TreeNode node) {
        if (node == null)
            return;
        printInorder(node.left);
        System.out.print(" " + node.data);
        printInorder(node.right);
    }
}

class TreeNode {
    public int data;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public void insertInOrder(int data) {
        if (data <= this.data) {
            if (this.left != null) {
                left.insertInOrder(data);
            } else {
                this.left = new TreeNode(data);
            }
            if (data > this.data) {
                if (this.right == null) {
                    this.right = new TreeNode(data);
                } else {
                    this.right.insertInOrder(data);
                }
            }
        }
    }
}