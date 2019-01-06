package application;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.FileChooser.ExtensionFilter;

public class TextAreaTextSaver {
	private static FileChooser fileChooser;

	private TextAreaTextSaver() {
	}

	public static void showFileChooser() {
		ExtensionFilter extFiler = new ExtensionFilter("Text files", "*.txt");
		fileChooser = new FileChooser();
		fileChooser.setTitle("Save Text File");
		fileChooser.setInitialFileName("NewTextFile");
		fileChooser.getExtensionFilters().add(extFiler);
		fileChooser.setSelectedExtensionFilter(extFiler);
	}

	public static void saveTextToFile(TextArea mainTextArea) {
			
		try {
			FileWriter fileWriter;
			File file = fileChooser.showSaveDialog(new Stage());
			fileWriter = new FileWriter(file);

			PrintWriter printWriter = new PrintWriter(fileWriter);
			printWriter.printf(mainTextArea.getText());
			printWriter.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}


}
