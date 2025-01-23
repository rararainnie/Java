public abstract class PlaneSeating {
    protected String planeType;
    protected char[][] seating;

    public void showSeating() {
        for (int i = 0; i < seating.length; i++) {
            System.out.printf("row %d --> %s%n", i + 1, String.valueOf(seating[i]));
        }
    }

    public abstract boolean reserveSeat(int row, int col);
}