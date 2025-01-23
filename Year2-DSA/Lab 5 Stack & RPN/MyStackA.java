public class MyStackA {
    int MAX_SIZE = 100;
    Double stack[] = new Double[MAX_SIZE];
    int top = 0;

    public void push(Double d) {
        stack[top++] = d;
    }

    public Double pop() {
        return stack[--top];
    }

    public Double top() {
        return stack[top - 1];
    }

    public boolean isFull() {
        return top == MAX_SIZE;
    }

    public boolean isEmpty() {
        return top == 0;
    }

    public String toString() {
        return "result stackA : " + pop();
    }
}
