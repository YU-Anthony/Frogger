package element;

import interact.controller.LevelController;
import javafx.scene.image.Image;
import p4_group_8_repo.GameStage;

/**
 * This Class inherit {@link Actor} and is displayed in {@link LevelController}.
 * 
 * <p>
 * This class define all attributes and actions of {@code Shark}.
 */
public class Shark extends Actor {

	private Image shark1;
	private double speed;

	/**
	 * Act.
	 *
	 * @param now the now
	 */
	@Override
	public void act(long now) {
		long temp = now / 900000000 % 3;
		if (temp == 0 || temp == 1 || temp == 2) {
			setImage(shark1);
		}

		move(speed, 0);
		if (getX() > 600 && speed > 0)
			setX(-200);
		if (getX() < -75 && speed < 0)
			setX(600);
	}

	/**
	 * Instantiates a new shark with specific parameters.
	 *
	 * @param xpos the x position
	 * @param ypos the y position
	 * @param s    the speed
	 * @param w    the image width
	 * @param h    the image height
	 */
	public Shark(int xpos, int ypos, double s, int w, int h) {
		shark1 = new Image("file:resource/img/shark.png", w, h, true, true);

		setX(xpos);
		setY(ypos);
		speed = s;
		setImage(shark1);
	}

	/**
	 * Instantiates a new shark without specific parameters.
	 */
	public Shark() {
	}

	/**
	 * Inherit this method from {@link Actor} to generate pre-defined {@code Shark}.
	 * <p>
	 * This method will be called in {@link Display} and the {@code Shark} will be
	 * displayed in normal game level.
	 */
	@Override
	public void disPlay() {
		for (int i = 0; i < 3; i++) {
			LevelController.background.add(new Shark(500, 355, -1.5, 80, 120));
			LevelController.background.add(new Shark(300, 355, -1.5, 80, 120));
			LevelController.background.add(new Shark(700, 356, -1.5, 80, 120));

			LevelController.background.add(new AngryShark(800, 185, -1.5, 80, 95));
			LevelController.background.add(new AngryShark(600, 185, -1.5, 80, 130));
			LevelController.background.add(new AngryShark(400, 185, -1.5, 80, 130));

		}
	}

	@Override
	public void disPlay(GameStage bg) {
		for (int i = 0; i < 3; i++) {
			bg.add(new Shark(500, 355, -1.5, 80, 120));
			bg.add(new Shark(300, 355, -1.5, 80, 120));
			bg.add(new Shark(700, 356, -1.5, 80, 120));

			bg.add(new AngryShark(800, 185, -1.5, 80, 95));
			bg.add(new AngryShark(600, 185, -1.5, 80, 130));
			bg.add(new AngryShark(400, 185, -1.5, 80, 130));

		}
	}
}
