package Task1.UI;

import Task1.DataManagement.Contact;
import Task1.FileIO.FileManager;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


public class UI extends Application
{
	static Contact contact;
	static BoxedNamedField nField;
	static BoxedNamedField sField;
	static NamedField cField;
	static NamedField stField;
	static NamedField zField;

	@Override
	public void start(Stage primaryStage) throws Exception {

		contact = new Contact();

		//Setup Scene and pane
		FlowPane pane = new FlowPane();
		pane.setPadding(new Insets(10, 10, 10, 10));
		
		Scene scene = new Scene(pane , 450, 250);		
		
		//---Build Elements in Scene---//
		
		//NAME
		nField = new BoxedNamedField("Name", 32);

		pane.getChildren().add(nField.m_hBox);

		//STREET
		sField = new BoxedNamedField("Street", 32);

		pane.getChildren().add(sField.m_hBox);
		
		//CSZ
		HBox cszHbox = new HBox(2);
		cszHbox.setPadding(new Insets(10, 10, 10, 10));

		cField = new NamedField("City", 20);
		cszHbox.getChildren().addAll(cField.m_label, cField.m_field);

		stField = new NamedField("State", 2);

		cszHbox.getChildren().addAll(stField.m_label, stField.m_field);

		zField = new NamedField("Zip", 5);
		cszHbox.getChildren().addAll(zField.m_label, zField.m_field);

		pane.getChildren().add(cszHbox);
		
		
		//BUTTONS
		ActionButton.buttonHBox.setPadding(new Insets(10, 10, 10, 10));

		ActionButton addB = new ActionButton("Add");
		addB.button.setOnAction(event ->{
			UpdateContact();
			FileManager.createRecord(contact.toString());
		});

		ActionButton firstB = new ActionButton("First");
		firstB.button.setOnAction(event ->{
			FileManager.setPos(0);
			ChangeContact(FileManager.readRecord());
		});

		ActionButton nextB = new ActionButton("Next");
		nextB.button.setOnAction(event ->{
			FileManager.setPos(FileManager.getPos() + 1);
			ChangeContact(FileManager.readRecord());
		});

		ActionButton prevB = new ActionButton("Prev");
		prevB.button.setOnAction(event ->{
			FileManager.setPos(FileManager.getPos() - 1);
			ChangeContact(FileManager.readRecord());
		});

		ActionButton lastB = new ActionButton("Last");
		lastB.button.setOnAction(event ->{
			ChangeContact(FileManager.readLastRecord());
		});

		ActionButton updateB = new ActionButton("Update");
		updateB.button.setOnAction(event ->{
			UpdateContact();
			FileManager.updateRecord(contact.toString());
		});

		pane.getChildren().add(ActionButton.buttonHBox);
		//Draw Scene
		primaryStage.setResizable(false);
		primaryStage.setTitle("Task 1 - Elliot Maude");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void ChangeContact(Contact contact) {
		nField.m_field.setText(contact.getM_name());
		sField.m_field.setText(contact.getM_street());
		cField.m_field.setText(contact.getM_city());
		stField.m_field.setText(contact.getM_state());
		zField.m_field.setText(contact.getM_zip());
	}

	public static void UpdateContact()
	{
		contact.setM_name(nField.m_field.getText());
		contact.setM_street(sField.m_field.getText());
		contact.setM_city(cField.m_field.getText());
		contact.setM_state(stField.m_field.getText());
		contact.setM_zip(zField.m_field.getText());
	}
}
