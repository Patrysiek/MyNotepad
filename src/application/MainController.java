package application;


import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class MainController {

	@FXML
	TextArea mainTextArea;

	public void menuItemOpenAction()  {
		TextAreaTextLoader.showFileChooser();
		TextAreaTextLoader.setTextFromFile(mainTextArea);
	}
	
	public void menuItemSaveAction() {
		TextAreaTextSaver.showFileChooser();
		if(mainTextArea.getText().length()>0)
		TextAreaTextSaver.saveTextToFile(mainTextArea);
	}
	public void menuItemNewWindowAction() {
		new Main().start(new Stage());
	}

}
