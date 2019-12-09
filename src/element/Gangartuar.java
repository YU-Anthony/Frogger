package element;

import java.util.ArrayList;

import interact.controller.LevelController;
import javafx.scene.image.Image;

public class Gangartuar extends Actor{
	private double speed;
	ArrayList<Image> image=new ArrayList<Image>();
	
	@Override
	public void act(long now) {
		long temp = now / 900000000 % 8;

		if (temp == 0) {
			setImage(image.get(0));
		} else if (temp == 1) {
			setImage(image.get(1));
		} else if (temp == 2) {
			setImage(image.get(2));
		} else if (temp == 3) {
			setImage(image.get(3));
		}else if (temp == 4) {
			setImage(image.get(4));
		}else if (temp == 5) {
			setImage(image.get(5));
		}else if (temp == 6) {
			setImage(image.get(6));
		}else if(temp==7) {
			setImage(image.get(7));
		}

		move(speed, 0);
		if (getX() > 600 && speed > 0)
			setX(-200);
		if (getX() < -75 && speed < 0)
			setX(600);
	}
	
	public Gangartuar(int xpos, int ypos, double s, int w, int h) {
		
		
		for(int i=1;i<=8;i++) {
			Image zombie=new Image("file:src/img/zombie/Gargantuar_"+ String.valueOf(i)+".png", w, h, true, true);
			image.add(zombie);
		}

		setX(xpos);
		setY(ypos);
		speed = s;
		setImage(image.get(2));
		
	}
	
	public Gangartuar(){}
	
	
	@Override
	public void disPlay() {
			for (int i = 0; i < 4; i++) {
				LevelController.background2.add(new Gangartuar( 100 + 150 * i, 170, 1, 150, 150));
			}
			
			for (int i = 0; i < 3; i++) {
				LevelController.background2.add(new Gangartuar( 100 + 150 * i, 440, 0.5, 150, 150));
			}

	}
	
}
