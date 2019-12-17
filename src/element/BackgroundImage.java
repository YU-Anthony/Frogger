package element;

import javafx.scene.image.Image;

/**
 * This class define the attributes of background image.
 * Import BackgroundImage in {@link interact.controller.LevelController}.
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
	 * Instantiates a new background image with given Image link.
	 *
	 * @param imageLink - the image link
	 */
	public BackgroundImage(String imageLink) {
		setImage(new Image(imageLink, 600, 800, true, true));

	}

}
