package element;

import javafx.scene.image.Image;

/**
 * Import BackgroundImage in {@link LevelController}.
 */
public class BackgroundImage extends Actor {

	/**
	 * Act.
	 *
	 * @param now the now
	 */
	@Override
	public void act(long now) {

	}

	/**
	 * Instantiates a new background image.
	 *
	 * @param imageLink the image link
	 */
	public BackgroundImage(String imageLink) {
		setImage(new Image(imageLink, 600, 800, true, true));

	}

}
