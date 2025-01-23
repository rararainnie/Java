package packEmp;

import java.util.ArrayList;
import java.util.Arrays;

public class Programmer extends Employee {
    private ArrayList<String> skills;

    public Programmer(String n, int exp, int sal, String... sk) {
        super(n, exp, sal);
        skills = new ArrayList<>(Arrays.asList(sk));
    }

    public ArrayList<String> getSkills() {
        return skills;
    }

    public void setSkills(String... skLang) {
        for (String skList : skLang) {
            skills.add(skList);
        }
    }

    public String coding() {
        return "Coding in " + skills;
    }

    @Override
    public void sayHi() {
        System.out.println("From Programmer");
    }
}
