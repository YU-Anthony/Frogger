package element;

import javafx.scene.image.Image;
import p4_group_8_repo.MyStage;
import interact.controller.LevelController;;


public class Log extends Actor {

	MyStage bg;
	
	private double speed;
	@Override
	public void act(long now) {
		move(speed , 0);
		if (getX()>600 && speed>0)
			setX(-180);
		if (getX()<-300 && speed<0)
			setX(700);
	}
	
	public Log(String imageLink, int size, int xpos, int ypos, double s) {
		setImage(new Image(imageLink, size,size, true, true));
		setX(xpos);
		setY(ypos);
		speed = s;
		

	}
	
	
	public Log() {
		
	}
	
	public boolean getLeft() {
		return speed < 0;
	}

	
	
	@Override
	public void disPlay(String gameLevel){
		
		if(gameLevel.equalsIgnoreCase("Easy")) {
			for(int i=0;i<3;i++) {
				LevelController.background.add(new Log("file:src/img/log3.png", 130, 0+220*i, 166, 0.75));
				LevelController.background.add(new Log("file:src/img/log3.png", 130, 50+220*i, 329, 0.75));
			}
			
			LevelController.background.add(new Log("file:src/img/logs.png", 250, 0, 276, -2));
			LevelController.background.add(new Log("file:src/img/logs.png", 250, 400, 276,-2));
		}else if (gameLevel.equalsIgnoreCase("Normal")) {
			for(int i=0;i<3;i++) {
				LevelController.background.add(new Log("file:src/img/log3.png", 130, 0+220*i, 166, 0.75));
				LevelController.background.add(new Log("file:src/img/log3.png", 130, 50+220*i, 329, 0.75));
			}
			
			LevelController.background.add(new Log("file:src/img/logs.png", 250, 0, 276, -2));
			LevelController.background.add(new Log("file:src/img/logs.png", 250, 400, 276,-2));
		}
		
	} 
	


}
