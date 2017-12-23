package bd.ac.seu.aj.restconsumer;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public Main() {
        //mizansQuestion();
        readAllStudents();
        System.out.println("-----");
        readOneStudents("420");
        createStudent("45663232", "Md. Ashiqur Rahman", 3.99);
    }

    private void mizansQuestion() {
        Student a = new Student("10", "A", 2.9);
        Student b = new Student("11", "B", 2.19);
        Student c = new Student("12", "C", 2.49);

        ArrayList<Student> studentsA = new ArrayList<>();
        studentsA.add(a);
        studentsA.add(b);
        studentsA.add(c);

        ArrayList<Student> studentsB = new ArrayList<>();
        studentsB.add(a.copy());
        studentsB.add(b.copy());
        studentsB.add(c.copy());

        System.out.println("Before");
        System.out.println(studentsA);
        System.out.println(studentsB);
        studentsB.get(0).setStudentId("34");
        System.out.println("After");
        System.out.println(studentsA);
        System.out.println(studentsB);
    }

    private void readOneStudents(String studentId) {
        try {
            URL url = new URL("http://localhost:8081/api/v1/student/" + studentId);

            ObjectMapper objectMapper = new ObjectMapper();

            Student student = objectMapper.readValue(url, Student.class);
            System.out.println(student);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readAllStudents() {
        try {
            URL url = new URL("http://localhost:8081/api/v1/students");
            /*
            URLConnection connection = url.openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            String line;
            while ((line = reader.readLine()) != null)
                System.out.println(line);
                */
            ObjectMapper objectMapper = new ObjectMapper();
            List<Student> studentList = objectMapper.readValue(url, new TypeReference<List<Student>>() {});
            studentList.forEach(System.out::println);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createStudent(String studentId, String studentName, double cgpa) {
        // You could use Apache's HTTP client library to do things more elegantly
        // http://www.baeldung.com/httpclient-post-http-request
        Student student = new Student(studentId, studentName, cgpa);
        try {
            URL url = new URL("http://localhost:8081/api/v1/student");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setRequestMethod("POST");

            Map<String, String> parameterMap = new HashMap<>();
            parameterMap.put("studentId", "12345");
            parameterMap.put("studentName", "John Doe");
            parameterMap.put("cgpa", "2.35");

            StringBuilder builder = new StringBuilder();
            parameterMap.forEach((key, value) -> {
                if (builder.length() > 0)
                    builder.append('&');
                builder.append(key);
                builder.append('=');
                builder.append(value);
            });

            String parameters = builder.toString();
            connection.getOutputStream().write(parameters.getBytes());

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;

            while ((line = reader.readLine()) != null)
                System.out.println(line);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {
        new Main();
    }
}
