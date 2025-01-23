public class MyStackL {
    public class Node {
        Double data;
        Node next;

        public Node(Double d) {
            data = d;
        }
    }

    Node top = null;

    public void add(Double d) {
        Node p = new Node(d);
        p.next = top;
        top = p;
    }

    public void push(Double d) {
        Node p = new Node(d);
        p.next = top;
        top = p;
    }

    public Double pop() {
        Double d = (double) top.data;
        top = top.next;
        return d;
    }

    public Double top() {
        return (double) top.data;
    }

    public boolean isFull() {
        return false;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public String toString() {
        return "result stackL : " + pop();
    }
}
