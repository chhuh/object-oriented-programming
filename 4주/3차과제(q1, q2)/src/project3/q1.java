package project3;

import java.util.*;

public class q1 {
	private static final int MAX = 10;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Scanner in = new Scanner(System.in);
		
		int control = 0;
		
		int[] VML= new int[4]; // {CPU_NUM, RAM_NUM, DISK_NUM, NUM_of_VM}
		
		VML[3] = 0;
		
		String temp_n = "";
		int temp_c, temp_r, temp_d;

		String del_n = "";
		
		V_M[] vim = new V_M[MAX];
		
	
		System.out.println(">>����ӽ� �����ڰ� ó�� ����Ǿ����ϴ�. ���� �ڿ��� �ʱ�ȭ �Ͻʽÿ�. ���� �ӽ� ������ �Ҵ��� �ڿ��� �����Ͻʽÿ�.");
		System.out.print("CPU�� ��� �����ұ�� (���� 0�� ����)? ");
		VML[0]=in.nextInt();
		System.out.print("RMA�� �� GB�� �����ұ�� (���� 0GB ��밡��, ����: GB)? ");
		VML[1]=in.nextInt();
		System.out.print("DISK�� �� GB�� �����ұ�� (���� 0GB ��밡��, ����: GB)? ");
		VML[2]=in.nextInt();
		System.out.println("����ӽ� ������ ���� �ڿ� ������ �Ϸ�Ǿ����ϴ�.\n");
	
		while(control != 4) {
			System.out.println(">>����ӽ� ������ ȭ���Դϴ�.");
			System.out.println("���� CPU " + VML[0] +"��, RAM "+ VML[1] + "GB, DISK " + VML[2] + "GB�� ��밡���մϴ�. ���� �������� ����ӽ��� " +  VML[3] +  "���Դϴ�.");
			System.out.println("� �۾��� �ϱ�ڽ��ϱ�? (1: ����ӽ� ����, 2: ����ӽ� ����, 3: ����ӽ� ���, 4: ����)");
			control=in.nextInt();
			switch(control) {
			case 1 :
				if(VML[0] == 0) {
					System.out.println("�Ҵ� ������ CPU�ڿ��� �����ϴ�. ����ӽ��� ������ �� �����ϴ�.\n");
					break;	
				}
				else if(VML[1] == 0) {
					System.out.println("�Ҵ� ������ RAM�ڿ��� �����ϴ�. ����ӽ��� ������ �� �����ϴ�.\n");
					break;	
				}
				else if(VML[2] == 0) {
					System.out.println("�Ҵ� ������ DISK�ڿ��� �����ϴ�. ����ӽ��� ������ �� �����ϴ�.\n");
					break;	
				}
				
				System.out.println("����ӽ��� �����մϴ�.");
				System.out.print("����ӽ��� �̸��� �����Դϱ�? ");
				temp_n = sc.nextLine();
				
				System.out.print("CPU�� �� ���� �Ҵ��ұ�� (����  " + VML[0] + "�� ����) ? ");
				temp_c = in.nextInt();
				if(temp_c > VML[0]) {
					System.out.println("�Ҵ� ������ CPU�ڿ��� �����ϴ�. ����ӽ��� ������ �� �����ϴ�.\n");
					break;
				}
				VML[0] -= temp_c; 
				
				System.out.print("RAM�� ��  GB�� �Ҵ��ұ�� (����  " + VML[1] + "GB ��밡��, ���� : GB) ? ");
				temp_r = in.nextInt();
				if(temp_r > VML[1]) {
					System.out.println("�Ҵ� ������ RAM�ڿ��� �����ϴ�. ����ӽ��� ������ �� �����ϴ�.\n");
					break;
				}
				VML[1] -= temp_r;
				
				System.out.print("DISK�� ��  GB�� �Ҵ��ұ�� (����  " + VML[2] + "GB ��밡��, ���� : GB) ? ");
				temp_d = in.nextInt();
				if(temp_d > VML[2]) {
					System.out.println("�Ҵ� ������ DISK�ڿ��� �����ϴ�. ����ӽ��� ������ �� �����ϴ�.\n");
					break;
				}
				VML[2] -= temp_d;
				
				vim[VML[3]] = new V_M(temp_n, temp_c, temp_r, temp_d);
				System.out.println("����ӽ��� �����Ǿ����ϴ�.");
				System.out.print("| NAME |");
				System.out.print(" CPU |");
				System.out.print(" RAM |");
				System.out.print(" DISK |\n");
				System.out.println(vim[VML[3]].get_name() + "    | " + vim[VML[3]].get_CPU() + "   | " + vim[VML[3]].get_RAM() + "  | " + vim[VML[3]].get_DISK() + "\n" );
				VML[3]++;
				break;
				
			case 2 :
				if(VML[3] == 0) {
					System.out.println("������ ����ӽ��� �����ϴ�.\n");
					break;
				}
				else {
					Pr_VML(vim, VML);
					System.out.println("������ ����ӽ��� �̸��� �����Դϱ�? ");
					del_n = sc.nextLine();
					Del_VM(vim, VML, del_n);
					System.out.println("����ӽ� " + del_n + "�� �����Ǿ� �ڿ��� ȸ���Ǿ����ϴ�.\n");
					break;
				}
				
			case 3 : 
				Pr_VML(vim, VML);
				System.out.print("\n");
				break;
				
			case 4 : 
				break;
				
			default :
				break;
			}
		}
		System.out.print("���α׷��� �����մϴ�.");	
	}
	
	
	
	
	public static void Pr_VML(V_M[] vim, int[] VML) {
		System.out.print("| NAME |");
		System.out.print(" CPU |");
		System.out.print(" RAM |");
		System.out.print(" DISK |\n");
		
		for(int i = 0; i < VML[3]; i++) {
			System.out.print(vim[i].get_name() + "    | " + vim[i].get_CPU() + "   | " + vim[i].get_RAM() + "  | " + vim[i].get_DISK() + "\n" );
		}
	}
	
	public static void Del_VM(V_M[] vim, int[] VML, String del_n) {
		
		V_M[] temp_v = new V_M[MAX];
		
		for(int i = 0; i<VML[3]; i++) {
			if(del_n.contentEquals(vim[i].get_name())) {
				VML[0] += vim[i].get_CPU();
				VML[1] += vim[i].get_RAM();
				VML[2] += vim[i].get_DISK();
				if(i == VML[3]-1) {
					VML[3]--;
					break;
				}
				else {
					for(int k = i+1; k<VML[3]; k++) {
						temp_v[k-i-1] = vim[k];
					}
					for(int j = i; j<VML[3]-1; j++) {
						vim[j] = temp_v[j-i];
					}
					VML[3]--;
					break;
				}
				

			}
		}
		
	}
}









class V_M
{
	private String name;
	private int CPU_NUM;
	private int RAM_NUM;
	private int DISK_NUM;

	public V_M(String n, int c, int r, int d) {
		name = n;
		CPU_NUM = c;
		RAM_NUM = r;
		DISK_NUM = d;
	}

	public String get_name() {
		return name;
	}
	
	public int get_CPU() {
		return CPU_NUM;
	}

	public int get_RAM() {
		return RAM_NUM;
	}

	public int get_DISK() {
		return DISK_NUM;
	}
}