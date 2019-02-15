package application;

import javafx.fxml.FXML;
import javafx.scene.control.ColorPicker;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ColorChangerController {

	IColorChanger changer;
	@FXML ColorPicker backgroundColorPicker;
	@FXML ColorPicker textColorPicker;
	Color fontColor,backgroundColor;
	public void setChangeColorListener(IColorChanger changer) {
		this.changer  = changer;
		
	}
	public void okClick() {
		backgroundColor = backgroundColorPicker.getValue();
		fontColor = textColorPicker.getValue();
		changer.changeColors(fontColor, backgroundColor);
		closeWindow();
	}
	public void cancelClick() {
		closeWindow();
	}

	private void closeWindow() {
		Stage stage = (Stage) textColorPicker.getScene().getWindow();
	    stage.close();
	}
}
