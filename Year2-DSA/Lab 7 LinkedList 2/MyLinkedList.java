public class MyLinkedList {
    public class Node {
        int data;
        Node next;

        Node(int d) {
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

    // Question 1
    public void rotateCounterClockwise(int k) {
        if (head == null || k <= 0) {
            return;
        }

        Node current = head;
        int count = 1;
        while (count < k && current != null) {
            current = current.next;
            count++;
        }

        if (current == null) {
            return;
        }

        Node kthNode = current;
        while (current.next != null) {
            current = current.next;
        }

        current.next = head;
        head = kthNode.next;
        kthNode.next = null;
    }

    // Question 4
    public void removeDuplicates() {
        if (head == null || head.next == null) {
            return;
        }

        Node p1 = head;

        while (p1 != null) {
            Node p2 = p1;
            while (p2.next != null) {
                if (p1.data == p2.next.data) {
                    p2.next = p2.next.next;
                } else {
                    p2 = p2.next;
                }
            }
            p1 = p1.next;
        }
    }

    public void display() {
        Node current = head;
        if (current != null) {
            while (current.next != null) {
                System.out.print(current.data + " -> ");
                current = current.next;
            }
            System.out.println(current.data);
        }
    }
}
