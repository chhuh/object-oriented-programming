import java.util.*;

public class ����1
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
			System.out.print("��� A���� �ٲٰ� ���� ���� A(i,j)�� ���� ��ġ i�� �Է��Ͻÿ�: ");
			i=sc.nextInt();
			i -=1;
			System.out.print("��� A���� �ٲٰ� ���� ���� A(i,j)�� ���� ��ġ j�� �Է��Ͻÿ�: ");
			j=sc.nextInt();
			j -=1;
			ch = 4*i +j;
			System.out.println("�����Ͻ� ���Ҵ� " + A[ch] + " �Դϴ�.");
			System.out.print("������ yes�� �Է��ϰ�, �ٽ� �Է��ϰ� ������ no�� �Է��ϼ���: ");
			y_n = in.next();
			switch(y_n) {
			case "yes" :
				System.out.println(A[ch] + " �� �����ϼ̽��ϴ�.");
				for(c=0; c<(15-ch); c++) {
					temp[c] = A[15-c];
				}
				System.out.print("�ٲٰ� ���� ���Ҹ� �Է��ϼ���: ");
				ni=sc.nextInt();
				temp[c] = ni;
				for(d = c; d>0; d--) {
					A[15-d] = temp[d];
				}
				System.out.println("�ٲ� ���Ҹ� �����Ͽ� ������ ���� ����� �����Ͽ����ϴ�.");
				Pr_Arr(A);
				System.out.print("�� �̻� ������ ���Ұ� ������ yes�� �Է��ϰ�, ������ ���Ұ� �ִٸ� no�� �Է��ϼ���: ");
				y_n = in.next();
				break;
			case "no" :
				break;
			default : 
				break;
			}
		}
		System.out.print("���α׷��� ����Ǿ����ϴ�.");
		

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

	