package bd.ac.seu.aj.streamlabtask.model;

public class Course {
    private String courseCode;
    private String courseTitle;
    private double credits;

    public Course(String courseCode, String courseTitle, double credits) {
        this.courseCode = courseCode;
        this.courseTitle = courseTitle;
        this.credits = credits;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public double getCredits() {
        return credits;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Course{");
        sb.append("courseCode='").append(courseCode).append('\'');
        sb.append(", courseTitle='").append(courseTitle).append('\'');
        sb.append(", credits=").append(credits);
        sb.append('}');
        return sb.toString();
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
}
