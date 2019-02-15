package application;

import java.io.File;

import java.util.Scanner;


import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.FileChooser.ExtensionFilter;

public class TextAreaTextLoader {
	private FileChooser fileChooser;
	private File file;
	private String pathToFile;

	private void initFileChooser() {
		fileChooser = new FileChooser();
		fileChooser.setTitle("Open Text File");
		fileChooser.getExtensionFilters().add(new ExtensionFilter("Text files", "*.txt"));
	}

	public String setTextFromFile() {
		String text = "";
		initFileChooser();
		file = fileChooser.showOpenDialog(new Stage());
		Scanner reader;
		try {
			pathToFile = file.getPath();
			reader = new Scanner(file);
			reader.useDelimiter("\\Z");
			text = reader.next();
			reader.close();
			

		} catch (Exception e) {
		}
		return text;
	}

	public String getPathToFile() {
		return pathToFile;
	}


}
