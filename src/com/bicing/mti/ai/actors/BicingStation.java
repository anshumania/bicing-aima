package com.bicing.mti.ai.actors;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;


// TODO: Auto-generated Javadoc
/**
 * The Class BicingStation represents a bicing station.
 * It has information when its inovked at a certain hour
 * <li>the number of cycles that dont move from this station at
 * <li>the number of cycles that are left over after the users move the cycles
 * <li>the number of cycles which are expected to be demanded the next hour
 * <li>the coordinates of the station
 * 
 * @author      Anshuman Mehta
 * @author 		<a href="mailto:mehta.anshuman@gmail.com">mehta.anshuman@gmail.com</a>
 * @since       1.0
 */
public class BicingStation implements Comparable<BicingStation>, Serializable {
	

	/**
	 * Instantiates a new bicing station.
	 * 
	 * @param id the id
	 */
	public BicingStation(int id)
	{
		stationID = id;
	}

	/** The station id. */
	int stationID;
	
	/** The demand of bicycle next hour. */
	int demandOfBicycleNextHour;
	
	/** The number of bicycles at beginning of next hour. */
	int numberOfBicyclesAtBeginningOfNextHour;
	
	/** The number of bicycles that dont move from this station. */
	int numberOfBicyclesThatDontMoveFromThisStation;
	
	/** The number of vans in this station. */
	int numberOfVansInThisStation;
	
	/** The vans at this station. */
	List<Van> vansAtThisStation;
	
	/** The van for this station. */
	Van vanForThisStation;
	
	/**
	 * Gets the van for this station.
	 * 
	 * @return the van for this station
	 */
	public Van getVanForThisStation() {
		return vanForThisStation;
	}

	/**
	 * Sets the van for this station.
	 * 
	 * @param vanForThisStation the new van for this station
	 */
	public void setVanForThisStation(Van vanForThisStation) {
		this.vanForThisStation = vanForThisStation;
	}

	/** The requirement. */
	int requirement;
	
	/** The excess. */
	int excess;
	
	/** The is supply station. */
	boolean isSupplyStation;
	
	

	
	/** The coordinates. */
	Position coordinates;
	
	

	/**
	 * Gets the station id.
	 * 
	 * @return the station id
	 */
	public int getStationID() {
		return stationID;
	}

	/**
	 * Sets the station id.
	 * 
	 * @param stationID the new station id
	 */
	public void setStationID(int stationID) {
		this.stationID = stationID;
	}

	/**
	 * Gets the demand of bicycle next hour.
	 * 
	 * @return the demand of bicycle next hour
	 */
	public int getDemandOfBicycleNextHour() {
		return demandOfBicycleNextHour;
	}

	/**
	 * Sets the demand of bicycle next hour.
	 * 
	 * @param demandOfBicycleNextHour the new demand of bicycle next hour
	 */
	public void setDemandOfBicycleNextHour(int demandOfBicycleNextHour) {
		this.demandOfBicycleNextHour = demandOfBicycleNextHour;
	}

	/**
	 * Gets the number of bicycles at beginning of next hour.
	 * 
	 * @return the number of bicycles at beginning of next hour
	 */
	public int getNumberOfBicyclesAtBeginningOfNextHour() {
		return numberOfBicyclesAtBeginningOfNextHour;
	}

	/**
	 * Sets the number of bicycles at beginning of next hour.
	 * 
	 * @param numberOfBicyclesAtBeginningOfNextHour the new number of bicycles at beginning of next hour
	 */
	public void setNumberOfBicyclesAtBeginningOfNextHour(
			int numberOfBicyclesAtBeginningOfNextHour) {
		this.numberOfBicyclesAtBeginningOfNextHour = numberOfBicyclesAtBeginningOfNextHour;
	}

	/**
	 * Gets the number of bicycles that dont move from this station.
	 * 
	 * @return the number of bicycles that dont move from this station
	 */
	public int getNumberOfBicyclesThatDontMoveFromThisStation() {
		return numberOfBicyclesThatDontMoveFromThisStation;
	}

	/**
	 * Sets the number of bicycles that dont move from this station.
	 * 
	 * @param numberOfBicyclesThatDontMoveFromThisStation the new number of bicycles that dont move from this station
	 */
	public void setNumberOfBicyclesThatDontMoveFromThisStation(
			int numberOfBicyclesThatDontMoveFromThisStation) {
		this.numberOfBicyclesThatDontMoveFromThisStation = numberOfBicyclesThatDontMoveFromThisStation;
	}

	/**
	 * Gets the number of vans in this station.
	 * 
	 * @return the number of vans in this station
	 */
	public int getNumberOfVansInThisStation() {
		return numberOfVansInThisStation;
	}

	/**
	 * Sets the number of vans in this station.
	 * 
	 * @param numberOfVansInThisStation the new number of vans in this station
	 */
	public void setNumberOfVansInThisStation(int numberOfVansInThisStation) {
		this.numberOfVansInThisStation = numberOfVansInThisStation;
	}

	/**
	 * Checks if is supply station.
	 * 
	 * @return true, if is supply station
	 */
	public boolean isSupplyStation() {
		return isSupplyStation;
	}

	/**
	 * Sets the checks if is supply station.
	 * 
	 * @param isSupplyStation the new checks if is supply station
	 */
	public void setIsSupplyStation(boolean isSupplyStation) {
		this.isSupplyStation = isSupplyStation;
	}


	

	/**
	 * Gets the coordinates.
	 * 
	 * @return the coordinates
	 */
	public Position getCoordinates() {
		return coordinates;
	}

	/**
	 * Sets the coordinates.
	 * 
	 * @param coordinates the new coordinates
	 */
	public void setCoordinates(Position coordinates) {
		this.coordinates = coordinates;
	}


	/**
	 * Gets the vans at this station.
	 * 
	 * @return the vans at this station
	 */
	public List<Van> getVansAtThisStation() {
		return vansAtThisStation;
	}

	/**
	 * Sets the vans at this station.
	 * 
	 * @param vansAtThisStation the new vans at this station
	 */
	public void setVansAtThisStation(List<Van> vansAtThisStation) {
		this.vansAtThisStation = vansAtThisStation;
	}

	/**
	 * Adds the van to this station.
	 * 
	 * @param van the van
	 */
	public void addVanToThisStation(Van van)
	{
		if(getVansAtThisStation()==null)
			setVansAtThisStation(new ArrayList<Van>());
		getVansAtThisStation().add(van);
		
	}
	
	/**
	 * Removes the van from this station.
	 * 
	 * @param vanId the van id
	 * 
	 * @return the van
	 */
	public Van removeVanFromThisStation(int vanId) 
	{
		for(Van v : getVansAtThisStation())
			if (v.getVanID() == vanId ) 
					return getVansAtThisStation().remove(v) ? null : v;
				
		throw new UnsupportedOperationException("This Van is not present in this station");
		
	}
	
	/**
	 * Evaluates the station as supply or demand station.
	 */
	public void evaluateStation()
	{
		
		int balance = getNumberOfBicyclesAtBeginningOfNextHour()-getDemandOfBicycleNextHour();
		
	//	int availability = getNumberOfBicyclesAtBeginningOfNextHour()+getNumberOfBicyclesThatDontMoveFromThisStation();
//		if(availability < 0 )
//		{
//			System.err.println("the cycles available next hr are less than the cycles that dont move !");
//			System.out.println("the cycles available next hr are less than the cycles that dont move !");
//		}
		
		if(balance > 0)
		{
			//supply station
			this.setIsSupplyStation(true);
			if(balance > getNumberOfBicyclesThatDontMoveFromThisStation())
				setExcess(getNumberOfBicyclesThatDontMoveFromThisStation());
			else
				setExcess(balance);
		}
		else
		{
			//demand station
			this.setIsSupplyStation(false);
			setRequirement(Math.abs(balance));
		}
		
//		int supplyLimit = getDemandOfBicycleNextHour() - availability;
//		if(supplyLimit < 0)
//		{
//			//demand station
//			this.setIsSupplyStation(false);
//			setRequirement(Math.abs(supplyLimit));
//		}
//		else
//		{
//			//supply station
//			this.setIsSupplyStation(true);
//			setExcess(supplyLimit);
//		}
			
		
	}
	
	/**
	 * Gets the requirement.
	 * 
	 * @return the requirement
	 */
	public int getRequirement() {
		return requirement;
	}

	/**
	 * Sets the requirement.
	 * 
	 * @param requirement the new requirement
	 */
	public void setRequirement(int requirement) {
		this.requirement = requirement;
	}

	/**
	 * Gets the excess.
	 * 
	 * @return the excess
	 */
	public int getExcess() {
		return excess;
	}

	/**
	 * Sets the excess.
	 * 
	 * @param excess the new excess
	 */
	public void setExcess(int excess) {
		this.excess = excess;
	}
	
	/**
	 * Gets the distance of this Bicing station from another bicing station
	 * 
	 * @param nextStation the next station
	 * 
	 * @return the distance from
	 */
	public double getDistanceFrom(BicingStation nextStation)
	{
		double dist = Position.getDistanceFromPositions(this.getCoordinates(), nextStation.getCoordinates());
		DecimalFormat d = new DecimalFormat("#.##");
        return Double.valueOf(d.format(dist)).doubleValue();
		
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString()
	{
		StringBuffer stringBuff = new StringBuffer() ;
		stringBuff.append("S[ID="+getStationID()+",");
		stringBuff.append("[NHr="+getDemandOfBicycleNextHour()+",");
		stringBuff.append("[BNHr="+getNumberOfBicyclesAtBeginningOfNextHour() +",");
		stringBuff.append("[DM="+getNumberOfBicyclesThatDontMoveFromThisStation() +",");
		stringBuff.append("[C="+getCoordinates().toString() +",");
		if(getVansAtThisStation()!= null)
			stringBuff.append("[V="+getVansAtThisStation().size()+",");
		stringBuff.append("[Req="+getRequirement()+",Excs="+getExcess()+"]");
		return stringBuff.toString();
		
		
		
	}

			
	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(BicingStation arg0) {
		final int EQUAL = 0;
		final int LESS = -1;
		final int GREAT = 1;
		
		if(this.isSupplyStation())
		{
			int val = getExcess() - arg0.getExcess();
			if(val == 0) return EQUAL;
			if(val < 0) return LESS;
			else return GREAT;
		}
		else
		{
			int val = (getRequirement())-(arg0.getRequirement());
			if(val == 0) return EQUAL;
			if(val < 0) return LESS;
			else return GREAT;
		}
	}
	
	
}
