package element;

import interact.controller.LevelController;
import javafx.scene.image.Image;

/**
 * This Class inherit {@link Actor} and is displayed in {@link LevelController}.
 * 
 * <p>
 * This class define all attributes and actions of {@code WetTurtle}.
 */
public class WetTurtle extends Actor {

	private Image turtle1;
	private Image turtle2;
	private Image turtle3;
	private Image turtle4;
	private int speed;
	private boolean sunk = false;

	/**
	 * Act.
	 *
	 * @param now the now
	 */
	@Override
	public void act(long now) {
		long temp = now / 900000000 % 4;

		if (temp == 0) {
			setImage(turtle2);
			sunk = false;
		} else if (temp == 1) {
			setImage(turtle1);
			sunk = false;
		} else if (temp == 2) {
			setImage(turtle3);
			sunk = false;
		} else if (temp == 3) {
			setImage(turtle4);
			sunk = true;
		}

		move(speed, 0);
		if (getX() > 600 && speed > 0)
			setX(-200);
		if (getX() < -75 && speed < 0)
			setX(600);
	}

	/**
	 * Instantiates a new wet turtle with specific parameters.
	 *
	 * @param xpos - the x position
	 * @param ypos - the y position
	 * @param s    - the speed
	 * @param w    - the image width
	 * @param h    - the image height
	 */
	public WetTurtle(int xpos, int ypos, int s, int w, int h) {
		turtle1 = new Image("file:resource/img/TurtleAnimation1.png", w, h, true, true);
		turtle2 = new Image("file:resource/img/TurtleAnimation2Wet.png", w, h, true, true);
		turtle3 = new Image("file:resource/img/TurtleAnimation3Wet.png", w, h, true, true);
		turtle4 = new Image("file:resource/img/TurtleAnimation4Wet.png", w, h, true, true);
		setX(xpos);
		setY(ypos);
		speed = s;
		setImage(turtle2);
	}

	/**
	 * Checks if turtle is sunk. <br>
	 * This method will be used to judge whether a turtle is sunk in {@code Animal}.
	 * <br>
	 * If yes, the frogger will trigger {@code WaterDeath}.
	 *
	 * @return true, if is sunk
	 */
	public boolean isSunk() {
		return sunk;
	}
}
