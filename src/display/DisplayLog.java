package display;

import element.Log;
import p4_group_8_repo.MyStage;

public class DisplayLog {
	
	public void dELog(MyStage bg) {
				
		// The third log line 
		for(int i=0;i<3;i++) {
			bg.add(new Log("file:src/img/log3.png", 130, 0+220*i, 166, 0.75));
			bg.add(new Log("file:src/img/log3.png", 130, 50+220*i, 329, 0.75));
		}
		
		bg.add(new Log("file:src/img/logs.png", 250, 0, 276, -2));
		bg.add(new Log("file:src/img/logs.png", 250, 400, 276,-2));
	}
	
	public void dNLog(MyStage bg) {
		
		// The third log line 
		for(int i=0;i<3;i++) {
			bg.add(new Log("file:src/img/log3.png", 130, 0+220*i, 166, 0.75));
			bg.add(new Log("file:src/img/log3.png", 130, 50+220*i, 329, 0.75));
		}
		
		bg.add(new Log("file:src/img/logs.png", 250, 0, 276, -2));
		bg.add(new Log("file:src/img/logs.png", 250, 400, 276,-2));
	}
	
	public void dDLog(MyStage bg) {
		
		// The third log line 
		for(int i=0;i<3;i++) {
			bg.add(new Log("file:src/img/log3.png", 130, 0+220*i, 166, 0.75));
			bg.add(new Log("file:src/img/log3.png", 130, 50+220*i, 329, 0.75));
		}
		
		bg.add(new Log("file:src/img/logs.png", 250, 0, 276, -2));
		bg.add(new Log("file:src/img/logs.png", 250, 400, 276,-2));
	}
}
