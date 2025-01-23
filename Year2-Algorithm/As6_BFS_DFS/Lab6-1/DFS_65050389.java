import java.util.*;

class Node {
    char data;
    Node left, right;

    Node(char item) {
        data = item;
        left = right = null;
    }
}

class BinaryTree {
    Node root;
    Map<Character, Node> nodes = new HashMap<>();

    void postOrder(Node node) {
        if (node == null)
            return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data + " ");
    }

    void inOrder(Node node) {
        if (node == null)
            return;
        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);
    }

    void preOrder(Node node) {
        if (node == null)
            return;
        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    void printPostOrder() {
        postOrder(root);
    }

    void printInOrder() {
        inOrder(root);
    }

    void printPreOrder() {
        preOrder(root);
    }

    void createTree(String input) {
        for (char c : input.toCharArray()) {
            nodes.put(c, new Node(c));
        }

        root = nodes.get(input.charAt(0));

        for (int i = 0; i < input.length() / 2; i++) {
            Node current = nodes.get(input.charAt(i));
            current.left = nodes.get(input.charAt(2 * i + 1));

            if (2 * i + 2 < input.length()) {
                current.right = nodes.get(input.charAt(2 * i + 2));
            }
        }
    }

    void printTraversals() {
        System.out.println("\n------------ Output -------------\n");

        System.out.print("DFS in-order: ");
        printInOrder();

        System.out.print("\nDFS pre-order: ");
        printPreOrder();

        System.out.print("\nDFS post-order: ");
        printPostOrder();

        System.out.println("\n\n----------------------------------");
    }
}

public class DFS_65050389 {

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        Scanner scanner = new Scanner(System.in);

        System.out.print("\nEnter a string (ex. ABCDEFG): ");
        String input = scanner.nextLine();

        tree.createTree(input);
        tree.printTraversals();

        scanner.close();
    }
}
