package bd.ac.seu.aj.vaadindemo.ui;

import bd.ac.seu.aj.vaadindemo.model.Student;
import bd.ac.seu.aj.vaadindemo.service.StudentService;
import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@SpringUI
@Theme("valo")
public class IndexUI extends UI {
    private VerticalLayout verticalLayout;
    private Label label;
    private Button button;

    private TextField studentIdField;
    private TextField studentNameField;
    private TextField cgpaField;
    private Button addStudentButton;

    Grid<Student> studentGrid;
    List<Student> studentList;

    @Autowired
    private StudentService studentService;

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        studentList = studentService.getAllStudents();

        verticalLayout = new VerticalLayout();
        this.setContent(verticalLayout);

        label = new Label("Hello, Vaadin!");
        verticalLayout.addComponent(label);

        button = new Button("Click");
        verticalLayout.addComponent(button);
        button.addClickListener(clickEvent -> label.setValue("Clicked"));

        FormLayout formLayout = new FormLayout();
        verticalLayout.addComponent(formLayout);

        studentIdField = new TextField("Student ID", "");
        studentNameField = new TextField("Student Name", "");
        cgpaField = new TextField("CGPA", "");
        addStudentButton = new Button("Add");

        formLayout.setCaption("Add a new Student");
        formLayout.addComponent(studentIdField);
        formLayout.addComponent(studentNameField);
        formLayout.addComponent(cgpaField);
        formLayout.addComponent(addStudentButton);

        addStudentButton.addClickListener(clickEvent -> {
            String studentId = studentIdField.getValue();
            String studentName = studentNameField.getValue();
            double cgpa = Double.parseDouble(cgpaField.getValue());
            studentService.addStudent(studentId, studentName, cgpa);
            studentList.add(new Student(studentId, studentName, cgpa));
            studentGrid.clearSortOrder();
            studentIdField.clear();
            studentNameField.clear();
            cgpaField.clear();
            Notification.show("Added " + studentName, Notification.Type.TRAY_NOTIFICATION);
        });

        studentGrid = new Grid<>();
        studentGrid.setItems(studentList);
        verticalLayout.addComponent(studentGrid);

        studentGrid.addColumn(Student::getStudentId).setCaption("Student ID");
        studentGrid.addColumn(Student::getStudentName).setCaption("Student Name");
        studentGrid.addColumn(Student::getCgpa).setCaption("CGPA");
    }
}
