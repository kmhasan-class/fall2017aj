package bd.ac.seu.aj.streamlabtask.model;

import java.util.ArrayList;
import java.util.List;

public class Semester {
    int semesterNumber;
    String semesterLabel;
    private final static int START_YEAR = 2002;
    private final static String LABELS[] = {"Spring", "Summer", "Fall"};
    private final static List<Semester> cachedSemesterList = new ArrayList<>();

    static {
        // add a null entry for semester 0
        cachedSemesterList.add(null);

        for (int i = 1; i <= 100; i++) {
            Semester.of(i);
        }
    }

    private Semester(int semesterNumber, String semesterLabel) {
        this.semesterNumber = semesterNumber;
        this.semesterLabel = semesterLabel;
    }

    public static Semester of(int semesterNumber) {
        if (semesterNumber >= cachedSemesterList.size()) {
            for (int i = cachedSemesterList.size(); i <= semesterNumber; i++) {
                int year = semesterNumber / 3 + START_YEAR;
                int index = semesterNumber % 3;

                cachedSemesterList.add(new Semester(i, LABELS[index] + " " + year));
            }
        }

        return cachedSemesterList.get(semesterNumber);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Semester{");
        sb.append("semesterNumber=").append(semesterNumber);
        sb.append(", semesterLabel='").append(semesterLabel).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Semester semester = (Semester) o;

        return semesterNumber == semester.semesterNumber;
    }

    @Override
    public int hashCode() {
        return semesterNumber;
    }
}
