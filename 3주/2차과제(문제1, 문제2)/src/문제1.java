import java.util.*;

public class 문제1
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		Scanner in = new Scanner(System.in);
		int i, j;
		int ch;
		int ni;
		int c;
		int d;
		
		String y_n = "no";
		
		int[] temp= new int[] {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
		int[] A= new int[] {13,5,61,83,21,75,9,46,2,38,85,72,27,62,22,51};
		
		Pr_Arr(A);
		
		while(y_n.equals("no")) {
			System.out.print("행렬 A에서 바꾸고 싶은 원소 A(i,j)의 행의 위치 i를 입력하시오: ");
			i=sc.nextInt();
			i -=1;
			System.out.print("행렬 A에서 바꾸고 싶은 원소 A(i,j)의 열의 위치 j를 입력하시오: ");
			j=sc.nextInt();
			j -=1;
			ch = 4*i +j;
			System.out.println("선택하신 원소는 " + A[ch] + " 입니다.");
			System.out.print("맞으면 yes를 입력하고, 다시 입력하고 싶으면 no를 입력하세요: ");
			y_n = in.next();
			switch(y_n) {
			case "yes" :
				System.out.println(A[ch] + " 를 선택하셨습니다.");
				for(c=0; c<(15-ch); c++) {
					temp[c] = A[15-c];
				}
				System.out.print("바꾸고 싶은 원소를 입력하세요: ");
				ni=sc.nextInt();
				temp[c] = ni;
				for(d = c; d>0; d--) {
					A[15-d] = temp[d];
				}
				System.out.println("바꾼 원소를 적용하여 다음과 같이 행렬을 갱신하였습니다.");
				Pr_Arr(A);
				System.out.print("더 이상 변경할 원소가 없으면 yes를 입력하고, 변경할 원소가 있다면 no를 입력하세요: ");
				y_n = in.next();
				break;
			case "no" :
				break;
			default : 
				break;
			}
		}
		System.out.print("프로그램이 종료되었습니다.");
		

	}	

	public static void Pr_Arr(int[] A) {
		int i;
		for(i=0; i<=15; i++) {
			if((i+1)%4==0) {
				if(A[i]>=0 && A[i]<10) {
					System.out.print(" " + A[i] + "\n");
				}
				else {
					System.out.print(A[i] + "\n");
				}
			}
			else {
				if(A[i]>=0 && A[i]<10) {
					System.out.print(" " + A[i] + " ");
				}
				else {
					System.out.print(A[i] + " ");
				}
			}
		}
		return;
	}
	
	
}

	