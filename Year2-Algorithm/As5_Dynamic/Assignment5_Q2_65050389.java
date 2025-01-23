/*
 * 65050389 Thumasorn Prasertsri
 * Assignment5 Question 2-> Longest Common Sub-Sequence: LCS
 * x = A,B,C,B,D,A,B
 * y = B,D,B,A,B,A
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Assignment5_Q2_65050389 {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);

        System.out.print("Enter the DNA of X (for example: A,B,C): ");
        String x = userInput.nextLine();

        System.out.print("Enter the DNA of Y (for example: D,E,F): ");
        String y = userInput.nextLine();

        String[] arrX = x.split(",");
        String[] arrY = y.split(",");

        int[][] arrLCS = new int[arrX.length + 1][arrY.length + 1];

        System.out.println("\n    --- LCS Tracking ---");
        for (int i = 0; i <= arrX.length; i++) {
            for (int j = 0; j <= arrY.length; j++) {
                if (i >= 1 && j >= 1) {
                    if (arrX[i - 1].equals(arrY[j - 1])) {
                        arrLCS[i][j] = arrLCS[i - 1][j - 1] + 1;
                    } else
                        arrLCS[i][j] = Math.max(arrLCS[i][j - 1], arrLCS[i - 1][j]);
                }
                System.out.printf(" %2d ", arrLCS[i][j]);
            }
            System.out.println();
        }

        printResultLCS(arrX, arrY, arrLCS);
        userInput.close();
    }

    private static void printResultLCS(String[] arrX, String[] arrY, int[][] arrLCS) {
        int LCSAmount = 0;
        int max = 0;
        ArrayList<ArrayList<String>> LCSs = new ArrayList<ArrayList<String>>();

        for (int i = 0; i < arrY.length + 1; i++) {
            if (arrLCS[arrX.length][i] > max) {
                max = arrLCS[arrX.length][i];
                LCSAmount = 1;
            } else
                LCSAmount++;
        }

        for (int k = 0; k < LCSAmount; k++) {
            int i = arrX.length;
            int j = arrY.length - k;
            ArrayList<String> LCS = new ArrayList<String>();

            while (i != 0 || j != 0) {
                if (arrLCS[i][j] == arrLCS[i - 1][j])
                    i--;
                else if (arrLCS[i][j] == arrLCS[i][j - 1])
                    j--;
                else {
                    i--;
                    j--;
                    LCS.add(arrX[i]);
                }
            }

            Collections.reverse(LCS);

            boolean isRepeated = false;

            for (ArrayList<String> sequence : LCSs) {
                if (LCS.equals(sequence)) {
                    isRepeated = true;
                    break;
                }
            }

            if (!isRepeated)
                LCSs.add(LCS);
        }
        System.out.println("\nLCSs: " + LCSs);
    }
}