package as10;

public class Person {
	private String name;
	private String phoneNumber;
	
	public Person(String name, String phoneNumber) {
		this.name = name;
		this.phoneNumber = phoneNumber;
	}
	
	public String toString() {
		return "(" + name + ", " + phoneNumber + ")";
	}
	
}
