import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class SillyLuckyNumber {
    private String breed;
    private int luckyNumber;
    private int threeDigit; // 0 to 999

    public SillyLuckyNumber(String s) {
        breed = s;
        for (int i = 0; i < breed.length(); i++)
            luckyNumber += breed.charAt(i);
        threeDigit = luckyNumber % 1000;
    }

    public int getLuckyNumber() {
        return luckyNumber;
    }

    // Task 3
    public void setBreed(String breed) {
        this.breed = breed;
    }

    @Override
    public String toString() {
        return "<<" + breed + " "
                + luckyNumber + " " + threeDigit + ">>";
    }

    public static class MyArrDemo<T> {
        public final int MAX_SIZE = 9;
        private int size = 0;
        private Object[] arr = new Object[MAX_SIZE];

        public void add(T instance) {
            arr[size++] = instance;
        }

        public void set(int i, T instance) {
            arr[i] = instance;
        }

        public T get(int i) {
            @SuppressWarnings("unchecked")
            final T element = (T) arr[i];
            return element;
        }

        // Task 4
        public void swap(int i, int j) {
            if (i >= 0 && i < size && j >= 0 && j < size) {
                T temp = get(i);
                set(i, get(j));
                set(j, temp);
            } else {
                System.out.println("Invalid index");
            }
        }

        public int currentSize() {
            return size;
        }

        @Override
        public String toString() {
            StringBuffer sb = new StringBuffer();
            sb.append("My snapshot looks like this -> ");
            for (int i = 0; i < size; i++)
                sb.append(arr[i] + ",");
            return sb.toString();
        }
    }

    // Task 5
    static void selectionSort(MyArrDemo<SillyLuckyNumber> arr) {
        int n = arr.currentSize();
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr.get(j).getLuckyNumber() < arr.get(minIndex).getLuckyNumber()) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                arr.swap(i, minIndex);
            }
        }
    }

    static void ex0() {
        System.out.println("-ex0---");
        int[] arr = { 7, 3, 1, 9, 6, 8, 4, 2, 5 };
        System.out.println(Arrays.toString(arr));
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void demo1() {
        System.out.println("-demo1---");
        SillyLuckyNumber[] arr = {
                new SillyLuckyNumber("Terrier"), new SillyLuckyNumber("Jack"),
                new SillyLuckyNumber("Pom"), new SillyLuckyNumber("Beagle")
        };
        System.out.println(Arrays.toString(arr));
        // Task 1
        Comparator<SillyLuckyNumber> engine = (o1, o2) -> Integer.compare(o1.getLuckyNumber(), o2.getLuckyNumber());
        Arrays.sort(arr, engine);
        System.out.println(Arrays.toString(arr));
    }

    static void demo2() {
        System.out.println("-demo2----");
        ArrayList<SillyLuckyNumber> list = new ArrayList<>(Arrays.asList(
                new SillyLuckyNumber("Terrier"), new SillyLuckyNumber("Jack"),
                new SillyLuckyNumber("Pom"), new SillyLuckyNumber("Beagle")));
        System.out.println(list);
        // Task 2
        Collections.sort(list,
                Comparator.comparing(SillyLuckyNumber::getLuckyNumber));
        System.out.println(list);
    }

    static void demo3() {
        System.out.println("-demo3----");
        ArrayList<SillyLuckyNumber> list = new ArrayList<>(Arrays.asList(
                new SillyLuckyNumber("Terrier"), new SillyLuckyNumber("Jack"),
                new SillyLuckyNumber("Pom"), new SillyLuckyNumber("Beagle")));
        System.out.println(list);
        list.sort(Comparator.comparing(SillyLuckyNumber::getLuckyNumber));
        System.out.println(list);
        // demo shallow copy
        ArrayList<SillyLuckyNumber> anotherList = new ArrayList<>(list.subList(0,
                list.size()));
        anotherList.get(0).setBreed("newBreed"); // Terrier
        System.out.println(list); // notice how Terrier in list is also effected
    }

    static void demo4() {
        System.out.println("-demo4----");
        MyArrDemo<SillyLuckyNumber> arr = new MyArrDemo<>();
        arr.add(new SillyLuckyNumber("Terrier"));
        arr.add(new SillyLuckyNumber("Jack"));
        arr.add(new SillyLuckyNumber("Pom"));
        arr.add(new SillyLuckyNumber("Beagle"));
        System.out.println(arr);
        arr.swap(16, 3);
        System.out.println(arr);
    }

    static void demo5() {
        System.out.println("-demo5----");
        MyArrDemo<SillyLuckyNumber> arr = new MyArrDemo<>();
        arr.add(new SillyLuckyNumber("Terrier"));
        arr.add(new SillyLuckyNumber("Jack"));
        arr.add(new SillyLuckyNumber("Pom"));
        arr.add(new SillyLuckyNumber("Beagle"));
        arr.add(new SillyLuckyNumber("Cocker Spaniel"));
        arr.add(new SillyLuckyNumber("Basenji"));
        System.out.println(arr);
        selectionSort(arr);
        System.out.println(arr);
    }

    public static void main(String[] args) {
        demo5();
    }
}
