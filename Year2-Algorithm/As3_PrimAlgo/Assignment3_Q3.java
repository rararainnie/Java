/*
 * 65050389 Thumasorn Prasertsri
 * Assignment3 Question 3 -> Minimum Spanning Tree (Prim Algorithm)
 */

import java.util.PriorityQueue;
import java.util.Scanner;

public class Assignment3_Q3 {
    public static void main(String[] args) {
        int[][] graph = {
                { 0, 10, 0, 30, 45, 0 },
                { 10, 0, 50, 0, 40, 25 },
                { 0, 50, 0, 0, 35, 15 },
                { 30, 0, 0, 0, 0, 20 },
                { 45, 40, 35, 0, 0, 55 },
                { 0, 25, 15, 20, 55, 0 }
        };

        Scanner sc = new Scanner(System.in);
        System.out.print("Starting node (1 to " + graph.length + "): ");
        int startNode = sc.nextInt() - 1;
        sc.close();

        primAlgorithm(graph, startNode);
    }

    static void primAlgorithm(int[][] graph, int startNode) {
        int minWeight = 0;
        boolean[] visited = new boolean[graph.length];
        visited[startNode] = true;

        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        for (int i = 0; i < graph.length; i++) {
            if (graph[startNode][i] != 0) {
                priorityQueue.add(new Edge(startNode, i, graph[startNode][i]));
            }
        }

        while (!priorityQueue.isEmpty()) {
            Edge edge = priorityQueue.poll();

            int from = edge.from;
            int to = edge.to;
            int weight = edge.weight;

            if (visited[to]) {
                continue;
            }

            visited[to] = true;
            minWeight += weight;

            System.out.println("Node " + (from + 1) + " -> Node " + (to + 1) + "\tWeight: " + weight);

            for (int i = 0; i < graph.length; i++) {
                if (!visited[i] && graph[to][i] != 0) {
                    priorityQueue.add(new Edge(to, i, graph[to][i]));
                }
            }
        }

        System.out.println("Total Weight of MST (Prim Algorithm): " + minWeight);
    }

    static class Edge {
        int from;
        int to;
        int weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }
}
