package as6;

import java.util.*;

public class 문제2 {
	public static void main(String[] args) {
		
		SensorSystem Sen = new SensorSystem();
		
		Buzzer pd = new Buzzer("팔달관",4);
		Buzzer sh = new Buzzer("성호관",3);
		Buzzer ds = new Buzzer("다산관",2);
		
		Sen.register(pd);
		Sen.register(sh);
		Sen.register(ds);
		
		Sen.giveAlarm("정문", 3);
		

	}

}

interface AlarmListener{
	void alarm(SensorSystem a);
}

class Buzzer implements AlarmListener{
	
	String place;
	int level;
	
	public Buzzer(String place, int level) {
		this.place = place;
		this.level = level;
	}
	
	public void alarm(SensorSystem a) {
		if(this.level <= a.getlevelGage()) {
			System.out.println(a.getlevelGage() + "레벨의 경보가 " + a.getPl() + "에서 발생하였습니다." + this.place + " 버저를 작동합니다.");
		}
	}
	
}

class SensorSystem{
	int levelGage;
	String Pl;
	ArrayList<AlarmListener> array = new ArrayList<AlarmListener>();
	
	public int getlevelGage() {return this.levelGage;}
	public String getPl() {return this.Pl;}
	
	public void setlevelGage(int levelGage) {this.levelGage = levelGage;}
	public void setPl(String Pl) {this.Pl = Pl;} 
	
	public void register(AlarmListener a) {
		array.add(a);
	}
	
	public void notifyAllDevices() {
		for (AlarmListener a: array) {
			a.alarm(this);
		}
	}
	
	public void giveAlarm(String Pl, int levelGage){
		setPl(Pl);
		setlevelGage(levelGage);
		notifyAllDevices();
	}
	
	
	
}