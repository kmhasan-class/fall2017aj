/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restconsumergui;

import java.util.List;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.MalformedURLException;
/**
 *
 * @author kmhasan
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private ListView<Student> studentListView;
    private ObservableList<Student> studentList;
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        studentList = FXCollections.observableArrayList();
        studentListView.setItems(studentList);
        readStudentList();
        /*
        studentList.add(new Student("1345", "John Doe", 3.454));
        studentList.add(new Student("1455", "Jane Doe", 3.514));
        studentList.add(new Student("1661", "John Smith", 3.223));
*/
    }
    
    private void readStudentList() {
        try {
            URL url = new URL("http://localhost:8081/api/v1/students");
            ObjectMapper objectMapper = new ObjectMapper();
            List<Student> studentList = objectMapper.readValue(url, new TypeReference<List<Student>>() {});
            studentList.forEach(System.out::println);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }        
    }
    
}
