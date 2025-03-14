import java.util.ArrayList;

public class Stack<J> {
	
	//Data 
	private ArrayList<J> data;
	
	//add a constructor 
	public Stack() {
		
		//initialize the instance vars
		data = new ArrayList<J>();
		
	}
	
	
	public String toString() {
		return data.toString();
	}
	
	/*
	 * Add the element to the Stack
	 */
	public void push(J el) {
		
		
		
		data.add(el); //end of the list is the "TOP"
	}
	
	
	
	/*
	 * remove AND return the top of the stack
	 */
	public J pop() {
		if(data.size() != 0) {
			return data.remove(data.size()-1);
		} else {
			
			return null;
		}
	}
	
	/*
	 * return the size of the stack
	 */
	
	public int size() {
		return data.size();
	}
	
	public J peek() {
		if(data.size() != 0) {
			return data.get(data.size()-1);
		} else {
			return null;
		}
	}
	
	public boolean empty() {
		return data.size() == 0;
	}
	
}
