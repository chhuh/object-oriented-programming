package as10;

import java.util.*;

public class q1 {
	   public static void main(String[] args) {
		   String[] names = {"Lasandra Packer", "Oren Evan", "Danelle Wasko", "Rich Havel", "Kristle woodruff", "Tara Witt", "Patti Kellner", "Thranh Bunkley", "Lorranie Skelly", "Lorranie Skelly"};
		   String[] phoneNumbers = {"(958) 416-6820", "(958) 416-6820", "(422) 559-3857", "(673) 509-8613", "(551) 981-6195", "(513) 781-8347", "(892) 408-6187", "(554) 452-6981", "(531) 558-3976", "(260) 206-2730"};
		   String[] deleteNames = {"Lasandra Packer", "same name"};
		   
		   PhoneBook ph;
		   // fill
		   ph = new PhoneBook();
		   
		   System.out.println("### Add information to the phone book");
		   // fill
		   for(int i =0; i<names.length; i++)
		   {
			   if(!ph.add(names[i], phoneNumbers[i]))
			   {
				   Person t_p = new Person(names[i], phoneNumbers[i]);
				   System.out.println("Add failure: Duplicate name or phone number: " +  t_p.toString());
			   }
		   }
		   System.out.println();
		   
		   System.out.println("### Delete information");
		   // fill
		   for(int i =0; i<deleteNames.length; i++)
		   {
			   if(!ph.delete(deleteNames[i]))
			   {
				   System.out.println("Delete failure - No such name: " +  "(" + deleteNames[i] + ")");
			   }
		   }
		   
		   System.out.println();
		   
		   System.out.println("### List of all the Person objects in the phone book");
		   // fill
		   Set<Person> pn = ph.list();
		   for(Person p : pn) {
			   System.out.println(p.toString());
		   }
		   
		   System.out.println();
		   
	   }
}

