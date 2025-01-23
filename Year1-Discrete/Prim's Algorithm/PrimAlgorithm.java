import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class PrimAlgorithm {
    static class Edge implements Comparable<Edge> {
        int from, to, weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        public int compareTo(Edge other) {
            return Integer.compare(weight, other.weight);
        }
    }

    public void runPrim(int[][] graph, String[] vertices, int start) {
        List<Integer> selectedVertices = new ArrayList<>();
        PriorityQueue<Edge> pq = new PriorityQueue<>();

        System.out.printf("%s \t%s \t\t%s \t\t\t%s%n",
                "Iteration Number", "Vertex Added", "Edge Added", "Weight");
        int iteration = 0;
        System.out.printf("%9d \t\t %s%n", iteration, vertices[start]);

        selectedVertices.add(start);
        while (selectedVertices.size() < vertices.length) {
            int currentVertex = selectedVertices.get(selectedVertices.size() - 1);
            for (int i = 0; i < vertices.length; i++) {
                if (i == currentVertex || selectedVertices.contains(i)) {
                    continue;
                }
                int weight = graph[currentVertex][i];
                if (weight > 0) {
                    pq.add(new Edge(currentVertex, i, weight));
                }
            }

            Edge minEdge = pq.poll();
            while (minEdge != null && selectedVertices.contains(minEdge.to)) {
                minEdge = pq.poll();
            }

            if (minEdge != null) {
                selectedVertices.add(minEdge.to);
                System.out.printf("%9d \t\t %s \t\t%s \t\t%d%n",
                        iteration + 1, vertices[minEdge.to],
                        vertices[minEdge.from] + "-" + vertices[minEdge.to],
                        minEdge.weight);
                iteration++;
            }
        }
    }
}
