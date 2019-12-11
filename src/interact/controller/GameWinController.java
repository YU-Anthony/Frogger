package interact.controller;

import java.io.IOException;

import interact.SceneSwitch;
import interact.model.ScoreBoard;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * This controller controls the action: After the winner submit his game, the
 * game change to index page.
 */
public class GameWinController {

	public static final ScoreBoard s = null;
	@FXML
	private Button submitButton;
	@FXML
	private TextField nameText;

	/**
	 * Submit name when click on {@code submitButton}.
	 *
	 * @throws Exception the exception
	 */
	@FXML
	protected void nameSubmit() throws Exception {

		submitButton.setOnAction(event -> {
			String name = nameText.getText();
			ScoreBoard s = ScoreBoard.getInstance();
			s.inputName(name);
			s.inputScore();

			SceneSwitch a = new SceneSwitch();
			try {
				a.sceneJump(submitButton, "/interact/view/Index.fxml");
			} catch (IOException e) {
				e.printStackTrace();
			}

		});

	}

}
