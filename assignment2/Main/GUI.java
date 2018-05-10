package assignment1;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Separator;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.util.*;
import javax.swing.*;

public class GUI extends Application {
	Stage primaryStage = new Stage();
	List<Person> net = new ArrayList<Person>();
	ComboBox comboBox = new ComboBox();
	Person selectedPerson;
	Scene scene;

	@Override // Override the start in the Application

	public void start(Stage primaryStage) {

		primaryStage.setScene(mainMenu());
		primaryStage.show();

	}

	private void setComboBox() {
		for (Person p : net) {
			comboBox.getItems().addAll(p.getName());
		}

	}

	public Scene mainMenu() {
		FlowPane primaryPane = new FlowPane(Orientation.VERTICAL, 5, 5);
		scene = new Scene(primaryPane, 200, 250);
		Button choice_1 = new Button("1. Select Person");
		Button choice_2 = new Button("2. Add Person");
		Button choice_3 = new Button("3. Delete Person");
		Button choice_4 = new Button("4. Exit");
		choice_1.setOnAction((e) -> {
			scene = new Scene(selectedPerson(), 250, 200);
			primaryStage.setScene(scene);
			primaryStage.show();

		});
		choice_2.setOnAction((e) -> {
		});
		choice_3.setOnAction((e) -> {

		});
		choice_4.setOnAction((e) -> {
			System.exit(0);
		});
		primaryPane.getChildren().add(new Label("Menu :"));
		primaryPane.getChildren().add(choice_1);
		primaryPane.getChildren().add(choice_2);
		primaryPane.getChildren().add(choice_3);
		primaryPane.getChildren().add(choice_4);
		return scene;
	}

	public Pane selectedPerson() {
		initialize();
		setComboBox();
		GridPane selectedPerson = new GridPane();
		selectedPerson.setAlignment(Pos.TOP_LEFT);
		selectedPerson.setHgap(5);
		selectedPerson.setVgap(5);
		Label profile = new Label();
		Label relationList = new Label();
		Button showProfile = new Button("Show Profile");
		Button backButton = new Button("Exit");
		showProfile.setOnAction((ActionEvent e) -> {

			for (int i = 0; i < net.size(); i++) {
				if (comboBox.getValue().equals(net.get(i).getName())) {
					profile.setText(net.get(i).showProfile_string());

					relationList.setWrapText(true);
					relationList.setText(net.get(i).showFriends_string() + "\n" + net.get(i).showChildren_string()
							+ "\n" + net.get(i).showParents_string() + "\n");
				}

			}

		});
		backButton.setOnAction((e) -> {
			primaryStage.setScene(mainMenu());
		});
		selectedPerson.add(new Label("Selected Person : "), 0, 0);
		selectedPerson.add(comboBox, 1, 0);
		selectedPerson.add(showProfile, 0, 1);
		selectedPerson.add(profile, 0, 2);
		selectedPerson.add(relationList, 1, 2);
		selectedPerson.add(backButton, 0, 3);

		return selectedPerson;

	}

	class backMenu implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent e) {
		}
	}

	public void initialize() {
		Adult A = new Adult("A", 24);
		Adult B = new Adult("B", 21);
		Adult C = new Adult("C", 27);
		Adult D = new Adult("D", 28);
		Adult E = new Adult("E", 29);
		Adult F = new Adult("F", 34);
		Child G = new Child("G", 16);
		Child H = new Child("H", 1);
		Child I = new Child("I", 13);
		A.Friends.add(B);
		B.Friends.add(A);
		B.Friends.add(C);
		C.Friends.add(B);
		C.Friends.add(D);
		D.Friends.add(C);
		D.Friends.add(E);
		E.Friends.add(D);
		E.Friends.add(F);
		F.Friends.add(E);
		net.add(A);
		net.add(B);
		net.add(C);
		net.add(D);
		net.add(E);
		net.add(F);
		net.add(G);
		net.add(H);
		net.add(I);
	}

	public static void main(String[] args) {
		Application.launch(args);
	}

}
