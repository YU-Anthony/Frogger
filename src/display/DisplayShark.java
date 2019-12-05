package display;

import element.AngryShark;

import element.Shark;
import p4_group_8_repo.MyStage;



public class DisplayShark {
	

	
	public void dShark(MyStage bg) {
		
		// The third Shark line 
		for(int i=0;i<3;i++) {
			bg.add(new Shark( 500, 355, -1.5, 80, 120));
			bg.add(new Shark(300, 355, -1.5, 80, 120));
			bg.add(new Shark( 700, 356, -1.5, 80, 120));
			
			bg.add(new AngryShark(800, 185, -1.5, 80, 95));
			bg.add(new AngryShark(600, 185, -1.5, 80, 130));
			bg.add(new AngryShark(400, 185, -1.5, 80, 130));

		}
//		
//		bg.add(new Shark( 100, 0, 276, -4));
//		bg.add(new Shark( 100, 400, 276,-4));
	}
}
