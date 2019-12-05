package display;

import element.Obstacle;
import p4_group_8_repo.MyStage;

public class DisplayCar {

		public void dECar(MyStage bg) {
			// The first line of car
			for(int i=0;i<4;i++) {
				bg.add(new Obstacle("file:src/img/car1Left.png", 100+150*i, 597, -1, 50, 50));
			}
			
			// The second line of car
			bg.add(new Obstacle("file:src/img/car1Left.png", 500, 490, -5, 50, 50));
		}
		
		public void dNCar(MyStage bg) {
			// The first line of car
			for(int i=0;i<3;i++) {
				bg.add(new Obstacle("file:src/img/traincar3.png", 100+150*i, 597, -1, 80, 80));
			}
			
			// The second line of car
			bg.add(new Obstacle("file:src/img/traincar4.png", 500, 490, -5, 80, 80));
		}
		
		public void dDCar(MyStage bg) {
			// The first line of car
			for(int i=0;i<4;i++) {
				bg.add(new Obstacle("file:src/img/car1Left.png", 100+150*i, 597, -1, 50, 50));
			}
			
			// The second line of car
			bg.add(new Obstacle("file:src/img/car1Left.png", 500, 490, -5, 50, 50));
		}
}
