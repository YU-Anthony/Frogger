package element;

import java.util.ArrayList;
import javafx.event.EventHandler;

import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;


import interact.controller.LevelController;
import display.Display;

public class Animal extends Actor {
	private Image imgW1;
	private Image imgA1;
	private Image imgS1;
	private Image imgD1;
	private Image imgW2;
	private Image imgA2;
	private Image imgS2;
	private Image imgD2;
	int points = 0;
	int end = 0;
	int lose=0;
	
	
	private boolean second = false;
	boolean noMove = false;
	
	static final double MOVEMENT = 13.3333333*2;
	static final double MOVEMENTX = 10.666666*2;
	static final int IMG_SIZE = 40;
	static final int NUM_OF_END = 1;
	
	boolean carDeath = false;
	boolean waterDeath = false;
	boolean stop = false;
	boolean changeScore = false;
	int carD = 0;
	private static int numSecondflase=1;
	double w = 730;
	ArrayList<End> inter = new ArrayList<End>();
	public Animal(String imageLink) {
		setImage(new Image(imageLink, IMG_SIZE, IMG_SIZE, true, true));
		setX(300);
		setY(730+MOVEMENT);
		
		
		imgW1 = new Image("file:src/img/froggerUp.png", IMG_SIZE, IMG_SIZE, true, true);
		imgA1 = new Image("file:src/img/froggerLeft.png", IMG_SIZE, IMG_SIZE, true, true);
		imgS1 = new Image("file:src/img/froggerDown.png", IMG_SIZE, IMG_SIZE, true, true);
		imgD1 = new Image("file:src/img/froggerRight.png", IMG_SIZE, IMG_SIZE, true, true);
		imgW2 = new Image("file:src/img/froggerUpJump.png", IMG_SIZE, IMG_SIZE, true, true);
		imgA2 = new Image("file:src/img/froggerLeftJump.png", IMG_SIZE, IMG_SIZE, true, true);
		imgS2 = new Image("file:src/img/froggerDownJump.png", IMG_SIZE, IMG_SIZE, true, true);
		imgD2 = new Image("file:src/img/froggerRightJump.png", IMG_SIZE, IMG_SIZE, true, true);
		
		setOnKeyPressed(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent event){
				if (!noMove) {
					if (second) {
						if (event.getCode() == KeyCode.W) {	  
			                move(0, -MOVEMENT);	         
			                changeScore = false;
			                setImage(imgW1);
			                
			            }
			            else if (event.getCode() == KeyCode.A) {	            	
			            	 move(-MOVEMENTX, 0);
			            	 setImage(imgA1);			           
			            }
			            else if (event.getCode() == KeyCode.S) {	            	
			            	 move(0, MOVEMENT);
			            	 setImage(imgS1);			            	 
			            }
			            else if (event.getCode() == KeyCode.D) {	            	
			            	 move(MOVEMENTX, 0);
			            	 setImage(imgD1);
			            }
						second = false;
					
					}else {
						 if (event.getCode() == KeyCode.W) {	            	
				                move(0, -MOVEMENT);
				               
				                setImage(imgW2);
				                
						 }
						 else if (event.getCode() == KeyCode.A) {	            	
			            	 move(-MOVEMENTX, 0);
			            	 setImage(imgA2);
			            }
						  else if (event.getCode() == KeyCode.S) {	            	
				            	 move(0, MOVEMENT);
				            	 setImage(imgS2);
				          }
						  else if (event.getCode() == KeyCode.D) {	            	
				            	 move(MOVEMENTX, 0);
				            	 setImage(imgD2);
				          }
						 second = true;
					}
					 numSecondflase++;
				}
			}
		});	
		
		
			
			setOnKeyReleased(new EventHandler<KeyEvent>() {
				public void handle(KeyEvent event) {
					if(numSecondflase==2 ||numSecondflase%2==0) {
									System.out.println(numSecondflase);
									if (noMove) {}
									else {
										if (event.getCode() == KeyCode.W) {	  
											if (getY() < w) {
												changeScore = true;
												w = getY();
												points+=10;
											}
				
											move(0,-MOVEMENT);
							                setImage(imgW1);
							             
							            }
							            else if (event.getCode() == KeyCode.A) {	            	
							            	 move(-MOVEMENTX, 0);
							            	 setImage(imgA1);
							            }
							            else if (event.getCode() == KeyCode.S) {	            	
							            	 move(0, MOVEMENT);
							            	 setImage(imgS1);
							            }
							            else if (event.getCode() == KeyCode.D) {	            	
							            	 move(MOVEMENTX, 0);
							            	 setImage(imgD1);
							            }
										 second = false;
						         }
								numSecondflase=1;
				}
				}
			});
			
		
		
	}
	
	
	
	
	
	
	
	@Override
	public void act(long now) {
		
		int bounds = 0;
		
		// The forger can not get out of the boundary of scene.
		insideBoundary();
		
		// CarDeath or waterDeath. 
		
			death(now);
	


	

		keepSpeed();
	}
	
	//*************************gai hui lai
	public boolean getStop() {
		return end==NUM_OF_END;
	}
	
	public int getPoints() {
		return points;
	}
	
	public boolean changeScore() {
		if (changeScore) {
			changeScore = false;
			return true;
		}
		return false;
		
	}
	
	public int loseNumber() {
		return lose;
	}
	
	/**
	 * Judge if this forger trigger carDeath or waterDeath event.
	 */
	public void death(long now) {
		String deathType = null;
		boolean deathState = false;
		
		if(waterDeath) {
			 deathType="water";
			 deathState=true;
		}else if(carDeath){
			 deathType="car";
			 deathState=true;
		}
			
		
		if (deathState) {
			noMove = true;
			if ((now)% 11 ==0) {
				carD++;
			}
			
			switch(carD) {
			case 1:		setImage(new Image("file:src/img/"+deathType+"death1.png", IMG_SIZE, IMG_SIZE, true, true));
			case 2:		setImage(new Image("file:src/img/"+deathType+"death2.png", IMG_SIZE, IMG_SIZE, true, true));
			case 3:		setImage(new Image("file:src/img/"+deathType+"death3.png", IMG_SIZE, IMG_SIZE, true, true));
			}

			if(carD==4) {
				if("water".equals(deathType)) {
					setImage(new Image("file:src/img/"+deathType+"death4.png", IMG_SIZE, IMG_SIZE, true, true));
				}else {
					reOrigin(carDeath,deathType);
					carDeath=false;
				}
			}
			
			if(carD == 5 && "water".equals(deathType)) {
				 reOrigin(waterDeath,deathType);
				waterDeath=false;
			}
			 				
		}

		
		if (getIntersectingObjects(Obstacle.class).size() >= 1) {
			carDeath = true;
		}
		
		
	}
	
	/**
	 * Let this forger move inside the scene
	 */
	public void insideBoundary() {
		if (getY()<=0 || getY()>800) {
//			setX(300);
			//move(MOVEMENT*2, 0);
			move(0,-MOVEMENT*2);
		}
		if (getX()<10) {
			move(MOVEMENT*2, 0);
		}
		
		if (getX()>600) {
			move(-MOVEMENT*2, 0);
		}
	}

	/**
	 * Keep space and direction with items when this forger accrosing the river
	 */
	public void keepSpeed() {
		if (getIntersectingObjects(Log.class).size() >= 1 && !noMove) {
			if(getIntersectingObjects(Log.class).get(0).getLeft())
				move(-2,0);
			else
				move (.75,0);
		}
		else if (getIntersectingObjects(Boat.class).size() >= 1 && !noMove) {
			if(getIntersectingObjects(Boat.class).get(0).getLeft())
				move(-2,0);
			else
				move (.75,0);
		}
		else if (getIntersectingObjects(Turtle.class).size() >= 1 && !noMove) {
			move(-1,0);
		}
		else if (getIntersectingObjects(WetTurtle.class).size() >= 1) {
			if (getIntersectingObjects(WetTurtle.class).get(0).isSunk()) {
				waterDeath = true;
			} else {
				move(-1,0);
			}
		}
		else if (getIntersectingObjects(Shark.class).size() >= 1 && !noMove) {
			move(-1.5,0);
		}
		else if (getIntersectingObjects(AngryShark.class).size() >= 1) {
			if (getIntersectingObjects(AngryShark.class).get(0).isSunk()) {
				waterDeath = true;
			} else {
				move(-1.5,0);
			}
		}
		
		
		else if (getIntersectingObjects(End.class).size() >= 1) {
			inter = (ArrayList<End>) getIntersectingObjects(End.class);
			if (getIntersectingObjects(End.class).get(0).isActivated()) {
				move(0,MOVEMENT*1.5);
				points-=10;
			}else {
				points+=50;
				changeScore = true;
				w=730;
				getIntersectingObjects(End.class).get(0).setEnd();
				end++;
				setX(300);
				setY(730+MOVEMENT);
			}
			
		}
		else if (getY()<413){
			waterDeath = true;
		}
	}
	
	
	/*
	 * Frogger returns to the origin point. 
	 */
	public void reOrigin( boolean deathState, String deathType) {
		setX(300);
		setY(730+MOVEMENT);
		deathState = false;
		// Life decreases when frogger lose. 
		LevelController.background.remove(Display.health.get(lose));
		lose++;
		carD = 0;
		setImage(new Image("file:src/img/froggerUp.png", IMG_SIZE, IMG_SIZE, true, true));
		noMove = false;
		if (points>50) {
			points-=50;
			changeScore = true;
		}
		deathType=null;
		deathState=false;
	}
}
