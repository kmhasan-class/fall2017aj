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
import java.util.List;

public class Main {
    public Main() {
        readAllStudents();
        System.out.println("-----");
        readOneStudents("420");
    }

    private void readOneStudents(String studentId) {
        try {
            URL url = new URL("http://localhost:8081/api/v1/student/" + studentId);
            /*
            URLConnection connection = url.openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            String line;
            while ((line = reader.readLine()) != null)
                System.out.println(line);
            */
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

    public static void main(String args[]) {
        new Main();
    }
}
