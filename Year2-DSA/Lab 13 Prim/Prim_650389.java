import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Prim_650389 {
    private int[][] graph;
    private PriorityQueue<PrimEdge> pq;

    public Prim_650389(int[][] graph) {
        this.graph = graph;
    }

    public int[][] getMST() {
        return getMST(0);
    }

    public int[][] getGraph() {
        return graph;
    }

    public int[][] getMST(int source) {
        pq = new PriorityQueue<>(Comparator.comparingInt(PrimEdge::getWeight));
        int n = graph.length;
        int[][] mst = new int[n][n];
        boolean[] visited = new boolean[n];
        visited[source] = true;

        for (int i = 0; i < n; i++) {
            if (graph[source][i] != 0) {
                pq.add(new PrimEdge(source, i, graph[source][i]));
            }
        }

        while (!pq.isEmpty()) {
            PrimEdge minEdge = pq.poll();
            int u = minEdge.getU();
            int v = minEdge.getV();
            int weight = minEdge.getWeight();

            if (visited[v]) {
                continue;
            }

            mst[u][v] = weight;
            visited[v] = true;

            for (int i = 0; i < n; i++) {
                if (graph[v][i] != 0 && !visited[i]) {
                    pq.add(new PrimEdge(v, i, graph[v][i]));
                }
            }
        }

        return mst;
    }

    public static void showTreeAdjacency(int[][] mst) {
        for (int[] row : mst)
            System.out.println(Arrays.toString(row));
    }
}