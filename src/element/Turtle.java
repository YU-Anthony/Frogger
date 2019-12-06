package element;

import interact.controller.LevelController;
import javafx.scene.image.Image;

public class Turtle extends Actor{
	Image turtle1;
	Image turtle2;
	Image turtle3;
	

	
	
	private int speed;
	int i = 1;
	boolean bool = true;
	@Override
	public void act(long now) {

				if (now/900000000  % 3 ==0) {
					setImage(turtle2);
					
				}
				else if (now/900000000 % 3 == 1) {
					setImage(turtle1);
					
				}
				else if (now/900000000 %3 == 2) {
					setImage(turtle3);
					
				}
			
		move(speed , 0);
		if (getX() > 600 && speed>0)
			setX(-200);
		if (getX() < -75 && speed<0)
			setX(600);
	}

	public Turtle(int xpos, int ypos, int s, int w, int h) {
	
		
		
		turtle1 = new Image("file:src/img/TurtleAnimation1.png", w, h, true, true);
		turtle2 = new Image("file:src/img/TurtleAnimation2.png", w, h, true, true);
		turtle3 = new Image("file:src/img/TurtleAnimation3.png", w, h, true, true);
		setX(xpos);
		setY(ypos);
		speed = s;
		setImage(turtle2);
	}
	
	public Turtle() {}
	
	
	
	@Override
	public void disPlay() {
		LevelController.background.add(new Turtle(500, 376, -1, 130, 130));
		LevelController.background.add(new Turtle(300, 376, -1, 130, 130));
		
		LevelController.background.add(new WetTurtle(700, 376, -1, 130, 130));
		LevelController.background.add(new WetTurtle(600, 217, -1, 130, 130));
		LevelController.background.add(new WetTurtle(400, 217, -1, 130, 130));
		LevelController.background.add(new WetTurtle(200, 217, -1, 130, 130));
	}

	

	
	
}
