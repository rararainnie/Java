import Matrix_Method.MethodMatrix;
import java.util.Scanner;

public class Matrix_Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MethodMatrix methodMatrix = new MethodMatrix();

        int[][] arrMatrix = {
                { 0, 2, 1, 0, 0 },
                { 2, 0, 1, 2, 0 },
                { 1, 1, 0, 3, 1 },
                { 0, 2, 3, 0, 1 },
                { 0, 0, 1, 1, 0 } };
        int[][] result = new int[arrMatrix.length][arrMatrix[0].length];

        System.out.print("Enter power (between 0 - 9): ");
        int powMatrix = sc.nextInt();

        System.out.println("Display the Begin Matrix:");
        methodMatrix.displayMatrix(arrMatrix);
        methodMatrix.identityMatrix(arrMatrix, result, powMatrix);

        sc.close();
    }
}
