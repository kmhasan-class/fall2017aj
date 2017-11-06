package bd.ac.seu.aj.streamlabtask.model;

import java.util.ArrayList;
import java.util.List;

public class Faculty {
    private String facultyInitials;
    private String fullName;
    private Rank rank;
    private List<Section> assignedSections;

    public Faculty() {
        assignedSections = new ArrayList<>();
    }

    public Faculty(String facultyInitials, String fullName, Rank rank) {
        this.facultyInitials = facultyInitials;
        this.fullName = fullName;
        this.rank = rank;
    }

    public String getFacultyInitials() {
        return facultyInitials;
    }

    public String getFullName() {
        return fullName;
    }

    public Rank getRank() {
        return rank;
    }

    public List<Section> getAssignedSections() {
        return assignedSections;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Faculty{");
        sb.append("facultyInitials='").append(facultyInitials).append('\'');
        sb.append(", fullName='").append(fullName).append('\'');
        sb.append(", rank=").append(rank);
        sb.append(", assignedSections=").append(assignedSections);
        sb.append('}');
        return sb.toString();
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
}
