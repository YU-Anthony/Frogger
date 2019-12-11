package element;

import javafx.scene.image.Image;
import interact.controller.LevelController;;

/**
 * This Class inherit {@link Actor} and is displayed in {@link LevelController}.
 * 
 * <p>
 * This class define all attributes and actions of {@code Log}.
 */
public class Log extends Actor {

	private double speed;

	/**
	 * Act.
	 *
	 * @param now the now
	 */
	@Override
	public void act(long now) {
		move(speed, 0);
		if (getX() > 600 && speed > 0)
			setX(-180);
		if (getX() < -300 && speed < 0)
			setX(700);
	}

	/**
	 * Instantiates a new log.
	 *
	 * @param imageLink the image link
	 * @param size      the image size
	 * @param xpos      the horizontal axis
	 * @param ypos      the vertical axis
	 * @param s         the speed
	 */
	public Log(String imageLink, int size, int xpos, int ypos, double s) {
		setImage(new Image(imageLink, size, size, true, true));
		setX(xpos);
		setY(ypos);
		speed = s;

	}

	/**
	 * Instantiates a new log without specific parameters.
	 */
	public Log() {

	}

	/**
	 * Judge the direction of {@code Log} Return true if it in left direction.
	 *
	 * @return the left
	 */
	public boolean getLeft() {
		return speed < 0;
	}

	/**
	 * Inherit this method from {@link Actor} to generate pre-defined {@code Log}.
	 * <p>
	 * This method will be called in {@link Display} and the {@code Log} will be
	 * displayed in normal game level.
	 */
	@Override
	public void disPlay(String gameLevel) {

		if (gameLevel.equalsIgnoreCase("Easy")) {
			for (int i = 0; i < 3; i++) {
				LevelController.background.add(new Log("file:resource/img/log3.png", 130, 0 + 220 * i, 166, 0.75));
				LevelController.background.add(new Log("file:resource/img/log3.png", 130, 50 + 220 * i, 329, 0.75));
			}

			LevelController.background.add(new Log("file:resource/img/logs.png", 250, 0, 276, -2));
			LevelController.background.add(new Log("file:resource/img/logs.png", 250, 400, 276, -2));
		} else if (gameLevel.equalsIgnoreCase("Normal")) {
			for (int i = 0; i < 3; i++) {
				LevelController.background.add(new Log("file:resource/img/log3.png", 130, 0 + 220 * i, 166, 0.75));
				LevelController.background.add(new Log("file:resource/img/log3.png", 130, 50 + 220 * i, 329, 0.75));
			}

			LevelController.background.add(new Log("file:resource/img/logs.png", 250, 0, 276, -2));
			LevelController.background.add(new Log("file:resource/img/logs.png", 250, 400, 276, -2));
		}

	}

}
