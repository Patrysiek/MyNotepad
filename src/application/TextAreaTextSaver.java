package application;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.FileChooser.ExtensionFilter;

public class TextAreaTextSaver {
	private  FileChooser fileChooser;
	private String pathToFile;

	public  void saveTextToFileAs(String text) {
			initFileChooser();
		try {
			FileWriter fileWriter;
			File file = fileChooser.showSaveDialog(new Stage());

			if (file != null) {
				fileWriter = new FileWriter(file);
				PrintWriter printWriter = new PrintWriter(fileWriter);
				printWriter.printf(text);
				printWriter.close();
				pathToFile = file.getPath();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public  void saveTextToFile(String text) {
	try {
		FileWriter fileWriter;
	
		if (pathToFile != null) {
			fileWriter = new FileWriter(pathToFile);
			PrintWriter printWriter = new PrintWriter(fileWriter);
			printWriter.printf(text);
			printWriter.close();
		}
		else
			saveTextToFileAs(text);

	} catch (IOException e) {
		e.printStackTrace();
	}
}

	private void initFileChooser() {
		ExtensionFilter extFiler = new ExtensionFilter("Text files", "*.txt");
		fileChooser = new FileChooser();
		fileChooser.setTitle("Save Text File");
		fileChooser.setInitialFileName("NewTextFile");
		fileChooser.getExtensionFilters().add(extFiler);
		fileChooser.setSelectedExtensionFilter(extFiler);
	}

	public void setPathToFile(String pathToFile) {
		this.pathToFile = pathToFile;
	}
}
