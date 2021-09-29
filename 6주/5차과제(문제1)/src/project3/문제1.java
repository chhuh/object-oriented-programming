package project3;

import java.util.*;

public class 문제1 {

	// 미로 생성하기
	public static int row = 10, col = 10;
	public static String [][] maze_matrix = new String[][] {{"GY","GY","W","GY","W","W","W","W","GY","W"},{"S","W","W","GY","W","GN","GN","W","GY","D"},{"GY","GY","W","GY","W","GY","GY","W","GY","W"},{"W","W","W","GY","W","GY","GY","W","GY","W"},{"GY","W","GN","W","W","W","W","GN","W","W"},{"W","W","GN","W","GY","GY","W","GY","W","W"},{"W","GY","GN","W","W","GN","W","GY","W","GY"},{"W","W","GY","W","W","GN","W","W","W","GY"},{"W","GY","W","W","GY","GY","GY","GY","W","W"},{"W","W","W","W","W","W","W","W","GN","GY"}};
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		String Y_N;
		
		int D_N1 = 0; // decision number : 무엇을 할지 결정하는 역할을 수행
		
		while(D_N1 != 6) // 프로그램 무한 루프 시작
		{
			// 초기값 설정
			int hp = 30;
			Brick ME = new Brick(2,1,maze_matrix[1][0],hp);
			
			System.out.println("미로 출구 찾기 프로그램입니다. 미로의 크기는 가로 10, 세로 10 입니다.");
			System.out.println("출발지 A지점의 좌표는 A(2,1) 입니다. 도착지 B지점의 좌표는 B(2,10) 입니다.");
			System.out.println("미로에 들어가겠습니까?");
			Y_N = in.next();
			
			if(Y_N.equals("no")) {
				break;
			}
			// 미로 입장시키기
			else {
				System.out.println("미로에 입장하였습니다.");
				
				
				while(ME.get_hp() != -1) // 미로에서 길을 찾는 무한루프 생성
				{
					System.out.print(ME.brief()); //현재 자신의 위치 및 체력 표시
					
					// 체력이 모두 소진 될때까지 도착지에 도착하지 못한 경우
					if(ME.get_type() != "D" && ME.get_hp() == 0) {
						System.out.println("\n어떻게 할까요? (5: 다시하기)");
					}
					
					// 어떤 업무를 수행할지 입력 받음
					else {
						System.out.println("\n어떻게 할까요? (1: 위로 이동, 2: 아래로 이동, 3: 좌로 이동, 4. 우로 이동, 5: 다시하기)");
					}
					D_N1 = in.nextInt();
					
					// 입력 받은 D_N에 따른 수행
					switch(D_N1) {
					case 1:
						boolean move, green;
						
						// 이동 가능한 블록인지 확인
						move = verify_movable((ME.get_r()-1)-1,(ME.get_c()-1));
						if(move) {
							 
							// 나아갈 블록이 초록색인지 확인
							green = check_green((ME.get_r()-1)-1,(ME.get_c()-1));
							if(green) 
							{
								// 초록색 칸으로 이동할지를 물어봄
								String ask_gn;
								System.out.println("녹색 칸입니다. 체력이 2 감소합니다. 이동합니까?");
								ask_gn = in.next();
								
								// 이동에 따른 자신의 위치, 체력, 서있는 블록타입 수정
								if(ask_gn.equals("yes")) {
									ME.set_r(ME.get_r()-1);
									ME.set_hp(ME.get_hp()-2);
									ME.set_type(maze_matrix[(ME.get_r()-1)][(ME.get_c()-1)]);
									System.out.println("이동하였습니다.");
									break;
								}
								else {
									break;
								}
							}
							
							// 이동에 따른 자신의 위치, 체력, 서있는 블록타입 수정
							else {
								ME.set_r(ME.get_r()-1);
								ME.set_hp(ME.get_hp()-1);
								ME.set_type(maze_matrix[(ME.get_r()-1)][(ME.get_c()-1)]);
								System.out.println("이동하였습니다.");
								break;
							}
						}
						
						// 이동불가능한 블록임을 사용자에게 알림
						else {
							System.out.println("이동할 수 없습니다.");
							break;
						}
					case 2:
						
						// 이동 가능한 블록인지 확인
						move = verify_movable((ME.get_r()-1)+1,(ME.get_c()-1));
						if(move) {
							
							// 나아갈 블록이 초록색인지 확인
							green = check_green((ME.get_r()-1)+1,(ME.get_c()-1));
							if(green) {
								
								// 초록색 칸으로 이동할지를 물어봄
								String ask_gn;
								System.out.println("녹색 칸입니다. 체력이 2 감소합니다. 이동합니까?");
								ask_gn = in.next();
								
								// 이동에 따른 자신의 위치, 체력, 서있는 블록타입 수정
								if(ask_gn.equals("yes")) {
									ME.set_r(ME.get_r()+1);
									ME.set_hp(ME.get_hp()-2);
									ME.set_type(maze_matrix[(ME.get_r()-1)][(ME.get_c()-1)]);
									System.out.println("이동하였습니다.");
									break;
								}
								else {
									break;
								}
							}
							
							// 이동에 따른 자신의 위치, 체력, 서있는 블록타입 수정
							else {
								ME.set_r(ME.get_r()+1);
								ME.set_hp(ME.get_hp()-1);
								ME.set_type(maze_matrix[(ME.get_r()-1)][(ME.get_c()-1)]);
								System.out.println("이동하였습니다.");
								break;
							}
						}
						
						// 이동불가능한 블록임을 사용자에게 알림
						else {
							System.out.println("이동할 수 없습니다.");
							break;
						}
					case 3:
						
						// 서있는 위치가 출발지인 경우 좌로 이동시 입구임을 알림
						if(ME.get_type() == "S") {System.out.print("입구입니다.");}
						
						// 이동 가능한 블록인지 확인
						move = verify_movable((ME.get_r()-1),(ME.get_c()-1)-1);
						if(move) {
							
							// 나아갈 블록이 초록색인지 확인
							green = check_green((ME.get_r()-1),(ME.get_c()-1)-1);
							if(green) {
								
								// 초록색 칸으로 이동할지를 물어봄
								String ask_gn;
								System.out.println("녹색 칸입니다. 체력이 2 감소합니다. 이동합니까?");
								ask_gn = in.next();
								
								// 이동에 따른 자신의 위치, 체력, 서있는 블록타입 수정
								if(ask_gn.equals("yes")) {
									ME.set_c(ME.get_c()-1);
									ME.set_hp(ME.get_hp()-2);
									ME.set_type(maze_matrix[(ME.get_r()-1)][(ME.get_c()-1)]);
									System.out.println("이동하였습니다.");
									break;
								}
								else {
									break;
								}
							}
							
							// 이동에 따른 자신의 위치, 체력, 서있는 블록타입 수정
							else {
								ME.set_c(ME.get_c()-1);
								ME.set_hp(ME.get_hp()-1);
								ME.set_type(maze_matrix[(ME.get_r()-1)][(ME.get_c()-1)]);
								System.out.println("이동하였습니다.");
								break;
							}
						}
						
						// 이동불가능한 블록임을 사용자에게 알림
						else {
							System.out.println("이동할 수 없습니다.");
							break;
						}
					case 4:
						// 도착지에서 우로 이동할 경우 출구임을 알리고 프로그램 종료
						if(ME.get_type() == "D") {
							System.out.println("이동하였습니다.");
							D_N1 = 6; ME.set_hp(-1);
							System.out.print("출구입니다.");
							break;
						}
						
						// 이동 가능한 블록인지 확인
						move = verify_movable((ME.get_r()-1),(ME.get_c()-1)+1);
						if(move) {
							
							// 나아갈 블록이 초록색인지 확인
							green = check_green((ME.get_r()-1),(ME.get_c()-1)+1);
							if(green) {
								
								// 초록색 칸으로 이동할지를 물어봄
								String ask_gn;
								System.out.println("녹색 칸입니다. 체력이 2 감소합니다. 이동합니까?");
								ask_gn = in.next();
								
								// 이동에 따른 자신의 위치, 체력, 서있는 블록타입 수정
								if(ask_gn.equals("yes")) {
									ME.set_c(ME.get_c()+1);
									ME.set_hp(ME.get_hp()-2);
									ME.set_type(maze_matrix[(ME.get_r()-1)][(ME.get_c()-1)]);
									System.out.println("이동하였습니다.");
									break;
								}
								else {
									break;
								}
							}
							
							// 이동에 따른 자신의 위치, 체력, 서있는 블록타입 수정
							else {
								ME.set_c(ME.get_c()+1);
								ME.set_hp(ME.get_hp()-1);
								ME.set_type(maze_matrix[(ME.get_r()-1)][(ME.get_c()-1)]);
								System.out.println("이동하였습니다.");
								break;
							}
						}
						
						// 이동불가능한 블록임을 사용자에게 알림
						else {
							System.out.println("이동할 수 없습니다.");
							break;
						}
					
					case 5:
						
						// 다시할것인지 물어봄
						String ag;
						System.out.print("다시 하겠습니까? ");
						ag = in.next();
						
						// 아닌 경우 현재 자신의 위치, 체력, 메뉴창을 표시
						if(ag.equals("no")) {
							break;
						}
						
						// 다시하기를 선택한 경우 프로그램을 다시 처음부터 시작
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
	System.out.println("프로그램을 종료합니다.");
	}
	


	// 이동가능한 블록인지 확인하는 method
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

	
	// 블록이 초록색인지 확인하는 method
	public static boolean check_green(int row, int col) {
		if (maze_matrix[row][col] == "GN") {
			 return true;
		 }
		 else {
			 return false;
		 }
	}
	



}


// 블록의 위치, 타입, 및 현재 자신의 체력을 포함하는 class
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
	
	//블록 타입에 맞는 자신의 현재 상태 표시
	public String brief() {
		if(this.type == "S"){
			return ">> 현재 위치는" + r + "," + c + "입니다. 출발지입니다. 체력은 " + hp + "입니다.";
		}
		else if(this.type == "D"){
			return ">> 현재 위치는" + r + "," + c + "입니다. 도착지입니다. 체력은 " + hp + "입니다.";
		}
		else if(this.type != "D" && this.hp == 0){
			return  ">> 현재 위치는" + r + "," + c + "입니다. 체력은 " + hp + "입니다. 이동할 수 업습니다.";
		}
		else {
			return  ">> 현재 위치는" + r + "," + c + "입니다. 체력은 " + hp + "입니다.";
		}

	}
}
	
	