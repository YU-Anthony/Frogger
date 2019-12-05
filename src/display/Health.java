package display;

import element.Actor;
import javafx.scene.image.Image;

public class Health extends Actor{

	
	public Health(int x, int y) {
		setX(x);
		setY(y);
		setImage(new Image("file:src/img/hp.png", 40, 40, true, true));
	}

	@Override
	public void act(long now) {
		// TODO Auto-generated method stub		
	}
}
