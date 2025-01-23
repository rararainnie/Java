public class MyDate {
    int day;
    int month;
    int year;
    
    public int getDay() {
        return day;
    }
    public void setDay(int d) {
        this.day = d;
    }
    public int getMonth() {
        return month;
    }
    public void setMonth(int m) {
        this.month = m;
    }
    public int getYear() {
        return year;
    }
    public void setYear(int y) {
        this.year = y;
    }

    public String toString(){
        return String.format("%d/%d/%d", day, month, year);
    }
}
