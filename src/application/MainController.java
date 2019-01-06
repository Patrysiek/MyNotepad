package application;

import java.io.FileNotFoundException;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class MainController {

	@FXML
	TextArea mainTextArea;

	public void menuItemOpenAction() throws FileNotFoundException {
		TextAreaTextLoader.showFileChooser();
		TextAreaTextLoader.setTextFromFile(mainTextArea);
	}

}
