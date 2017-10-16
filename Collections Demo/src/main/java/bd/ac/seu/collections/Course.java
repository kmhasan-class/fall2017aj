package bd.ac.seu.collections;

public class Course {
    private String courseCode;
    private String courseTitle;
    private double credits;

    /*
    Lab task
    add two methods
    1) return the number of students that got grades for this course for a given semester
        int getStudentCount(int semesterId)
    2) return the average numeric grade point for all the students for this course for a given semester
        double getAverageGrade(int semesterId)
     */
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Course course = (Course) o;

        return courseCode.equals(course.courseCode);
    }

    @Override
    public int hashCode() {
        return courseCode.hashCode();
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
