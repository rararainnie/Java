import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lab9_1_65050389 {
    static final int L = 10;

    public static void main(String[] args) {
        int[] items = { 2, 8, 3, 4, 1, 10, 6, 9, 5 };

        System.out.println("First Fit");
        System.out.println(Arrays.toString(items).replace("[", "").replace("]", ""));
        firstFit(items);

        System.out.println("\nBest Fit");
        System.out.println(Arrays.toString(items).replace("[", "").replace("]", ""));
        bestFit(items);

        System.out.println("\nFFD (First-fit decreasing)");
        int[] itemsFFD = Arrays.copyOf(items, items.length);
        Arrays.sort(itemsFFD);
        reverse(itemsFFD);
        System.out.println(Arrays.toString(itemsFFD).replace("[", "").replace("]", ""));
        firstFit(itemsFFD);
    }

    static void firstFit(int[] items) {
        List<List<Integer>> bins = new ArrayList<>();
        bins.add(new ArrayList<>());

        for (int i = 0; i < items.length; i++) {
            boolean packed = false;
            for (int j = 0; j < bins.size(); j++) {
                if (sumList(bins.get(j), items) + items[i] <= L) {
                    bins.get(j).add(i + 1);
                    System.out.println("S" + (i + 1) + " = " + items[i] + " in Bin " + (j + 1));
                    packed = true;
                    break;
                }
            }
            if (!packed) {
                bins.add(new ArrayList<>());
                bins.get(bins.size() - 1).add(i + 1);
                System.out.println("S" + (i + 1) + " = " + items[i] + " in Bin " + bins.size());
            }
        }

        printBins(bins, items);
    }

    static void bestFit(int[] items) {
        List<List<Integer>> bins = new ArrayList<>();

        for (int i = 0; i < items.length; i++) {
            int minSpaceLeft = Integer.MAX_VALUE;
            int bestBinIdx = -1;
            for (int j = 0; j < bins.size(); j++) {
                if (sumList(bins.get(j), items) + items[i] <= L) {
                    int spaceLeft = L - sumList(bins.get(j), items) - items[i];
                    if (spaceLeft < minSpaceLeft) {
                        minSpaceLeft = spaceLeft;
                        bestBinIdx = j;
                    }
                }
            }
            if (bestBinIdx != -1) {
                bins.get(bestBinIdx).add(i + 1);
                System.out.println("S" + (i + 1) + " = " + items[i] + " in Bin " + (bestBinIdx + 1));
            } else {
                bins.add(new ArrayList<>());
                bins.get(bins.size() - 1).add(i + 1);
                System.out.println("S" + (i + 1) + " = " + items[i] + " in Bin " + bins.size());
            }
        }

        printBins(bins, items);
    }

    static void printBins(List<List<Integer>> bins, int[] items) {
        for (int i = 0; i < bins.size(); i++) {
            System.out.print("Bin" + (i + 1) + " : ");
            for (int j = 0; j < bins.get(i).size(); j++) {
                int itemIndex = bins.get(i).get(j);
                System.out.print(itemIndex + "(" + items[itemIndex - 1] + ")");
                if (j < bins.get(i).size() - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println();
        }
    }

    static int sumList(List<Integer> list, int[] items) {
        int sum = 0;
        for (int index : list) {
            sum += items[index - 1];
        }
        return sum;
    }

    static void reverse(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
