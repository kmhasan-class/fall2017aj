package bd.ac.seu.collections;

import java.util.*;

/**
 * Main class that drives the demonstrations.
 *
 * @author Monirul Hasan
 * @version 1.0-SNAPSHOT
 */
public class Main {
    private List<Student> studentList;
    private List<Course> courseList;
    private List<Registration> registrationList;
    private List<GradeRecord> gradeRecordList;
    private Set<Faculty> facultySet;
    private Map<Integer, Student> studentMap;
    private Map<String, Course> courseMap;

    public Main() {
        studentMap = new HashMap<>();
        courseMap = new HashMap<>();
        facultySet = new HashSet<>();

        StudentDao studentDao = new StudentDaoMysqlImplementation();
//        StudentDao studentDao = new StudentDaoCsvImplementation();
        studentList = studentDao.getAllStudents();
        for (Student student : studentList)
            studentMap.put(student.getStudentId(), student);

        CourseDao courseDao = new CourseDaoMysqlImplementation();
        courseList = courseDao.getAllCourses();
        for (Course course: courseList)
            courseMap.put(course.getCourseCode(), course);

        RegistrationDao registrationDao = new RegistrationDaoMysqlImplementation();
        registrationList = registrationDao.getAllRegistrations();
        for (Registration registration : registrationList)
            facultySet.add(new Faculty(registration.getFacultyInitials()));

        GradeRecordDao gradeRecordDao = new GradeRecordDaoMysqlImplementation();
        gradeRecordList = gradeRecordDao.getAllGradeRecords();

        for (GradeRecord gradeRecord : gradeRecordList) {

            Student student = studentMap.get(gradeRecord.getStudentId());
            Course course = courseMap.get(gradeRecord.getCourseCode());
            // HW: Find a way to efficiently find a faculty from a given collection
            // Hint: you can change the way how the faculties are stored
            Faculty faculty = null;

            // HW: efficiently find a Grade object based on letter grade that you
            // read from the gradeRecord

            // HW: once you have all these objects, add them as a GradeEntry object
            // for the "student"
            System.out.println(gradeRecord);
            System.out.println(student);
            System.out.println(course);

            System.out.println();

        }

/*
// From JDK1.1+
            for (int i = 0; i < studentList.size(); i++)
                System.out.println(studentList.get(i));
*/
/*
// From JDK1.5+
            for (Student student : studentList)
                System.out.println(student);
*/

/*
// From JDK1.8+
            studentList.forEach(System.out::println);
*/

/*
    Homework:
    1. Find out the student with the longest name
    2. Read course data from the database and save them into a list of courses
    3. Add a list of grades for each student and populate the student object with their own grades
 */
/*
// Finding the student with the longest name
            Student maxLengthNameStudent = studentList.get(0);
            for (Student student : studentList) {
                if (student.getStudentName().length() > maxLengthNameStudent.getStudentName().length()) {
                    maxLengthNameStudent = student;
                }
            }
            System.out.println("Maximum length of a name belongs to: " + maxLengthNameStudent);
            */
    }

    public static void main(String args[]) {
        new Main();
    }
}
