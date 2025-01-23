package packEmp;

public class Accountant extends Employee {
    private static String companyName = "berk barn jamkad";
    private int experience;
    private String specialty;

    public Accountant(String name, int superExp, int experience, int sal, String talent) {
        super(name, superExp, sal);
        this.experience = experience;
        specialty = talent;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setAccountExperience(int exp) {
        experience = exp;
    }

    public int getAccountExperience() {
        return experience;
    }

    @Override
    public void sayHi() {
        System.out.println("From Acc");
    }

    public String tellProfit() {
        return companyName + "'s profit is " + (int) (Math.random() * 1000) + ". My salary is " + salary;
    }

    public static String tellMyRole() {
        return "I am an accountant at " + companyName;
    }
}
