import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.Set;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

import packExercise.*;

public class Lab9_650389 {
    static ArrayList<Employee> empList;
    static {
        empList = new ArrayList<>();
        try (Scanner input = new Scanner(Paths.get("packExercise//names.csv"))) {
            input.nextLine(); // skip first row
            while (input.hasNext()) {
                String row = input.nextLine().trim();
                empList.add(new Employee(row));
            }
            System.out.println("There are " + empList.size() + " employees.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println("Q1------");
        q6();
        System.out.println("Q2------");
        q7();
        System.out.println("Q3------");
        q8();
        System.out.println("Q4------");
        q9();
        System.out.println("Q5------");
        q10();
        System.out.println("Q6------");
        q11();
        System.out.println("Q7------");
        q12();
        System.out.println("Q8------");
        q13();
        System.out.println("Q9------");
        q14();
        System.out.println("Q10------");
        q15();
    }

    static void q6() {
        List<Employee> singers1 = new ArrayList<Employee>(Arrays.asList(new Employee("aba"), new Employee("abi")));
        List<Employee> singers2 = new ArrayList<>();
        singers2.add(new Employee("abo"));
        singers2.add(new Employee("abe"));

        List<Employee> join = q6_1(singers1, singers2);

        System.out.println(singers1);
        System.out.println(singers2);
        System.out.println(join);
        singers1.addAll(singers2);
        System.out.println(singers1);
    }

    private static List<Employee> q6_1(List<Employee> l1, List<Employee> l2) {
        List<Employee> resultJoin = new ArrayList<>();
        resultJoin.addAll(l1);
        resultJoin.addAll(l2);
        return resultJoin;
    }

    static void q7() {
        List<Employee> singers = Arrays.asList(new Employee("aba"), new Employee("abi"));
        System.out.println(singers);
        singers = q7_1(singers);
        System.out.println(singers);
    }

    private static List<Employee> q7_1(List<Employee> list) {
        List<Employee> newList = Arrays.asList(list.get(0));
        return newList;
    }

    static void q8() {
        Employee yindee = new Employee("yindee");
        Employee preeda = new Employee("preeda");
        Employee pramote = new Employee("pramote");
        List<Employee> list1 = Arrays.asList(yindee, pramote);
        List<Employee> list2 = Arrays.asList(pramote, preeda);
        Set<Employee> empSet = new HashSet<>(list1);
        empSet.addAll(list2);
        List<Employee> q8_ans = new ArrayList<>(empSet);
        System.out.println(q8_ans);
    }

    static void q9() {
        Employee yindee = new Employee("yindee");
        Employee preeda = new Employee("preeda");
        Employee pramote = new Employee("pramote");
        List<Employee> list1 = new ArrayList<>();
        list1.add(yindee);
        list1.add(preeda);
        list1.add(pramote);
        Set<Employee> empSet1 = new HashSet<>(list1);
        List<Employee> list2 = new ArrayList<>();
        list2.add(yindee);
        list2.add(pramote);
        empSet1.retainAll(list2);
        System.out.println(empSet1);
    }

    static void q10() {
        Employee yindee = new Employee("yindee");
        Employee preeda = new Employee("preeda");
        Employee pramote = new Employee("pramote");
        List<Employee> list1 = new ArrayList<>();
        list1.add(yindee);
        list1.add(preeda);
        list1.add(pramote);
        Set<Employee> empSet1 = new HashSet<>(list1);
        List<Employee> list2 = new ArrayList<>();
        list2.add(yindee);
        list2.add(pramote);
        empSet1.removeAll(list2);
        System.out.println(empSet1);
    }

    static void q11() {
        Set<Employee> empSet = new HashSet<>();
        empSet.add(new Employee("yindee"));
        empSet.add(new Employee("pramote"));
        empSet.add(new Employee("preeda"));
        empSet.add(new Employee("pramote"));
        Employee[] q11_ans = new Employee[empSet.size()];
        q11_ans = empSet.toArray(q11_ans);
        for (Employee e : q11_ans)
            System.out.print(e + " ");
        System.out.println();
    }

    static void q12() {
        int n = 3;
        Map<String, Employee> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            Employee emp = empList.get(i);
            map.put(emp.getName(), emp);
        }
        System.out.println(map);
    }

    static void q13() {
        int n = 3;
        Map<String, Employee> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            Employee emp = empList.get(i);
            map.put(emp.getName(), emp);
        }
        Set<String> keySet = map.keySet();
        System.out.println(keySet);
    }

    static void q14() {
        PriorityQueue<Employee> pq = new PriorityQueue<>(
                (e1, e2) -> Integer.compare(e1.getSalary(), e2.getSalary()));
        pq.addAll(empList);
        List<Employee> q14_ans = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            q14_ans.add(pq.poll());
        }
        System.out.println(q14_ans);
    }

    static void q15() {
        int sum = 0;
        int cnt = 0;
        Iterator<Employee> it;
        Long pqStart = System.nanoTime(); // System.currentTimeMillis();
        sum = 0;
        PriorityQueue<Employee> pq = new PriorityQueue<>((e1, e2) -> Integer.compare(e1.getSalary(), e2.getSalary()));
        pq.addAll(empList);
        it = pq.iterator();
        while (it.hasNext()) {
            sum += it.next().getSalary();
            cnt++;
        }
        System.out.println("PQ (" + sum + ") takes "
                + String.format("%,d", System.nanoTime() - pqStart));
        Long listStart = System.nanoTime();
        ArrayList<Employee> clone = new ArrayList<>();
        sum = 0;
        clone.addAll(empList);
        Collections.sort(clone, (e1, e2) -> Integer.compare(e1.getSalary(), e2.getSalary()));
        it = clone.iterator();
        while (it.hasNext()) {
            sum += it.next().getSalary();
            cnt--;
        }
        System.out.println("ArrayList (" + sum + ") takes "
                + String.format("%,d", System.nanoTime() - listStart));
        if (cnt != 0)
            System.out.println("error on number of elements");
    }
    // sort faster than pq
}
