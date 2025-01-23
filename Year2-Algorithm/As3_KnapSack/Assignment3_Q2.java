/*
 * 65050389 Thumasorn Prasertsri
 * Assignment3 Question 2 -> Knapsack
 * p = 96 51 51 38 90
 * w = 8 13 12 15 20
 * M = 45;
 */

import java.util.Arrays;
import java.util.Comparator;

public class Assignment3_Q2 {
    public static void main(String[] args) {
        double[] p = { 96, 51, 51, 38, 90 };
        double[] w = { 8, 13, 12, 15, 20 };
        double M = 45;

        double result = calculateKnapsack(p, w, M);
        System.out.printf("Result = %.1f", result);
    }

    public static Integer[] sortIdxByPdivW(double[] p, double[] w) {
        Integer[] idx = new Integer[p.length];
        for (int i = 0; i < idx.length; i++) {
            idx[i] = i;
        }
        Arrays.sort(idx, Comparator.comparingDouble(i -> -p[i] / w[i]));

        return idx;
    }

    public static double calculateKnapsack(double[] p, double[] w, double M) {
        Integer[] idx = sortIdxByPdivW(p, w);
        double[] x = new double[p.length];
        double totalValue = 0.0;

        for (int i = 0; i < x.length; i++) {
            int curIdx = idx[i];
            if (w[curIdx] <= M) {
                x[curIdx] = 1;
                M -= w[curIdx];
            } else {
                x[curIdx] = M / w[curIdx];
                M = 0;
            }
        }

        for (int i = 0; i < x.length; i++) {
            totalValue += x[idx[i]] * p[idx[i]];
        }

        return totalValue;
    }
}