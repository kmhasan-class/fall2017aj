package bd.ac.seu.ormdemo;

import bd.ac.seu.ormdemo.Service.StudentService;
import bd.ac.seu.ormdemo.model.*;
import bd.ac.seu.ormdemo.util.Filter;
import bd.ac.seu.ormdemo.util.TestInterface;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    private static final String DOMAINS[] = {".edu", ".com", ".net", ".org"};

    class StudentComparatorBasedOnEmailAddressInnerClass implements Comparator<Student> {

        @Override
        public int compare(Student s1, Student s2) {
            if (s1.getEmailAddress().compareTo(s2.getEmailAddress()) < 0)
                return -1;
            else if (s1.getEmailAddress().compareTo(s2.getEmailAddress()) > 0)
                return +1;
            else return 0;
        }
    }

    private String generateRandomName() {
        StringBuilder stringBuilder = new StringBuilder();
        int length = (int) (Math.random() * 10 + 3);
        stringBuilder.append((char) (Math.random() * 26 + 'A'));
        for (int i = 0; i < length; i++)
            stringBuilder.append((char) (Math.random() * 26 + 'a'));
        return stringBuilder.toString();
    }

    private String generateRandomEmailAddress() {
        StringBuilder stringBuilder = new StringBuilder();
        int length = (int) (Math.random() * 5 + 3);
        for (int i = 0; i < length; i++)
            stringBuilder.append((char) (Math.random() * 26 + 'a'));
        stringBuilder.append('@');
        length = (int) (Math.random() * 5 + 3);
        for (int i = 0; i < length; i++)
            stringBuilder.append((char) (Math.random() * 26 + 'a'));
        stringBuilder.append(DOMAINS[(int) (Math.random() * DOMAINS.length)]);
        return stringBuilder.toString();
    }

    private void sortingDemo() {
        double doubleArray[] = {5.25, 6, 2, 1.21, 3, 7, -81.997, 2, 44, 1, 6};
        String stringArray[] = {"apple", "peach", "baby", "apple124", "jackfruit", "123jackfruit", "banana"};
/*
        System.out.println("Before sorting " + Arrays.toString(stringArray));
        Arrays.sort(stringArray);
        System.out.println("After sorting  " + Arrays.toString(stringArray));
*/

        List<String> stringList = Arrays.asList(stringArray);
        System.out.println("Before sorting: " + stringList);
        Collections.sort(stringList);
        System.out.println("After sorting:  " + stringList);
    }

    public Main() {
        List<Course> courseList = new ArrayList<>();
        courseList.add(new Course("CSE1021", "Discreate Mathematics", 3));
        courseList.add(new Course("CSE1012", "Programming Language I", 1));
        courseList.add(new Course("ENG1001", "Basic Composition", 0));
        courseList.add(new Course("MATH1024", "Coordinate Geometry", 3));
        courseList.add(new Course("MATH2015", "Linear Algebra", 3));
        Filter<Course> courseFilter = new Filter<>();
        //List<Course> courseSubset = courseFilter.getSubset(courseList, course -> course.getCourseCode().startsWith("CSE"));
        Collection<Course> courseSubset = courseFilter.getSubset(courseList, course -> course.getCreditHours() == 3);
        courseSubset.forEach(System.out::println);

        String[] strings = {"Abul", "Babul", "Kabul", "Putul", "Tutul", "Rafiq", "Rakibul", "Monirul", "Ashiqur"};
        List<String> stringList = Arrays.asList(strings);
        Filter<String> stringFilter = new Filter<>();
        Collection<String> stringNotEndingWithUl =  stringFilter.getSubset(stringList, string -> !string.endsWith("ul"));
        System.out.println(stringNotEndingWithUl);

        long startTime, stopTime;
        StudentService studentService = new StudentService();
        startTime = System.currentTimeMillis();
        List<Student> studentList = studentService.getStudentList();
        stopTime = System.currentTimeMillis();
        System.out.printf("Time taken to fetch student list: %.6f seconds\n", (stopTime - startTime) / 1000.0);

        startTime = System.currentTimeMillis();
        /*
        List<Student> femaleStudents = new ArrayList<>();
        for (Student student : studentList)
            if (student.getSex() == Sex.FEMALE)
                femaleStudents.add(student);
        */

        Filter<Student> studentFilter = new Filter<>();
        Collection<Student> femaleCollection = studentFilter.getSubset(studentList, (student) -> {
            return (student.getSex() == Sex.FEMALE);
        });
        List<Student> femaleStudents = null;
        if (femaleCollection instanceof List)
            femaleStudents = (List<Student>) femaleCollection;

        Collection<Student> maleList = studentFilter.getSubset(studentList, student -> student.getSex() == Sex.MALE);

        Collection<Student> studentWithNullAddressList = studentFilter.getSubset(studentList,
                (student) -> {
                    if (student.getAddress() == null)
                        return true;
                    else {
                        if (student.getAddress().getStreetAddress() == null)
                            return true;
                        if (student.getAddress().getCity() == null)
                            return true;
                        if (student.getAddress().getPostalCode() == null)
                            return true;
                        return false;
                    }
                });


        stopTime = System.currentTimeMillis();
        System.out.println("We got " + femaleStudents.size() + " female students");
        System.out.printf("Time taken: %.6f seconds\n", (stopTime - startTime) / 1000.0);

        System.out.println("Printing 10 female students BEFORE SORTING");
        for (int i = 0; i < 10; i++)
            System.out.println(femaleStudents.get(i));
//        Collections.sort(femaleStudents, new StudentComparatorBasedOnNameLength());
//        Collections.sort(femaleStudents, new StudentComparatorBasedOnEmailAddress());
//        Collections.sort(femaleStudents, new StudentComparatorBasedOnEmailAddressInnerClass());
/*        Collections.sort(femaleStudents, new Comparator<Student>() {
            // Anonymous Inner Class
            @Override
            public int compare(Student s1, Student s2) {
                if (s1.getEmailAddress().compareTo(s2.getEmailAddress()) < 0)
                    return -1;
                else if (s1.getEmailAddress().compareTo(s2.getEmailAddress()) > 0)
                    return +1;
                else return 0;
            }
        });*/

        // lambda expression
        Collections.sort(femaleStudents, (s1, s2) -> {
            if (s1.getEmailAddress().compareTo(s2.getEmailAddress()) < 0)
                return -1;
            else if (s1.getEmailAddress().compareTo(s2.getEmailAddress()) > 0)
                return +1;
            else return 0;
        });
//        Collections.sort(femaleStudents, (s1, s2) -> s1.getEmailAddress().compareTo(s2.getEmailAddress()));
        System.out.println("Printing 10 female students AFTER SORTING");
        for (int i = 0; i < 10; i++)
            System.out.println(femaleStudents.get(i));

        startTime = System.currentTimeMillis();
        List<Student> maleStudents = studentList
                .parallelStream()
                .filter(student -> student.getSex() == Sex.MALE)
                .collect(Collectors.toList());
        stopTime = System.currentTimeMillis();
        System.out.println("We got " + maleStudents.size() + " male students");
        System.out.printf("Time taken: %.6f seconds\n", (stopTime - startTime) / 1000.0);

        //studentList.forEach(System.out::println);
        /*
            public Student(int id, Name name, String emailAddress, Sex sex, Address address) {
        this();
        this.id = id;
        this.name = name;
        this.emailAddress = emailAddress;
        this.sex = sex;
        this.address = address;
    }

         */
/*

        startTime = System.currentTimeMillis();
        List<Student> insertionList = new ArrayList<>();
        for (int i = 1; i <= 1000000; i++) {
            Student student = new Student(i,
                    new Name(generateRandomName(), generateRandomName()),
                    generateRandomEmailAddress(),
                    Math.random() < 0.5 ? Sex.MALE : Sex.FEMALE,
                    null);
            insertionList.add(student);
        }
        stopTime = System.currentTimeMillis();
        System.out.printf("Done storing them in a list in %.3f seconds.\n", (stopTime - startTime) / 1000.0);
        startTime = System.currentTimeMillis();
        studentService.addAll(insertionList);
        stopTime = System.currentTimeMillis();
        System.out.printf("Done storing them in the database in %.3f seconds.\n", (stopTime - startTime) / 1000.0);

*/
        /*
        Course course1 = session.get(Course.class, "CSE2015");
        Course course2 = session.get(Course.class, "CSE2016");
        student.getCourseSet().add(course1);
        student.getCourseSet().add(course2);
        */
/*
        Course course = session.get(Course.class, "CSE4029");
        System.out.println(course);
        System.out.println("Registered students:");
        course.getStudentList().forEach(System.out::println);
*/

/*
        Query query = session.createQuery("from Student"); // HQL - Hibernate Query Language
        List<Student> studentList = query.getResultList();
        studentList.forEach(System.out::println);

        query = session.createQuery("from Course");
        List<Course> courseList = query.getResultList();
        courseList.forEach(System.out::println);
        */
/*
        session.save(new Course("CSE4047", "Advanced Java", 3.0));
        session.save(new Course("CSE4048", "Advanced Java Lab", 1.0));
        session.save(new Course("CSE4029", "Image Processing", 3.0));
        session.save(new Course("CSE2015", "Programming Language II (Java)", 3.0));
        session.save(new Course("CSE2016", "Programming Language II (Java) Lab", 1.0));
*/


        //System.out.println(student);

        SessionFactorySingleton.getSessionFactory().close();
    }

    public static void main(String args[]) {
        new Main();
    }
}
