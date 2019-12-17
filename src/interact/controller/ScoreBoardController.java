package interact.controller;

import interact.SceneSwitch;

import java.io.IOException;

import interact.model.ScoreBoard;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * The Class will dispkay the information of TOP5 players.
 */
public class ScoreBoardController {
	
	/** The first name. */
	@FXML
	private Label firstName;
	
	/** The second name. */
	@FXML
	private Label secondName;
	
	/** The third name. */
	@FXML
	private Label thirdName;
	
	/** The fourth name. */
	@FXML
	private Label fourthName;
	
	/** The fifth name. */
	@FXML
	private Label fifthName;

	/** The first score. */
	@FXML
	private Label firstScore;
	
	/** The second score. */
	@FXML
	private Label secondScore;
	
	/** The third score. */
	@FXML
	private Label thirdScore;
	
	/** The fourth score. */
	@FXML
	private Label fourthScore;
	
	/** The fifth score. */
	@FXML
	private Label fifthScore;

	/** The goback button. */
	@FXML
	private Button gobackButton;

	/**
	 * Initialize the {@code ScoreBoard} scene with top5 player names and their
	 * scores. <br>
	 * Change to {@code Index page} when click on {@code gobackButton}
	 */
	@FXML
	public void initialize() {

		firstName.setText(nameOne);
		secondName.setText(nameTwo);
		thirdName.setText(nameThree);
		fourthName.setText(nameFour);
		fifthName.setText(nameFive);

		firstScore.setText(scoreOne);
		secondScore.setText(scoreTwo);
		thirdScore.setText(scoreThree);
		fourthScore.setText(scoreFour);
		fifthScore.setText(scoreFive);

	}

	/** The s. */
	ScoreBoard s = ScoreBoard.getInstance();

	/** The name one. */
	String nameOne = s.getName(1);
	
	/** The name two. */
	String nameTwo = s.getName(2);
	
	/** The name three. */
	String nameThree = s.getName(3);
	
	/** The name four. */
	String nameFour = s.getName(4);
	
	/** The name five. */
	String nameFive = s.getName(5);

	/** The score one. */
	String scoreOne = s.getScore(1);
	
	/** The score two. */
	String scoreTwo = s.getScore(2);
	
	/** The score three. */
	String scoreThree = s.getScore(3);
	
	/** The score four. */
	String scoreFour = s.getScore(4);
	
	/** The score five. */
	String scoreFive = s.getScore(5);

	/**
	 * Change to index page when user press {@code Go Back} button.
	 */
	@FXML
	protected void changeToIndex() {

		gobackButton.setOnAction(event -> {
			SceneSwitch a = new SceneSwitch();
			try {
				a.sceneJump(gobackButton, "/interact/view/Index.fxml");
			} catch (IOException e) {
				e.printStackTrace();
			}

		});

	}

}