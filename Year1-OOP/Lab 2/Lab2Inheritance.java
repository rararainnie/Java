import packA.*;

public class Lab2Inheritance {
    public static void main(String[] args) {
        q1();
        q2_Salesperson();
        q3_Accountant();
    }

    static void q1() {
        var p1 = new Programmer("ber1", 2, 500);
        System.out.println(p1);
    }

    static void q2_Salesperson() {
        var p2 = new Salesperson("mr.salesperson", 5, 150, 5000);
        var p3 = new Salesperson("mr.kayan", 4, 260, 9000);
        System.out.println("example of inherited method " + p2.getName());
        System.out.println(p2.makeQuotation());
        System.out.print("another example of inherited method ");
        p3.sayHi();
        System.out.println("notice the result of overridden setSalary(int incresedAmount) below");
        System.out.print(p2.getName() + "'s salary was " + p2.getSalary() + " -> ");
        p2.setSalary(100);
        System.out.println(p2);
        p2.setSalary();
        System.out.println(p2);
        System.out.println(p3);
    }

    static void q3_Accountant() {
        var p4 = new Accountant("goodAtmyJob", 7, 6, 390, "sing");
        var p5 = new Accountant("canRap", 4, 9, 480, "rap");
        System.out.println(p4.tellProfit());
        p5.sayHi();
        System.out.println(Accountant.tellMyRole());
        System.out.println(p4);
        System.out.println(p5);
    }
}
