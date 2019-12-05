package element;

import javafx.scene.image.Image;

public class Digit extends Actor{
	private static int dim;
	private static Image im1;
	@Override
	public void act(long now) {
		// TODO Auto-generated method stub
		
	}
	
	public Digit(int n, int dim, int x, int y) {
		
		im1 = new Image("file:src/img/"+n+".png", dim, dim, true, true);
		setImage(im1);
		setX(x);
		setY(y);
	}
	
}
