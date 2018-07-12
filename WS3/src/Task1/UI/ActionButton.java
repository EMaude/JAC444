package Task1.UI;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class ActionButton {
    static HBox buttonHBox = new HBox(10);
    Button button;

    ActionButton(String label)
    {
        button = new Button(label);
        buttonHBox.getChildren().add(button);
    }
}
