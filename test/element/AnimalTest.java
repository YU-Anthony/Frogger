package element;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import interact.GameStage;
import javafx.embed.swing.JFXPanel;

class AnimalTest {

	Animal a;
	GameStage b = new GameStage();
	JFXPanel jfxPanel=new JFXPanel();
	
	@BeforeEach
	void setUp() throws Exception {
		a=new Animal(b);
	}

	@Test
	void testGetPoints() {
		int i=a.getPoints();
		assertEquals(0,i);
	}

	@Test
	void testChangeScore() {
		boolean score=a.changeScore();
		assertEquals(false,score);
		
	}


}
