package interact;

import javafx.application.Application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;


import javafx.stage.Stage;

public class Index extends Application{

	private Stage window;
	private Scene scene1;
	
	
	@Override
	public void start(Stage primaryStage) throws Exception{
		 window=primaryStage;
				 
		 
		 Parent root1 = FXMLLoader.load(getClass().getResource("/interact/view/Index.fxml"));
		 scene1=new Scene(root1, 600, 800);
		 window.setScene(scene1);
	     		 
	     
	    window.setTitle("Frogger");
	    window.show();
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
	
}
