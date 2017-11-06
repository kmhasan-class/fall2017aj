package bd.ac.seu.aj.streamlabtask.repository;

import bd.ac.seu.aj.streamlabtask.model.Course;
import bd.ac.seu.aj.streamlabtask.model.Faculty;
import bd.ac.seu.aj.streamlabtask.model.Section;
import bd.ac.seu.aj.streamlabtask.model.Semester;

import java.util.ArrayList;
import java.util.List;

public class SectionRepository {
    private static final List<Section> SECTION_LIST = new ArrayList<>();

    static {
        createRandomSections(1000);
    }

    /**
     * Creates random sections and puts them in the section list
     * @param sectionCount the number of sections to create
     */
    private static void createRandomSections(int sectionCount) {
        List<Course> courseList = CourseRepository.getCourseList();
        List<Faculty> facultyList = FacultyRepository.getFacultyList();

        for (int i = 0; i < sectionCount; i++) {
            Faculty faculty = facultyList.get((int) (Math.random() * facultyList.size())); // ADD CODE TO RANDOMLY PICK A FACULTY
            Course course = null; // ADD CODE TO RANDOMLY PICK A COURSE
            Semester semester = null; // ADD CODE TO RANDOMLY PICK A SEMESTER IN THE RANGE [1, 50]
            int sectionNumber = 0; // ADD CODE TO FIND OUT WHAT THE NEW SECTION NUMBER SHOULD BE
            // ALL THE SECTIONS ARE TO BE NUMBERED SEQUENTIALLY STARTING FROM 1
            // USE LAMBDAS AND STREAMS HERE

            Section section = new Section(course, sectionNumber, semester, faculty);
            SECTION_LIST.add(section);
        }
    }

    public static List<Section> getSectionList() {
        return SECTION_LIST;
    }
}
