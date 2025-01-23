public class Plane22Seating extends PlaneSeating {
    public Plane22Seating(String args) {
        super();
        String[] tokens = args.split(",");
        int numRow = tokens.length;
        int numCol = tokens[0].length();
        seating = new char[numRow][numCol];
        for (int i = 0; i < tokens.length; i++) {
            seating[i] = tokens[i].toCharArray();
        }
    }

    private boolean isFull() {
        for (int i = 0; i < seating.length; i++) {
            for (int j = 0; j < seating[0].length; j++) {
                if (seating[i][j] == '^') {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public boolean reserveSeat(int row, int col) {
        int count = 0;
        for (int i = 0; i < seating[row - 1].length; i++) {
            if (seating[row - 1][i] == 'x' || seating[row - 1][i] == '^') {
                count++;
                if (count == col) {
                    if (seating[row - 1][i] == '^') {
                        System.out.printf("seat %d, %d symbol is %s. Latest seat map is%n",
                                row - 1, col - 1, seating[row - 1][i]);
                        seating[row - 1][i] = 'x';
                        showSeating();
                        return true;
                    } else {
                        showSeating();
                    }
                }
            }
        }
        return false;
    }
}
