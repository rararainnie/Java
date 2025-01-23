package packA;

public class Programmer extends EmpTmp {
    public Programmer(String n, int exp, int sal) {
        super(n, exp, sal);
    }

    @Override
    public void sayHi() {

    }

    @Override
    public String toString() {
        return "Hello";
    }

    public String coding() {
        return "From Programmer";
    }
}