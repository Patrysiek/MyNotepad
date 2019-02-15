package application;
	
import com.jfoenix.controls.JFXDecorator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Main extends Application {

	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/layout/MainLayout.fxml"));
			Parent root = loader.load();
			
			JFXDecorator decorator = new JFXDecorator(primaryStage , root);
			decorator.setCustomMaximize(true);                  
			String uri = getClass().getResource("/layout/style.css").toExternalForm();
			
			
			Scene scene = new Scene(decorator,1000,800);

			scene.getStylesheets().add(uri) ;
			
			primaryStage.setTitle("My Notepad");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}  
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
