import java.util.Arrays;

public class Lab5_650389 {
    static int[] data = { 28, 58, 8, 77, 48, 39 };
    static ArrayProcessor q1NumberOfEvenElement;
    static ArrayProcessor q2IndexOfLargestEvenValue;
    static ArrayProcessor myMedian;

    public static void main(String[] args) {
        q1NumberOfEvenElement();
        q2IndexOfLargestEvenValue();
        oneline();
    }

    static void q1NumberOfEvenElement() {
        q1NumberOfEvenElement = arr -> {
            int count = 0;
            for (int i : arr) {
                if (i % 2 == 0)
                    count++;
            }
            return count;
        };
        System.out.println(q1NumberOfEvenElement.calculate(data));
    }

    static void q2IndexOfLargestEvenValue() {
        q2IndexOfLargestEvenValue = arr -> {
            int max = arr[0];
            int index = 0;
            for (int i : arr) {
                if (i % 2 == 0) {
                    max = (max > i) ? max : i;
                }
            }
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == max) {
                    index = i;
                    break;
                }
            }
            return index;
        };
        System.out.println(q2IndexOfLargestEvenValue.calculate(data));
    }

    static void oneline() {
        int[] tmp = Arrays.copyOf(data, data.length);
        Arrays.sort(tmp);
        myMedian = arr -> arr[arr.length / 2];
        System.out.println(myMedian.calculate(tmp));
    }
}
