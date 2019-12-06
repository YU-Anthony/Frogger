package display;

import element.Actor;
import element.Boat;
import element.Log;
import element.Obstacle;
import element.Shark;
import element.Turtle;

/*
 * {@code Simple factory method}
 *  The implement of specific Actor 
 */

public class ActorFactory {

	
	public static Actor getActor(String type) {
		Actor actor=null;
		if(type.equalsIgnoreCase("Log")) {
			actor = new Log();
		}else if(type.equalsIgnoreCase("Obstacle")) {
			actor = new Obstacle();
		}else if(type.equalsIgnoreCase("Boat")) {
			actor = new Boat();
		}else if(type.equalsIgnoreCase("Shark")) {
			actor = new Shark();
		}else if(type.equalsIgnoreCase("Turtle")) {
			actor = new Turtle();
		}
		
		return actor;
	}
}
