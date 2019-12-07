package interact;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * Change between different scenes. Used in {@link GameLoseController},
 * {@link GameWinController},
 * {@link IndexController},{@link ScoreBoardController}
 */
public class SceneSwitch {

	/**
	 * Scene jump.
	 *
	 * @param buttonName the button name
	 * @param url        the fxml name
	 * @throws IOException Signals that an I/O exception has occurred.
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
