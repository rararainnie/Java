import java.util.Stack;

public class Question10 extends MyLinkedList {
    public static void main(String[] args) {
        Question10 list = new Question10();
        list.add('R');
        list.add('A');
        list.add('D');
        list.add('A');
        list.add('R');
        System.out.println(list.isPalindrome());
    }

    public boolean isPalindrome() {
        Stack<Character> stack = new Stack<>();
        Node current = head;

        while (current != null) {
            stack.push((char) current.data);
            current = current.next;
        }

        current = head;
        while (current != null) {
            char value = stack.pop();
            if (current.data != value) {
                return false;
            }
            current = current.next;
        }
        return true;
    }
}
