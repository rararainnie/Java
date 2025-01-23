/* 65050389 Thumasorn Prasertsri
 * Question1 Rotate a Linked List */

public class Q1 {
    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        int k = 4;
        for (int i = 10; i <= 60; i += 10) {
            list.add(i);
        }

        System.out.println("Linked list before rotating:");
        list.display();

        list.rotateCounterClockwise(k);

        System.out.println("Linked list after rotating by " + k + " positions:");
        list.display();
    }
}
