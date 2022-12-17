//Name: Jarrad Self
//Class: CS3642
//Assignment 1
//Object class for Vacuum

import java.lang.Math;

public class AiVacuum {
	private Node point;
	private int moves = 0;  //counter for total moves of vacuum
	private int totalclean = 0;   //counter for total cleans of vacuum
	
	public void move(){
		boolean hasMoved = false;
		
		while(!hasMoved)
			hasMoved = moveVacuum((int)(Math.random() * 4)); //choosing a random case below to select the way the vacuum will move
				
		moves++;
	}
	
	private boolean moveVacuum(int move){  //using switch statement with the above method to determine next move at random
		switch(move){
		case 0: 
			if(moveEast()){
				setpoint(point.getEast());
				return true;
			}
			break;
		case 1: 
			if(moveWest()){
				setpoint(point.getWest());
				return true;
			}
			break;
		case 2: 
			if(moveNorth()){
				setpoint(point.getNorth());
				return true;
			}
			break;
		case 3: 
			if(moveSouth()){
				setpoint(point.getSouth());
				return true;
			}
			break;
		}
		return false;
	}
	
	public void clean(){        //method that makes the vacuum clean and change the D to C
		if(point.dirty()){
			point.changeState();
			totalclean++;  // adding to the total number of cleans
		}
	}
	
	public void setpoint(Node point){
		this.point = point;
	}
	
	public int getMoves(){ //returning the amount of moves
		return moves;
	}
	
	public int getclean(){ //returning the total number of cleans
		return totalclean;
	}
	
	private boolean moveNorth(){
		return point.getNorth() != null;
	}
	
	private boolean moveSouth(){
		return point.getSouth() != null;
	}
	
	private boolean moveEast(){
		return point.getEast() != null;
	}
	
	private boolean moveWest(){
		return point.getWest() != null;
	}
}