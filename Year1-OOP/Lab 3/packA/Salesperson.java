package packA;

public class Salesperson extends EmpTmp {
    private int target;

    public Salesperson(String n, int exp) {
        super(n);
        super.setExperience(exp);
    }

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
    public void setSalary(int incresedAmount) {
        salary += incresedAmount;
    }

    public String makeQuotation() {
        return "Dear value customer, " + (int) (Math.random() * 900 + 100) + " is my best offer.";
    }

    @Override
    public String toString() {
        return "Salesperson [target=" + target + " " + super.toString() + " ]";
    }

}
