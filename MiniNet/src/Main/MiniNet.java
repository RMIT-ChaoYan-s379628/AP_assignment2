package Main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import Exception.NoAvailableException;
import Exception.NoParentException;
import Exception.NoSuchAgeException;
import Exception.NotToBeClassmatesException;
import Exception.NotToBeColleaguesException;
import Exception.NotToBeCoupledException;
import Exception.NotToBeFriendsException;
import Exception.TooYoungException;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 * @author Chao Yan
 * @date 1/5/17 12:00
 * @description
 */

public class MiniNet extends Application implements EventHandler<ActionEvent> {

	private LinkedList<Person> people;
	private RelationShipManager manager;
	private MenuBar menuBar;
	private Menu menu;
	private MenuItem addMenu;
	private MenuItem selectMenu;
	private MenuItem deleteMenu;
	private MenuItem findMenu;
	private MenuItem defineMenu;
	private MenuItem childrenMenu;
	private MenuItem parentMenu;
	private MenuItem exitMenu;
	private BorderPane mainPane;
	private Person currentSelected;

	public void initVariables() {
		menuBar = new MenuBar();
		menu = new Menu("Options");
		addMenu = new MenuItem("Add New Person");
		addMenu.setOnAction(this);
		selectMenu = new MenuItem("Select a Person");
		selectMenu.setOnAction(this);
		deleteMenu = new MenuItem("Delete a Person");
		deleteMenu.setOnAction(this);
		findMenu = new MenuItem("Is Direct Connected?");
		findMenu.setOnAction(this);
		defineMenu = new MenuItem("Add New Relation");
		defineMenu.setOnAction(this);
		childrenMenu = new MenuItem("Name(s) of Child(ren)");
		childrenMenu.setOnAction(this);
		parentMenu = new MenuItem("Names of Parents");
		parentMenu.setOnAction(this);
		exitMenu = new MenuItem("Exit");
		exitMenu.setOnAction((e) -> {
			System.exit(0);
		});
		mainPane = new BorderPane();
	}

	public void addNewPerson() {
		Stage addWindow = new Stage();
		GridPane root = new GridPane();
		root.setAlignment(Pos.CENTER);
		root.setHgap(10);
		root.setVgap(10);
		root.setPadding(new Insets(20, 20, 20, 20));
		ColumnConstraints column1 = new ColumnConstraints(80);
		ColumnConstraints column2 = new ColumnConstraints(100);
		column2.setHgrow(Priority.ALWAYS);
		root.getColumnConstraints().addAll(column1, column2);
		Label nameLabel = new Label("Name: ");
		TextField nameField = new TextField();
		Label ageLabel = new Label("Age: ");
		TextField ageField = new TextField();
		Label imageLabel = new Label("Image: ");
		Button image = new Button("SELECT");
		Label statusLabel = new Label("Status: ");
		TextField statusField = new TextField();
		Label sexLabel = new Label("Sex: ");
		ObservableList<String> sexOptions = FXCollections.observableArrayList("F", "M");
		ComboBox<String> sexField = new ComboBox<>(sexOptions);
		sexField.setValue("F");
		Label stateLabel = new Label("State: ");
		ObservableList<String> stateOptions = FXCollections.observableArrayList("ACT", "NSW", "NT", "QLD", "SA", "TAS",
				"VIC", "WA");
		ComboBox<String> stateField = new ComboBox<>(stateOptions);
		stateField.setValue("ACT");
		Button confirm = new Button("CONFIRM");
		GridPane.setHalignment(nameLabel, HPos.LEFT);
		root.add(nameLabel, 0, 0);
		GridPane.setHalignment(nameField, HPos.RIGHT);
		root.add(nameField, 1, 0);
		GridPane.setHalignment(ageLabel, HPos.LEFT);
		root.add(ageLabel, 0, 1);
		GridPane.setHalignment(ageField, HPos.RIGHT);
		root.add(ageField, 1, 1);
		GridPane.setHalignment(imageLabel, HPos.LEFT);
		root.add(imageLabel, 0, 2);
		GridPane.setHalignment(image, HPos.RIGHT);
		root.add(image, 1, 2);
		GridPane.setHalignment(statusLabel, HPos.LEFT);
		root.add(statusLabel, 0, 3);
		GridPane.setHalignment(statusField, HPos.RIGHT);
		root.add(statusField, 1, 3);
		GridPane.setHalignment(sexLabel, HPos.LEFT);
		root.add(sexLabel, 0, 4);
		GridPane.setHalignment(sexField, HPos.RIGHT);
		root.add(sexField, 1, 4);
		GridPane.setHalignment(stateLabel, HPos.LEFT);
		root.add(stateLabel, 0, 5);
		GridPane.setHalignment(stateField, HPos.RIGHT);
		root.add(stateField, 1, 5);
		GridPane.setHalignment(confirm, HPos.RIGHT);
		root.add(confirm, 1, 6);
		image.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				FileChooser chooseFile = new FileChooser();
				chooseFile.setInitialDirectory(new File(System.getProperty("user.home")));
				chooseFile.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("JPG", "*.jpg"),
						new FileChooser.ExtensionFilter("JPEG", "*.jpeg"),
						new FileChooser.ExtensionFilter("BMP", "*.bmp"),
						new FileChooser.ExtensionFilter("PNG", "*.png"));
				File file = chooseFile.showOpenDialog(addWindow);
				if (file != null) {
					String filename = file.getAbsolutePath();
					image.setText(filename);
				}
			}
		});
		confirm.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				String name = nameField.getText().trim();
				int age = Integer.parseInt(ageField.getText().trim());
				String img = "";
				if (!image.getText().trim().equals("SELECT")) {
					img = image.getText().trim();
				}
				String sex = sexField.getValue();
				String status = statusField.getText();
				String state = stateField.getValue();
				if (name.equals("")) {
					new AlertBox().display("Error", "Name cannot be empty");
				} else {
					Person person;
					try {
						boolean exist = false;
						for (int i = 0; i < people.size(); i++) {
							if (people.get(i).getName().equals(name)) {
								exist = true;
							}
						}
						if (exist) {
							new AlertBox().display("Error", "Person is already exist.");
						} else {
							person = Util.createPerson(name, age, img, status, sex, state);
							people.add(person);
							addWindow.close();
						}
					} catch (NoSuchAgeException e) {
						new AlertBox().display("Error", "No such age exception");
					}
				}
			}
		});
		Scene scene = new Scene(root, 250, 300);
		addWindow.setTitle("Add Window");
		addWindow.setScene(scene);
		addWindow.show();
	}

	@Override
	public void handle(ActionEvent e) {
		if (e.getSource() == addMenu) {
			addNewPerson();
		} else if (e.getSource() == selectMenu) {
			selectPerson();
		} else if (e.getSource() == deleteMenu) {
			if (currentSelected == null) {
				new AlertBox().display("Notice", "Select a person at first.");
			} else {
				deleteSelectedPerson();
			}
		} else if (e.getSource() == findMenu) {
			checkRelationShip();
		} else if (e.getSource() == defineMenu) {
			defineNewRelation();
		} else if (e.getSource() == childrenMenu) {
			if (currentSelected == null) {
				new AlertBox().display("Notice", "Select a person at first.");
			} else {
				showChildren();
			}
		} else if (e.getSource() == parentMenu) {
			if (currentSelected == null) {
				new AlertBox().display("Notice", "Select a person at first.");
			} else {
				showParents();
			}
		}
	}

	public void selectPerson() {
		Stage selectWindow = new Stage();
		selectWindow.setTitle("Select Window");
		BorderPane root = new BorderPane();
		String[] names = new String[people.size()];
		for (int i = 0; i < names.length; i++) {
			names[i] = String.format("%16s", people.get(i).getName());
		}
		ObservableList<String> namesList = FXCollections.observableArrayList(names);
		ListView<String> list = new ListView<>(namesList);
		list.setFocusTraversable(false);
		list.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				for (int i = 0; i < people.size(); i++) {
					if (people.get(i).getName().equals(newValue.trim())) {
						currentSelected = people.get(i);
					}
				}
				updatePersonProfile();
				selectWindow.close();
			}
		});
		root.setCenter(new ScrollPane(list));
		Scene scene = new Scene(root, 250, 300);
		selectWindow.setScene(scene);
		selectWindow.show();
	}

	public void updatePersonProfile() {
		GridPane pane = new GridPane();
		pane.setAlignment(Pos.TOP_LEFT);
		pane.setHgap(10);
		pane.setVgap(10);
		pane.setPadding(new Insets(20, 20, 20, 20));
		ColumnConstraints column1 = new ColumnConstraints(80);
		ColumnConstraints column2 = new ColumnConstraints(250);
		column2.setHgrow(Priority.ALWAYS);
		pane.getColumnConstraints().addAll(column1, column2);
		Label nameLabel = new Label("Name: ");
		Label nameField = new Label();
		Label ageLabel = new Label("Age: ");
		Label ageField = new Label();
		Label imageLabel = new Label("Image: ");
		Label image = new Label();
		Label statusLabel = new Label("Status: ");
		Label statusField = new Label();
		Label sexLabel = new Label("Sex: ");
		Label sexField = new Label();
		Label stateLabel = new Label("State: ");
		Label stateField = new Label();
		GridPane.setHalignment(nameLabel, HPos.LEFT);
		pane.add(nameLabel, 0, 0);
		GridPane.setHalignment(nameField, HPos.RIGHT);
		pane.add(nameField, 1, 0);
		GridPane.setHalignment(ageLabel, HPos.LEFT);
		pane.add(ageLabel, 0, 1);
		GridPane.setHalignment(ageField, HPos.RIGHT);
		pane.add(ageField, 1, 1);
		GridPane.setHalignment(imageLabel, HPos.LEFT);
		pane.add(imageLabel, 0, 2);
		GridPane.setHalignment(image, HPos.RIGHT);
		pane.add(image, 1, 2);
		GridPane.setHalignment(statusLabel, HPos.LEFT);
		pane.add(statusLabel, 0, 3);
		GridPane.setHalignment(statusField, HPos.RIGHT);
		pane.add(statusField, 1, 3);
		GridPane.setHalignment(sexLabel, HPos.LEFT);
		pane.add(sexLabel, 0, 4);
		GridPane.setHalignment(sexField, HPos.RIGHT);
		pane.add(sexField, 1, 4);
		GridPane.setHalignment(stateLabel, HPos.LEFT);
		pane.add(stateLabel, 0, 5);
		GridPane.setHalignment(stateField, HPos.RIGHT);
		pane.add(stateField, 1, 5);
		mainPane.setCenter(pane);
		if (currentSelected != null) {
			nameField.setText(currentSelected.getName());
			ageField.setText(currentSelected.getAge() + " years old");
			if (!currentSelected.getImage().equals("")) {
				Image icon;
				icon = new Image("file:" + currentSelected.getImage(), 100, 100, false, false);
				image.setGraphic(new ImageView(icon));
			}
			LinkedList<RelationShip> relations = manager.getAllRelatedRelation(currentSelected);
			String[] relationStr = new String[relations.size()];
			for (int i = 0; i < relations.size(); i++) {
				Person first = relations.get(i).getFirstPerson();
				Person second = relations.get(i).getSecondPerson();
				String type = manager.checkRelationShip(first, second);
				relationStr[i] = first.getName() + ", " + second.getName() + ", " + type;
			}
			ObservableList<String> relationssList = FXCollections.observableArrayList(relationStr);
			ListView<String> list = new ListView<>(relationssList);
			Label relationLabel = new Label("Relations: ");
			GridPane.setHalignment(relationLabel, HPos.LEFT);
			pane.add(relationLabel, 0, 6);
			GridPane.setHalignment(list, HPos.RIGHT);
			pane.add(list, 1, 6);
			statusField.setText(currentSelected.getStatus());
			sexField.setText(currentSelected.getSex());
			stateField.setText(currentSelected.getState());
		}
	}

	public void deleteSelectedPerson() {
		if (manager.deletePerson(currentSelected)) {
			new AlertBox().display("Error", "Delete Success!");
			for (int i = 0; i < people.size(); i++) {
				if (people.get(i).getName().equals(currentSelected.getName())) {
					people.remove(i);
					break;
				}
			}
			currentSelected = null;
			updatePersonProfile();
		} else {
			new AlertBox().display("Error", "Person is undeletable");
		}
	}

	public void checkRelationShip() {
		Stage checkWindow = new Stage();
		checkWindow.setTitle("Check Window");

		Label name1Label = new Label("Name 1: ");
		TextField name1Field = new TextField();
		Label name2Label = new Label("Name 2: ");
		TextField name2Field = new TextField();
		Label resultLabel = new Label();
		Button check = new Button("CHECK");

		GridPane pane = new GridPane();
		pane.setAlignment(Pos.TOP_LEFT);
		pane.setHgap(10);
		pane.setVgap(10);
		pane.setPadding(new Insets(20, 20, 20, 20));
		ColumnConstraints column1 = new ColumnConstraints(80);
		ColumnConstraints column2 = new ColumnConstraints(100);
		column2.setHgrow(Priority.ALWAYS);
		pane.getColumnConstraints().addAll(column1, column2);

		GridPane.setHalignment(name1Label, HPos.LEFT);
		pane.add(name1Label, 0, 0);
		GridPane.setHalignment(name1Field, HPos.RIGHT);
		pane.add(name1Field, 1, 0);
		GridPane.setHalignment(name2Label, HPos.LEFT);
		pane.add(name2Label, 0, 1);
		GridPane.setHalignment(name2Field, HPos.RIGHT);
		pane.add(name2Field, 1, 1);
		GridPane.setHalignment(resultLabel, HPos.LEFT);
		pane.add(resultLabel, 1, 2);
		GridPane.setHalignment(check, HPos.RIGHT);
		pane.add(check, 1, 3);

		check.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				String name1 = name1Field.getText().trim();
				String name2 = name2Field.getText().trim();
				if (name1.equals("") || name2.equals("")) {
					new AlertBox().display("Error", "Name cannot be empty");
				} else {
					Person first = null, second = null;
					for (int i = 0; i < people.size(); i++) {
						if (people.get(i).getName().equals(name1)) {
							first = people.get(i);
						} else if (people.get(i).getName().equals(name2)) {
							second = people.get(i);
						}
					}
					if (first == null || second == null) {
						new AlertBox().display("Error", "Person doesn't exist.");
					} else {
						String result = manager.checkRelationShip(first, second);
						resultLabel.setText(result);
					}
				}
			}
		});
		Scene scene = new Scene(pane, 250, 170);
		checkWindow.setScene(scene);
		checkWindow.show();
	}

	public void defineNewRelation() {
		Stage defineWindow = new Stage();
		defineWindow.setTitle("Define Window");

		Label name1Label = new Label("Name 1: ");
		TextField name1Field = new TextField();
		Label name2Label = new Label("Name 2: ");
		TextField name2Field = new TextField();
		Label typeLabel = new Label("Type: ");
		ComboBox<String> relationChoice = new ComboBox<>(FXCollections.observableArrayList(
				new String[] { "friends", "parent", "couple", "colleague", "classmate", "sibling" }));
		Button add = new Button("ADD");
		relationChoice.setValue("friends");
		GridPane pane = new GridPane();
		pane.setAlignment(Pos.TOP_LEFT);
		pane.setHgap(10);
		pane.setVgap(10);
		pane.setPadding(new Insets(20, 20, 20, 20));
		ColumnConstraints column1 = new ColumnConstraints(80);
		ColumnConstraints column2 = new ColumnConstraints(100);
		column2.setHgrow(Priority.ALWAYS);
		pane.getColumnConstraints().addAll(column1, column2);

		GridPane.setHalignment(name1Label, HPos.LEFT);
		pane.add(name1Label, 0, 0);
		GridPane.setHalignment(name1Field, HPos.RIGHT);
		pane.add(name1Field, 1, 0);
		GridPane.setHalignment(name2Label, HPos.LEFT);
		pane.add(name2Label, 0, 1);
		GridPane.setHalignment(name2Field, HPos.RIGHT);
		pane.add(name2Field, 1, 1);
		GridPane.setHalignment(typeLabel, HPos.LEFT);
		pane.add(typeLabel, 0, 2);
		GridPane.setHalignment(relationChoice, HPos.RIGHT);
		pane.add(relationChoice, 1, 2);
		GridPane.setHalignment(add, HPos.RIGHT);
		pane.add(add, 1, 3);

		add.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				String name1 = name1Field.getText().trim();
				String name2 = name2Field.getText().trim();
				if (name1.equals("") || name2.equals("")) {
					new AlertBox().display("Error", "Name cannot be empty");
				} else {
					Person first = null, second = null;
					for (int i = 0; i < people.size(); i++) {
						if (people.get(i).getName().equals(name1)) {
							first = people.get(i);
						} else if (people.get(i).getName().equals(name2)) {
							second = people.get(i);
						}
					}
					if (first == null || second == null) {
						new AlertBox().display("Error", "Person doesn't exist.");
					} else {
						try {
							manager.addRelationShip(first, second, relationChoice.getValue().trim());
							defineWindow.close();
						} catch (TooYoungException | NotToBeFriendsException | NotToBeCoupledException
								| NoAvailableException | NotToBeColleaguesException | NotToBeClassmatesException
								| NoParentException e) {
							new AlertBox().display("Error", e.getMessage());
						}
					}
				}
			}
		});
		Scene scene = new Scene(pane, 250, 170);
		defineWindow.setScene(scene);
		defineWindow.show();
	}

	public void showChildren() {
		LinkedList<Person> children = manager.getChildren(currentSelected);
		String[] names = new String[children.size()];
		for (int i = 0; i < children.size(); i++) {
			names[i] = String.format("%16s", children.get(i).getName());
		}
		ObservableList<String> namesList = FXCollections.observableArrayList(names);
		ListView<String> list = new ListView<>(namesList);
		mainPane.setCenter(list);
	}

	public void showParents() {
		LinkedList<Person> parents = manager.getParents(currentSelected);
		String[] names = new String[parents.size()];
		for (int i = 0; i < parents.size(); i++) {
			names[i] = String.format("%16s", parents.get(i).getName());
		}
		ObservableList<String> namesList = FXCollections.observableArrayList(names);
		ListView<String> list = new ListView<>(namesList);
		mainPane.setCenter(list);
	}

	@Override
	public void start(Stage primaryStage) {
		this.manager = RelationShipManager.getInstance();
		currentSelected = null;
		initVariables();
		try {
			// initFrame();
			people = Util.readPersonFromFile();
			Util.readRelationFromFile(people, manager);
		} catch (FileNotFoundException | NumberFormatException | NoSuchAgeException ex) {
			new AlertBox().display("Error", "Cannot read people.txt or relation.txt");
			people = new LinkedList<>();
		}

		BorderPane root = new BorderPane();
		menuBar.getMenus().addAll(menu);
		menuBar.prefWidthProperty().bind(primaryStage.widthProperty());
		menu.getItems().addAll(addMenu, selectMenu, deleteMenu, findMenu, defineMenu, childrenMenu, parentMenu,
				exitMenu);
		root.setTop(menuBar);
		root.setCenter(mainPane);
		Scene scene = new Scene(root, 400, 400);
		primaryStage.setTitle("MiniNet");
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
			@Override
			public void handle(WindowEvent event) {
				try {
					Util.writePersonToFile(people);
					Util.writeRelationToFile(manager);
				} catch (IOException ex) {
					new AlertBox().display("Error", "Write to file failed");
				}
			}
		});
	}

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String[] args) {
		launch(args);
	}

}
