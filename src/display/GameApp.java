package display;


import java.util.ArrayList;

import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import element.*;
import interact.GameStage;
import javafx.animation.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.util.Duration;

// TODO: Auto-generated Javadoc

/**
 * Display different game level by using {@code ActorFactory}. 
 * <br> Besides, this class also display {@code End}, {@code HealthPoint} and {@code Score}  
 * 
 * @author 	scyyz4 
 *
 */
public class GameApp {
	
	/** The animal. */
	private Animal animal;
	
	/** The stage. */
	public static Stage stage;
	
	/** The music 1. */
	private String music1 = "resource/music/Frogger Main Song Theme (loop).mp3";
	
	/** The music 2. */
	private String music2 = "resource/music/SpongBob.mp3";
	
	/** The music 3. */
	private String music3 = "resource/music/Grasswalk.mp3";

	/** The health. */
	public static ArrayList<Health> health = new ArrayList<Health>(50);

	/** Import the variable-background. */
	private GameStage background;

	/**
	 * Generates the easy world based current GameStage and Stage.
	 *
	 * @param bg 		Current background
	 * @param stage 	Current stage
	 */
	public void createEasyWorld(GameStage bg, Stage stage) {

		BackgroundImage froggerback = new BackgroundImage("file:resource/img/arcade.png");
		bg.add(froggerback);
		
		Actor actor1 = ActorFactory.getActor("log");
		Actor actor3 = ActorFactory.getActor("Turtle");
		Actor actor4 = ActorFactory.getActor("Portal");
		Actor actor2 = ActorFactory.getActor("Obstacle");
		
		actor1.disPlay(bg);
		actor2.disPlay("Easy",bg);
		actor3.disPlay(bg);
		actor4.disPlay(bg);

		endAndDigit(bg);
		healthPoint(bg);
		stageDisplay(bg,stage,music1);
		

	}

	/**
	 * Generates the normal world based current GameStage and Stage.
	 *
	 * @param bg 		Current background
	 * @param stage 	Current stage
	 */
	public void createNormalWorld(GameStage bg,Stage stage) {
		
		BackgroundImage froggerback = new BackgroundImage("file:resource/img/arcade2.png");
		bg.add(froggerback);

		Actor actor1 = ActorFactory.getActor("Obstacle");
		Actor actor2 = ActorFactory.getActor("Boat");
		Actor actor3 = ActorFactory.getActor("Shark");
		Actor actor4 = ActorFactory.getActor("Portal");
		

		
		actor1.disPlay("Normal",bg);
		actor2.disPlay(bg);
		actor3.disPlay(bg);
		actor4.disPlay(bg);
		
		endAndDigit(bg);
		healthPoint(bg);
		stageDisplay(bg,stage,music2);
	}

	/**
	 * Generates the secret world based current GameStage and Stage.
	 *
	 * @param bg2 		Current background
	 * @param stage 	Current stage
	 */
	public void createNewWorld(GameStage bg2,Stage stage) {
		BackgroundImage froggerback = new BackgroundImage("file:resource/img/background3test.png");
		bg2.add(froggerback);

		Actor actor1 = ActorFactory.getActor("Zombie");
		actor1.disPlay(bg2);

		Actor actor2 = ActorFactory.getActor("Gangartuar");
		actor2.disPlay(bg2);
		
		endAndDigit(bg2);
		healthPoint(bg2);
		stageDisplay(bg2,stage,music3);


	}
	
	
	/**
	 * Display time bar, animal and play corresponding music.
	 * <p>For the time bar, if the player have not won the game before time consumed, 
	 * <br>an alert will be displayed to remind him process up the process.
	 *
	 * @param bg 		Current background
	 * @param stage 	Current stage
	 * @param music 	Music played in corresponding level
	 */
	public void stageDisplay(GameStage bg,Stage stage,String music) {
		Scene scene1 = new Scene(bg, 600, 800);
		
		animal = new Animal(bg);
		bg.add(animal);
		
		ProgressBar bar = new ProgressBar(0);
	    bar.setPrefSize(300, 24);

	    Timeline task = new Timeline(
	        new KeyFrame(
	                Duration.seconds(150),       
	                new KeyValue(bar.progressProperty(), 0)
	        ),
	        new KeyFrame(
	                Duration.ZERO, 
	                new KeyValue(bar.progressProperty(), 1)            
	        )
	    );
	    
	    task.playFromStart();
	    
	    task.setOnFinished(event->{
	    	Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Alert! Alert! Alert!");
			alert.setHeaderText("Be quick!");
			alert.setContentText("You are slower than most prople");
			alert.show();
	     });
	

	    GridPane layout = new GridPane();
	    layout.getChildren().setAll(bar);
	    layout.setPadding(new Insets(45));
	    layout.setAlignment(Pos.CENTER);   
	    bg.getChildren().add(layout);
	
	    
		bg.start();

		stage.setScene(scene1);
		stage.show();
		stage.setResizable(false);
		
		// Put the score part in keepScore.java
		KeepScore score = new KeepScore(animal, stage, music,bg);
		score.start();
		
	}
	
	
	
	
	

	/**
	 * Display the  element {@code End} and {@code score} in game stage.
	 *
	 * @param bg 	Current  background
	 */
	public void endAndDigit(GameStage bg) {
		// The end block
		for (int i = 0; i < 5; i++) {
			if (i < 3) {
				bg.add(new End(13 + (141 - 13) * i, 96));
			} else {
				switch (i) {
				case 3:
					bg.add(new End(13 + (141 - 13) * 3 + 1, 96));
					break;
				case 4:
					bg.add(new End(13 + (141 - 13) * 4 + 3, 96));
					break;
				}

			}
		}

		bg.add(new Digit(0, 30, 550, 10));

	}

	/**
	 * Display the health point. For each players, they will have five times to try this game everytime.
	 *
	 * @param bg 		Current  background
	 */
	public void healthPoint(GameStage bg) {
		for (int i = 0; i < KeepScore.numOfLifes; i++) {
			Health a = new Health(390 + i * 40, 35);
			health.add(i, a);
			bg.add(health.get(i));
		}
	}
	
	/**
	 * Instantiates a new game app.
	 *
	 * @param bg the bg
	 */
	public GameApp(GameStage bg) {
		this.background=bg;
	}
	


}
