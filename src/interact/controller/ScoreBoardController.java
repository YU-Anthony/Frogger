package interact.controller;
import interact.SceneSwitch;




import java.io.IOException;

import interact.model.ScoreBoard;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;


public class ScoreBoardController {
	@FXML private Label firstName;
	@FXML private Label secondName;
	@FXML private Label thirdName;
	@FXML private Label fourthName;
	@FXML private Label fifthName;
	
	@FXML private Label firstScore;
	@FXML private Label secondScore;
	@FXML private Label thirdScore;
	@FXML private Label fourthScore;
	@FXML private Label fifthScore;
	
	@FXML private Button gobackButton;
	
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
	
	ScoreBoard s =new ScoreBoard();
	
	
	String nameOne=s.getName(1);
	String nameTwo=s.getName(2);
	String nameThree=s.getName(3);
	String nameFour=s.getName(4);
	String nameFive=s.getName(5);
	
	String scoreOne=s.getScore(1);
	String scoreTwo=s.getScore(2);
	String scoreThree=s.getScore(3);
	String scoreFour=s.getScore(4);
	String scoreFive=s.getScore(5);
	
	@FXML
	protected void changeToIndex(){

		gobackButton.setOnAction (event -> {
			 	SceneSwitch a = new SceneSwitch();
				try {
					a.sceneJump(gobackButton,"/interact/view/Index.fxml");
				} catch (IOException e) {
					e.printStackTrace();
				}

		});
		
	}
	
	
	
}