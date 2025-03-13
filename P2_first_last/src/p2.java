import java.io.File;
import java.io.FileNotFoundException;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class p2 {
	
	//Instance variables to check which algorithm to run 
	//temporary until more clarification on the command line arguments
	private static boolean isStack; 
	private static boolean isQueue; 
	private static boolean isOpt;
	private static boolean printTime; 
	private static boolean isInCoord;
	private static boolean isOutCoord;
	private static boolean help; //will probably not need this in the future 
	
	//temporary until further clarification
	private static char[][] map;
	

	public static void main(String[] args) {
		isInCoord = true;
		readMap("testC02");
		
		
		
	}
	
	public static void readMap(String filename) {
		
		
		try {
			File file = new File("Maps/" + filename);
			Scanner scan = new Scanner(file);
			
			int numRows = scan.nextInt();
			
			int numCols = scan.nextInt();
			
			int numRooms = scan.nextInt();
			
			int rowIndex = 0;
			
			map = new char[numRows*numRooms][numCols];
			
			//process the map
			while(scan.hasNextLine()) {
				
				if(!isInCoord) {
					//grab a line (one row of the map)
					String row = scan.nextLine();
					
					if(row.length() > 0) {
						for(int i = 0; i < numCols && i < row.length(); i++) {
							char el = row.charAt(i); 
							Tile obj = new Tile(rowIndex, i, el);
							
							map[rowIndex][i] = el; //fill a 2D array to traverse later on
							
						}
						
						System.out.println(row);
						
						rowIndex++;
					}
					
					
				} else { //read the coords and put it into the correct position in the map
					
					//grab a line (one row of the map)
					String row = scan.nextLine();
					
					//error with this chunk of code 
					if(row.length() > 0) {
						//the char is always at the first column
						char el = row.charAt(0); 
						Tile obj = new Tile(rowIndex, 0, el);
						
						//read the coords for the char/element
						int rowCoord = scan.nextInt();
						int colCoord = scan.nextInt();
						int roomCoord = scan.nextInt();					
						
						map[rowCoord][colCoord] = el; //fill a 2D array to traverse later on
					
					}
						
					System.out.println(row);
						
					rowIndex++;
				}
				
			}
			
			
			//System.out.println(map);
			
			
			//close the scanner before the method ends
			scan.close();			
		
			
			
		
		} catch (FileNotFoundException e) {
			// handle exception
			System.out.println(e);
		}
		
		
	}
	
	
	/*
	 * Method to convert regular maps to coordinate (output)
	 */
	public static void convertToCoord() {
		
		
		
		
		
	}
	
	
	
	/*
	 * Method for Stack based approach 
	 */
	
	public void stackPath() {
		
		//create a stack to find the correct path to the $
		Stack path = new Stack();

	}
	
	
	
	/*
	 * Method for Queue based approach
	 */
	
	public void queuePath() {
		
		//start tracking runtime at the start of the method 
		
		
		
		//create a queue to find the path
		//Queue path = new Queue<Q>();
		
			
			//enqueue all walkable tiles nearby (in order of North, South, East, West)
			
			
			
			//check if any visited tiles hold the coin
			//if not, reset back to step 1
			
			
			//if solution is found, print out the path 
			
			//return nothing so method is completed
			return;
			
			
			//print the wolverine store is closed if solution DNE
			//System.out.println("The Wolverine Store is closed.");
			
			
			
			
		
		
	}
	
	
	/*
	 * Method for Optimal path based approach
	 * Must be faster than both runtimes for stack and queue combined
	 */
	
	public void optPath() {
	
		
	}
	
	

}
