package interact.controller;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import interact.SceneSwitch;

/**
 * The IndexController controllers four actions:
 * <p>
 * <ul>
 * <li>Change to {@code Level choose} page
 * <li>Change to {@code Information} page
 * <li>Change to {@code Index} page
 * <li>Change to {@code Score board} page
 * </ul>
 */
public class IndexController {

	@FXML
	private Button playButton;
	@FXML
	private Button informationButton;
	@FXML
	private Button gobackButton;
	@FXML
	private Button highScoreButton;

	/**
	 * Instantiates a new index controller.
	 */
	public IndexController() {

	}

	/**
	 * Change to {@code Level choose} when click on {@code playButton}.
	 *
	 * @throws Exception the exception
	 */
	@FXML
	protected void changeToLevel() throws Exception {

		playButton.setOnAction(event -> {
			SceneSwitch a = new SceneSwitch();
			try {
				a.sceneJump(playButton, "/interact/view/LevelChoose.fxml");
			} catch (IOException e) {
				e.printStackTrace();
			}
		});

	}

	/**
	 * Change to {@code Information} when click on {@code informationButton}.
	 *
	 * @throws Exception the exception
	 */
	@FXML
	protected void changeToInformation() throws Exception {

		informationButton.setOnAction(event -> {
			SceneSwitch b = new SceneSwitch();
			try {
				b.sceneJump(informationButton, "/interact/view/Information.fxml");
			} catch (IOException e) {
				e.printStackTrace();
			}
		});

	}

	/**
	 * Change to {@code Score board} when click on {@code highScoreButton}.
	 *
	 * @throws Exception the exception
	 */
	@FXML
	protected void changeToHighScore() throws Exception {

		highScoreButton.setOnAction(event -> {
			SceneSwitch c = new SceneSwitch();
			try {
				c.sceneJump(highScoreButton, "/interact/view/ScoreBoard.fxml");
			} catch (IOException e) {
				e.printStackTrace();
			}
		});

	}

	/**
	 * Change to {@code Index} when click on {@code gobackButton}.
	 *
	 * @throws Exception the exception
	 */
	@FXML
	protected void changeToIndex() throws Exception {

		gobackButton.setOnAction(event -> {
			SceneSwitch c = new SceneSwitch();
			try {
				c.sceneJump(gobackButton, "/interact/view/Index.fxml");
			} catch (IOException e) {
				e.printStackTrace();
			}
		});

	}

}
