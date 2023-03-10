import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * This panel is the basic panel, inside which other panels are placed. Before
 * beginning to implement, design the structure of your GUI in order to
 * understand what panels go inside which ones, and what buttons or other
 * components go in which panels.
 * 
 * @author ralexander
 *
 */
//make the main panel's layout be a VBox
public class FXMainPane extends VBox {

	// student Task #2:
	// declare five buttons, a label, and a textfield
	Button but1, but2, but3, but4, but5;
	Button but6;
	Label theLabel;
	TextField theTextField;
	// declare two HBoxes
	HBox box1, box2;
	// student Task #4:
	// declare an instance of DataManager
	DataManager dataManager;

	/**
	 * The MainPanel constructor sets up the entire GUI in this approach. Remember
	 * to wait to add a component to its containing component until the container
	 * has been created. This is the only constraint on the order in which the
	 * following statements appear.
	 */
	FXMainPane() {
		// student Task #2:
		// instantiate the buttons, label, and textfield
		but1 = new Button("Hello");
		but2 = new Button("Howdy");
		but3 = new Button("Chinese");
		but4 = new Button("Clear");
		but5 = new Button("Exit");

		but6 = new Button("Spanish");

		theLabel = new Label("FeedBack:");
		theTextField = new TextField();
		// instantiate the HBoxes
		box1 = new HBox();
		box2 = new HBox();
		// student Task #4:
		// instantiate the DataManager instance
		dataManager = new DataManager();
		// set margins and set alignment of the components

		// student Task #3:
		// add the label and textfield to one of the HBoxes
		box2.getChildren().addAll(theLabel, theTextField);
		// add the buttons to the other HBox
		box1.getChildren().addAll(but1, but2, but3, but6, but4, but5);
		// add the HBoxes to this FXMainPanel (a VBox)
		getChildren().addAll(box1, box2);

		but1.setOnAction(new ButtonHandler());
		but2.setOnAction(new ButtonHandler());
		but3.setOnAction(new ButtonHandler());
		but4.setOnAction(new ButtonHandler());
		but5.setOnAction(new ButtonHandler());
		but6.setOnAction(new ButtonHandler());

		Insets inset = new Insets(8);
		HBox.setMargin(but1, inset);
		HBox.setMargin(but2, inset);
		HBox.setMargin(but3, inset);
		HBox.setMargin(but4, inset);
		HBox.setMargin(but5, inset);
		HBox.setMargin(but6, inset);

		box1.setAlignment(Pos.CENTER);
		box2.setAlignment(Pos.CENTER);

	}

	// Task #4:
	// create a private inner class to handle the button clicks
	private class ButtonHandler implements EventHandler<ActionEvent> {

		public void handle(ActionEvent event) {

			if (event.getTarget().equals(but1)) {
				theTextField.setText(dataManager.getHello());
			} else if (event.getTarget().equals(but2)) {
				theTextField.setText(dataManager.getHowdy());
			} else if (event.getTarget().equals(but3)) {
				theTextField.setText(dataManager.getChinese());
			} else if (event.getTarget().equals(but6)) {
				theTextField.setText(dataManager.getSpanish());
			} else if (event.getTarget().equals(but4)) {
				theTextField.setText("");
			} else if (event.getTarget().equals(but5)) {
				Platform.exit();
				System.exit(0);
			}

		}
	}
}
