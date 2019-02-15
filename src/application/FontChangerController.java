package application;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class FontChangerController {

	@FXML Spinner<Integer> fontSizeSpinner;
	@FXML ComboBox<String> fontComboBox;
	private ChangeFontListener changeFontListener;
	
	public void initialize() {

		fontComboBox.getItems().addAll(Font.getFamilies());
		fontComboBox.getSelectionModel().select(0);
		SpinnerValueFactory<Integer> spinnerFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 100,12);
		fontSizeSpinner.setValueFactory(spinnerFactory);

	}

	public void okClick() {
		changeFontListener.changeFont(fontComboBox.getSelectionModel().getSelectedItem(), fontSizeSpinner.getValue());
		closeWindow();
	}
	public void cancelClick() {
		closeWindow();
	}

	private void closeWindow() {
		Stage stage = (Stage) fontComboBox.getScene().getWindow();
	    stage.close();
	}

	public void setChangeFontListener(ChangeFontListener changeFontListener) {
		this.changeFontListener = changeFontListener;
		
	}
}
