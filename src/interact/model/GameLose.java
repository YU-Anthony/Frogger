package interact.model;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * This class gives choices {@code exit} or {@code restart} to users when the
 * lose the game.
 * <br> Player can choose to exit or restart game.
 */
public class GameLose {

	private Stage primaryStage;
	private Scene scene1;

	/**
	 * Show up choices when user lose the game. <br>
	 * Used in {@link display.KeepScore}
	 *
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void endChoices() throws IOException {
		Parent root1 = FXMLLoader.load(getClass().getResource("/interact/view/gameLose.fxml"));
		scene1 = new Scene(root1, 600, 800);
		primaryStage.setScene(scene1);
		primaryStage.show();
		primaryStage.setResizable(false);

	}

	/**
	 * Input {@code Stage}.
	 *
	 * @param primaryStage the primary stage
	 */
	public GameLose(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}
}
