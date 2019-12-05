package display;

import element.Obstacle;
import p4_group_8_repo.MyStage;

public class DisplayTruck {
	
	public void dETruck(MyStage bg) {
		for(int i=0;i<3;i++) {
			bg.add(new Obstacle("file:src/img/truck1"+"Right.png", 0+300*i, 649, 2, 120, 120));
		}
	
		bg.add(new Obstacle("file:src/img/truck2Right.png", 0, 540, 1, 200, 200));
		bg.add(new Obstacle("file:src/img/truck2Right.png", 500, 540, 1, 200, 200));
	}
	
	public void dNTruck(MyStage bg) {
		for(int i=0;i<3;i++) {
			bg.add(new Obstacle("file:src/img/"+"traincar1.png", 0+250*i, 649, 2, 80, 80));
		}
	
		bg.add(new Obstacle("file:src/img/trainRight.png", 0, 540, 1, 200, 200));
		bg.add(new Obstacle("file:src/img/trainRight.png", 500, 540, 1, 200, 200));
	}
	
	public void dDTruck(MyStage bg) {
		for(int i=0;i<3;i++) {
			bg.add(new Obstacle("file:src/img/truck1"+"Right.png", 0+300*i, 649, 2, 120, 120));
		}
	
		bg.add(new Obstacle("file:src/img/truck2Right.png", 0, 540, 1, 200, 200));
		bg.add(new Obstacle("file:src/img/truck2Right.png", 500, 540, 1, 200, 200));
	}
}
