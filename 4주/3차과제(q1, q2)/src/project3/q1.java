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
		
	
		System.out.println(">>가상머신 관리자가 처음 실행되었습니다. 가상 자원을 초기화 하십시오. 가상 머신 생성에 할당할 자원을 설정하십시오.");
		System.out.print("CPU는 몇개를 설정할까요 (현재 0개 남음)? ");
		VML[0]=in.nextInt();
		System.out.print("RMA는 몇 GB를 설정할까요 (현재 0GB 사용가능, 단위: GB)? ");
		VML[1]=in.nextInt();
		System.out.print("DISK는 몇 GB를 설정할까요 (현재 0GB 사용가능, 단위: GB)? ");
		VML[2]=in.nextInt();
		System.out.println("가상머신 생성을 위한 자원 설정이 완료되었습니다.\n");
	
		while(control != 4) {
			System.out.println(">>가상머신 관리자 화면입니다.");
			System.out.println("현재 CPU " + VML[0] +"개, RAM "+ VML[1] + "GB, DISK " + VML[2] + "GB가 사용가능합니다. 현재 구동중인 가상머신은 " +  VML[3] +  "개입니다.");
			System.out.println("어떤 작업을 하기겠습니까? (1: 가상머신 생성, 2: 가상머신 삭제, 3: 가상머신 목록, 4: 종료)");
			control=in.nextInt();
			switch(control) {
			case 1 :
				if(VML[0] == 0) {
					System.out.println("할당 가능한 CPU자원이 없습니다. 가상머신을 생성할 수 없습니다.\n");
					break;	
				}
				else if(VML[1] == 0) {
					System.out.println("할당 가능한 RAM자원이 없습니다. 가상머신을 생성할 수 없습니다.\n");
					break;	
				}
				else if(VML[2] == 0) {
					System.out.println("할당 가능한 DISK자원이 없습니다. 가상머신을 생성할 수 없습니다.\n");
					break;	
				}
				
				System.out.println("가상머신을 생성합니다.");
				System.out.print("가상머신의 이름은 무엇입니까? ");
				temp_n = sc.nextLine();
				
				System.out.print("CPU는 몇 개를 할당할까요 (현재  " + VML[0] + "개 남음) ? ");
				temp_c = in.nextInt();
				if(temp_c > VML[0]) {
					System.out.println("할당 가능한 CPU자원이 없습니다. 가상머신을 생성할 수 없습니다.\n");
					break;
				}
				VML[0] -= temp_c; 
				
				System.out.print("RAM은 몇  GB를 할당할까요 (현재  " + VML[1] + "GB 사용가능, 단위 : GB) ? ");
				temp_r = in.nextInt();
				if(temp_r > VML[1]) {
					System.out.println("할당 가능한 RAM자원이 없습니다. 가상머신을 생성할 수 없습니다.\n");
					break;
				}
				VML[1] -= temp_r;
				
				System.out.print("DISK은 몇  GB를 할당할까요 (현재  " + VML[2] + "GB 사용가능, 단위 : GB) ? ");
				temp_d = in.nextInt();
				if(temp_d > VML[2]) {
					System.out.println("할당 가능한 DISK자원이 없습니다. 가상머신을 생성할 수 없습니다.\n");
					break;
				}
				VML[2] -= temp_d;
				
				vim[VML[3]] = new V_M(temp_n, temp_c, temp_r, temp_d);
				System.out.println("가상머신을 생성되었습니다.");
				System.out.print("| NAME |");
				System.out.print(" CPU |");
				System.out.print(" RAM |");
				System.out.print(" DISK |\n");
				System.out.println(vim[VML[3]].get_name() + "    | " + vim[VML[3]].get_CPU() + "   | " + vim[VML[3]].get_RAM() + "  | " + vim[VML[3]].get_DISK() + "\n" );
				VML[3]++;
				break;
				
			case 2 :
				if(VML[3] == 0) {
					System.out.println("삭제할 가상머신이 없습니다.\n");
					break;
				}
				else {
					Pr_VML(vim, VML);
					System.out.println("삭제할 가상머신의 이름은 무엇입니까? ");
					del_n = sc.nextLine();
					Del_VM(vim, VML, del_n);
					System.out.println("가상머신 " + del_n + "이 삭제되어 자원이 회수되었습니다.\n");
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
		System.out.print("프로그램을 종료합니다.");	
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