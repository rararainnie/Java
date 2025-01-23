import java.util.ArrayList;
import java.util.Arrays;

public class Lab1Coder{
    private String name;
    private ArrayList<String> languages;
    int experience;

    Lab1Coder(String n){
        name = n;
    }

    Lab1Coder(String n, int exp){
        name = n;
        experience = exp;
    }

    void setLanguages(String... lang){
        languages = new ArrayList<>(Arrays.asList(lang));
    }
    ArrayList<String> getLanguages(){
        return languages;
    }

    String getName(){
        return name;
    }
    void setName(String name){
        this.name = name;
    }

    int getExperience(){
        return experience;
    }
    void setExperience(int exp){
        experience = exp;
    }

    ArrayList<String> findCommonLanguages(Lab1Coder others){
        ArrayList<String> arrCommon = new ArrayList<>();
        for (int i = 0; i < languages.size(); i++) {
            if (others.getLanguages().contains(languages.get(i))){
                arrCommon.add(languages.get(i));
            }
        }
        if (arrCommon.isEmpty()){
            arrCommon.add("none");
        }

        return arrCommon;
    }

    public String toString(){
        String str = String.format("%s(%d) knows", name, experience);
        for (String s : languages){
            str += " " + s;
        }
        
        return str;
    }
}