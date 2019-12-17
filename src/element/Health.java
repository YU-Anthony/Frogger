package element;

import javafx.scene.image.Image;

/**
 * This Class inherit {@link Actor} and is displayed in {@link interact.controller.LevelController}.
 * And set the location of health point.
 */
public class Health extends Actor {

	/**
	 * Instantiates a new health with specific parameters.
	 *
	 * @param x - the horizontal axis
	 * @param y - the vertical axis
	 */
	public Health(int x, int y) {
		setX(x);
		setY(y);
		setImage(new Image("file:resource/img/hp.png", 40, 40, true, true));
	}

	/**
	 * Act.
	 *
	 * @param now the now
	 */
	@Override
	public void act(long now) {
	}
}
