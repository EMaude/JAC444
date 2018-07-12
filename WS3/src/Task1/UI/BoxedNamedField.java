package Task1.UI;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

//Builds a hbox with textfield and label

public class BoxedNamedField {
    HBox m_hBox;
    TextField m_field;

    BoxedNamedField(String label, int ColCount) {
        m_hBox = new HBox();
        m_hBox.setPadding(new Insets(10, 10, 10, 10));
        m_hBox.getChildren().add(new Label(label));
        m_field = new TextField();
        m_field.setPrefColumnCount(ColCount);
        m_hBox.getChildren().add(m_field);
    }
}
