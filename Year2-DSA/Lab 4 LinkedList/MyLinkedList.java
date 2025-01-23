public class MyLinkedList {
    public class Node {
        int data;
        Node next;

        public Node(int d) {
            data = d;
        }
    }

    Node head = null;

    public void add(int d) {
        Node newNode = new Node(d);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void insert(int d) {
        Node newNode = new Node(d);

        if (head == null || d < head.data) {
            newNode.next = head;
            head = newNode;
            return;
        }

        Node current = head;
        while (current.next != null && current.next.data < d) {
            current = current.next;
        }

        newNode.next = current.next;
        current.next = newNode;
    }

    public void delete(Node p) {
        p.next = p.next.next;
    }
}