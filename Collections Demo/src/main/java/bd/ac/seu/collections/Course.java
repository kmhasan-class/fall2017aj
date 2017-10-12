package bd.ac.seu.collections;

public class Course {
    private String courseCode;
    private String courseTitle;
    private double credits;

    public Course() {
    }

    public Course(String courseCode, String courseTitle, double credits) {
        this.setCourseCode(courseCode);
        this.setCourseTitle(courseTitle);
        this.setCredits(credits);
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public double getCredits() {
        return credits;
    }

    public void setCredits(double credits) {
        this.credits = credits;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseCode='" + courseCode + '\'' +
                ", courseTitle='" + courseTitle + '\'' +
                ", credits=" + credits +
                '}';
    }
}
