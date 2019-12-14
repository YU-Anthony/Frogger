package interact.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ScoreBoardTest {


	ScoreBoard sb;
	
	@BeforeEach
	void setUp() throws Exception {
		sb=new ScoreBoard();
	}

	@Test
	void testGetName() {
		String name=sb.getName(100);
		assertSame(name,"-");
	}

	@Test
	void testGetScore() {
		String score=sb.getName(100);
		assertSame(score,"-");
	}

}
