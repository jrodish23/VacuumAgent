//Name: Jarrad Self
//Class: CS3642
//Assignment 1
//Object class for my grid

import java.lang.Math;

public class Grid {
	
	private Node floor[][]; //2d array to hold the user input floor 
	private AiVacuum vacuum;
	private int x, y = 0;
	
	public Grid(AiVacuum vacuum, int y, int x){
		this.vacuum = vacuum;
		this.x = x;
		this.y = y;
		
		createFloor();
		run();
	}
	
	public Grid(AiVacuum vacuum, Node floor[][]){
		
		run();
	}
	
	private void run(){  //method calling all of methods below
		generateVacuumLocation();
		displayInitialFloor();
		cleanTheFloor();
		displayFinalSummary();
	}
	
	private void createFloor(){ // creating the randomly generated floor with clean or dirty Nodes
		initializeFloor();
		generateNodes();
		randomDirty();
	}
	
	private void initializeFloor(){
		floor = new Node[x][y];
	}
	
	private void generateNodes(){ //method with nested for loops to generate the x by y grid of tiles
		for(int i = 0; i < x; i++)
			for(int j = 0; j < y; j++)
				floor[i][j] = new Node(false);
	}
	
	private void randomDirty(){ //method with nested for loop that randomly makes Nodes dirty
		for(int i = 0; i < x; i++){
			for(int j = 0; j< y; j++){
				eastWest(i, j);
				northSouth(i, j);
				randChangeState(i, j);
			}
		}
	}
	
	private void eastWest(int i, int j){ //moving the vacuum either east or west
		if(i > 0 && x > 1){
			floor[i - 1][j].setEast(floor[i][j]);
			floor[i][j].setWest(floor[i-1][j]);
		}
	}
	
	private void northSouth(int i, int j){  //moving the vacuum either north or south
		if(j > 0 && y > 1){
			floor[i][j-1].setSouth(floor[i][j]);
			floor[i][j].setNorth(floor[i][j-1]);
		}
	}
	
	private void randChangeState(int i, int j){ //method calling the changeState method to change the letter
		if(randChangeState())
			floor[i][j].changeState();
	}
	
	private boolean randChangeState(){ //if the math.random returns 1 that spot is dirty, if it is 0 it is clean
		return (Math.random() > .5);
	}
	
	private void generateVacuumLocation(){ //method using do while loop to randomly place the vacuum on the grid
		int randX;
		int randY;
		
		do{
			randX = (int)(Math.random() * x);
			randY = (int)(Math.random() * y);
		}while(floor[randX][randY] == null);
		
		vacuum.setpoint(floor[randX][randY]);
	}

	private void displayInitialFloor(){  //method displaying the initial floor before being cleaned
		System.out.println(" ");
		System.out.println("Floor before cleaning... ");
		displayFloor();
	}
	
	private void cleanTheFloor(){
		while(!checkIfFloorIsClean())
			cleanAndMoveVacuum();
	}
	
	private void cleanAndMoveVacuum(){   //method calling the vacuum class to move and clean 
		vacuum.clean();
		vacuum.move();
	}
	
	private void displayFinalSummary(){ //method showing the final cleaned floor and displaying moves and cleans from vacuum
		System.out.println(" ");
		System.out.println("Floor after clean... ");
		displayFloor();
		
		System.out.println("\nThe vacuum changed positions: " + vacuum.getMoves() + " times");
		System.out.println(" ");
		System.out.println("The vacuum cleaned the floor: " + vacuum.getclean() + " times\n");
	}
	
	private void displayFloor(){  //method to call printFloorNode until it has printed all lines of the grid
		for(int i = 0; i < x; i++){
			for(int j = 0; j < y; j++)
				printFloorNode(i, j);
			System.out.println();
		}
	}
	
	private void printFloorNode(int i, int j){  //method to print out letters in grid
			System.out.print(" " + floor[i][j] + " ");
	}
	
	private boolean checkIfFloorIsClean(){ //method determining if the whole floor is clean so it can stop
		for(int i = 0; i < x; i++)
			for(int j = 0; j < y; j++)
				if(!checkIfFloorNodeIsClean(i, j))
					return false;
		return true;
	}
	
	private boolean checkIfFloorNodeIsClean(int i, int j){ //method determining if floor piece is clean or not
		if(floor[i][j].dirty())
				return false;
		else
			return true;
	}
}