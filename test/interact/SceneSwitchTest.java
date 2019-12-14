package interact;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import javafx.embed.swing.JFXPanel;
import javafx.scene.control.Button;

class SceneSwitchTest {

	SceneSwitch ss;
	JFXPanel jfxPanel = new JFXPanel();
	String url = "./resource/img/frogger.png";
	Button button = new Button();

	@BeforeEach
	void setUp() throws Exception {
		ss = new SceneSwitch();
	}

	@Test
	void testSceneJump() {
		Assertions.assertThrows(NullPointerException.class, new Executable() {

			@Override
			public void execute() throws Throwable {
				ss.sceneJump(button, url);

			}

		});
	}

	@Test
	void testSceneJumpTwo() {
		Assertions.assertThrows(NullPointerException.class, new Executable() {

			@Override
			public void execute() throws Throwable {
				ss.sceneJumpTwo(url);

			}

		});
	}


}
