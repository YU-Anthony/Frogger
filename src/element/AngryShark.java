package element;

import javafx.scene.image.Image;

/**
 * The Class AngryShark.
 */
public class AngryShark extends Actor {

	private Image Shark1;
	private Image Shark2;

	private double speed;

	private boolean sunk = false;

	/**
	 * AngryShark 's action.
	 *
	 * @param now the now
	 */
	@Override
	public void act(long now) {

		long temp = now / 900000000 % 4;

		if (temp == 0 || temp == 1 || temp == 2) {
			setImage(Shark1);
			sunk = false;
		} else if (temp == 3) {
			setImage(Shark2);
			sunk = true;
		}

		move(speed, 0);
		if (getX() > 600 && speed > 0)
			setX(-200);
		if (getX() < -75 && speed < 0)
			setX(600);
	}

	/**
	 * Instantiates a new angry shark with specific parameters.
	 *
	 * @param xpos the movement on x-coordinate
	 * @param ypos the movement on x-coordinate
	 * @param s    the speed
	 * @param w    the width
	 * @param h    the height
	 */
	public AngryShark(int xpos, int ypos, double s, int w, int h) {
		Shark1 = new Image("file:src/img/shark.png", w, h, true, true);
		Shark2 = new Image("file:src/img/shark2.png", w, h, true, true);

		setX(xpos);
		setY(ypos);
		speed = s;
		setImage(Shark2);
	}

	/**
	 * Instantiates a new angry shark without parameters.
	 */
	public AngryShark() {

	}

	/**
	 * Checks if actor is sunk.
	 *
	 * @return true, if is sunk
	 */
	public boolean isSunk() {
		return sunk;
	}

}
