package display;


import javafx.application.Application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * This Class is used to start this game.
 */
public class GameStart extends Application {

	private Stage window;
	private Scene scene1;

	/**
	 * Generate the start scene.
	 *
	 * @param primaryStage the primary stage
	 * @throws Exception the exception
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;

		Parent root1 = FXMLLoader.load(getClass().getResource("/interact/view/Index.fxml"));
		window.getIcons().add(new Image("file:resource/img/icon.png"));
		scene1 = new Scene(root1, 600, 800);
		window.setScene(scene1);

		window.setTitle("Frogger");
		
		
		window.show();
		window.setResizable(false);

	}

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		launch(args);
	}

}
