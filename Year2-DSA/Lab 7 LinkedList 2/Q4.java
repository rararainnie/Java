/* 65050389 Thumasorn Prasertsri
 * Question4 Remove duplicate element from sorted linked List */

public class Q4 {
    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        int[] arr = { 12, 11, 12, 21, 41, 43, 21 };

        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
        }

        System.out.println("Linked list before remove duplicate element:");
        list.display();

        list.removeDuplicates();

        System.out.println("Linked list after remove duplicate element:");
        list.display();
    }
}