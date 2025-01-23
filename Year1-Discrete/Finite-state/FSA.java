import java.util.Scanner;

public class FSA {
    public static void main(String[] args) {
        int[][] transitions = {
                { 0, 2, 3, 4 }, // State 0 transitions: 0 -> State 1, 1 -> State 2, 2 -> State 3, 3 -> State 4
                { 1, 2, 4, 1 }, // State 1 transitions: 0 -> State 3, 1 -> State 2, 2 -> State 4, 3 -> State 1
                { 2, 4, 0, 3 }, // State 2 transitions: 0 -> State 2, 1 -> State 4, 2 -> State 0, 3 -> State 3
                { 3, 2, 1, 4 }, // State 3 transitions: 0 -> State 3, 1 -> State 2, 2 -> State 1, 3 -> State 4
                { 4, 4, 3, 1 } // State 4 transitions: 0 -> State 4, 1 -> State 4, 2 -> State 3, 3 -> State 1
        };
        checkValid(transitions);
    }

    public static void checkValid(int[][] t) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < t.length; i++) {
            System.out.printf("Enter a string (Start on state %d): ", i);
            String input = sc.nextLine();
            int currentState = 0;
            boolean accept = false;
            for (int j = 0; j < input.length(); j++) {
                char c = input.charAt(j);
                int inputSymbol = Character.getNumericValue(c);
                currentState = t[currentState][inputSymbol];
            }
            if (currentState == 4) {
                accept = true;
            }
            System.out.println((accept ? "Accepted" : "Rejected"));
        }
        sc.close();
    }
}
