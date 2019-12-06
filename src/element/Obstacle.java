package element;

import interact.controller.LevelController;
import javafx.scene.image.Image;

public class Obstacle extends Actor {
	private int speed;
	@Override
	public void act(long now) {
		move(speed , 0);
		if (getX() > 600 && speed>0)
			setX(-200);
		if (getX() < -50 && speed<0)
			setX(600);
	}
	
	public Obstacle(String imageLink, int xpos, int ypos, int s, int w, int h) {
		setImage(new Image(imageLink, w,h, true, true));
		setX(xpos);
		setY(ypos);
		speed = s;
	}
	
	public Obstacle() {}
	
	
	@Override
	public void disPlay(String gameLevel) {
		if(gameLevel.equalsIgnoreCase("Easy")) {
			// The first line of car
			for(int i=0;i<4;i++) {
				LevelController.background.add(new Obstacle("file:src/img/car1Left.png", 100+150*i, 597, -1, 50, 50));
			}
			
			// The second line of car
			LevelController.background.add(new Obstacle("file:src/img/car1Left.png", 500, 490, -5, 50, 50));
			
		
			// For truck
			for(int i=0;i<3;i++) {
				LevelController.background.add(new Obstacle("file:src/img/truck1"+"Right.png", 0+300*i, 649, 2, 120, 120));
			}
		
			LevelController.background.add(new Obstacle("file:src/img/truck2Right.png", 0, 540, 1, 200, 200));
			LevelController.background.add(new Obstacle("file:src/img/truck2Right.png", 500, 540, 1, 200, 200));
			
		}else if(gameLevel.equalsIgnoreCase("Normal")) {
			
			
			// The first line of car
			for(int i=0;i<4;i++) {
				LevelController.background.add(new Obstacle("file:src/img/car1Left.png", 100+150*i, 597, -1, 50, 50));
			}
			
			// The second line of car
			LevelController.background.add(new Obstacle("file:src/img/car2Left.png", 500, 490, -5, 50, 50));
			
			
			// For train
			for(int i=0;i<3;i++) {
				LevelController.background.add(new Obstacle("file:src/img/"+"traincar1.png", 0+250*i, 649, 2, 80, 80));
			}
		
			LevelController.background.add(new Obstacle("file:src/img/trainRight.png", 0, 540, 1, 200, 200));
			LevelController.background.add(new Obstacle("file:src/img/trainRight.png", 500, 540, 1, 200, 200));
		}
	}
	
}
