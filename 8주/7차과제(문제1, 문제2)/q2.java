package as7;

import java.util.*;

public class q2{
	public static void main(String[] arg) {
		int Num = 5;
		int grade=0;
		int i=0;
		int[] ans = {2,3,4,5,6};
		int[] res = {0,0,0,0,0};
		String[] TestInput = {	"10 ���ѹα� 0 �̱� 12 �Ϻ�(���ص�) 3 ���� 5",
								"10 ���ѹα�(����) 0 ���ѹα�(��õ) 1 ������ 6 ���� 3 �̱� 12 �߱� 7 �ʸ��� 10",
								"20 ���ѹα�(����) 0 ���ѹα�(��õ) 1 ������ 6 ���� 3 �̱� 12 �߱� 7 �ʸ��� 10",
								"30 ���ѹα�(����) 0 ���ѹα�(��õ) 1 ������ 6 ���� 3 �̱� 12 �߱� 7 �ʸ��� 10",
								"40 ���ѹα�(����) 0 ���ѹα�(��õ) 1 ������ 6 ���� 3 �̱� 12 �߱� 7 �ʸ��� 10"
								};
		
		ArrayList <Route> t = new ArrayList<Route>();
		
		for(i=0; i<Num; i++) {
			t.add(new Route(TestInput[i]));
		}
		
		for(i=0; i<Num; i++) {		
			res[i] = t.get(i).CountPoint();
		}
			
		for(i=0;i<Num; i++) {
			if(res[i] == ans[i])	grade++;
		}
		
		if(grade == Num)	System.out.println("�����մϴ�. �հ��Դϴ�.");
		else	System.out.println(grade*20 + "���Դϴ�. ������ �ٽ� ������ �ּ���");
	}
}