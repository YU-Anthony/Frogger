package element;

import javafx.scene.image.Image;

/**
 * This Class inherit from {@link Actor} to define all attributes and action of
 * End.
 */
public class End extends Actor {

	private boolean activated = false;

	/**
	 * Act.
	 *
	 * @param now the now
	 */
	@Override
	public void act(long now) {
	}

	/**
	 * Instantiates a new end.
	 *
	 * @param x the horizontal axis
	 * @param y the vertical axis
	 */
	public End(int x, int y) {
		setX(x);
		setY(y);
		setImage(new Image("file:resource/img/End.png", 60, 60, true, true));
	}

	/**
	 * Sets the end.
	 */
	public void setEnd() {
		setImage(new Image("file:resource/img/FrogEnd.png", 70, 70, true, true));
		activated = true;
	}

	/**
	 * Checks if is activated.
	 *
	 * @return true, if is activated
	 */
	public boolean isActivated() {
		return activated;
	}

}
