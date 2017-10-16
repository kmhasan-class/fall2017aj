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
    private Map<String, Faculty> facultyMap;
    private Map<Integer, Student> studentMap;
    private Map<String, Course> courseMap;
    private Map<String, Grade> gradeMap;

    public Main() {
        studentMap = new HashMap<>();
        courseMap = new HashMap<>();
        facultyMap = new HashMap<>();
        gradeMap = new HashMap<>();

        for (Grade grade : Grade.values())
            gradeMap.put(grade.getLetterGrade(), grade);

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
            facultyMap.putIfAbsent(registration.getFacultyInitials(),
                    new Faculty(registration.getFacultyInitials()));

        GradeRecordDao gradeRecordDao = new GradeRecordDaoMysqlImplementation();
        gradeRecordList = gradeRecordDao.getAllGradeRecords();

        for (GradeRecord gradeRecord : gradeRecordList) {

            Student student = studentMap.get(gradeRecord.getStudentId());
            Course course = courseMap.get(gradeRecord.getCourseCode());
            Faculty faculty = facultyMap.get(gradeRecord.getFacultyInitials());
            Grade grade = gradeMap.get(gradeRecord.getGrade());

            GradeEntry gradeEntry = new GradeEntry(course, faculty, gradeRecord.getSemesterId(), grade);

            student.getGradeEntryList().add(gradeEntry);
        }

        Student student = studentList.get(studentList.size() - 1);
        for (int i = 40; i <= 46; i++)
            System.out.println(i + ": " + student.getTermGpa(i));
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
