package element;

import interact.controller.LevelController;
import javafx.scene.image.Image;

public class Boat extends Actor {
	private double speed;
	@Override
	public void act(long now) {
		move(speed , 0);
		if (getX()>600 && speed>0)
			setX(-180);
		if (getX()<-300 && speed<0)
			setX(700);
	}
	
	public Boat(String imageLink, int size, int xpos, int ypos, double s) {
		setImage(new Image(imageLink, size,size, true, true));
		setX(xpos);
		setY(ypos);
		speed = s;
		
	}
	
	public Boat() {}
	
	public boolean getLeft() {
		return speed < 0;
	}
	
	
	
	@Override
	public void disPlay() {
		// The third Boat line 
		for(int i=0;i<3;i++) {
			LevelController.background.add(new Boat("file:src/img/speedboat.png", 130, 0+220*i, 160, 0.75));
			LevelController.background.add(new Boat("file:src/img/speedboat.png", 130, 50+220*i, 320, 0.75));
		}
		
		LevelController.background.add(new Boat("file:src/img/speedboatleft.png", 140, 0, 260, -2));
		LevelController.background.add(new Boat("file:src/img/speedboatleft.png", 140, 400, 260,-2));
	}
	
}
