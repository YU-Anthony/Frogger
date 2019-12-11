package p4_group_8_repo;

import java.io.File;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 * The Class MyStage: Used as background to combine different actors.
 */
public class GameStage extends World {

	private MediaPlayer mediaPlayer;

	/**
	 * Act.
	 *
	 * @param now the now
	 */
	@Override
	public void act(long now) {

	}

	/**
	 * Instantiates a new my stage.
	 */
	public GameStage() {
	}

	/**
	 * Play music.
	 *
	 * @param music the music
	 */
	public void playMusic(String music) {
		String musicFile = music;
		Media sound = new Media(new File(musicFile).toURI().toString());
		mediaPlayer = new MediaPlayer(sound);
		mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
		mediaPlayer.play();
	}

	/**
	 * Stop music.
	 */
	public void stopMusic() {
		mediaPlayer.stop();
	}

}
