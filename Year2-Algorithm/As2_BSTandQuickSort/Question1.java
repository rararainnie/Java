/*
 * 65050389 Thumasorn Prasertsri
 * Assignment 2
 * data = 12, 39, 32, 75, 16, 45, 39, 86, 23, 38
*/

import java.util.Scanner;

class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}

class BinaryTree {
    Node root;

    BinaryTree() {
        root = null;
    }

    void insert(int data) {
        root = insertRec(root, data);
        System.out.println("Inserted: " + data);
        System.out.print("Data in tree: ");
        printTree(root);
        System.out.println();
    }

    Node insertRec(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }

        if (data <= root.data) {
            root.left = insertRec(root.left, data);
        } else if (data > root.data) {
            root.right = insertRec(root.right, data);
        }

        return root;
    }

    int findMinValue() {
        Node current = root;
        while (current.left != null) {
            current = current.left;
        }
        return current.data;
    }

    int findMaxValue() {
        Node current = root;
        while (current.right != null) {
            current = current.right;
        }
        return current.data;
    }

    void printTree(Node node) {
        if (node != null) {
            printTree(node.left);
            System.out.print(node.data + " ");
            printTree(node.right);
        }
    }

}

public class Question1 {

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        BinaryTree tree = new BinaryTree();

        System.out.print("Enter the number of elements: ");
        int n = userInput.nextInt();

        System.out.print("Enter " + n + " elements: ");
        for (int i = 0; i < n; i++) {
            int value = userInput.nextInt();
            tree.insert(value);
            System.out.println();
        }

        int minValue = tree.findMinValue();
        int maxValue = tree.findMaxValue();

        System.out.println("Minimum value: " + minValue);
        System.out.println("Maximum value: " + maxValue);
        userInput.close();
    }
}
