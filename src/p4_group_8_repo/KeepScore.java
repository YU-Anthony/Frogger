package p4_group_8_repo;


import java.io.BufferedWriter;

import java.io.FileWriter;
import java.io.IOException;

import element.Animal;
import element.Digit;
import interact.model.ScoreBoard;
import interact.model.GameLose;
import javafx.animation.AnimationTimer;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

import interact.model.GameWin;

import interact.controller.LevelController;

public class KeepScore extends World{
	
	private AnimationTimer timer;
	private Animal animal;
	private Stage primaryStage;
	private Boolean input=false;
	private static final String FILENAME= "score.txt";
	private String music;
	
	public static int numOfLifes = 5;
	
	@Override
	public void createTimer() {
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
            	if (animal.changeScore()) {
            		setNumber(animal.getPoints());
            	}
            	if (animal.getStop()) {
            		System.out.print("STOPP:");
            		LevelController.background.stopMusic();
            		stop();
            		LevelController.background.stop();
            		Alert alert = new Alert(AlertType.INFORMATION);
            		alert.setTitle("You Have Won The Game!");
            		alert.setHeaderText("Your High Score: "+animal.getPoints()+"!");
            		alert.setContentText("Highest Possible Score: 800");
            		alert.show();
            		
            		
            	
            		
            		// A new user can input his name when his score higher than the 5th score, otherwise the nameInput page doesn't show.
            		ScoreBoard a = new ScoreBoard();
         		
            		if(a.getScore(5)!="-"  ) {                		
                		if(Integer.valueOf(a.getScore(5)) < animal.getPoints()) {
                			input=true;  
                		}           			
            		}else if("-".equals(a.getScore(5))){
                		input=true;     
            		}else if("-".equals(a.getScore(1))) {            			
            			input=true;  
            		}
            		
            		
            		
            		if(input==true) {
            			writeToFile(Integer.toString(animal.getPoints()));
                		
                		GameWin win= new GameWin(primaryStage);
                		try {
    						win.nameEnterDisplay();
    					} catch (IOException e) {
    						e.printStackTrace();
    					}
            		}else {
            			GameWin win= new GameWin(primaryStage);
            			try {
    						win.gotoIndex();
    					} catch (IOException e) {
    						e.printStackTrace();
    					}
            		}       
            	}
            	
            	
            	
            	if(animal.loseNumber()==numOfLifes) {
            		System.out.print("STOPP:");
            		LevelController.background.stopMusic();
            		stop();
            		LevelController.background.stop();
            		
            		GameLose lose= new GameLose(primaryStage);
            		try {
						lose.endChoices();
					} catch (IOException e) {
						e.printStackTrace();
					}
            		
            	}
            }
        };
    }
	
	@Override
	public void start() {
		LevelController.background.playMusic(music);
    	createTimer();
        timer.start();
    }


    
    public void setNumber(int n) {
    	int shift = 0;
    	while (n > 0) {
    		  int d = n / 10;
    		  int k = n - d * 10;
    		  n = d;
    		  LevelController.background.add(new Digit(k, 30, 360 - shift, 10));
    		  shift+=30;
    		}
    }

    /*
     * Function try to write score in a particular file which named "score.txt".
     */
    public void writeToFile(String data) {
  
    	String content = ";";
    	
    	try(BufferedWriter bw = new BufferedWriter(new FileWriter(FILENAME,true))) {
    	
			bw.write(data);
			bw.write(content);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
	@Override
	public void act(long now) {
		// TODO Auto-generated method stub
		
	}
	
	public KeepScore(Animal animal, Stage primaryStage, String music) {
		this.animal=animal;
		this.primaryStage=primaryStage;
		this.music = music;
	}

}