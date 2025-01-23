import java.util.Arrays;

public class Puzzle8State {
    int[] sequence;

    public Puzzle8State(int[] sequence) {
        this.sequence = sequence;

    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Puzzle8State)) {
            return false;
        }
        Puzzle8State state = (Puzzle8State) obj;
        return Arrays.equals(this.sequence, state.sequence);
    }

    @Override
    public String toString() {
        return "Puzzle8State{" +
                "sequence=" + Arrays.toString(sequence);
    }
}