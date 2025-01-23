package packA;

public class Salesperson extends Programmer {
    private int target;

    public Salesperson(String n, int exp, int salary, int assignedTarget) {
        super(n, exp, salary);
        target = assignedTarget;
    }

    public Salesperson(String n, int exp) {
        super(n);
        super.setExperience(exp);
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
    public void setSalary(int incresedAmount) {
        salary += incresedAmount;
    }

    public String makeQuotation() {
        return "Dear value customer, " + (int) (Math.random() * 1000) + " is my best offer.";
    }

    @Override
    public String toString() {
        return String.format("Salesperson [target=%d " + super.toString() + "]", target);
    }
}
