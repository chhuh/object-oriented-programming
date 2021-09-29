package project3;

import java.util.*;

public class ����1 {

	// �̷� �����ϱ�
	public static int row = 10, col = 10;
	public static String [][] maze_matrix = new String[][] {{"GY","GY","W","GY","W","W","W","W","GY","W"},{"S","W","W","GY","W","GN","GN","W","GY","D"},{"GY","GY","W","GY","W","GY","GY","W","GY","W"},{"W","W","W","GY","W","GY","GY","W","GY","W"},{"GY","W","GN","W","W","W","W","GN","W","W"},{"W","W","GN","W","GY","GY","W","GY","W","W"},{"W","GY","GN","W","W","GN","W","GY","W","GY"},{"W","W","GY","W","W","GN","W","W","W","GY"},{"W","GY","W","W","GY","GY","GY","GY","W","W"},{"W","W","W","W","W","W","W","W","GN","GY"}};
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		String Y_N;
		
		int D_N1 = 0; // decision number : ������ ���� �����ϴ� ������ ����
		
		while(D_N1 != 6) // ���α׷� ���� ���� ����
		{
			// �ʱⰪ ����
			int hp = 30;
			Brick ME = new Brick(2,1,maze_matrix[1][0],hp);
			
			System.out.println("�̷� �ⱸ ã�� ���α׷��Դϴ�. �̷��� ũ��� ���� 10, ���� 10 �Դϴ�.");
			System.out.println("����� A������ ��ǥ�� A(2,1) �Դϴ�. ������ B������ ��ǥ�� B(2,10) �Դϴ�.");
			System.out.println("�̷ο� ���ڽ��ϱ�?");
			Y_N = in.next();
			
			if(Y_N.equals("no")) {
				break;
			}
			// �̷� �����Ű��
			else {
				System.out.println("�̷ο� �����Ͽ����ϴ�.");
				
				
				while(ME.get_hp() != -1) // �̷ο��� ���� ã�� ���ѷ��� ����
				{
					System.out.print(ME.brief()); //���� �ڽ��� ��ġ �� ü�� ǥ��
					
					// ü���� ��� ���� �ɶ����� �������� �������� ���� ���
					if(ME.get_type() != "D" && ME.get_hp() == 0) {
						System.out.println("\n��� �ұ��? (5: �ٽ��ϱ�)");
					}
					
					// � ������ �������� �Է� ����
					else {
						System.out.println("\n��� �ұ��? (1: ���� �̵�, 2: �Ʒ��� �̵�, 3: �·� �̵�, 4. ��� �̵�, 5: �ٽ��ϱ�)");
					}
					D_N1 = in.nextInt();
					
					// �Է� ���� D_N�� ���� ����
					switch(D_N1) {
					case 1:
						boolean move, green;
						
						// �̵� ������ ������� Ȯ��
						move = verify_movable((ME.get_r()-1)-1,(ME.get_c()-1));
						if(move) {
							 
							// ���ư� ����� �ʷϻ����� Ȯ��
							green = check_green((ME.get_r()-1)-1,(ME.get_c()-1));
							if(green) 
							{
								// �ʷϻ� ĭ���� �̵������� ���
								String ask_gn;
								System.out.println("��� ĭ�Դϴ�. ü���� 2 �����մϴ�. �̵��մϱ�?");
								ask_gn = in.next();
								
								// �̵��� ���� �ڽ��� ��ġ, ü��, ���ִ� ���Ÿ�� ����
								if(ask_gn.equals("yes")) {
									ME.set_r(ME.get_r()-1);
									ME.set_hp(ME.get_hp()-2);
									ME.set_type(maze_matrix[(ME.get_r()-1)][(ME.get_c()-1)]);
									System.out.println("�̵��Ͽ����ϴ�.");
									break;
								}
								else {
									break;
								}
							}
							
							// �̵��� ���� �ڽ��� ��ġ, ü��, ���ִ� ���Ÿ�� ����
							else {
								ME.set_r(ME.get_r()-1);
								ME.set_hp(ME.get_hp()-1);
								ME.set_type(maze_matrix[(ME.get_r()-1)][(ME.get_c()-1)]);
								System.out.println("�̵��Ͽ����ϴ�.");
								break;
							}
						}
						
						// �̵��Ұ����� ������� ����ڿ��� �˸�
						else {
							System.out.println("�̵��� �� �����ϴ�.");
							break;
						}
					case 2:
						
						// �̵� ������ ������� Ȯ��
						move = verify_movable((ME.get_r()-1)+1,(ME.get_c()-1));
						if(move) {
							
							// ���ư� ����� �ʷϻ����� Ȯ��
							green = check_green((ME.get_r()-1)+1,(ME.get_c()-1));
							if(green) {
								
								// �ʷϻ� ĭ���� �̵������� ���
								String ask_gn;
								System.out.println("��� ĭ�Դϴ�. ü���� 2 �����մϴ�. �̵��մϱ�?");
								ask_gn = in.next();
								
								// �̵��� ���� �ڽ��� ��ġ, ü��, ���ִ� ���Ÿ�� ����
								if(ask_gn.equals("yes")) {
									ME.set_r(ME.get_r()+1);
									ME.set_hp(ME.get_hp()-2);
									ME.set_type(maze_matrix[(ME.get_r()-1)][(ME.get_c()-1)]);
									System.out.println("�̵��Ͽ����ϴ�.");
									break;
								}
								else {
									break;
								}
							}
							
							// �̵��� ���� �ڽ��� ��ġ, ü��, ���ִ� ���Ÿ�� ����
							else {
								ME.set_r(ME.get_r()+1);
								ME.set_hp(ME.get_hp()-1);
								ME.set_type(maze_matrix[(ME.get_r()-1)][(ME.get_c()-1)]);
								System.out.println("�̵��Ͽ����ϴ�.");
								break;
							}
						}
						
						// �̵��Ұ����� ������� ����ڿ��� �˸�
						else {
							System.out.println("�̵��� �� �����ϴ�.");
							break;
						}
					case 3:
						
						// ���ִ� ��ġ�� ������� ��� �·� �̵��� �Ա����� �˸�
						if(ME.get_type() == "S") {System.out.print("�Ա��Դϴ�.");}
						
						// �̵� ������ ������� Ȯ��
						move = verify_movable((ME.get_r()-1),(ME.get_c()-1)-1);
						if(move) {
							
							// ���ư� ����� �ʷϻ����� Ȯ��
							green = check_green((ME.get_r()-1),(ME.get_c()-1)-1);
							if(green) {
								
								// �ʷϻ� ĭ���� �̵������� ���
								String ask_gn;
								System.out.println("��� ĭ�Դϴ�. ü���� 2 �����մϴ�. �̵��մϱ�?");
								ask_gn = in.next();
								
								// �̵��� ���� �ڽ��� ��ġ, ü��, ���ִ� ���Ÿ�� ����
								if(ask_gn.equals("yes")) {
									ME.set_c(ME.get_c()-1);
									ME.set_hp(ME.get_hp()-2);
									ME.set_type(maze_matrix[(ME.get_r()-1)][(ME.get_c()-1)]);
									System.out.println("�̵��Ͽ����ϴ�.");
									break;
								}
								else {
									break;
								}
							}
							
							// �̵��� ���� �ڽ��� ��ġ, ü��, ���ִ� ���Ÿ�� ����
							else {
								ME.set_c(ME.get_c()-1);
								ME.set_hp(ME.get_hp()-1);
								ME.set_type(maze_matrix[(ME.get_r()-1)][(ME.get_c()-1)]);
								System.out.println("�̵��Ͽ����ϴ�.");
								break;
							}
						}
						
						// �̵��Ұ����� ������� ����ڿ��� �˸�
						else {
							System.out.println("�̵��� �� �����ϴ�.");
							break;
						}
					case 4:
						// ���������� ��� �̵��� ��� �ⱸ���� �˸��� ���α׷� ����
						if(ME.get_type() == "D") {
							System.out.println("�̵��Ͽ����ϴ�.");
							D_N1 = 6; ME.set_hp(-1);
							System.out.print("�ⱸ�Դϴ�.");
							break;
						}
						
						// �̵� ������ ������� Ȯ��
						move = verify_movable((ME.get_r()-1),(ME.get_c()-1)+1);
						if(move) {
							
							// ���ư� ����� �ʷϻ����� Ȯ��
							green = check_green((ME.get_r()-1),(ME.get_c()-1)+1);
							if(green) {
								
								// �ʷϻ� ĭ���� �̵������� ���
								String ask_gn;
								System.out.println("��� ĭ�Դϴ�. ü���� 2 �����մϴ�. �̵��մϱ�?");
								ask_gn = in.next();
								
								// �̵��� ���� �ڽ��� ��ġ, ü��, ���ִ� ���Ÿ�� ����
								if(ask_gn.equals("yes")) {
									ME.set_c(ME.get_c()+1);
									ME.set_hp(ME.get_hp()-2);
									ME.set_type(maze_matrix[(ME.get_r()-1)][(ME.get_c()-1)]);
									System.out.println("�̵��Ͽ����ϴ�.");
									break;
								}
								else {
									break;
								}
							}
							
							// �̵��� ���� �ڽ��� ��ġ, ü��, ���ִ� ���Ÿ�� ����
							else {
								ME.set_c(ME.get_c()+1);
								ME.set_hp(ME.get_hp()-1);
								ME.set_type(maze_matrix[(ME.get_r()-1)][(ME.get_c()-1)]);
								System.out.println("�̵��Ͽ����ϴ�.");
								break;
							}
						}
						
						// �̵��Ұ����� ������� ����ڿ��� �˸�
						else {
							System.out.println("�̵��� �� �����ϴ�.");
							break;
						}
					
					case 5:
						
						// �ٽ��Ұ����� ���
						String ag;
						System.out.print("�ٽ� �ϰڽ��ϱ�? ");
						ag = in.next();
						
						// �ƴ� ��� ���� �ڽ��� ��ġ, ü��, �޴�â�� ǥ��
						if(ag.equals("no")) {
							break;
						}
						
						// �ٽ��ϱ⸦ ������ ��� ���α׷��� �ٽ� ó������ ����
						else {
							ME.set_hp(-1);
							break;
						}
					
					default:
						
						break;
					}
				}
			}
		}
	System.out.println("���α׷��� �����մϴ�.");
	}
	


	// �̵������� ������� Ȯ���ϴ� method
	public static boolean verify_movable(int row, int col) {
		if(row<0 || col<0) {
			return false;
		}
		else if(row>=10 || col>=10) {
			return false;
		}
		else if (maze_matrix[row][col] == "GY") {
			 return false;
		 }
		 else {
			 return true;
		 }
	}

	
	// ����� �ʷϻ����� Ȯ���ϴ� method
	public static boolean check_green(int row, int col) {
		if (maze_matrix[row][col] == "GN") {
			 return true;
		 }
		 else {
			 return false;
		 }
	}
	



}


// ����� ��ġ, Ÿ��, �� ���� �ڽ��� ü���� �����ϴ� class
class Brick
{
	private int r;
	private int c;
	private String type;
	private int hp;

	public Brick(int r, int c, String type, int hp) {
		
		this.r = r;
		this.c = c;
		this.type = type;
		this.hp = hp;
	}

	public int get_r() {
		return r;
	}
	
	public int get_c() {
		return c;
	}

	public String get_type() {
		return type;
	}
	
	public int get_hp() {
		return hp;
	}
	
	public void set_r(int r) {
		this.r = r;
	}
	
	public void set_c(int c) {
		this.c = c;
	}
	
	public void set_type(String type) {
		this.type = type;
	}
	
	public void set_hp(int hp) {
		this.hp = hp;
	}
	
	//��� Ÿ�Կ� �´� �ڽ��� ���� ���� ǥ��
	public String brief() {
		if(this.type == "S"){
			return ">> ���� ��ġ��" + r + "," + c + "�Դϴ�. ������Դϴ�. ü���� " + hp + "�Դϴ�.";
		}
		else if(this.type == "D"){
			return ">> ���� ��ġ��" + r + "," + c + "�Դϴ�. �������Դϴ�. ü���� " + hp + "�Դϴ�.";
		}
		else if(this.type != "D" && this.hp == 0){
			return  ">> ���� ��ġ��" + r + "," + c + "�Դϴ�. ü���� " + hp + "�Դϴ�. �̵��� �� �����ϴ�.";
		}
		else {
			return  ">> ���� ��ġ��" + r + "," + c + "�Դϴ�. ü���� " + hp + "�Դϴ�.";
		}

	}
}
	
	