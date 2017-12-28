package bd.ac.seu.aj.vaadindemo.ui;

import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@SpringUI(path = "/students")
public class StudentUI extends UI {
    private VerticalLayout verticalLayout;

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        verticalLayout = new VerticalLayout();
        setContent(verticalLayout);

        verticalLayout.addComponent(new Label("Students"));
    }
}
