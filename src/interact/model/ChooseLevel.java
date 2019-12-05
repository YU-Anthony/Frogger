package interact.model;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
 
public class ChooseLevel extends Application {
	 Stage stage=new Stage();
 
	@Override
	public void start(Stage primaryStage) throws Exception{
//        Parent root = FXMLLoader.load(getClass().getResource("ChooseLevel.fxml"));
//        primaryStage.setTitle("Choose Level");
//        primaryStage.setScene(new Scene(root, 576, 814.5));
//        primaryStage.show(); 
//        primaryStage.setResizable(false);
    }
 
//	public static void main(String[] args) {
//		launch(args);
//	}
	
	public void  showWindow() throws Exception {
		start(stage);
	}
	
}
