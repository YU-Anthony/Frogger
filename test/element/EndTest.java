package element;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import javafx.embed.swing.JFXPanel;

class EndTest {

	JFXPanel jfxPanel = new JFXPanel();
	End end = new End(1, 2);

	@Test
	void testEnd() {
		assertEquals(1, end.getX());
		assertEquals(2, end.getY());
	}

}
