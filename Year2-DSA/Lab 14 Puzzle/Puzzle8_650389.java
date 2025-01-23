import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Puzzle8_650389 {
    int size = 3;
    int[] sequence;
    ArrayList<Puzzle8State> explored = new ArrayList<>();;
    Stack<Puzzle8State> dfs = new Stack<>();;

    Puzzle8_650389(int[] input) {
        sequence = new int[size * size];
        for (int i = 0; i < input.length; i += 3) {
            int row = input[i + 1];
            int col = input[i + 2];
            sequence[row * 3 + col] = input[i];
        }

        Puzzle8State initialState = new Puzzle8State(sequence);
        explored.add(initialState);
        dfs.push(initialState);
    }

    void nextMoveWithStack() {
        while (!dfs.isEmpty()) {
            generateNextMove();
        }
    }

    private boolean isGoal(int[] seq) {
        return Arrays.equals(seq, new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 });
    }

    private void displayBoard() {
        System.out.print(Arrays.toString(sequence));
    }

    private void generateNextMove() {
        Puzzle8State currentState = dfs.pop();
        sequence = currentState.sequence;
        int blankPos = 0;

        if (isGoal(sequence)) {
            System.out.println(Arrays.toString(sequence));
            displayBoard();
            return;
        }

        for (int i = 0; i < sequence.length; i++) {
            if (sequence[i] == 9) {
                blankPos = i;
                break;
            }
        }

        if (blankPos + 3 < size * size) {
            int[] newState = Arrays.copyOf(currentState.sequence, size * size);
            newState[blankPos] = newState[blankPos + 3];
            newState[blankPos + 3] = 9;
            Puzzle8State nextState = new Puzzle8State(newState);
            System.out.println("pushing south " + Arrays.toString(newState));
            if (!explored.contains(nextState)) {
                explored.add(nextState);
                dfs.push(nextState);
            }
        }

        if (blankPos - 3 > -1) {
            int[] newState = Arrays.copyOf(currentState.sequence, size * size);
            newState[blankPos] = newState[blankPos - 3];
            newState[blankPos - 3] = 9;
            Puzzle8State nextState = new Puzzle8State(newState);
            System.out.println("pushing north " + Arrays.toString(newState));
            if (!explored.contains(nextState)) {
                explored.add(nextState);
                dfs.push(nextState);
            }
        }

        if (blankPos % 3 < 2) {
            int[] newState = Arrays.copyOf(currentState.sequence, size * size);
            newState[blankPos] = newState[blankPos + 1];
            newState[blankPos + 1] = 9;
            Puzzle8State nextState = new Puzzle8State(newState);
            System.out.println("pushing east " + Arrays.toString(newState));
            if (!explored.contains(nextState)) {
                explored.add(nextState);
                dfs.push(nextState);
            }
        }

        if (blankPos % 3 > 0) {
            int[] newState = Arrays.copyOf(currentState.sequence, size * size);
            newState[blankPos] = newState[blankPos - 1];
            newState[blankPos - 1] = 9;
            Puzzle8State nextState = new Puzzle8State(newState);
            System.out.println("pushing west " + Arrays.toString(newState));
            if (!explored.contains(nextState)) {
                explored.add(nextState);
                dfs.push(nextState);
            }
        }
    }
}