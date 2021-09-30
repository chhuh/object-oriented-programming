package as7;

import java.util.*;

public class q1 {
	public static void main(String[] args) {
			
		Route t1 = new Route("10 ���ѹα� 0 �̱� 12 �Ϻ�(���ص�) 3 ���� 5");
		Route t2 = new Route("10 ���ѹα�(����) 0 ���ѹα�(��õ) 1 ������ 6 ���� 3 �̱� 12 �߱� 7 �ʸ��� 10");
		Route t3 = new Route("20 ���ѹα�(����) 0 ���ѹα�(��õ) 1 ������ 6 ���� 3 �̱� 12 �߱� 7 �ʸ��� 10");
		Route t4 = new Route("30 ���ѹα�(����) 0 ���ѹα�(��õ) 1 ������ 6 ���� 3 �̱� 12 �߱� 7 �ʸ��� 10");
		Route t5 = new Route("50 ���ѹα�(����) 0 ���ѹα�(��õ) 1 ������ 6 ���� 3 �̱� 12 �߱� 7 �ʸ��� 10");
		
		t1.PrintRoute();
		t2.PrintRoute();
		t3.PrintRoute();
		t4.PrintRoute();
		t5.PrintRoute();
		
	}
}
class Route // �ִ� ���� ���
{ 
		
		String[] arr;
		int Max;
		int count=0;
		int temp=0;
		StartPoint SP;
		ArrayList<Point> list = new ArrayList<Point>();
		
		public Route(String input) {
			arr = input.split(" ");
			
			Max = (Integer.parseInt(arr[0]));
			
			try {
				this.SP = new StartPoint(arr[1],Integer.parseInt(arr[2]));
			}
			catch(Exception e) {
		         e.printStackTrace();
			}
			
			for(int i=3; i<(arr.length); i+=2)	list.add(new TravelPoint(arr[i],Integer.parseInt(arr[i+1])));
				
			list.sort(new Comparator<Point>()
			{
				@Override
				public int compare(Point c1, Point c2)
				{
					int time1 = c1.getTime();
					int time2 = c2.getTime();
					if(time1 == time2)	return 0;
					else if(time1 > time2)	return 1;
					else return -1;
				}
			}
			);
			
			for(Point c: list) {
				if((temp + c.getTime())>Max) break;
				count++;
				temp+=c.getTime();
				
			}
		}
		
		public void PrintRoute() {
			System.out.print("���� ��Ʈ�� " + SP.getName() + "-> ");
			for(int i=0; i<count; i++) {
				System.out.print(list.get(i).getName() + "-> ");
			}
			System.out.println(SP.getName() + "�Դϴ�. �־��� " + Max + "�ð� �̳��� �湮�� ������ ����(����)�� �ִ� " + count + "�� �Դϴ�.");
		}
		
		public int CountPoint() {
			return count;
		}
	

}

interface Get  // getter �Լ��� interface
{
	String getName();
	int getTime();
}


abstract class Point implements Get // ��������Ʈ
{

	private String Name;	
	protected int Time;
	
	@Override
	public String getName() {
		return this.Name;
	}
	
	@Override
	public int getTime() {
		return Time;
	}
	
	public void setName(String Name) {
		this.Name = Name;
	}
	
	public void setTime(int Time) {
		this.Time = Time;
	}
	
}	

class StartPoint extends Point implements AutoCloseable  // ���� ������
{
	
	public StartPoint(String Name, int Time) throws Exception {
		Exception e1 = new Exception("You must type a word! Your input is empty!");
		
		if(Time !=0) {	
			throw e1;
		}
		super.setName(Name);
		super.setTime(Time);
	}
	
   @Override
   public void close() throws Exception {
	   System.out.println("Well Done.");
   }
}

class TravelPoint extends Point   // ������
{
	
	public TravelPoint(String Name, int Time) {
		super.setName(Name);
		super.setTime(Time);
	}
}