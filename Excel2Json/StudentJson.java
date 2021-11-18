package Excel2Json;

public class StudentJson {

    private String Name;
    private int Age;
    private double TotalMarks;

    public StudentJson() {
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public double getTotalMarks() {
        return TotalMarks;
    }

    public void setTotalMarks(double totalMarks) {
        TotalMarks = totalMarks;
    }

    public StudentJson(String name, int age, double totalMarks) {
        Name = name;
        Age = age;
        TotalMarks = totalMarks;
    }

    @Override
    public String toString() {
        return "StudentJson{" +
                "Name='" + Name + '\'' +
                ", Age=" + Age +
                ", TotalMarks=" + TotalMarks +
                '}';
    }
}
