package interact.controller;

import java.io.IOException;
import interact.SceneSwitch;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class GameLoseController {

	@FXML
	private Button exitButton;
	@FXML
	private Button restartButton;
	
	/*
	 * This controller controls two action: exit and restart in the "gameLose scene".
	 * 
	 */
	
	@FXML
	protected void exitGame() throws Exception{
		exitButton.setOnAction(event -> {
		   
		    Stage stage = (Stage) exitButton.getScene().getWindow();
		    stage.close();
		});
		
	}
	
	@FXML
	protected void restartGame() throws Exception{
		
		restartButton.setOnAction(event -> {	    
		    SceneSwitch a = new SceneSwitch();
		    try {
				a.sceneJump(restartButton,"/interact/view/Index.fxml");
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
		
		
	}
}
