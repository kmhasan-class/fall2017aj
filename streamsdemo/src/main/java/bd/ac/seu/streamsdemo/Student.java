package bd.ac.seu.streamsdemo;

public class Student {
    private int id;
    private String name;
    private double age;

    public Student(int id, String name, double age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAge() {
        return age;
    }

    public void setAge(double age) {
        this.age = age;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Student{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", age=").append(age);
        sb.append('}');
        return sb.toString();
    }

    public void doSomething() {
        System.out.println(name.toUpperCase());
    }

    public void doSomethingElse(double x) {
        System.out.println(name.toUpperCase() + x);
    }
}
