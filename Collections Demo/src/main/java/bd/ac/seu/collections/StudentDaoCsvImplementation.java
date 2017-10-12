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
                String name = line.substring(commaIndex + 2, line.length() - 1);

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

    @Override
    public boolean deleteStudent(int studentId) {
        studentList = getAllStudents();
        for (int i = 0; i < studentList.size(); i++)
            if (studentId == studentList.get(i).getStudentId()) {
                studentList.remove(i);
            }

        try (RandomAccessFile output = new RandomAccessFile("students.csv", "rw")) {
            output.setLength(0);
            for (Student student : studentList) {
                String message = String.format("%d,\"%s\"\n", student.getStudentId(), student.getStudentName());
                output.writeBytes(message);
            }
            output.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
