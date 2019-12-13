package element;

import interact.GameStage;
import interact.controller.LevelController;
import javafx.scene.image.Image;

/**
 * This Class inherit {@link Actor} and is displayed in {@link LevelController}.
 * 
 * <p>
 * This class define all attributes and actions of {@code Car} and
 * {@code Truck}.
 */
public class Obstacle extends Actor {

	private int speed;

	/**
	 * Act.
	 *
	 * @param now the now
	 */
	@Override
	public void act(long now) {
		move(speed, 0);
		if (getX() > 600 && speed > 0)
			setX(-200);
		if (getX() < -50 && speed < 0)
			setX(600);
	}

	/**
	 * Instantiates a new obstacle.
	 *
	 * @param imageLink the image link
	 * @param xpos      the horizontal position
	 * @param ypos      the vertical position
	 * @param s         the speed
	 * @param w         the width
	 * @param h         the height
	 */
	public Obstacle(String imageLink, int xpos, int ypos, int s, int w, int h) {
		setImage(new Image(imageLink, w, h, true, true));
		setX(xpos);
		setY(ypos);
		speed = s;
	}

	/**
	 * Instantiates a new obstacle without specific parameters.
	 */
	public Obstacle() {
	}

	/**
	 * Inherit this method from {@link Actor} to generate pre-defined {@code car}
	 * and {@code Truck}.
	 * <p>
	 * This method will be called in {@link Display} and the {@code car} and
	 * {@code Truck} will be displayed in easy game level.
	 * 
	 * @param gameLevel the game level
	 */
	@Override
	public void disPlay(String gameLevel,GameStage background) {
		if (gameLevel.equalsIgnoreCase("Easy")) {
			// The first line of car
			for (int i = 0; i < 3; i++) {
				background
						.add(new Obstacle("file:resource/img/car1Left.png", 100 + 150 * i, 597, -1, 50, 50));
			}

			// The second line of car
			background.add(new Obstacle("file:resource/img/car1Left.png", 500, 490, -5, 50, 50));

			// For truck
			for (int i = 0; i < 3; i++) {
				background
						.add(new Obstacle("file:resource/img/truck1" + "Right.png", 0 + 300 * i, 649, 2, 120, 120));
			}

			background.add(new Obstacle("file:resource/img/truck2Right.png", 0, 540, 1, 200, 200));
			background.add(new Obstacle("file:resource/img/truck2Right.png", 500, 540, 1, 200, 200));

		} else if (gameLevel.equalsIgnoreCase("Normal")) {

			// The first line of car
			for (int i = 0; i < 4; i++) {
				background
						.add(new Obstacle("file:resource/img/car1Left.png", 100 + 150 * i, 597, -1, 50, 50));
			}

			// The second line of car
			background.add(new Obstacle("file:resource/img/car2Left.png", 500, 490, -5, 50, 50));

			// For train
			for (int i = 0; i < 3; i++) {
				background.add(new Obstacle("file:resource/img/" + "traincar1.png", 0 + 250 * i, 649, 2, 80, 80));
			}

			background.add(new Obstacle("file:resource/img/trainRight.png", 0, 540, 1, 200, 200));
			background.add(new Obstacle("file:resource/img/trainRight.png", 500, 540, 1, 200, 200));
		}
	}

}
