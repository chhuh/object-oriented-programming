import java.util.*;
public class ¹®Á¦2
{
	private static final int MAX = 10;
	private static int top = 0;
	private static int[]s = new int[MAX];
	
	public static void main(String[] args)
	{	
		int e_n;
		int i=1;
		
		String run = "";
		
		Scanner sc = new Scanner(System.in);
		Scanner in = new Scanner(System.in);
		System.out.println("Please enter the number of N between 1 and 20.");
		e_n=sc.nextInt();
		for(i=0; i<e_n; i++) {
			run = "";
			run = in.nextLine();
			stack_work(run);
		}
	}
	
	
	public static void pop() {
		if(top==0) {
			System.out.println("-1");
		}
		else {
			System.out.println(s[--top]);
		}
		return;
	}
	
	public static void push(int x) {
		if(top == MAX) {
			System.out.println("Full!");
			System.exit(-1);
		}
		else {
			s[top++] = x;
			return;
		}
	}
	
	public static void stack_work(String run) {
		int p;
		int l;
		String temp;
		String n_s;
		
		Scanner sc = new Scanner(System.in);
		
		n_s = run.substring(0,3);
		switch(n_s){
		case "pus" :
			l = run.length();
			temp = (run.substring(5,l));
			p = Integer.parseInt(temp);
			push(p);
			break;
		
		case "pop" :
			pop();
			break;
			
		case "top" :
			if(top==0) {
				System.out.println("-1");
			}
			else {
				System.out.println(s[top-1]);
			}
		break;
		default : 
			break;
		}
		return;
	}
}