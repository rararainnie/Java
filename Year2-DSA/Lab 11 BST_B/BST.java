public class BST {
    TreeNode root;

    public BST() {
        root = null;
    }

    public TreeNode getRoot() {
        return root;
    }

    public void insert(int d) {
        if (root == null) {
            root = new TreeNode(d);
        } else {
            TreeNode cur = root;
            while (cur != null) {
                if (d < cur.data) {
                    if (cur.left != null)
                        cur = cur.left;
                    else {
                        cur.left = new TreeNode(d);
                        cur.parent = cur;
                        return;
                    }
                } else { // d >= cur.data
                    if (cur.right != null)
                        cur = cur.right;
                    else {
                        cur.right = new TreeNode(d);
                        cur.right.parent = cur;
                        return;
                    }
                }
            }
        }
    }

    private void printPreOrderRecurse(TreeNode node) {
        if (node != null) {
            printPreOrderRecurse(node.left);
            System.out.print(node.data + " ");
            printPreOrderRecurse(node.right);
        }
    }

    public void printPreOrder() {
        printPreOrderRecurse(root);
    }

    public static void main(String[] args) {
        demo4();
    }

    public static void demo1() {
        int[] data = { 2, 1, 3, 4, 5, 6, 7, 8, 9 };
        BST bst = new BST();
        for (int j = 0; j < data.length; j++)
            bst.insert(data[j]);
        bst.printInOrder();
        System.out.println("Tree height = " + bst.height());
        int[] dat = { 15, 20, 10, 18, 16, 12, 8, 25, 19, 30 };
        bst = new BST();
        for (int j = 0; j < dat.length; j++)
            bst.insert(dat[j]);
        bst.printInOrder();
        System.out.println("Tree height = " + bst.height());
    }

    public static void demo2() {
        int[] dat = { 15, 20, 10, 18, 16, 12, 8, 25, 19, 30 };
        BST bst = new BST();
        for (int j = 0; j < dat.length; j++)
            bst.insert(dat[j]);
        System.out.println("node with max value " +
                bst.findMaxFrom(bst.getRoot()));
    }

    public static void demo3() {
        int[] dat = { 15, 20, 10, 18, 16, 12, 8, 25, 19, 30 };
        BST bst = new BST();
        for (int j = 0; j < dat.length; j++)
            bst.insert(dat[j]);
        bst.delete(12, bst.getRoot());
        System.out.println(bst.search(20)); // 18<-20->25
        System.out.println(bst.search(25)); // null<-25->30
        System.out.println(bst.search(16)); // null<-16->null
        System.out.println(bst.search(10)); // 8<-10->null
        System.out.println(bst.search(12)); // not found
    }

    public static void demo4() {
        int[] dat = { 15, 20, 10, 18, 16, 12, 8, 30, 19, 25 };
        BST bst = new BST();
        for (int j = 0; j < dat.length; j++) {
            bst.insert(dat[j]);
        }
        bst.printInOrder();
        bst.delete(20, bst.getRoot()); // default TreeNode is root
        bst.printInOrder();
        bst.delete(15, bst.getRoot()); // root -> complete the delete(int, TreeNode)
        bst.printInOrder();
    }

    public void printInOrder() {
        printInOrderRecurse(root);
    }

    private void printInOrderRecurse(TreeNode node) {
        if (node != null) {
            System.out.print(node.data + " ");
            printInOrderRecurse(node.left);
            printInOrderRecurse(node.right);
        }
    }

    private void printPostOrderRecurse(TreeNode node) {
        if (node != null) {
            printPostOrderRecurse(node.left);
            printPostOrderRecurse(node.right);
            System.out.print(node.data + " ");
        }
    }

    public void printPostOrder() {
        printPostOrderRecurse(root);
    }

    public TreeNode search(int d) {
        TreeNode result = searchRecurse(d, root);
        return result;
    }

    public TreeNode searchRecurse(int d, TreeNode n) {
        if (n == null)
            return null;
        if (d == n.data)
            return n;
        if (d < n.data) {
            return searchRecurse(d, n.left);
        } else {
            return searchRecurse(d, n.right);
        }
    }

    public TreeNode searchIter(int key) {
        if (root.data == key)
            return root;
        TreeNode current = root;
        while (current != null) {
            if (key < current.data) {
                if (current.left != null)
                    current = current.left;
            } else {
                if (current.right != null)
                    current = current.right;
            }
            if (current.data == key)
                return current;
            if (current.left == null && current.right == null)
                return null;

        } // while
        return null;
    }

    public int height() {
        return root == null ? 0 : height(root);
    }

    public int height(TreeNode node) {
        if (node == null)
            return 0;
        return Math.max(height(node.left), height(node.right)) + 1;
    }

    public TreeNode findMaxFrom(TreeNode findMaxFrom) {
        if (findMaxFrom == null) {
            return null;
        }
        TreeNode current = findMaxFrom;
        while (current.right != null) {
            current = current.right;
        }
        return current;
    }

    public void delete(int d, TreeNode current) {
        if (current == null)
            return; // not found

        if (d < current.data) {
            delete(d, current.left);
        } else if (d > current.data) {
            delete(d, current.right);
        } else { // found ... time to delete
            if (current.left == null || current.right == null) { // 0 or 1 child
                TreeNode q = (current.left == null) ? current.right : current.left;
                if (current.parent.left == current) {
                    current.parent.left = q; // this node is left child
                } else {
                    current.parent.right = q;
                }
                if (q != null)
                    q.parent = current.parent;
            } else { // two children
                TreeNode q = findMaxFrom(current.left);
                current.data = q.data;
                delete(q.data, current.left);
            } // two children
        } // found
    }

}

class TreeNode {
    int data;
    TreeNode left, right, parent;

    public TreeNode(int d) {
        data = d;
    }

    @Override
    public String toString() {
        String leftString = (left != null) ? String.valueOf(left.data) : "null";
        String rightString = (right != null) ? String.valueOf(right.data) : "null";

        return leftString + "<-" + data + "->" + rightString;
    }
}
