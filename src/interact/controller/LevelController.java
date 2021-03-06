package interact.controller;

import display.GameApp;
import interact.GameStage;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;
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
	@FXML
	private Button secretButton;

	/**
	 * Change to {@code easy level} when click on {@code easyButton} <br>
	 * @throws Exception the exception
	 */
	@FXML
	protected void changeToEasy() throws Exception {

		easyButton.setOnAction(event -> {

			generateWorld(background,easyButton,"easy");

		});

	}
	
	
	/**
	 * Change to {@code normal} when click on {@code normalButton}
	 *
	 * @throws Exception the exception
	 */
	@FXML
	protected void changeToNormal() throws Exception {
		normalButton.setOnAction(event -> {

			generateWorld(background,normalButton,"normal");

		});

	}

	/**
	 * Change to {@code Hidden level} when click on {@code enterButton} <br>
	 * @throws Exception the exception
	 */
	@FXML
	protected void changeToSecret() throws Exception {
		GameStage background2=new GameStage();

		enterButton.setOnAction(e -> {

			generateWorld(background2,enterButton,"new");

		});
		

	}
	
	/**
	 * An alert will be given when choosing the secret level <br>
	 * @throws Exception the exception
	 */
	@FXML
	protected void information() throws Exception{
		secretButton.setOnAction(event->{
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Information");
			alert.setHeaderText("This a hidden level !");
			alert.setContentText("You can find it when playing other levels");
			alert.show();
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
