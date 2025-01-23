/*
 * 65050389 Thumasorn Prasertsri
 * Assignment4 -> Dijkstra Algorithm
 */

import java.util.*;

class Graph {
    private final int V;
    private final Map<Integer, List<Edge>> adjList;

    public Graph(int V) {
        this.V = V;
        adjList = new HashMap<>();
        for (int i = 1; i <= V; i++) {
            adjList.put(i, new ArrayList<>());
        }
    }

    public void addEdge(int source, int dest, int weight) {
        adjList.get(source).add(new Edge(dest, weight));
    }

    public Map<Integer, Integer> dijkstra(int source) {
        Map<Integer, Integer> distances = new HashMap<>();
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.distance));

        for (int i = 1; i <= V; i++) {
            distances.put(i, Integer.MAX_VALUE);
        }

        distances.put(source, 0);
        pq.add(new Node(source, 0));

        while (!pq.isEmpty()) {
            int u = pq.poll().vertex;

            for (Edge neighbor : adjList.get(u)) {
                int v = neighbor.destination;
                int weight = neighbor.weight;
                if (distances.get(u) != Integer.MAX_VALUE && distances.get(u) + weight < distances.get(v)) {
                    distances.put(v, distances.get(u) + weight);
                    pq.add(new Node(v, distances.get(v)));
                }
            }
        }

        return distances;
    }

    static class Node {
        int vertex;
        int distance;

        public Node(int vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }
    }

    static class Edge {
        int destination;
        int weight;

        public Edge(int destination, int weight) {
            this.destination = destination;
            this.weight = weight;
        }
    }
}

public class Assignment4 {
    public static void main(String[] args) {
        int n = 5;
        Graph graph = new Graph(n);
        int sumShortestPaths = 0;

        int[][] edges = {
                { 1, 2, 1 },
                { 1, 3, 7 },
                { 2, 3, 5 },
                { 2, 4, 4 },
                { 2, 5, 3 },
                { 3, 4, 1 },
                { 5, 3, 1 },
                { 5, 4, 2 }
        };

        for (int[] edge : edges) {
            graph.addEdge(edge[0], edge[1], edge[2]);
        }

        int startVertex = 1;
        Map<Integer, Integer> shortestPaths = graph.dijkstra(startVertex);

        System.out.println("Shortest paths from vertex 1:");
        for (int vertex = 2; vertex <= n; vertex++) {
            int distance = shortestPaths.get(vertex);
            sumShortestPaths += distance;
            System.out.println("Shortest path to Vertex " + vertex + "\tDistance: " + distance);
        }
        System.out.println("Sum of Shortest Paths: " + sumShortestPaths);
    }
}