import java.util.ArrayList;

public class Queue<Q> {
	
	//data 
	private Stack<Q> data;
	private Stack<Q> dataB;
	
	public Queue() {
		data = new Stack<Q>();
		dataB = new Stack<Q>();
	}
	
	//Add to the queue
	
	public void enqueu(Q el) {
		
		
		data.push(el);
		
		
	}
	
	//remove from the queue
	//return NULL if empty 
	public Q dequeue() {
		
		if(data.size() != 0) {
			Q first = data.peek();
			dataB = data;
			for(int i = 0; i < data.size()-1; i++) {
				
				data.pop();
			}
			first = data.pop();
			
			for(int i = 0; i < dataB.size(); i++) {
				data.push(dataB.peek());
			}
			
			return first;
			
			
		} else {
			return null;
		}
	}
	
	//return next element in the Queue but do not remove
	public Q peek() {
		if(data.size() != 0) {
			return data.peek();
		} else {
			return null;
		}
		
	}
	
	
	public int size() {
		return data.size();
	}
	
	public String toString() {
		
		if(data.size() == 0 ) {
			return "[]";
		}else {
			dataB = data;
			String all = "[" + dataB.peek() ;
			dataB.pop();
			
			for(int i = 0; i < dataB.size(); i++) {
				all += "," + " " + dataB.peek() ;
				dataB.pop();
				
			}
			
			all += "]";
			
			
			return all;
		}
	
	}
	
	
	
}
