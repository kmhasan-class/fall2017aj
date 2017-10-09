package bd.ac.seu.collections;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoCsvImplementation implements StudentDao {
    List<Student> studentList;

    @Override
    public List<Student> getAllStudents() {
        studentList = new ArrayList<>();

        try (RandomAccessFile input = new RandomAccessFile("students.csv", "r")) {
            input.readLine();
            String line;

            while ((line = input.readLine()) != null) {
                int commaIndex = line.indexOf(",");
                String id = line.substring(0, commaIndex);
                String name = line.substring(commaIndex + 1);

                /*
                HW3: Fix this code to ensure that we don't have double quotes
                 */
                Student student = new Student(Integer.parseInt(id), name);
                studentList.add(student);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return studentList;
    }
}
