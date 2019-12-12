package element;

import java.util.ArrayList;

import display.GameApp;
import javafx.scene.image.Image;
import p4_group_8_repo.KeepScore;
import interact.controller.LevelController;

/**
 * Define the actions for frogger, this class is implement in
 * {@link LevelController}.
 */
public class Animal extends Actor {

	public int points = 0;
	private static int basePoints;
	private int end = 0;
	private int lose = 0;
	private static int staticButton;
	private int button=0;

	boolean noMove = false;

	static final double MOVEMENT = 13.3333333 * 2;
	static final double MOVEMENTX = 10.666666 * 2;
	static final int IMG_SIZE = 40;
	static final int NUM_OF_END = 5;
	static double w = 730;

	private boolean carDeath = false;
	private boolean waterDeath = false;
	public boolean changeScore = false;
	private boolean enterNewWorld = false;
	

	private int carD = 0;


	ArrayList<End> inter = new ArrayList<End>();

	/**
	 * Instantiates a frogger.
	 *
	 * @param imageLink the image link
	 */
	public Animal(String imageLink) {
		setImage(new Image(imageLink, IMG_SIZE, IMG_SIZE, true, true));
		setX(300);
		setY(730 + MOVEMENT);

		if(staticButton==1) {
			points=basePoints;
			button=1;
		}
	}

	/**
	 * Act.
	 *
	 * @param now the now
	 */
	@Override
	public void act(long now) {

		AnimalMovementController amc = new AnimalMovementController();
		amc.pressedMovent(this);
		amc.insideBoundary();
		// CarDeath or waterDeath.
		death(now);
		keepSpeed();
		enterWorld();
	}
	
	

	

	/**
	 * Stop if frogger have reached to terminal point {@code NUM_OF_END} times.
	 *
	 * @return the stop
	 */
	public boolean getStop() {
		return end == NUM_OF_END;
	}

	/**
	 * Gets the current points.
	 *
	 * @return the points
	 */
	public int getPoints() {
		return points;
	}

	/**
	 * Change score.
	 *
	 * @return true, if successful
	 */
	public boolean changeScore() {
		if (changeScore) {
			changeScore = false;
			return true;
		}
		return false;

	}

	/**
	 * Return the number of death in {@link keepScore} so that so game ends when
	 * health is consumed.
	 *
	 * @return the lose number
	 */
	public int loseNumber() {
		return lose;
	}

	/**
	 * Judge if this forger trigger carDeath or waterDeath event.
	 *
	 * @param now the now
	 */
	private void death(long now) {
		
		String deathType = null;
		boolean deathState = false;

		if (waterDeath) {
			deathType = "water";
			deathState = true;
		} else if (carDeath) {
			deathType = "car";
			deathState = true;
		}

		if (deathState) {
			noMove = true;
			if ((now) % 11 == 0) {
				carD++;
			}

			switch (carD) {
			case 1:
				setImage(new Image("file:resource/img/" + deathType + "death1.png", IMG_SIZE, IMG_SIZE, true, true));
			case 2:
				setImage(new Image("file:resource/img/" + deathType + "death2.png", IMG_SIZE, IMG_SIZE, true, true));
			case 3:
				setImage(new Image("file:resource/img/" + deathType + "death3.png", IMG_SIZE, IMG_SIZE, true, true));
			}

			if (carD == 4) {
				if ("water".equals(deathType)) {
					setImage(new Image("file:resource/img/" + deathType + "death4.png", IMG_SIZE, IMG_SIZE, true, true));
				} else {
					reOrigin(carDeath, deathType);
					carDeath = false;
				}
			}

			if (carD == 5 && "water".equals(deathType)) {
				reOrigin(waterDeath, deathType);
				waterDeath = false;
			}

		}

		if (getIntersectingObjects(Obstacle.class).size() >= 1 || getIntersectingObjects(Zombie.class).size() >= 1 || getIntersectingObjects(Gangartuar.class).size() >= 1 ){
			carDeath = true;
		}

	}



	/**
	 * Keep space and direction with items when this forger accrosing the river.
	 */
	private void keepSpeed() {
		if (getIntersectingObjects(Log.class).size() >= 1 && !noMove) {
			if (getIntersectingObjects(Log.class).get(0).getLeft())
				move(-2, 0);
			else
				move(.75, 0);
		} else if (getIntersectingObjects(Boat.class).size() >= 1 && !noMove) {
			if (getIntersectingObjects(Boat.class).get(0).getLeft())
				move(-2, 0);
			else
				move(.75, 0);
		} else if (getIntersectingObjects(Turtle.class).size() >= 1 && !noMove) {
			move(-1, 0);
		} else if (getIntersectingObjects(WetTurtle.class).size() >= 1) {
			if (getIntersectingObjects(WetTurtle.class).get(0).isSunk()) {
				waterDeath = true;
			} else {
				move(-1, 0);
			}
		} else if (getIntersectingObjects(Shark.class).size() >= 1 && !noMove) {
			move(-1.5, 0);
		} else if (getIntersectingObjects(AngryShark.class).size() >= 1) {
			if (getIntersectingObjects(AngryShark.class).get(0).isSunk()) {
				waterDeath = true;
			} else {
				move(-1.5, 0);
			}
		}

		else if (getIntersectingObjects(End.class).size() >= 1) {
			inter = (ArrayList<End>) getIntersectingObjects(End.class);
			if (getIntersectingObjects(End.class).get(0).isActivated()) {
				move(0, MOVEMENT * 1.5);
				points -= 10;
			} else {
				points += 50;
				changeScore = true;
				w = 730;
				getIntersectingObjects(End.class).get(0).setEnd();
				end++;
				setX(300);
				setY(730 + MOVEMENT);
			}

		} else if (getY() < 413 && button==0) {
			waterDeath = true;
		}
	}

	/**
	 * Before game stops, let the frogger goes back to the origin point once it
	 * dies.
	 *
	 * @param deathState the death state
	 * @param deathType  the death type
	 */
	private void reOrigin(boolean deathState, String deathType) {
		setX(300);
		setY(730 + MOVEMENT);
		deathState = false;
		// Life decreases when frogger lose.
			LevelController.background2.remove(GameApp.health.get(lose));
			LevelController.background.remove(GameApp.health.get(lose));
		lose++;
		carD = 0;
		setImage(new Image("file:resource/img/froggerUp.png", IMG_SIZE, IMG_SIZE, true, true));
		noMove = false;
		if (points > 50) {
			points -= 50;
			changeScore = true;
		}
		deathType = null;
		deathState = false;
	}

	public boolean enterWorld() {
		if (getIntersectingObjects(Portal.class).size() >= 1 && !noMove) {		
			enterNewWorld=true;
		}
		w=730;
		staticButton=1;
		basePoints=points;
		return enterNewWorld;
		
	}
	

	public int getNumSecondflase() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void setNumSecondflase(int i) {
		// TODO Auto-generated method stub
		
	}

}
