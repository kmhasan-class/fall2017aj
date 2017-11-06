package bd.ac.seu.aj.streamlabtask.repository;

import bd.ac.seu.aj.streamlabtask.model.Faculty;
import bd.ac.seu.aj.streamlabtask.model.Rank;
import org.ajbrown.namemachine.Name;
import org.ajbrown.namemachine.NameGenerator;

import java.util.ArrayList;
import java.util.List;

public class FacultyRepository {
    private static final List<Faculty> FACULTY_LIST = new ArrayList<>();

    static {
        createRandomFaculties(100);
    }

    private static void createRandomFaculties(int facultyCount) {
        NameGenerator generator = new NameGenerator();
        List<Name> names = generator.generateNames(facultyCount);

        for (int i = 0; i < facultyCount; i++) {
            String facultyName = names.get(i).getFirstName() + " " + names.get(i).getLastName();
            final String initials = "" + names.get(i).getFirstName().charAt(0) + names.get(i).getLastName().charAt(0);
            long countSameInitials = getFacultyList().stream().filter(faculty -> faculty.getFacultyInitials().startsWith(initials)).count();
            String facultyInitials = initials;
            if (countSameInitials > 0)
                facultyInitials += countSameInitials + 1;
            Rank rank = Rank.values()[(int) (Math.random() * Rank.values().length)];
            Faculty faculty = new Faculty(facultyInitials, facultyName, rank);
            FACULTY_LIST.add(faculty);
        }
    }

    public static List<Faculty> getFacultyList() {
        return FACULTY_LIST;
    }
}
