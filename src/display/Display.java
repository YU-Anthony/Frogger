package display;

import java.util.ArrayList;

import interact.controller.LevelController;
import p4_group_8_repo.KeepScore;
import p4_group_8_repo.MyStage;
import element.*;

public class Display{
	
	public static ArrayList<Health> health =new ArrayList<Health>(50);
	MyStage bg=LevelController.background;
	
	
	// ****Actually, the method to generate different world is not efficient, it needs to be updated to get total different and efficient format
	
	public void createEasyWorld(MyStage bg) {
	
		
		Actor actor1=ActorFactory.getActor("log");
		actor1.disPlay("Easy");
		
		Actor actor2=ActorFactory.getActor("Obstacle");
		actor2.disPlay("Easy");

	
		Actor actor3=ActorFactory.getActor("Turtle");
		actor3.disPlay();
		

		
	
		bg.add(new Digit(0, 30, 360, 10));

		
	}
	
	public void createNormalWorld(MyStage bg) {
		
		Actor actor1=ActorFactory.getActor("Obstacle");
		actor1.disPlay("Normal");
		
		Actor actor2=ActorFactory.getActor("Boat");
		actor2.disPlay();
		

		Actor actor3=ActorFactory.getActor("Shark");
		actor3.disPlay();
						
	}
	
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
	
	public void healthPoint() {
		for(int i=0;i<KeepScore.numOfLifes;i++) {
			Health a = new Health(390+i*40,35);
			health.add(i,a);
			bg.add(health.get(i));
		}
	}

}


