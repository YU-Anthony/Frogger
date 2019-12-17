package interact;

import java.io.File;

import display.World;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 * The Class MyStage: It's the basement of this game, used as background to combine different actors.
 * @author scyyz4
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
	 * Instantiates a new background.
	 */
	public GameStage() {
	}

	/**
	 * Play music.
	 *
	 * @param music - the path of music
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
