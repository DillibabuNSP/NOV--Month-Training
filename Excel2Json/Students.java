package Excel2Json;

public class Students {

    private String Name;
    private int Age;
    private int TotalMarks;

    public Students(String name, int age, int totalMarks) {
        Name = name;
        Age = age;
        TotalMarks = totalMarks;
    }

    public String getName() {

        return Name;
    }

    public void setName(String name) {

        Name = name;
    }

    public int getAge()
    {
        return Age;
    }

    public void setAge(int age)
    {
        Age = age;
    }

    public int getTotalMarks() {

        return TotalMarks;
    }


    public void setTotalMarks(int totalMarks)
    {
        TotalMarks = totalMarks;
    }

    public Students() {
    }

    @Override
    public String toString() {
        return "Students{" +
                "Name='" + Name + '\'' +
                ", Age=" + Age +
                ", TotalMarks=" + TotalMarks +
                '}';
    }
}
