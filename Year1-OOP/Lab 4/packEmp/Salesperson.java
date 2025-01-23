package packEmp;

public class Salesperson extends Employee implements SalesRoles {
    private int target;

    public Salesperson(String n, int exp, int sal, int assignedTarget) {
        super(n, exp, sal);
        target = assignedTarget;
    }

    public void setTarget(int target) {
        this.target = target;
    }

    public int getTarget() {
        return target;
    }

    public void setSalary() {
        salary *= 1.1;
    }

    @Override
    public void setSalary(int incAmount) {
        salary += incAmount;
    }

    @Override
    public void sayHi() {
        System.out.println("From Salesperson");
    }

    public String makeQuotation() {
        return "Dear value customer, " + (int) (Math.random() * 900 + 100) + " is my best offer.";
    }
}
