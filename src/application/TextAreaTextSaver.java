package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.FileChooser.ExtensionFilter;

public class TextAreaTextSaver {
	private static FileChooser fileChooser;
	
	private TextAreaTextSaver() {
	}
	
	public static void showFileChooser() {
		fileChooser = new FileChooser();
		fileChooser.setTitle("Open Text File");
		fileChooser.getExtensionFilters().add(new ExtensionFilter("Text files", "*.txt"));
	}
	
	public static void setTextFromFile(TextArea mainTextArea) throws FileNotFoundException {

		File file = fileChooser.showOpenDialog(new Stage());
		Scanner reader = new Scanner(file);
		reader.useDelimiter("\\Z"); 
		mainTextArea.setText(reader.next());
		reader.close();
		
	}

}
