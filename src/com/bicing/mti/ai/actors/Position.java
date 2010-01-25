package com.bicing.mti.ai.actors;

import java.io.Serializable;


// TODO: Auto-generated Javadoc
/**
 * The Class Position represents an X and Y coordinate.
 * @author      Anshuman Mehta
 * @author 		<a href="mailto:mehta.anshuman@gmail.com">mehta.anshuman@gmail.com</a>
 * @since       1.0
 */
public class Position implements Serializable{

	/** The x coordinate. */
	int xCoordinate;
	
	/** The y coordinate. */
	int yCoordinate;
	
	/**
	 * Instantiates a new position.
	 * 
	 * @param coords the coords
	 */
	public Position(int[] coords)
	{
		setXCoordinate(coords[0]);
		setYCoordinate(coords[1]);
	}
	
	
	/**
	 * Gets the x coordinate.
	 * 
	 * @return the x coordinate
	 */
	public int getXCoordinate() {
		return xCoordinate;
	}
	
	/**
	 * Sets the x coordinate.
	 * 
	 * @param coordinate the new x coordinate
	 */
	public void setXCoordinate(int coordinate) {
		xCoordinate = coordinate;
	}
	
	/**
	 * Gets the y coordinate.
	 * 
	 * @return the y coordinate
	 */
	public int getYCoordinate() {
		return yCoordinate;
	}
	
	/**
	 * Sets the y coordinate.
	 * 
	 * @param coordinate the new y coordinate
	 */
	public void setYCoordinate(int coordinate) {
		yCoordinate = coordinate;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString()
	{
		return "Pos[X="+getXCoordinate()+",Y="+getYCoordinate()+"]";
	}
	
	  /**
  	 * Gets the distance between two positions.
  	 * 
  	 * @param station1 the station1
  	 * @param station2 the station2
  	 * 
  	 * @return the distance from positions
  	 */
  	public static double getDistanceFromPositions(Position station1,Position station2) {
	        double dist;

	        dist= Math.sqrt(Math.pow(station1.getXCoordinate()- station2.getXCoordinate(),2)
	                       +Math.pow(station1.getYCoordinate()-station2.getXCoordinate(),2)) ;
	      

	        return dist;
	    }
	
}
