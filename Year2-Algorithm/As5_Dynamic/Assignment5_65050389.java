/*
 * 65050389 Thumasorn Prasertsri
 * Assignment5 -> All-Pair Minimum Bottleneck Paths
 */

import java.util.Scanner;

public class Assignment5 {
    public static int[][] inputGraph() {
        Scanner scanner = new Scanner(System.in);

        int n;
        while (true) {
            try {
                System.out.print("Enter the number of vertices: ");
                n = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        int[][] adjMatrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                System.out.print("Enter weight of edge(v" + (i + 1) + ", v" + (j + 1) + "): ");
                String w = scanner.nextLine();

                while (true) {
                    if (w.isEmpty()) {
                        adjMatrix[i][j] = Integer.MAX_VALUE;
                        adjMatrix[j][i] = Integer.MAX_VALUE;
                        break;
                    }

                    try {
                        int weight = Integer.parseInt(w);
                        if (weight > 0) {
                            adjMatrix[i][j] = weight;
                            adjMatrix[j][i] = weight;
                            break;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Error: Invalid input.");
                    }

                    System.out.println("Error: Invalid input.");
                    System.out.print("Enter weight of edge(v" + (i + 1) + ", v" + (j + 1) + "): ");
                    w = scanner.nextLine();
                }
            }
        }
        scanner.close();
        return adjMatrix;
    }

    public static int[][] minBPs(int[][] cost) {
        int n = cost.length;

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int newCost = Math.max(cost[k][i], cost[k][j]);
                    if (newCost < cost[i][j]) {
                        cost[i][j] = newCost;
                    }
                }
            }
        }

        return cost;
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int cell : row) {
                System.out.print(cell == Integer.MAX_VALUE ? "inf" : cell + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[][] adjMatrix = inputGraph();

        System.out.println();
        System.out.println("Adjacency Matrix:");
        printMatrix(adjMatrix);

        int[][] cost = minBPs(adjMatrix);
        System.out.println("Minimum Bottleneck Paths:");
        printMatrix(cost);
    }
}
