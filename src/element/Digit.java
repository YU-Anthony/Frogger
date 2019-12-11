package element;

import javafx.scene.image.Image;

/**
 * This class is used for determining the location of the initial scoreboard.
 */
public class Digit extends Actor {

	private Image im1;

	/**
	 * Act.
	 *
	 * @param now the now
	 */
	@Override
	public void act(long now) {
	}

	/**
	 * Determine the location of the initial scoreboard in {@link LevelController}
	 * when generate a new game scene.
	 *
	 * @param n   the number
	 * @param dim the image size
	 * @param x   the horizontal axis
	 * @param y   the vertical axis
	 */
	public Digit(int n, int dim, int x, int y) {

		im1 = new Image("file:resource/img/" + n + ".png", dim, dim, true, true);
		setImage(im1);
		setX(x);
		setY(y);
	}

}
