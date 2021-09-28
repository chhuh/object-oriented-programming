package project3;

import java.util.*;
import java.lang.*;

public class q2 {
	
	private static final int length = 26;
	private static int[]i_alp_up = new int[length];
	private static int[]i_alp_low = new int[length];
	private static char[]c_alp_up = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
	private static char[]c_alp_low = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
	
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		int A = 65;
		int a = 97;
		
		int df = 1;
		
		String s ="";
		
		for(int i = 0; i<length; i++) {
			i_alp_up[i] = A++;
			i_alp_low[i] = a++;
		}
		while(df != 0) {
			System.out.println(">> AI챗봇: 네, 뺄셈에 사용할 알파벳 2개를 입력해 주세요.");
			s = in.nextLine();
			char[] ch_arr = s.toCharArray();
			System.out.print(">> AI챗봇: " + Up_or_Low(ch_arr[0]) + " " + ch_arr[0] + "의 값은 " + get_num(ch_arr[0]) + ", " + Up_or_Low(ch_arr[2]) + " " + ch_arr[2] + "의 값은 " + get_num(ch_arr[2]) + "입니다. ");
			df = determine(ch_arr[0], ch_arr[2]);
		}
		System.out.println("프로그램을 종료합니다.");
		
	}
	
	
	
	
	public static int determine(char l_o, char r_o) {
		if(alp_cmp(l_o, r_o)) {
			int result = get_num(l_o) - get_num(r_o);
			System.out.println("뺄셈 결과는 양수이며, " +  result + " 입니다.");
			return 1;
		}
		else {
			System.out.println("좌항이 우항보다 작습니다.\n뺄셈 결과가 음수가 되는 것은 학습되지 않은 조건입니다.");
			return 0;
		}
	}

	public static String Up_or_Low(char alp) {
		String temp = "";
		if(get_num(alp)>=65 && get_num(alp)<=90) {
			temp = "대문자";
			return temp;
		}
		else {
			temp = "소문자";
			return temp;
		}
	}
		
	public static int get_num(char alp) {
		int alp_num=0;
		
		for(int i = 0; i<26; i++) {
			if(alp == c_alp_up[i]) {
				alp_num = i_alp_up[i];
				break;
			}
			if(alp == c_alp_low[i]) {
				alp_num = i_alp_low[i];
				break;
			}
		}
		return alp_num;

	}
	
	public static boolean alp_cmp(char alp1, char alp2) {
		
		if(get_num(alp1)>get_num(alp2)) {
			return true;
		}
		else {
			return false;
		}
	}
	
}
