import java.util.*;
public class 문제1
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int i1, i2;
		int m;

		int[] res1;
		res1 = new int[2];
		
		int[] res2;
		res2 = new int[2];
		
		System.out.println("Please enter two numbers between 1 and 100.");
		i1 = sc.nextInt();		
		i2 = sc.nextInt();
		fib_no(i1,i2,res1);
		
		Scanner in = new Scanner(System.in);
		System.out.println("Please enter condition among(홀수, 짝수, 배수, 약수)");
		String cond = in.nextLine();
		switch(cond) {
			case"홀수" : 
				fib_odd_even(i1,i2,1,res2);
				break;
			case"짝수" : 
				fib_odd_even(i1,i2,0,res2);
				break;
			case"약수" : 
				System.out.println("Please enter number");	
				m = sc.nextInt();
				fib_div(i1,i2,m,res2);	
				break;
			case"배수" : 
				System.out.println("Please enter number");	
				m = sc.nextInt();
				fib_mul(i1,i2,m,res2);
				break;
			default:
				break;
		}
		System.out.println(res1[0]+"," + res2[0]+"," + res1[1]+"," + res2[1]);
		big(res1[0], res2[0], res1[1], res2[1]);
	}	
	
	
	static int fibonacci(int n) {
		if (n==0 || n==1) {
			return 1;
		}
		else {
			return fibonacci(n-1) + fibonacci(n-2);
		}
	}
	
	
	
	static void fib_no(int n1, int n2, int[] res1) {
		int[] numarr;
		numarr = new int[100];
		int sum =0;
		int n=1;
		int c=0;
		while(1>0) {
			if(fibonacci(n) < n1){
				n++;
				continue;
			}
			else if(fibonacci(n) >= n1 && fibonacci(n) <= n2) {
				numarr[c] = fibonacci(n);
				c++;
				n++;
			}
			else {
				break;
			}
		}
		for(int e: numarr)
			sum = sum + e;
	System.out.println(n1 + "부터 " + n2 + "까지의 피보나치 수의 합은 " + sum + "이며, 평균은" + sum/c + "이다.");
	res1[0] = sum;
	res1[1] = sum/c;
	}


	static void fib_odd_even(int n1, int n2, int oe,int[] res2) {
		int[] numarr;
		numarr = new int[100];
		int sum =0;
		int n=1;
		int c=0;
		int d;
		if(oe==1) {
			d = 1;
		}
		else {
			d = 0;
		}
		while(1>0) {
			if(fibonacci(n) < n1){
				n++;
				continue;
			}
			else if(fibonacci(n) >= n1 && fibonacci(n) <= n2) {
				if(fibonacci(n)%2==d) {
					numarr[c] = fibonacci(n);
					c++;
					n++;
				}
				else {
					n++;
				}
			}
			else {
				break;
			}
		}
		for(int e: numarr)
			sum = sum + e;
		if(d==0){
			System.out.println(n1 + "부터 " + n2 + "까지의 짝수인 피보나치 수의 합은 " + sum + "이며, 평균은" + sum/c + "이다.");
		}
		else {
			System.out.println(n1 + "부터 " + n2 + "까지의 홀수인 피보나치 수의 합은 " + sum + "이며, 평균은" + sum/c + "이다.");
		}
		res2[0] = sum;
		res2[1] = sum/c;
	}
	
	static void fib_mul(int n1, int n2, int m, int[] res2) {
		int[] numarr;
		numarr = new int[100];
		int sum =0;
		int n=1;
		int c=0;
		while(1>0) {
			if(fibonacci(n) < n1){
				n++;
				continue;
			}
			else if(fibonacci(n) >= n1 && fibonacci(n) <= n2) {
				if(fibonacci(n)%m==0) {
					numarr[c] = fibonacci(n);
					c++;
					n++;
				}
				else {
					n++;
				}
			}
			else {
				break;
			}
		}
		for(int e: numarr)
			sum = sum + e;
		System.out.println(n1 + "부터 " + n2 + "까지" + m + "의 배수인 피보나치 수의 합은 " + sum + "이며, 평균은" + sum/c + "이다.");
		res2[0] = sum;
		res2[1] = sum/c;
	}
	
	
	static void fib_div(int n1, int n2, int m, int[] res2) {
		int[] numarr;
		numarr = new int[100];
		int sum =0;
		int n=1;
		int c=0;
		while(1>0) {
			if(fibonacci(n) < n1){
				n++;
				continue;
			}
			else if(fibonacci(n) >= n1 && fibonacci(n) <= n2) {
				if(m%fibonacci(n)==0) {
					numarr[c] = fibonacci(n);
					c++;
					n++;
				}
				else {
					n++;
				}
			}
			else {
				break;
			}
		}
		for(int e: numarr)
			sum = sum + e;
		System.out.println(n1 + "부터 " + n2 + "까지" + m + "의 약수인 피보나치 수의 합은 " + sum + "이며, 평균은" + sum/c + "이다.");
		res2[0] = sum;
		res2[1] = sum/c;
	}

static void big(int s1, int s2, int a1, int a2) {
		if(s1>=s2 && a1>=a2) {
			System.out.println("큰 합은 " + s1 + " 큰 평균은 " + a1 + "이다.");
		}
		else if(s1>=s2 && a1<a2) {
			System.out.println("큰 합은 " + s1 + " 큰 평균은 " + a2 + "이다.");
		}
		else if(s1<s2 && a1>=a2) {
			System.out.println("큰 합은 " + s2 + " 큰 평균은 " + a1 + "이다.");
		}
		else {
			System.out.println("큰 합은 " + s2 + " 큰 평균은 " + a2 + "이다.");
		}
	}	
}

	