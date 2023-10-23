package ss12_dsa_stack_quece.exec.demerging_uses_queue;

public class Person implements Comparable<Person>{
    private String name;
    private String gender;
    private int year;
    private int month;
    private int day;
    public Person(){}

    public Person(String name, String gender,  int day, int month,int year) {
        this.name = name;
        this.gender = gender;
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @Override
    public int compareTo(Person o) {
        if (this.year != o.year){
            return Integer.compare(this.year, o.year);
        } else if (this.month != o.month){
            return Integer.compare(this.month, o.month);
        } else {
            return Integer.compare(this.day, o.day);
        }
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }
}
