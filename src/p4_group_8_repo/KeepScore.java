package p4_group_8_repo;

import java.io.BufferedWriter;

import java.io.FileWriter;
import java.io.IOException;

import element.Animal;
import element.Digit;
import interact.model.ScoreBoard;
import interact.model.GameLose;
import javafx.animation.AnimationTimer;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

import interact.model.GameWin;
import interact.SceneSwitch;
import interact.controller.LevelController;

/**
 * The KeepScore Class: <br>
 * <ul>
 * <li>change score when playing game
 * <li>Judge if user win or lose
 * <li>and write winner's name to {@code score.txt}.
 * <p>
 * Used in <{@link LevelController}
 */
public class KeepScore extends World {

	private AnimationTimer timer;
	private Animal animal;
	private Stage primaryStage;
	private Boolean input = false;
	private static final String FILENAME = "score.txt";
	private String music;
	private GameStage background;

	public static int numOfLifes = 5;

	/**
	 * Creates the timer and judge whether user is win or lose.
	 */
	@Override
	public void createTimer() {
		timer = new AnimationTimer() {
			@Override
			public void handle(long now){
				if (animal.changeScore()) {
					setNumber(animal.getPoints());
				}
				if (animal.getStop()) {
					System.out.print("STOPP:");
					background.stopMusic();
					stop();
					background.stop();
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("You Have Won The Game!");
					alert.setHeaderText("Your High Score: " + animal.getPoints() + "!");
					alert.setContentText("Highest Possible Score: 800");
					alert.show();

					// A new user can input his name when his score higher than the 5th score,
					// otherwise the nameInput page doesn't show.
					ScoreBoard a = ScoreBoard.getInstance();

					if (a.getScore(5) != "-") {
						if (Integer.valueOf(a.getScore(5)) < animal.getPoints()) {
							input = true;
						}
					} else if ("-".equals(a.getScore(5))) {
						input = true;
					} else if ("-".equals(a.getScore(1))) {
						input = true;
					}

					if (input == true) {
						writeToFile(Integer.toString(animal.getPoints()));

						GameWin win = new GameWin(primaryStage);
						try {
							win.nameEnterDisplay();
						} catch (IOException e) {
							e.printStackTrace();
						}
					} else {
						GameWin win = new GameWin(primaryStage);
						try {
							win.gotoIndex();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}

				if (animal.loseNumber() == numOfLifes) {
					System.out.print("STOPP:");
					background.stopMusic();
					stop();
					background.stop();

					GameLose lose = new GameLose(primaryStage);
					try {
						lose.endChoices();
					} catch (IOException e) {
						e.printStackTrace();
					}

				}
				
				if(animal.enterWorld()) {
					background.stopMusic();
					stop();
					background.stop();
					
					SceneSwitch a = new SceneSwitch();
					try {
						a.sceneJumpTwo("/interact/view/NewWorld.fxml");
					} catch (IOException e) {
						e.printStackTrace();
					}
					
				}
			}
		};
	}

	/**
	 * Start.
	 */
	@Override
	public void start() {
		background.playMusic(music);
		createTimer();
		timer.start();
	}

	/**
	 * Change scores when playing game.
	 *
	 * @param n the new number
	 */
	public void setNumber(int n) {
		int shift = 0;
		while (n > 0) {
			int d = n / 10;
			int k = n - d * 10;
			n = d;
			background.add(new Digit(k, 30, 360 - shift, 10));
			shift += 30;
		}
	}

	/**
	 * Write user name to {@code score.txt}.
	 *
	 * @param data the data
	 */
	/*
	 * Function try to write score in a particular file which named "score.txt".
	 */
	public void writeToFile(String data) {

		String content = ";";

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILENAME, true))) {

			bw.write(data);
			bw.write(content);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Act.
	 *
	 * @param now the now
	 */
	@Override
	public void act(long now) {
	}

	/**
	 * Input {@code Animal}, {@code Stage}, {@code Music}. <br>
	 * Used in {@link LevelController}.
	 *
	 * @param animal       the animal
	 * @param primaryStage the primary stage
	 * @param music        the music
	 */
	public KeepScore(Animal animal, Stage primaryStage, String music, GameStage background) {
		this.animal = animal;
		this.primaryStage = primaryStage;
		this.music = music;
		this.background=background;
	}

}
