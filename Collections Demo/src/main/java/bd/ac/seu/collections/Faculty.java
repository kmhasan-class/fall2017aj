package bd.ac.seu.collections;

public class Faculty {
    private String facultyInitials;

    public Faculty(String facultyInitials) {
        this.facultyInitials = facultyInitials;
    }

    public String getFacultyInitials() {
        return facultyInitials;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Faculty faculty = (Faculty) o;

        return facultyInitials.equals(faculty.facultyInitials);
    }

    @Override
    public int hashCode() {
        return facultyInitials.hashCode();
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "facultyInitials='" + facultyInitials + '\'' +
                '}';
    }
}
