public class MyQueueA {
    int MAX_SIZE = 100;
    String queue[] = new String[MAX_SIZE];
    int head = 0, tail = 0;

    public void enqueue(String str) {
        queue[tail] = str;
        tail = (tail + 1) % MAX_SIZE;
    }

    public String dequeue() {
        String d = queue[head];
        head = (head + 1) % MAX_SIZE;
        return d;
    }

    public String front() {
        return queue[head];
    }

    public boolean isFull() {
        return ((tail + 1) % MAX_SIZE) == head;
    }

    public boolean isEmpty() {
        return head == tail;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = head; i != tail; i = (i + 1) % MAX_SIZE) {
            sb.append(queue[i]).append(" ");
        }
        return sb.toString();
    }
}
