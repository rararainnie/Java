package packEmp;

public class ProgrammerManager extends Programmer implements ManagerRoles {
    public ProgrammerManager(String n, int exp, int sal, String... skills) {
        super(n, exp, sal, skills);
    }

    public ProgrammerManager(String n, int exp, int sal) {
        super(n, exp, sal);
    }

    @Override
    public void sayHi() {
        System.out.println("From ProgrammerManager");
    }

    @Override
    public String coding() {
        return super.coding();
    }

    public int evaluate(Programmer p) {
        return p.salary = (int) Math.round(p.salary * 1.15);
    }

    public String toString() {
        return "ManagerProgrammer [name=" + name + ", experience=" + experience + ", salary=" + salary + "]";
    }
}
