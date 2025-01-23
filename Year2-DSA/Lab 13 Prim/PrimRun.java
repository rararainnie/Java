import java.util.Arrays;

public class PrimRun {
    public static void main(String[] args) {
        Prim_650389 mst = new Prim_650389(new int[][] {
                { 0, 10, 0, 30, 45, 0 },
                { 10, 0, 50, 0, 40, 25 },
                { 0, 50, 0, 0, 35, 15 },
                { 30, 0, 0, 0, 0, 20 },
                { 45, 40, 35, 0, 0, 55 },
                { 0, 25, 15, 20, 55, 0 }
        });

        System.out.println("-input--");
        for (int[] row : mst.getGraph())
            System.out.println(Arrays.toString(row));
        System.out.println("----");
        Prim_650389.showTreeAdjacency(mst.getMST());
        System.out.println("----");
        Prim_650389.showTreeAdjacency(mst.getMST(2));
    }
}
