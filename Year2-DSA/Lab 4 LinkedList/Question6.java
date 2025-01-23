public class Question6 extends MyLinkedList {
    public static void main(String[] args) {
        Question6 list = new Question6();
        for (int i = 1; i <= 5; i++)
            list.add(i);

        System.out.println("Original list:");
        list.printList();

        list.findMiddle();
        if (list.findMiddle() != null) {
            System.out.println("Middle of linked list: " + list.findMiddle().data);
        } else {
            System.out.println("The list is empty.");
        }
    }

    public Node findMiddle() {
        if (head == null) {
            return null;
        }

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data);
            if (temp.next != null) {
                System.out.print(" -> ");
            }
            temp = temp.next;
        }
        System.out.println();
    }
}
