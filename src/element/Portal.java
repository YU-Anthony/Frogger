package element;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import interact.GameStage;
import javafx.application.Platform;
import javafx.scene.image.Image;

public class Portal extends Actor {

	private static Portal a;

	public Portal(String imageLink, int size, int xpos, int ypos) {
		setImage(new Image(imageLink, size, size, true, true));
		setX(xpos);
		setY(ypos);

	}

	public Portal() {
	}

	@Override
	public void act(long now) {
	}

	@Override
	public void disPlay(GameStage background) {

		a = new Portal("file:resource/img/door.png", 70, 200, 400);
//		background.add(a);

		startTimer(background);
	}

	public static void startTimer(GameStage background) {
		TimerTask task = new TimerTask() {

			@Override
			public void run() {
				Platform.runLater(() -> {
					background.remove(a);
				});

				try {
					Thread.sleep(1000 * 6);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				Platform.runLater(() -> {
					Random random = new Random();
					a = new Portal("file:resource/img/door.png", 70, 200 - random.nextInt(200),
							400 + random.nextInt(300));
					background.add(a);
				});
			}

		};
		Timer timer = new Timer();
		timer.schedule(task, 1000 * 8, 1000 * 8);
	}

}
