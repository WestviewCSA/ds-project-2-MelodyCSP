import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


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

	
	//global variables to store #rows, cols, and rooms
	static int numRows;
	static int numCols;
	static int numRooms;
	

	public static void main(String[] args) {
		isInCoord = false;
		readMap("test01");
		queuePath();
		
		
		if(help) { //if the help switch is activated, print out a short informative message 
			//describe what the program is supposed to do
			System.out.println();
		}
		
		
	}
	
	public static void readMap(String filename) {
		
		
		try {
			File file = new File("Maps/" + filename);
			Scanner scan = new Scanner(file);
			
			numRows = scan.nextInt();
			
			numCols = scan.nextInt();
			
			numRooms = scan.nextInt();
			
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
						
						
						//read the coords for the char/element
						int rowCoord = scan.nextInt();
						int colCoord = scan.nextInt();
						int roomCoord = scan.nextInt();					
						
						//map[rowCoord][colCoord] = el; //fill a 2D array to traverse later on
						
						//fill in any empty spaces with "-"
						for(int i = 0; i < numRows; i++) {
							for(int j = 0; j < numCols; j++) {
								if(Character.isWhitespace(map[i][j])) { //check if the space is empty
									map[i][j] = '-';
								}
							}
						}
						
											
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
		
		//this method will use sysout for now
		
		//traverse through the map 2d array and get ONLY the "+"
		for(int i = 0; i < numRows*numRooms; i++) {
			for(int j = 0; j < numCols; j++) {
				if(map[i][j] == '+') {
					//print out the element, row/col, and room number 
					System.out.println("+ " + i%numRows + " "+ j + " " + i/numRooms);
				}
			}
		}
		
		
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
	
	public static void queuePath() {
		
		//start tracking runtime at the start of the method 
		
		
		
		//create a queue to find the path
		Queue<Tile> history = new Queue<Tile>();
		Queue<Tile> visited = new Queue<Tile>();
		
		
		//find the starting position 
		for(int i = 0; i < numRows; i++) {
			for(int j = 0; j < numCols; j++) {
				if(map[i][j] == 'W') { //enqueu the starting position first
					history.enqueu(new Tile(i, j, 'W'));
					visited.enqueu(new Tile(i, j, 'W'));
					
				}
			}
		}

			
		while(visited.peek().getType() != '$') {
			//enqueue all walkable tiles nearby (in order of North, South, East, West)
			int row = visited.peek().getRow();
			int col = visited.peek().getCol();
			
			if(row != 0) {
				
				if(map[row-1][col] != '@') { //check for the walkable tile
					if(map[row-1][col] == '$') {
						history.enqueu(new Tile(row-1, col, '$'));
					} else if(map[row-1][col] == '|') {
						
					} else {
						
				 	history.enqueu(new Tile(row-1, col, map[row-1][col])); 
					}
				}
				
			}
			if(row != numRows-1) {
				if(map[row-1][col] != '@') { //check for the walkable tile
					
				 	history.enqueu(new Tile(row+1, col, '-')); //help
				}	
			} 
			if(col != 0) {
				if(map[row][col+1] != '@') {
					history.enqueu(new Tile(row, col-1, '-'));
				}
			} 
			if(col != numCols-1) {
				if(map[row][col-1] != '@') {
					history.enqueu(new Tile(row, col+1, '-'));
				}
			}
		
			
			visited.enqueu(history.dequeue());
		
		}
		
		
		//if solution is found, find and print out the path 
		char[][] solution = map;
		
		System.out.println(visited);
		
			
		
			//return nothing so method is completed
			
			
			
			//print the wolverine store is closed if solution DNE
			//System.out.println("The Wolverine Store is closed.");
		
		
	}
		
	public static Tile checkSpace(int row, int col) {
		if(map[row][col] != '@') { //check for the walkable tile
			if(map[row][col] == '$') {
				return new Tile(row, col, map[row][col]);
			} else if(map[row][col] == '|') {
				return new Tile()
			} else {
				
		 	return new Tile(row, col, map[row][col]); 
		 	
			}
		}
		
		
	}
	
	
	
	
	
	/*
	 * Method for Optimal path based approach
	 * Must be faster than both runtimes for stack and queue combined
	 */
	
	public void optPath() {
	
		
	}
	
	

}
