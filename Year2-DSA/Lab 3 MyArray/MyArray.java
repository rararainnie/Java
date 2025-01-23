public class MyArray {
    int MAX_SIZE = 5;
    int data[] = new int[MAX_SIZE];
    int size = 0;

    void expands() {
        MAX_SIZE = 2 * MAX_SIZE;
        int newData[] = new int[MAX_SIZE];
        System.arraycopy(data, 0, newData, 0, size);
        data = newData;
    }

    public void add(int d) {
        if (isFull())
            expands();
        data[size++] = d;
    }

    public boolean isFull() {
        return size == MAX_SIZE;
    }
}