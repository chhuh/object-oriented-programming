package as6;

import java.util.*;

public class ����2 {
	public static void main(String[] args) {
		
		SensorSystem Sen = new SensorSystem();
		
		Buzzer pd = new Buzzer("�ȴް�",4);
		Buzzer sh = new Buzzer("��ȣ��",3);
		Buzzer ds = new Buzzer("�ٻ��",2);
		
		Sen.register(pd);
		Sen.register(sh);
		Sen.register(ds);
		
		Sen.giveAlarm("����", 3);
		

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
			System.out.println(a.getlevelGage() + "������ �溸�� " + a.getPl() + "���� �߻��Ͽ����ϴ�." + this.place + " ������ �۵��մϴ�.");
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