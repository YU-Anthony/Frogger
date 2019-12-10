package element;

import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class AnimalMovementController extends Actor{

	private int IMG_SIZE = Animal.IMG_SIZE;
	private double MOVEMENT = Animal.MOVEMENT;
	private double MOVEMENTX = Animal.MOVEMENTX;
	private boolean second = false;

	private Image imgW1 = new Image("file:src/img/froggerUp.png", IMG_SIZE, IMG_SIZE, true, true);
	private Image imgA1 = new Image("file:src/img/froggerLeft.png", IMG_SIZE, IMG_SIZE, true, true);
	private Image imgS1 = new Image("file:src/img/froggerDown.png", IMG_SIZE, IMG_SIZE, true, true);
	private Image imgD1 = new Image("file:src/img/froggerRight.png", IMG_SIZE, IMG_SIZE, true, true);
	private Image imgW2 = new Image("file:src/img/froggerUpJump.png", IMG_SIZE, IMG_SIZE, true, true);
	private Image imgA2 = new Image("file:src/img/froggerLeftJump.png", IMG_SIZE, IMG_SIZE, true, true);
	private Image imgS2 = new Image("file:src/img/froggerDownJump.png", IMG_SIZE, IMG_SIZE, true, true);
	private Image imgD2 = new Image("file:src/img/froggerRightJump.png", IMG_SIZE, IMG_SIZE, true, true);

	public void pressedMovent(Animal animal)  {

		animal.setOnKeyPressed(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent event) {

				if (!animal.noMove) {
					if (second) {
						if (event.getCode() == KeyCode.W) {
							animal.move(0, -MOVEMENT);
							animal.changeScore = false;
							animal.setImage(imgW1);

						} else if (event.getCode() == KeyCode.A) {
							animal.move(-MOVEMENTX, 0);
							animal.setImage(imgA1);
						} else if (event.getCode() == KeyCode.S) {
							animal.move(0, MOVEMENT);
							animal.setImage(imgS1);
						} else if (event.getCode() == KeyCode.D) {
							animal.move(MOVEMENTX, 0);
							animal.setImage(imgD1);
						}
						second = false;

					} else {
						if (event.getCode() == KeyCode.W) {
							animal.move(0, -MOVEMENT);

							animal.setImage(imgW2);

						} else if (event.getCode() == KeyCode.A) {
							animal.move(-MOVEMENTX, 0);
							animal.setImage(imgA2);
						} else if (event.getCode() == KeyCode.S) {
							animal.move(0, MOVEMENT);
							animal.setImage(imgS2);
						} else if (event.getCode() == KeyCode.D) {
							animal.move(MOVEMENTX, 0);
							animal.setImage(imgD2);
						}
						second = true;
					}
					animal.setNumSecondflase(animal.getNumSecondflase() + 1);
				}
			}
		});

		animal.setOnKeyReleased(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent event) {

				if (animal.getNumSecondflase() == 2 || animal.getNumSecondflase() % 2 == 0) {
					System.out.println(animal.getNumSecondflase());
					if (animal.noMove) {
					} else {
						if (event.getCode() == KeyCode.W) {
							if (animal.getY() < animal.w) {
								animal.changeScore = true;
								animal.w = animal.getY();
								animal.points += 10;
							}

							animal.move(0, -MOVEMENT);
							animal.setImage(imgW1);

						} else if (event.getCode() == KeyCode.A) {
							animal.move(-MOVEMENTX, 0);
							animal.setImage(imgA1);
						} else if (event.getCode() == KeyCode.S) {
							animal.move(0, MOVEMENT);
							animal.setImage(imgS1);
						} else if (event.getCode() == KeyCode.D) {
							animal.move(MOVEMENTX, 0);
							animal.setImage(imgD1);
						}
						second = false;
					}
					animal.setNumSecondflase(1);
				}
			}
		});

	}

	
	/**
	 * Keep the frogger move inside the scene.
	 */
	public void insideBoundary(Animal animal) {
		if (getY() <= 0 || getY() > 800) {
			move(0, -MOVEMENT * 2);
		}
		if (getX() < 10) {
			move(MOVEMENT * 2, 0);
		}

		if (getX() > 600) {
			move(-MOVEMENT * 2, 0);
		}
	}


	@Override
	public void act(long now) {
		// TODO Auto-generated method stub
		
	}
	
}
