package as7;

import java.util.*;

public class q2{
	public static void main(String[] arg) {
		int Num = 5;
		int grade=0;
		int i=0;
		int[] ans = {2,3,4,5,6};
		int[] res = {0,0,0,0,0};
		String[] TestInput = {	"10 대한민국 0 미국 12 일본(북해도) 3 몽골 5",
								"10 대한민국(구성) 0 대한민국(인천) 1 프랑스 6 영국 3 미국 12 중국 7 필리핀 10",
								"20 대한민국(구성) 0 대한민국(인천) 1 프랑스 6 영국 3 미국 12 중국 7 필리핀 10",
								"30 대한민국(구성) 0 대한민국(인천) 1 프랑스 6 영국 3 미국 12 중국 7 필리핀 10",
								"40 대한민국(구성) 0 대한민국(인천) 1 프랑스 6 영국 3 미국 12 중국 7 필리핀 10"
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
		
		if(grade == Num)	System.out.println("축하합니다. 합격입니다.");
		else	System.out.println(grade*20 + "점입니다. 다음에 다시 도전해 주세요");
	}
}