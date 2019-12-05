package interact;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class SceneSwitch {
	
	/*
	 * Function to switch to a particular scene.
	 */
	public void sceneJump(Button buttonName, String url) throws IOException {
		Parent root = null;
		
		root = FXMLLoader.load(getClass().getResource(url));
		
		
	    Stage stage = (Stage) buttonName.getScene().getWindow();
	    Scene scene = new Scene(root);
	    stage.setScene(scene);
	    stage.show();
	    stage.setResizable(false);
	}
}
