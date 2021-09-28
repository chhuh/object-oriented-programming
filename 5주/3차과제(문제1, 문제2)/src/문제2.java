import java.util.*;
public class ¹®Á¦2
{
	public static void main(String[] args) {
		
		Scanner in_s = new Scanner(System.in);
		Scanner in_i = new Scanner(System.in);
		Scanner in_d = new Scanner(System.in);
		
		String temp_Model = "";
		int temp_Year = 0;
		double temp_Price = 0;
		
		Car car1 = new Car(temp_Model, temp_Year, temp_Price);
		Car car2 = new Car(temp_Model, temp_Year, temp_Price);
		Car cheap_car = new Car(temp_Model, temp_Year, temp_Price);
		
		
		
		System.out.println("Enter the Car1's model");
		temp_Model = in_s.nextLine();
		System.out.println("Enter the Car1's year");
		temp_Year = in_i.nextInt();
		System.out.println("Enter the Car1's price");		
		temp_Price = in_d.nextDouble();
		car1.set_Model(temp_Model);
		car1.set_Year(temp_Year);
		car1.set_Price(temp_Price);
		
		System.out.println("Enter the Car2's model");
		temp_Model = in_s.nextLine();
		System.out.println("Enter the Car2's year");
		temp_Year = in_i.nextInt();
		System.out.println("Enter the Car2's price");		
		temp_Price = in_d.nextDouble();
		car2.set_Model(temp_Model);
		car2.set_Year(temp_Year);
		car2.set_Price(temp_Price);
		
		cheap_car = cheap_Car(car1, car2);
		
		System.out.println("=======");
		System.out.println("Car1's info");
		System.out.println("Model: " + car1.get_Model());
		System.out.println("Year: " + car1.get_Year());
		System.out.println("Price: " + car1.get_Price());
		System.out.println("Car2's info");
		System.out.println("Model: " + car2.get_Model());
		System.out.println("Year: " + car2.get_Year());
		System.out.println("Price: " + car2.get_Price());

		System.out.println("=======");
		System.out.println("Cheaper Car: " + cheap_car.get_Model());
		
	}
	
	public static Car cheap_Car(Car car1, Car car2) {
		
		String temp_Model = "";
		int temp_Year = 0;
		double temp_Price = 0;
		
		Car cheap_car = new Car(temp_Model, temp_Year, temp_Price);
		
		if(car1.get_Price() > car2.get_Price()) {
			cheap_car = car2;
		}
		else {
			cheap_car = car1;
		}
		return cheap_car;
	}
	
}


class Car
{
	private String model;
	private int year;
	private double price;

	public Car(String model, int year, double price) {
		
		this.model = model;
		this.year = year;
		this.price = price;
	}

	public String get_Model() {
		return model;
	}
	
	public int get_Year() {
		return year;
	}

	public double get_Price() {
		return price;
	}
	
	public void set_Model(String model) {
		this.model = model;
	}
	
	public void set_Year(int year) {
		this.year = year;
	}

	public void set_Price(double price) {
		this.price = price;
	}
	
}

