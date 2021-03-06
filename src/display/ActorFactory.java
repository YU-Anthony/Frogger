package display;

import element.Actor;
import element.Boat;
import element.Gangartuar;
import element.Log;
import element.Obstacle;
import element.Portal;
import element.Shark;
import element.Turtle;
import element.Zombie;

/**
 * Class {@code ActoryFactory} abstract the actor instantiation process.
 * ��br��User can just input the kinds of the actor they want.
 * <p>
 * {@link GameApp} uses this class to create different actors such as
 * {@code Log},{@code Obstacle},{@code}.
 */
public class ActorFactory {
	/**
	 * Gets the type of actor.
	 *
	 * @param type 		the Actor type
	 * @return the actor
	 */
	public static Actor getActor(String type) {
		Actor actor = null;
		if (type.equalsIgnoreCase("Log")) {
			actor = new Log();
		} else if (type.equalsIgnoreCase("Obstacle")) {
			actor = new Obstacle();
		} else if (type.equalsIgnoreCase("Boat")) {
			actor = new Boat();
		} else if (type.equalsIgnoreCase("Shark")) {
			actor = new Shark();
		} else if (type.equalsIgnoreCase("Turtle")) {
			actor = new Turtle();
		} else if (type.equalsIgnoreCase("Portal")) {
			actor = new Portal();
		}else if(type.equalsIgnoreCase("Zombie")) {
			actor = new Zombie();
		}else if(type.equalsIgnoreCase("Gangartuar")) {
			actor = new Gangartuar();
		}

		return actor;
	}
}
