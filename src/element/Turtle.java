package element;

import interact.GameStage;
import interact.controller.LevelController;
import javafx.scene.image.Image;

/**
 * This Class inherit {@link Actor} and is displayed in {@link LevelController}.
 * 
 * <p>
 * This class define all attributes and actions of {@code Turtle}.
 */
public class Turtle extends Actor {

	private Image turtle1;
	private Image turtle2;
	private Image turtle3;
	private int speed;

	/**
	 * Act.
	 *
	 * @param now the now
	 */
	@Override
	public void act(long now) {

		long temp = now / 900000000 % 3;
		if (temp == 0) {
			setImage(turtle2);

		} else if (temp == 1) {
			setImage(turtle1);

		} else if (temp == 2) {
			setImage(turtle3);

		}

		move(speed, 0);
		if (getX() > 600 && speed > 0)
			setX(-200);
		if (getX() < -75 && speed < 0)
			setX(600);
	}

	/**
	 * Instantiates a new turtle with specific parameters.
	 *
	 * @param xpos - the x position
	 * @param ypos - the y position
	 * @param s    - the speed
	 * @param w    - the image width
	 * @param h    - the image height
	 */
	public Turtle(int xpos, int ypos, int s, int w, int h) {

		turtle1 = new Image("file:resource/img/TurtleAnimation1.png", w, h, true, true);
		turtle2 = new Image("file:resource/img/TurtleAnimation2.png", w, h, true, true);
		turtle3 = new Image("file:resource/img/TurtleAnimation3.png", w, h, true, true);
		setX(xpos);
		setY(ypos);
		speed = s;
		setImage(turtle2);
	}

	/**
	 * Instantiates a new turtle without specific parameters.
	 */
	public Turtle() {
	}

	/**
	 * Inherit this method from {@link Actor} to generate pre-defined
	 * {@code Turtle}.
	 * <p>
	 * This method will be called in {@link display.GameApp} and the {@code Turtle} will be
	 * displayed in easy game level.
	 */
	@Override
	public void disPlay(GameStage background) {
		background.add(new Turtle(500, 376, -1, 130, 130));
		background.add(new Turtle(300, 376, -1, 130, 130));

		background.add(new WetTurtle(700, 376, -1, 130, 130));
		background.add(new WetTurtle(600, 217, -1, 130, 130));
		background.add(new WetTurtle(400, 217, -1, 130, 130));
		background.add(new WetTurtle(200, 217, -1, 130, 130));
	}

}
