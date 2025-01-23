package packA;

public class EmpTmp {
    protected String name;
    protected int salary;
    protected int experience;

    public EmpTmp(String n, int exp, int sal){
        name = n;
        salary = sal;
        experience = exp;
    }
    public EmpTmp(String n){
        name = n;
    }
    public EmpTmp(){

    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setSalary(int newSalary){
        salary = newSalary;
    }
    public int getSalary(){
        return salary;
    }
    public void setExperience(int exp){
        experience = exp;
    }
    public int getExperience(){
        return experience;
    }
    public String toString(){
        return String.format("Programmer [name=%s, salary=%d, experience=%d]", name, salary, experience);
    }
    public void sayHi(){
        System.out.println("hi from " + name);
    }
}
