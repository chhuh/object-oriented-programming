package as10;

import java.util.*;

public class PhoneBook {
	private HashMap<String, String> phoneBook;
	
	public PhoneBook() {phoneBook = new HashMap<String, String>();};
	
	public Boolean add(String name, String phoneNumber) {
		if(phoneBook.containsKey(name) || phoneBook.containsValue(phoneNumber)) {
			return false;
		}
		else {
			phoneBook.put(name, phoneNumber);
			return true;
		}
	}
	
	public Boolean delete(String name) {
		if(phoneBook.containsKey(name)) {
			phoneBook.remove(name);
			return true;
		}
		else {
			return false;
		}
	}
	
	public Set<Person> list(){
		Set<Person> Per = new HashSet<Person>();
		
		for(HashMap.Entry<String, String> entry : phoneBook.entrySet()) {
			Person t_p = new Person(entry.getKey(), entry.getValue());
			Per.add(t_p);
		}
		
		return Per;
	}
	
	
	
}
