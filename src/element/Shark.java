package element;

import javafx.scene.image.Image;

public class Shark extends Actor {
	Image shark1;


	private double speed;
	int i = 1;
	boolean bool = true;
	boolean sunk = false;
	@Override
	public void act(long now) {

				if (now/900000000  % 3 ==0) {
					setImage(shark1);
					sunk = false;
					
				}
				else if (now/900000000 % 3 == 1) {
					setImage(shark1);
					sunk = false;
				}
				else if (now/900000000 % 3 == 2) {
					setImage(shark1);
					sunk = false;
				}
				
			
		move(speed , 0);
		if (getX() > 600 && speed>0)
			setX(-200);
		if (getX() < -75 && speed<0)
			setX(600);
	}
	public Shark(int xpos, int ypos, double s, int w, int h) {
		shark1 = new Image("file:src/img/shark.png", w, h, true, true);
		

		setX(xpos);
		setY(ypos);
		speed = s;
		setImage(shark1);
	}
}
