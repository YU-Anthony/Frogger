package element;

import javafx.scene.image.Image;

public class Turtle extends Actor{
	Image turtle1;
	Image turtle2;
	Image turtle3;
	
	private static int xpos;
	private static int ypos;
	private static int s;
	private static int w;
	private static int h;
	
	
	
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
		Turtle.xpos=xpos;
		Turtle.ypos=ypos;
		Turtle.s=s;
		Turtle.w=w;
		Turtle.h=h;
		
		
		turtle1 = new Image("file:src/img/TurtleAnimation1.png", w, h, true, true);
		turtle2 = new Image("file:src/img/TurtleAnimation2.png", w, h, true, true);
		turtle3 = new Image("file:src/img/TurtleAnimation3.png", w, h, true, true);
		setX(xpos);
		setY(ypos);
		speed = s;
		setImage(turtle2);
	}
	
	
	// Encapsulate variables
	public static int getXpos() {
		return xpos;
	}

	public static void setXpos(int xpos) {
		Turtle.xpos = xpos;
	}

	public static int getYpos() {
		return ypos;
	}

	public static void setYpos(int ypos) {
		Turtle.ypos = ypos;
	}

	public static int getS() {
		return s;
	}

	public static void setS(int s) {
		Turtle.s = s;
	}

	public static int getW() {
		return w;
	}

	public static void setW(int w) {
		Turtle.w = w;
	}

	public static int getH() {
		return h;
	}

	public static void setH(int h) {
		Turtle.h = h;
	}
	
	

	
	
}
