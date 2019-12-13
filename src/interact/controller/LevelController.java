package interact.controller;

import display.GameApp;
import interact.GameStage;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * The Class LevelController controls action: <br>
 * Change to different game levels .
 */
public class LevelController extends Application {

	private  GameStage background = new GameStage();

	private GameApp world;

	public static Stage stage;
	public static Stage stage2;

	@FXML
	private Button easyButton;
	@FXML
	private Button normalButton;
	@FXML
	private Button enterButton;

	/**
	 * Change to {@code easy level} when click on {@code easyButton} <br>
	 * Change to {@code normal} when click on {@code normalButton}
	 *
	 * @throws Exception the exception
	 */
	@FXML
	protected void changeToEasy() throws Exception {

		easyButton.setOnAction(event -> {

			generateWorld(background,easyButton,"easy");

		});

	}

	@FXML
	protected void changeToNormal() throws Exception {
		normalButton.setOnAction(event -> {

			generateWorld(background,normalButton,"normal");

		});

	}

	@FXML
	protected void changeToSecret() throws Exception {
		GameStage background2=new GameStage();

		enterButton.setOnAction(e -> {

			generateWorld(background2,enterButton,"new");

		});

	}

	/**
	 * Start.
	 *
	 * @param arg0 the arg 0
	 * @throws Exception the exception
	 */
	@Override
	public void start(Stage arg0) throws Exception {

	}
	
	public void generateWorld(GameStage background, Button button,String gameLevel) {
		world = new GameApp(background);
		stage = (Stage) button.getScene().getWindow();
		if(gameLevel.contentEquals("easy")) {
			world.createEasyWorld(background,stage);
		}else if(gameLevel.contentEquals("normal")) {
			world.createNormalWorld(background,stage);
		}else if(gameLevel.contentEquals("new")){
			world.createNewWorld(background,stage);
		}
		
	}

}
