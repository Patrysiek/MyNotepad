package application;

import java.io.IOException;

import com.jfoenix.controls.JFXDecorator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Region;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.paint.Color;

public class MainController implements ChangeFontListener,IColorChanger{

	@FXML TextArea mainTextArea;
	@FXML MenuItem wrapper;
	private TextAreaTextSaver saver;
	private TextAreaTextLoader loader;

	@FXML
	public void initialize() {
		saver = new TextAreaTextSaver();
		loader = new TextAreaTextLoader();
		setWrapperText();
	}
	
	public void menuItemOpenAction() {
		mainTextArea.setText(loader.setTextFromFile());
		saver.setPathToFile(loader.getPathToFile());
	}

	public void menuItemSaveAsAction() {
		saver.saveTextToFileAs(mainTextArea.getText());
	}
	public void   menuItemSaveAction() {
		saver.saveTextToFile(mainTextArea.getText());
	}

	public void menuItemNewWindowAction() {
		new Main().start(new Stage());
	}

	public void deleteSelectedText() {
		mainTextArea.setText(mainTextArea.getText().replaceAll(mainTextArea.selectedTextProperty().getValue(), ""));
	}

	public void wrapText(ActionEvent actionEvent) {
		if( ((MenuItem)actionEvent.getSource()).getId().equals("wrapper")  )
			setWrapperText();
	}
	
	
	public void closeApplication() throws Exception {
		Stage stage = (Stage) mainTextArea.getScene().getWindow();
	    stage.close();
	}
	
	public void showFontChanger() throws IOException {
		FXMLLoader loader = new FXMLLoader((getClass().getResource("/layout/FontChangerLayout.fxml")));
		Parent root = loader.load();
		FontChangerController fontController = loader.getController();
		fontController.setChangeFontListener(this);
		setNewScene(root,200,200);
	}


	private void setNewScene(Parent root,int width,int height) {
		Stage stage = new Stage();
		
		JFXDecorator decorator = new JFXDecorator(stage, root);
		decorator.setCustomMaximize(false);    
		Scene scene = new Scene(decorator,width,height);
		stage.setScene(scene);
		stage.setResizable(false);	
		stage.show();
		
	}

	public void showColorChanger() throws IOException {
		FXMLLoader loader = new FXMLLoader((getClass().getResource("/layout/ColorChangerLayout.fxml")));
		Parent root = loader.load();
		ColorChangerController colorController = loader.getController();
		colorController.setChangeColorListener(this);
		setNewScene(root,200,230);
	}



	private void setWrapperText() {
		boolean isWrap = mainTextArea.wrapTextProperty().get();
		mainTextArea.wrapTextProperty().set(!isWrap);

		if (!isWrap)
			wrapper.setText("Wrap Text: Enabled");
		else
			wrapper.setText("Wrap Text: Disabled");		
	}

	@Override
	public void changeFont(String font, int fontSize) {
				mainTextArea.setFont(new Font(font, fontSize));
	}

	@Override
	public void changeColors(Color fontColor, Color backgroundColor) {
		 Region region = ( Region ) mainTextArea.lookup( ".content" );
		    region.setBackground( new Background( new BackgroundFill( backgroundColor, CornerRadii.EMPTY, Insets.EMPTY ) ) );
	}


}
