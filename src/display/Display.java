package display;

import java.util.ArrayList;

import interact.controller.LevelController;
import p4_group_8_repo.KeepScore;
import p4_group_8_repo.MyStage;
import element.*;

/**
 *  Display different game level by using {@code ActorFactory}.
 */
public class Display{
	
	/** The health. */
	public static ArrayList<Health> health =new ArrayList<Health>(50);
	
	/** Import the variable-background. */
	MyStage bg=LevelController.background;
	
	
	/**
	 * Generates the easy world.
	 *
	 * @param bg the background
	 */
	public void createEasyWorld(MyStage bg) {
	
		
		Actor actor1=ActorFactory.getActor("log");
		actor1.disPlay("Easy");
		
		Actor actor2=ActorFactory.getActor("Obstacle");
		actor2.disPlay("Easy");

	
		Actor actor3=ActorFactory.getActor("Turtle");
		actor3.disPlay();
			
		Actor actor4=ActorFactory.getActor("Portal");
		actor4.disPlay();
	
		bg.add(new Digit(0, 30, 360, 10));

		
	}
	
	/**
	 * Generates the normal world.
	 *
	 * @param bg the background
	 */
	public void createNormalWorld(MyStage bg) {
		
		Actor actor1=ActorFactory.getActor("Obstacle");
		actor1.disPlay("Normal");
		
		Actor actor2=ActorFactory.getActor("Boat");
		actor2.disPlay();
		

		Actor actor3=ActorFactory.getActor("Shark");
		actor3.disPlay();
						
	}
	
	/**
	 * Add the End and control digit.
	 */
	public void endAndDigit() {
		//The end block
				for(int i=0;i<5;i++) {
					if(i<3) {
						bg.add(new End(13+(141-13)*i,96));
					}else {
						switch(i) {
						case 3:bg.add(new End(13+(141-13)*3+1,96));
								break;
						case 4:bg.add(new End(13+(141-13)*4+3,96));
								break;
						}
							
					}
				}
		
		bg.add(new Digit(0, 30, 360, 10));
		
	}
	
	/**
	 * Control the health point.
	 */
	public void healthPoint() {
		for(int i=0;i<KeepScore.numOfLifes;i++) {
			Health a = new Health(390+i*40,35);
			health.add(i,a);
			bg.add(health.get(i));
		}
	}

}


