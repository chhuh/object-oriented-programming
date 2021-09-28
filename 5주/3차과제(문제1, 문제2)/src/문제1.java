import java.util.*;

public class ¹®Á¦1
{
	
	public static void main(String[] args) {
	
		Scanner in = new Scanner(System.in);
		
		int temp_width=0;
		int temp_height=0;
		
		Rectangle Rec = new Rectangle(temp_width, temp_height);
		
		System.out.println("Enter a width");
		temp_width = in.nextInt();
		
		System.out.println("Enter a height");
		temp_height = in.nextInt();
		
		Rec.set_width(temp_width);
		Rec.set_height(temp_height);

		String D = String.format("%.1f", Calculate_Diagonal(Rec.get_width(), Rec.get_height()));
		
		System.out.println("Rectangle's info");
		System.out.println("Width: " + Rec.get_width());		
		System.out.println("Height: " + Rec.get_height());
		System.out.println("Area: " + Calculate_Area(Rec.get_width(), Rec.get_height()));
		System.out.println("Diagonal: " + D);
		
	}	
	
	public static double Calculate_Diagonal(int width, int height) {
		double d=0;
		d = Math.sqrt(Math.pow((double)width,2) + Math.pow((double)height,2));
		return d; 
	}
	
	public static int Calculate_Area(int width, int height) {
		int A = 0;
		A = width * height;
		return A;
	}
	
}

class Rectangle
{
	private int width;
	private int height;

	public Rectangle(int width, int height) {
		
		this.width = width;
		this.height = height;
	}

	public int get_width() {
		return width;
	}
	
	public int get_height() {
		return height;
	}

	public void set_width(int width) {
		this.width = width;
	}
	
	public void set_height(int height) {
		this.height = height;
	}
}

	