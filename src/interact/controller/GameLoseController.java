package interact.controller;

import java.io.IOException;
import interact.SceneSwitch;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * This controller controls two actions: Exit game or restart game.
 */
public class GameLoseController {

	@FXML
	private Button exitButton;
	@FXML
	private Button restartButton;

	/**
	 * Exit game when click on {@code exitButton}
	 *
	 * @throws Exception the exception
	 */
	@FXML
	protected void exitGame() throws Exception {
		exitButton.setOnAction(event -> {

			Stage stage = (Stage) exitButton.getScene().getWindow();
			stage.close();
		});

	}

	/**
	 * Restart game when click on {@code restartButton}.
	 *
	 * @throws Exception the exception
	 */
	@FXML
	protected void restartGame() throws Exception {

		restartButton.setOnAction(event -> {
			SceneSwitch a = new SceneSwitch();
			try {
				a.sceneJump(restartButton, "/interact/view/Index.fxml");
			} catch (IOException e) {
				e.printStackTrace();
			}
		});

	}
}
