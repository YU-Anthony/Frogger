package interact.controller;



import display.Display;
import element.Animal;
import element.BackgroundImage;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import p4_group_8_repo.KeepScore;
import p4_group_8_repo.MyStage;

public class LevelController extends Application{
	private  AnimationTimer timer;
	public static  MyStage background;
	private  Animal animal;
	private  Display world;
	private String music1= "src/Frogger Main Song Theme (loop).mp3";
	private String music2= "src/SpongBob.mp3";
	

	@FXML
	private Button easyButton;
	@FXML
	private Button normalButton;
	
	@FXML
	protected void changeToTest() throws Exception {
		 background = new MyStage();
		 Scene scene  = new Scene(background,600,800);
		 
		
		// Different button to generate different levels 
		easyButton.setOnAction(event -> {
			
			BackgroundImage froggerback = new BackgroundImage("file:src/img/arcade.png");
			background.add(froggerback);
			
			world = new Display();
			world.createEasyWorld(background);
			world.endAndDigit();
			
			    	    
			animal = new Animal("file:src/img/froggerUp.png");
		    background.add(animal);
		    
		    world.healthPoint();
		     
		    background.start();
		   			
		    Stage stage = (Stage) easyButton.getScene().getWindow();
		    stage.setScene(scene);
		    stage.show();
		    
		 // Put the score part in keepScore.java
			KeepScore score=new KeepScore(animal,stage,music1);
			score.start();
		    
		   
		});
		
		normalButton.setOnAction(event -> {
			
			BackgroundImage froggerback = new BackgroundImage("file:src/img/arcade2.png");
			background.add(froggerback);
			
			world = new Display();
			world.createNormalWorld(background);
			world.endAndDigit();
			    	    
			animal = new Animal("file:src/img/froggerUp.png");
		    background.add(animal);
		    
		    world.healthPoint();
		     
		    background.start();
		   			
		    Stage stage = (Stage) normalButton.getScene().getWindow();
		    stage.setScene(scene);
		    stage.show();
		    
		 // Put the score part in keepScore.java
			KeepScore score=new KeepScore(animal,stage,music2);
			score.start();
		    
		   
		});
		
		
		
	}

	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	
}
