package interact.controller;

import java.io.IOException;

import interact.SceneSwitch;
import interact.model.ScoreBoard;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;


public class GameWinController {
	
	@FXML
	private Button submitButton;
	@FXML
	private TextField nameText;
	

	
	@FXML
	protected void nameSubmit() throws Exception{
		
		
		submitButton.setOnAction(event -> {
			String name= nameText.getText();
			ScoreBoard s= new ScoreBoard(name);
			s.inputScore();
			
			 SceneSwitch a = new SceneSwitch();
			    try {
					a.sceneJump(submitButton,"/interact/view/Index.fxml");
				} catch (IOException e) {
					e.printStackTrace();
				}
			    
		});
			    
	}
	
	
	

}
