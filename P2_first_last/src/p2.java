import java.io.File;
import java.io.FileNotFoundException;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class p2 {
	
	//Instance variables to check which algorithm to run 
	//temporary until more clarification on the command line arguments
	private boolean isStack; 
	private boolean isQueue; 
	private boolean isOpt;
	private boolean printTime; 
	private boolean isInCoord;
	private boolean isOutCoord;
	private boolean help; //will probably not need this in the future 

	public static void main(String[] args) {
		
		readMap("test01");
		
		
		
	}
	
	public static void readMap(String filename) {
		
		
		try {
			File file = new File(filename);
			Scanner scan = new Scanner(file);
			
			int numRows = scan.nextInt()
;
			int numCols = scan.nextInt()
;
			int rumRooms = scan.nextInt();
			
			int rowIndex = 0;
			
			//process the map
			while(scan.hasNextLine()) {
				//grab a line (one row of the map)
				String row = scan.nextLine();
				
				if(row.length()>0) {
					for(int i = 0; i < numCols && i < row.length(); i++) {
						char el = row.charAt(i); 
						Tile obj = new Tile(rowIndex, i, el);
						
					}
				}
				
			}
					
		
		} catch (FileNotFoundException e) {
			// handle exception
			System.out.println(e);
		}
		
		
	}
	
	
	/*
	 * Method for Stack based approach 
	 */
	
	public void stackPath(File map) { //parameter for the map file (to choose different maps when called?)
		
		//create a stack to find the correct path to the $
		Stack path = new Stack();
		
		//create a scanner to scan the map files 
		try {
			Scanner scan = new Scanner(map);
			
			
			
			
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	/*
	 * Method for Queue based approach
	 */
	
	public void queuePath(File map) { //parameter for the map file (to choose different maps when called?)
		
		//create a queue to find the path
		//Queue path = new Queue();
		
		//create a scanner to scan the map files 
		try {
			Scanner scan = new Scanner(map);
			
			//find the starting position first 
			while(scan.next().equals("W")) {
				scan.next();
			}
			
			//enqueue the starting position
			//path.add(scan.next());
			
			//? might not need?
			scan.next();
			
			//dequeue the next location (step 1)
			//path.remove(scan.next());
			
			//enqueue all walkable tiles nearby (in order of North, South, East, West)
			
			
			
			//check if any visited tiles hold the coin
			//if not, reset back to step 1
			
			
			//if solution is found, print out the path 
			
			//return nothing so method is completed
			return;
			
			
			//print the wolverine store is closed if solution DNE
			//System.out.println("The Wolverine Store is closed.");
			
			
			
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	/*
	 * Method for Optimal path based approach
	 * Must be faster than both runtimes for stack and queue combined
	 */
	
	public void optPath(File map) { //parameter for the map file (to choose different maps when called?)
		
		try {
			Scanner scan = new Scanner(map);
			
			
			
			
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	

}
