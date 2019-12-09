package interact.controller;

import java.io.IOException;

import display.Display;
import element.Animal;
import element.BackgroundImage;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import p4_group_8_repo.KeepScore;
import p4_group_8_repo.MyStage;

/**
 * The Class LevelController controls action: 
 * <br>
 * Change to different game levels .
 */
public class LevelController extends Application {

	public static MyStage background  = new MyStage();
	public static MyStage background2 = new MyStage();
	private Animal animal;
	private Display world;
	private String music1 = "src/Frogger Main Song Theme (loop).mp3";
	private String music2 = "src/SpongBob.mp3";
	private String music3 = "src/Grasswalk.mp3";
	
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
			
		Scene scene1 = new Scene(background, 600, 800);

		// Different button to generate different levels
		easyButton.setOnAction(event -> {

			BackgroundImage froggerback = new BackgroundImage("file:src/img/arcade.png");
			background.add(froggerback);

			world = new Display();
			world.createEasyWorld(background);
			world.endAndDigit(background);

			animal = new Animal("file:src/img/froggerUp.png");
			background.add(animal);

			world.healthPoint(background);

			background.start();

			stage = (Stage) easyButton.getScene().getWindow();
			stage.setScene(scene1);
			stage.show();
			stage.setResizable(false);

			// Put the score part in keepScore.java
			KeepScore score = new KeepScore(animal, stage, music1,background);
			score.start();
			
			
			

		});

		

		
	}
	
	@FXML
	protected void changeToNormal() throws Exception{
		normalButton.setOnAction(event -> {

			Scene scene1 = new Scene(background, 600, 800);
			BackgroundImage froggerback = new BackgroundImage("file:src/img/arcade2.png");
			background.add(froggerback);

			world = new Display();
			world.createNormalWorld(background);
			world.endAndDigit(background);

			animal = new Animal("file:src/img/froggerUp.png");
			background.add(animal);

			world.healthPoint(background);

			background.start();

			stage = (Stage) normalButton.getScene().getWindow();
			stage.setScene(scene1);
			stage.show();
			stage.setResizable(false);

			// Put the score part in keepScore.java
			KeepScore score = new KeepScore(animal, stage, music2,background);
			score.start();
			
			

		});

	}
	
	@FXML
	protected void changeToSecret() throws Exception{
		Scene scene2 = new Scene(background2, 600, 800);
		enterButton.setOnAction(e -> {
			
			BackgroundImage froggerback2 = new BackgroundImage("file:src/img/background3test.png");
			background2.add(froggerback2);

			world = new Display();
			world.createNewWorld(background2);
			world.endAndDigit(background2);

			animal = new Animal("file:src/img/froggerUp.png");
			background2.add(animal);

			world.healthPoint(background2);

			background2.start();

			stage = (Stage) enterButton.getScene().getWindow();
			stage.setScene(scene2);
			stage.show();
			stage.setResizable(false);
			
			// Put the score part in keepScore.java
			KeepScore score1 = new KeepScore(animal, stage, music3,background2);
			score1.start();

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

}
