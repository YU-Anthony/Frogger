package element;

import interact.controller.LevelController;
import javafx.scene.image.Image;

/**
 * Define all attributes and actions of {@code Boat}.
 */
public class Boat extends Actor {

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
	 * Instantiates a new boat with specific parameters.
	 *
	 * @param imageLink the image link
	 * @param size      the image size
	 * @param xpos      the abscissa
	 * @param ypos      the ordinate
	 * @param s         the speed
	 */
	public Boat(String imageLink, int size, int xpos, int ypos, double s) {
		setImage(new Image(imageLink, size, size, true, true));
		setX(xpos);
		setY(ypos);
		speed = s;

	}

	/**
	 * Instantiates a new boat without parameters.
	 */
	public Boat() {
	}

	/**
	 * Judge the direction of the boat.
	 *
	 * @return the direction
	 */
	public boolean getLeft() {
		return speed < 0;
	}

	/**
	 * Inherit this method from {@link Actor} to generate pre-defined {@code Boat}.
	 * <p>
	 * This method will be called in {@link Display} and the {@code Boat} will be
	 * displayed in normal game level.
	 */
	@Override
	public void disPlay() {
		// The third Boat line
		for (int i = 0; i < 3; i++) {
			LevelController.background.add(new Boat("file:src/img/speedboat.png", 130, 0 + 220 * i, 160, 0.75));
			LevelController.background.add(new Boat("file:src/img/speedboat.png", 130, 50 + 220 * i, 320, 0.75));
		}

		LevelController.background.add(new Boat("file:src/img/speedboatleft.png", 140, 0, 260, -2));
		LevelController.background.add(new Boat("file:src/img/speedboatleft.png", 140, 400, 260, -2));
	}

}
