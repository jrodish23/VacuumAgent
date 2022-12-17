//Name: Jarrad Self
//Class: CS3642
//Assignment 1
//Object class for each node the vacuum can move to to clean

public class Node {
	private boolean dirty;
	private Node north,south,east,west = null;
	
	public Node(boolean dirty){
		this.dirty = dirty;
	}
	
	public Node(boolean dirty, Node north, Node south, Node east, Node west){
		this.dirty = dirty; //assigning parameters to all below
		this.north = north;
		this.south = south;
		this.east = east;
		this.west = west;
	}
	
	public boolean dirty(){
		return dirty;
	}
	
	public void changeState(){  //method to check if a Node is dirty or clean
		if(dirty)
			dirty = false;
		else
			dirty = true;
	}

	public Node getNorth() { // getter returning the value for my Node
		return north;
	}

	public void setNorth(Node north) { //setter taking in the changed/unchanged parameter
		this.north = north;
	}

	public Node getSouth() { // getter returning the value for my Node
		return south;
	}

	public void setSouth(Node south) {  //setter taking in the changed/unchanged parameter
		this.south = south;
	}

	public Node getEast() {   // getter returning the value for my Node
		return east;
	}

	public void setEast(Node east) {  //setter taking in the changed/unchanged parameter
		this.east = east;
	}

	public Node getWest() {   // getter returning the value for my Node
		return west;
	}

	public void setWest(Node west) {   //setter taking in the changed/unchanged parameter
		this.west = west;
	}
	
	public String toString(){ //changing a Node from D (dirty) to C (clean)
		if(dirty)
			return "Dirty";
		else
			return "Clean";
	}
}