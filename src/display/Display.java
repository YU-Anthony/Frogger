package display;

import java.util.ArrayList;

import element.Digit;
import element.End;
import interact.controller.LevelController;
import p4_group_8_repo.KeepScore;
import p4_group_8_repo.MyStage;


public class Display{
	
	public static ArrayList<Health> health =new ArrayList<Health>(50);
	MyStage bg=LevelController.background;
	
	
	// ****Actually, the method to generate different world is not efficient, it needs to be updated to get total different and efficient format
	
	public void createEasyWorld(MyStage bg) {
	
		DisplayLog d1=new DisplayLog();
		//DisplayTruck d2=new DisplayTruck();
		DisplayTurtle d3=new DisplayTurtle();
		//DisplayCar d4 = new DisplayCar();
		
		d1.dELog(bg);
		//d2.dTruck(bg);		
		d3.dETurtle(bg);
		//d4.dCar(bg);
		
	
		bg.add(new Digit(0, 30, 360, 10));
		//bg.add(obstacle);
		//bg.add(obstacle1);
		//bg.add(obstacle2);
		
	}
	
	public void createNormalWorld(MyStage bg) {
		
		//DisplayLog d1=new DisplayLog();
		DisplayTruck d2=new DisplayTruck();
		//DisplayTurtle d3=new DisplayTurtle();
		DisplayCar d4 = new DisplayCar();
		DisplayShark d5=new DisplayShark();
		DisplayBoat d6 = new DisplayBoat();
		
		//d1.dNLog(bg);
		d2.dNTruck(bg);		
		//d3.dNTurtle(bg);
		d4.dNCar(bg);
		d5.dShark(bg);
		d6.dBoat(bg);
		

		//bg.add(obstacle);
		//bg.add(obstacle1);
		//bg.add(obstacle2);
		
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


