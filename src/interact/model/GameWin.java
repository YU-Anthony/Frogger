package interact.model;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * This class asks the winner to input their names. <br>
 * Used in {@link display.KeepScore}
 */
public class GameWin {

	private Stage primaryStage;
	private Scene scene1;

	/**
	 * Ask user to enter their name.
	 *
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void nameEnterDisplay() throws IOException {

		Parent root1 = FXMLLoader.load(getClass().getResource("/interact/view/gameWin.fxml"));
		scene1 = new Scene(root1, 600, 800);
		primaryStage.setScene(scene1);
		primaryStage.show();
		primaryStage.setResizable(false);

	}

	/**
	 * Once user submit their name, change to {@code Index page}.
	 *
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void gotoIndex() throws IOException {
		Parent root1 = FXMLLoader.load(getClass().getResource("/interact/view/Index.fxml"));
		scene1 = new Scene(root1, 600, 800);
		primaryStage.setScene(scene1);
		primaryStage.show();
		primaryStage.setResizable(false);
	}

	/**
	 * Input the {@code Stage}.
	 *
	 * @param primaryStage the primary stage
	 */
	public GameWin(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}

}
