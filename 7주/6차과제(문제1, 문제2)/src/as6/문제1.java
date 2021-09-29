package as6;

import java.util.*;

public class 문제1
{
	
	public static void main(String[] args) {
	
		
		Scanner in = new Scanner(System.in);
		
		double temp_length=0;
		double temp_height=0;
		double temp_radius=0;
		
		System.out.print("Enter a length: ");
		temp_length = in.nextInt();
		System.out.print("Enter a height: ");
		temp_height = in.nextInt();
		System.out.print("Enter a radius: ");
		temp_radius = in.nextInt();
		
		Shape triangle = new Triangle(temp_length, temp_height);
		Shape rectangle = new Rectangle(temp_length, temp_height);
		Shape circle = new Circle(temp_radius);
		
		
		
		triangle.calculateArea();
		rectangle.calculateArea();
		circle.calculateArea();
		
		
		
	}
}

class Shape
{
	protected double length;
	protected double height;

	public Shape() {
		length =0;
		height=0;
	}
	
	public double get_length() {
		return length;
	}
		
	public double get_height() {
		return height;
	}

	public void set_width(double length) {
		this.length = length;
	}
		
	public void set_height(int height) {
		this.height = height;
	}
		
	public void calculateArea() {
		System.out.println("잘못된 명령");
	}
}

class Triangle extends Shape
{
	public Triangle(double length, double height) {
		this.length = length;
		this.height = height;
	}
	
	@Override
	public void calculateArea() {
		System.out.println("Triangle area: " + (get_length()*get_height())/2);
	}
}

class Rectangle extends Shape
{
	public Rectangle(double length, double height) {
		this.length = length;
		this.height = height;
	}
	
	@Override
	public void calculateArea() {
		System.out.println("Rectangle area: " + get_length()*get_height());
	}
}

class Circle extends Shape
{
	private double radius;

	public Circle(double radius) {
		this.radius = radius;
	}
	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	@Override
	public void calculateArea() {
		System.out.println("Circle area: " + Math.pow(radius, 2)*Math.PI);
	}
}
