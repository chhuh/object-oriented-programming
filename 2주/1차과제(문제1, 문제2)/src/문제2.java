import java.util.*;
public class ¹®Á¦2
{
	public static void main(String[] args)
	{	
		Scanner sc = new Scanner(System.in);
		int i;
		System.out.println("Please enter the number of N between 1 and 100.");
		i = sc.nextInt();
		for(int n1 = 0; n1<i; n1++) {
			for(int n2 =0; n2<n1+1; n2++) {
				System.out.print("*");
			}
			System.out.println("");
		}
	}
}