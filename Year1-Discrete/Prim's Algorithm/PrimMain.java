import java.util.Arrays;
import java.util.Scanner;

public class PrimMain {
    public static void main(String[] args) {
        int[][] graph = {
                { 0, 355, 0, 0, 0, 0, 695, 0 },
                { 355, 0, 74, 262, 269, 0, 0, 0 },
                { 0, 74, 0, 0, 348, 0, 0, 0 },
                { 0, 262, 0, 0, 242, 0, 0, 0 },
                { 0, 269, 348, 242, 0, 83, 151, 306 },
                { 0, 0, 0, 0, 83, 0, 0, 230 },
                { 695, 0, 0, 0, 151, 0, 0, 0 },
                { 0, 0, 0, 0, 306, 230, 0, 0 }
        };

        String[] vertices = { "Minneapolis", "Chicago", "Milwaukee",
                "St. Louis", "Louisville", "Cincinnati",
                "Nashville", "Detroit" };

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter starting vertex: ");
        String startVertexName = scanner.nextLine();
        int start = Arrays.asList(vertices).indexOf(startVertexName);
        scanner.close();

        PrimAlgorithm prim = new PrimAlgorithm();
        prim.runPrim(graph, vertices, start);
    }
}
