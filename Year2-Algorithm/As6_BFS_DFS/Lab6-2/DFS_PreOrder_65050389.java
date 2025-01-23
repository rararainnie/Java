import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class DFS_PreOrder_65050389 {
    static void printAdjLists(int n, char[] L, String[][] v) {
        for (int i = 0; i < n; i++) {
            System.out.print("   " + L[i] + ": ");
            for (String adjacent : v[i]) {
                System.out.print(adjacent + " ");
            }
            System.out.println();
        }
    }

    static void graphDFS(int start, int n, char[] L, String[][] v, boolean[] visited) {
        System.out.print(L[start] + " ");
        visited[start] = true;
        for (String vertex : v[start]) {
            int index = Arrays.binarySearch(L, vertex.charAt(0));
            if (!visited[index]) {
                graphDFS(index, n, L, v, visited);
            }
        }
    }

    static void graphBFS(int n, char[] L, String[][] v) {
        Queue<Character> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        queue.add(L[0]);
        visited[0] = true;
        while (!queue.isEmpty()) {
            char vertex = queue.poll();
            System.out.print(vertex + " ");
            int index = Arrays.binarySearch(L, vertex);
            for (String adjacent : v[index]) {
                int adjIndex = Arrays.binarySearch(L, adjacent.charAt(0));
                if (!visited[adjIndex]) {
                    visited[adjIndex] = true;
                    queue.add(adjacent.charAt(0));
                }
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int n = 8;
        char[] L = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H' };
        String[][] v = { { "G", "F", "D", "B" }, { "A", "H", "C" }, { "B" }, { "A", "E" }, { "F", "D" }, { "A", "E" },
                { "A" }, { "B" } };

        System.out.println("Adjacent Lists :");
        printAdjLists(n, L, v);

        System.out.print("\nDFS: ");
        boolean[] visit = new boolean[n];
        graphDFS(0, n, L, v, visit);

        System.out.print("\nBFS WITH Queue: ");
        graphBFS(n, L, v);
    }
}
