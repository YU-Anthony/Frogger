package element;

import javafx.scene.image.Image;

public class AngryShark extends Actor {
	Image Shark1;
	Image Shark2;


	private double speed;
	int i = 1;
	boolean bool = true;
	boolean sunk = false;
	@Override
	public void act(long now) {

				if (now/900000000  % 4 ==0) {
					setImage(Shark1);
					sunk = false;
					
				}
				else if (now/900000000 % 4 == 1) {
					setImage(Shark1);
					sunk = false;
				}
				else if (now/900000000 % 4 == 2) {
					setImage(Shark1);
					sunk = false;
				}
				else if (now/900000000 % 4 == 3) {
					setImage(Shark2);
					sunk = true;
				}
			
			
		move(speed , 0);
		if (getX() > 600 && speed>0)
			setX(-200);
		if (getX() < -75 && speed<0)
			setX(600);
	}
	
	public AngryShark(int xpos, int ypos, double s, int w, int h) {
		Shark1 = new Image("file:src/img/shark.png", w, h, true, true);
		Shark2 = new Image("file:src/img/shark2.png", w, h, true, true);

		setX(xpos);
		setY(ypos);
		speed = s;
		setImage(Shark2);
	}
	
	public boolean isSunk() {
		return sunk;
	}
}
