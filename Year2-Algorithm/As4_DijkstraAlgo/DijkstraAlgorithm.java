import java.util.*;

public class DijkstraAlgorithm {
    private int V; // Number of vertices in the graph
    private List<List<Node>> adjList;

    public DijkstraAlgorithm(int V) {
        this.V = V;
        adjList = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            List<Node> item = new ArrayList<>();
            adjList.add(item);
        }
    }

    static class Node implements Comparable<Node> {
        int target;
        int weight;

        public Node(int target, int weight) {
            this.target = target;
            this.weight = weight;
        }

        public int compareTo(Node other) {
            return Integer.compare(this.weight, other.weight);
        }
    }

    public void addEdge(int source, int dest, int weight) {
        adjList.get(source).add(new Node(dest, weight));
        adjList.get(dest).add(new Node(source, weight)); // For bidirectional graphs
    }

    public int[] shortestPath(int source) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        pq.add(new Node(source, 0));
        dist[source] = 0;

        while (!pq.isEmpty()) {
            int u = pq.poll().target;
            for (Node neighbour : adjList.get(u)) {
                int v = neighbour.target;
                int weight = neighbour.weight;

                if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    pq.add(new Node(v, dist[v]));
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) {
        int V = 5; // Number of vertices in the graph
        DijkstraAlgorithm graph = new DijkstraAlgorithm(V);

        // Add edges and weights
        graph.addEdge(0, 1, 9);
        graph.addEdge(0, 2, 6);
        graph.addEdge(0, 3, 5);
        graph.addEdge(0, 4, 3);
        graph.addEdge(2, 1, 2);
        graph.addEdge(2, 3, 4);

        int source = 0; // Starting point
        int[] shortestPaths = graph.shortestPath(source);

        // Displaying the shortest paths to all destinations
        System.out.println("Shortest paths from source " + source + " to all destinations:");
        int sumShortestPaths = 0;
        for (int i = 0; i < V; i++) {
            System.out.println("Shortest path to destination " + i + ": " + shortestPaths[i]);
            sumShortestPaths += shortestPaths[i];
        }
        System.out.println("Sum of all shortest paths: " + sumShortestPaths);
    }
}
