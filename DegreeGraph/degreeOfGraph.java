package DegreeGraph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class degreeOfGraph {
    public static void main(String[] args) {
        ArrayList<String> vertexName = new ArrayList<>(Arrays.asList("v1", "v2", "v3",
                "v4", "v5", "v6", "v7"));
        String[] randVertex1 = randAllVertex(vertexName);
        String[] randVertex2 = randAllVertex(vertexName);
        int[] countVertex = countVertex(vertexName, randVertex1, randVertex2);

        System.out.println("Vertex\tDegree\t End Point");
        for (int i = 0; i < vertexName.size(); i++) {
            System.out.printf("%4s%7d\t{ %s , %s }%n", vertexName.get(i), countVertex[i],
                    randVertex1[i], randVertex2[i]);
        }
    }

    public static String[] randAllVertex(ArrayList<String> n) {
        Random rand = new Random();
        return n.stream().map(x -> n.get(rand.nextInt(n.size()))).toArray(String[]::new);
    }

    public static int[] countVertex(ArrayList<String> n, String[] r1, String[] r2) {
        int[] c = new int[n.size()];
        for (int i = 0; i < r1.length; i++) {
            for (int j = 0; j < n.size(); j++) {
                if (n.indexOf(r1[i]) == j && n.indexOf(r2[i]) == j) {
                    c[j]++;
                }
                if (n.indexOf(r1[i]) == j || n.indexOf(r2[i]) == j) {
                    c[j]++;
                }
            }
        }
        return c;
    }
}
