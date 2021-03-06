package element;

import java.util.ArrayList;

import interact.GameStage;
import javafx.scene.image.Image;

/**
 * This class defines all actions and attributes about Zombie.
 */
public class Zombie extends Actor {
	
	/** The speed. */
	private double speed;

	/** The image. */
	ArrayList<Image> image = new ArrayList<Image>();

	/**
	 * Act.
	 *
	 * @param now the now
	 */
	@Override
	public void act(long now) {
		long temp = now / 900000000 % 7;

		if (temp == 0) {
			setImage(image.get(0));
		} else if (temp == 1) {
			setImage(image.get(1));
		} else if (temp == 2) {
			setImage(image.get(2));
		} else if (temp == 3) {
			setImage(image.get(3));
		} else if (temp == 4) {
			setImage(image.get(4));
		} else if (temp == 5) {
			setImage(image.get(5));
		} else if (temp == 6) {
			setImage(image.get(6));
		}

		move(speed, 0);
		if (getX() > 600 && speed > 0)
			setX(-200);
		if (getX() < -75 && speed < 0)
			setX(600);
	}

	/**
	 * Instantiates a new zombie with specific parameters.
	 *
	 * @param xpos - the x position
	 * @param ypos - the y position
	 * @param s - zombie speed
	 * @param w - zombie width
	 * @param h - zombie height
	 */
	public Zombie(int xpos, int ypos, double s, int w, int h) {
		for (int i = 1; i <= 7; i++) {
			Image zombie = new Image("file:resource/img/zombie/z_1_0" + String.valueOf(i) + ".png", w, h, true, true);
			image.add(zombie);
		}

		setX(xpos);
		setY(ypos);
		speed = s;
		setImage(image.get(2));

	}

	/**
	 * Instantiates a new zombie without specific parameters.
	 */
	public Zombie() {
	}
	
	
	/**
	 * Inherit this method from {@link Actor} to generate pre-defined {@code Log}.
	 * <p>
	 * This method will be called in {@link display.GameApp} and the {@code Log} will be
	 * displayed in normal game level.
	 * @param background - Current background
	 */
	@Override
	public void disPlay(GameStage background) {
		// The first line of car
		for (int i = 0; i < 4; i++) {
			background.add(new Zombie(100 + 150 * i, 570, -0.5, 100, 100));
		}

		for (int i = 0; i < 3; i++) {
			background.add(new Zombie(100 + 150 * i, 340, -1.5, 100, 100));
		}

	}
}
