package interact.controller;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import interact.SceneSwitch;
  
public class IndexController  {
			
	
	@FXML
	private Button playButton;
	@FXML
	private Button informationButton;
	@FXML
	private Button gobackButton;
	@FXML
	private Button highScoreButton;
	
	public IndexController() {

	}


	@FXML
	protected void changeToLevel() throws Exception {

		playButton.setOnAction(event -> {
			 SceneSwitch a = new SceneSwitch();
			    try {
					a.sceneJump(playButton,"/interact/view/LevelChoose.fxml");
				} catch (IOException e) {
					e.printStackTrace();
				}
		});
		
	}
	
	@FXML
	protected void changeToInformation() throws Exception {

		informationButton.setOnAction(event -> {
			SceneSwitch b = new SceneSwitch();
		    try {
				b.sceneJump(informationButton,"/interact/view/Information.fxml");
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
		
	}
	
	@FXML
	protected void changeToHighScore() throws Exception {

		highScoreButton.setOnAction(event -> {
			SceneSwitch c = new SceneSwitch();
			try {
				c.sceneJump(highScoreButton,"/interact/view/ScoreBoard.fxml");
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
		
		 
	}
	
	@FXML
	protected void changeToIndex() throws Exception {

		gobackButton.setOnAction(event -> {
			SceneSwitch c = new SceneSwitch();
			try {
				c.sceneJump(gobackButton,"/interact/view/Index.fxml");
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
		
	}

	
 
}
