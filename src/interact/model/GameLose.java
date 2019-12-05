package interact.model;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GameLose {
	private Stage primaryStage;
	private Scene scene1;

	/*
	 * This function give user the choice that quit or restart the game
	 * when they lose the game.
	 */
	
	public void endChoices() throws IOException {
		 Parent root1 = FXMLLoader.load(getClass().getResource("/interact/view/gameLose.fxml"));
		 scene1=new Scene(root1, 600, 800);
		 primaryStage.setScene(scene1);
		 primaryStage.show();
		 primaryStage.setResizable(false);
		 
		 
	}
	
	public GameLose(Stage primaryStage) {
		this.primaryStage=primaryStage;
	}
}
