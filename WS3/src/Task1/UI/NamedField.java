package Task1.UI;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class NamedField {
    TextField m_field;
    Label m_label;

    NamedField(String label, int ColCount) {
        m_label = new Label(label);
        m_field = new TextField();
        m_field.setPrefColumnCount(ColCount);
    }
}
