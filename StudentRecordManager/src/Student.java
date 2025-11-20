public class Student {
    private int id;
    private String name;
    private String course;
    private double grade;

    public Student(int id, String name, String course, double grade) {
        this.id = id;
        this.name = name;
        this.course = course;
        this.grade = grade;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCourse() {
        return course;
    }

    public double getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return "ID: " + id +
               ", Name: " + name +
               ", Course: " + course +
               ", Grade: " + grade;
    }
}
