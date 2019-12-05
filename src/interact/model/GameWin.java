package interact.model;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GameWin {
	private Stage primaryStage;
	private Scene scene1;
	
	
	public void nameEnterDisplay() throws IOException {
		
		
		 Parent root1 = FXMLLoader.load(getClass().getResource("/interact/view/gameWin.fxml"));
		 scene1=new Scene(root1, 600, 800);
		 primaryStage.setScene(scene1);
		 primaryStage.show();
		 primaryStage.setResizable(false);
		 
	}
	
	public void gotoIndex() throws IOException{
		 Parent root1 = FXMLLoader.load(getClass().getResource("/interact/view/Index.fxml"));
		 scene1=new Scene(root1, 600, 800);
		 primaryStage.setScene(scene1);
		 primaryStage.show();
		 primaryStage.setResizable(false);
	}
	
	public GameWin(Stage primaryStage) {
		this.primaryStage=primaryStage;
	}
	
}
