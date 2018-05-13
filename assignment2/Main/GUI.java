package Main;

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
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
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

import java.awt.Frame;
import java.util.*;
import javax.swing.*;

public class GUI extends Application {
	Stage primaryStage = new Stage();
	Scene scene;
    List<Person> net = new ArrayList<Person>();
	ComboBox comboBox = new ComboBox();
	CheckBox checkBox;
	Person selectedPerson;

	@Override // Override the start in the Application
    
	public void start(Stage primaryStage) {
		this.initialize();
		this.primaryStage = primaryStage;
		primaryStage.setScene(mainMenu());
		primaryStage.show();

	}

	private void setComboBox(List<Person> net) {
		comboBox.getItems().clear();
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

			primaryStage.setScene(selectedPerson(net));

			primaryStage.show();

		});
		choice_2.setOnAction((e) -> {
			primaryStage.setScene(addPerson());

			primaryStage.show();
		});
		choice_3.setOnAction((e) -> {
			primaryStage.setScene(deletePerson(net));

			primaryStage.show();
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

	public Scene selectedPerson(List<Person> list) {
		net=list;
		setComboBox(net);
		GridPane selectedPerson = new GridPane();
		Scene selectedPerson_scene = new Scene(selectedPerson, 200, 250);
		selectedPerson.setAlignment(Pos.TOP_LEFT);
		selectedPerson.setHgap(5);
		selectedPerson.setVgap(5);
		Label profile = new Label();
		Label relationList = new Label();
		Button showProfile = new Button("Show Profile");
		Button backButton = new Button("Back to menu");
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
			this.primaryStage.setScene(mainMenu());

		});
		selectedPerson.add(new Label("Selected Person : "), 0, 0);
		selectedPerson.add(comboBox, 1, 0);
		selectedPerson.add(showProfile, 0, 1);
		selectedPerson.add(profile, 0, 2);
		selectedPerson.add(relationList, 1, 2);
		selectedPerson.add(backButton, 0, 3);

		return selectedPerson_scene;

	}
    public Scene addPerson(){
    	GridPane addPerson_pane=new GridPane();
    	Scene addPerson_scene=new Scene(addPerson_pane,250,200);
    	addPerson_pane.setAlignment(Pos.TOP_LEFT);
    	addPerson_pane.setHgap(5);
    	addPerson_pane.setVgap(5);
    	
    	Label title=new Label("Add Person :");
    	Label name=new Label("Name :");
    	TextField name_txt=new TextField();
    	Label age=new Label("Age :");
    	TextField age_txt=new TextField();
    	RadioButton male = new RadioButton("Male");
    	male.setSelected(true);
        RadioButton female = new RadioButton("Female");
        ToggleGroup buttonGroup=new ToggleGroup();
        male.setToggleGroup(buttonGroup);
        female.setToggleGroup(buttonGroup);
        Label status=new Label("Status :");
        TextField status_txt=new TextField();
        Button create=new Button("Create");
        create.setOnAction((e)->{
        	String iName=name_txt.getText();
            int iAge=Integer.parseInt(age_txt.getText());
            String iStatus=status_txt.getText();
            if(iAge>=18){
            	Adult newAdult=new Adult(iName,iAge);
        		net.add(newAdult);
        		newAdult.setStatus(iStatus);
        	}else{
        		Child newChild=new Child(iName,iAge);
        		net.add(newChild);
        		newChild.setStatus(iStatus);
        	}
        });
        Button back=new Button("Back to menu");
        back.setOnAction((e)->{
        	this.primaryStage.setScene(mainMenu());
        });
    	addPerson_pane.add(title, 0, 0);
    	addPerson_pane.add(name, 0, 1);
    	addPerson_pane.add(name_txt, 1, 1);
    	addPerson_pane.add(age, 0, 2);
    	addPerson_pane.add(age_txt, 1, 2);
    	addPerson_pane.add(male,0,3);
    	addPerson_pane.add(female,1, 3);
    	addPerson_pane.add(status, 0, 4);
    	addPerson_pane.add(status_txt, 1, 4);
    	addPerson_pane.add(create, 0, 5);
    	addPerson_pane.add(back, 0, 6);
    	return addPerson_scene;
    }
    public Scene deletePerson(List<Person> net){
    	
    	GridPane deletePerson=new GridPane();
    	Scene deletePerson_scene=new Scene(deletePerson,250,200);
    	deletePerson.setAlignment(Pos.TOP_LEFT);
    	deletePerson.setHgap(5);
    	deletePerson.setVgap(5);
    	/*for (Person p : net) {
			CheckBox list=new CheckBox(p.getName());
			deletePerson.add(list, 0, i);
		}
    	for (int i=0;i<net.size();i++){
    		CheckBox list=new CheckBox(net.get(i).Name);
    		list.setId(String.valueOf(i));
    				deletePerson.add(list, 0, i);
    				System.out.println(list.getId());

    	}*/
    	setComboBox(net);
    	Button delete=new Button("Delete");
    	delete.setOnAction((e)->{
    		for (int i = 0; i < net.size(); i++) {
				if (comboBox.getValue().equals(net.get(i).getName())){
					net.remove(i);
					
				}
    	}
    		setComboBox(net);
    		});
    	Button back=new Button("Back to menu");
        back.setOnAction((e)->{
        	this.primaryStage.setScene(mainMenu());
        });
        deletePerson.add(comboBox, 0, 0);
        deletePerson.add(delete, 0, 1);
        deletePerson.add(back, 0, 2);
		return deletePerson_scene;
    	
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
