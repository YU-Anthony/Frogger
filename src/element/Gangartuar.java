package element;

import java.util.ArrayList;

import interact.GameStage;
import javafx.scene.image.Image;

/**
 * This class define all actions and attributes about Gangartuar.
 * @version -html5
 */
public class Gangartuar extends Actor{
	
	/** The speed. */
	private double speed;
	
	/** The background. */
	private GameStage background;
	
	/** The image. */
	ArrayList<Image> image=new ArrayList<Image>();
	
	/**
	 * Act.
	 *
	 * @param now the now
	 */
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
	
	/**
	 * Instantiates gangartuars with specccific parameters.
	 *
	 * @param xpos - the horizonal position
	 * @param ypos - the vertical position
	 * @param s - the speed
	 * @param w - the width
	 * @param h - the height
	 */
	public Gangartuar(int xpos, int ypos, double s, int w, int h) {
		for(int i=1;i<=8;i++) {
			Image zombie=new Image("file:resource/img/zombie/Gargantuar_"+ String.valueOf(i)+".png", w, h, true, true);
			image.add(zombie);
		}

		setX(xpos);
		setY(ypos);
		speed = s;
		setImage(image.get(2));
		
	}
	
	/**
	 * Instantiates a new gangartuar without parameters.
	 */
	public Gangartuar(){}
	
	
	/**
	 * Display the Gangartuar. This method will be called in {@link display.GameApp}.
	 *
	 * @param background - Current background
	 */
	@Override
	public void disPlay(GameStage background) {
			for (int i = 0; i < 4; i++) {
				background.add(new Gangartuar( 100 + 150 * i, 170, 1, 150, 150));
			}
			
			for (int i = 0; i < 3; i++) {
				background.add(new Gangartuar( 100 + 150 * i, 440, 0.5, 150, 150));
			}

	}
	
}
