package display;

import element.Boat;
import p4_group_8_repo.MyStage;

public class DisplayBoat {
		
	
	public void dBoat(MyStage bg) {
			
			// The third Boat line 
		for(int i=0;i<3;i++) {
			bg.add(new Boat("file:src/img/speedboat.png", 130, 0+220*i, 160, 0.75));
			bg.add(new Boat("file:src/img/speedboat.png", 130, 50+220*i, 320, 0.75));
		}
		
		bg.add(new Boat("file:src/img/speedboatleft.png", 140, 0, 260, -2));
		bg.add(new Boat("file:src/img/speedboatleft.png", 140, 400, 260,-2));
	}
}
