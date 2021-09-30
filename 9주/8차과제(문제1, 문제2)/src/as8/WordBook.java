package as8;

import java.util.ArrayList;

public class WordBook implements AutoCloseable {
	   ArrayList<String> list;
	   public WordBook(ArrayList<String> list) {
		   this.list = list;
		   System.out.println("=====Created words=====");
		   System.out.println(list);
	   }
	   public int getSize() {
		   return list.size();
	   }
	   public void enter(String name) throws Exception {

		  Exception e1 = new Exception("You must type a word! Your input is empty!");
		  Exception e2 = new Exception(name + " is not in the WorkBook");
		  
		  if(list.contains(name)) {
			  list.remove(name);
			  System.out.println(name + " Deleted");
		  }
		  else if(name.equals("")) {
			  throw e1;
		  }
		  else{
			  throw e2;
		  }

	   }
	   @Override
	   public void close() throws Exception {
		   System.out.println("=====Remained words=====");
		   System.out.println(list);
	   }
	}
