package packEmp;

public abstract class Employee {
    protected String name;
    protected int experience;
    protected int salary;

    public Employee(String n, int exp, int sal) {
        name = n;
        experience = exp;
        salary = sal;
    }

    public void setName(String n) {
        name = n;
    }

    public String getName() {
        return name;
    }

    public void setExperience(int exp) {
        experience = exp;
    }

    public int getExperience() {
        return experience;
    }

    public void setSalary(int sal) {
        salary = sal;
    }

    public int getSalary() {
        return salary;
    }

    public abstract void sayHi();
}
