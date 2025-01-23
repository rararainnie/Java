public class MyQueueL {
    public class Node {
        String data;
        Node next;

        public Node(String d) {
            data = d;
        }

        public boolean isEmpty() {
            return head == null;
        }
    }

    Node head = null, tail = null;

    public void enqueue(String str) {
        Node p = new Node(str);
        if (head == null)
            head = tail = p;
        else {
            tail.next = p;
            tail = tail.next;
        }
    }

    public String dequeue() {
        String d = head.data;
        head = head.next;
        return d;
    }

    public String front() {
        return head.data;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node current = head;
        while (current != null) {
            sb.append(current.data).append(" ");
            current = current.next;
        }
        return sb.toString();
    }
}
