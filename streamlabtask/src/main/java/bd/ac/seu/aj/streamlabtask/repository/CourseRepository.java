package bd.ac.seu.aj.streamlabtask.repository;

import bd.ac.seu.aj.streamlabtask.model.Course;
import bd.ac.seu.aj.streamlabtask.model.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CourseRepository {
    private static final List<Course> COURSE_LIST = new ArrayList<>();
    private static final Random RANDOM = new Random();
    private static final String COURSE_TYPES[] = {"CSE", "ENG", "MATH", "PHY", "STAT", "ACT", "MGT", "EEE", "ECO", "SOC"};

    static {
        createRandomCourses(500);
    }

    private static void createRandomCourses(int courseCount) {
        for (int i = 0; i < courseCount; i++)
            COURSE_LIST.add(new Course(COURSE_TYPES[randBetween(0, COURSE_TYPES.length - 1)] + randBetween(1000, 4999),
                    "someTitle", Math.random() < 0.3 ? 1 : 3));
    }

    private static int randBetween(int min, int max) {
        return RANDOM.nextInt(max + 1 - min) + min;
    }

    public static List<Course> getCourseList() {
        return COURSE_LIST;
    }
}
