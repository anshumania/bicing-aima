package com.bicing.mti.ai.actors;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


// TODO: Auto-generated Javadoc
/**
 * The Class Van transports bicycles from one BicingStation to another
 * @author      Anshuman Mehta
 * @author 		<a href="mailto:mehta.anshuman@gmail.com">mehta.anshuman@gmail.com</a>
 * @since       1.0
 * 
 */
public class Van implements Serializable{

	/**
	 * Instantiates a new van.
	 * 
	 * @param id the id
	 */
	public Van(int id)
	{
		vanID = id;
		setStationsTravelledTo(new ArrayList<BicingStation>());
	}
	
	/** The van id. */
	int vanID;
	
	/** The bicycles to transport. */
	int bicyclesToTransport;
	
	/** The distance travelled. */
	private double distanceTravelled;
	
	
	
	/** The origin station. */
	BicingStation originStation;
	
	/** The current station. */
	private BicingStation currentStation;
	
	/** The stations travelled to. */
	List<BicingStation> stationsTravelledTo;
	
	/**
	 * Gets the origin station.
	 * 
	 * @return the origin station
	 */
	public BicingStation getOriginStation() {
		return originStation;
	}

	
	
	
	/**
	 * Last travel.
	 * 
	 * @return true, if successful
	 */
	public boolean lastTravel()
	{
		if(getStationsTravelledTo() == null ) return false;
		return getStationsTravelledTo().size()==1 ? true : false;
	}
	
	/**
	 * Sets the origin station.
	 * 
	 * @param originStation the new origin station
	 */
	public void setOriginStation(BicingStation originStation) {
		this.originStation = originStation;
	}

	/**
	 * Gets the stations travelled to.
	 * 
	 * @return the stations travelled to
	 */
	public List<BicingStation> getStationsTravelledTo() {
		return stationsTravelledTo;
	}

	/**
	 * Sets the stations travelled to.
	 * 
	 * @param stationsTravelledTo the new stations travelled to
	 */
	public void setStationsTravelledTo(List<BicingStation> stationsTravelledTo) {
		this.stationsTravelledTo = stationsTravelledTo;
	}

	/**
	 * Gets the van id.
	 * 
	 * @return the van id
	 */
	public int getVanID() {
		return vanID;
	}

	/**
	 * Sets the van id.
	 * 
	 * @param vanID the new van id
	 */
	public void setVanID(int vanID) {
		this.vanID = vanID;
	}

	/**
	 * Gets the bicycles to transport.
	 * 
	 * @return the bicycles to transport
	 */
	public int getBicyclesToTransport() {
		return bicyclesToTransport;
	}

	/**
	 * Sets the bicycles to transport.
	 * 
	 * @param bicyclesToTransport the bicycles to transport
	 * 
	 * @return the int
	 */
	public int setBicyclesToTransport(int bicyclesToTransport) {
		if(bicyclesToTransport > 30 )
		{
			this.bicyclesToTransport = 30;
			return bicyclesToTransport - 30;
		}
		this.bicyclesToTransport = bicyclesToTransport;
		return 0;
	}

	/**
	 * Checks if is second trip.
	 * 
	 * @return true, if is second trip
	 */
	public boolean isSecondTrip() {
		if (getStationsTravelledTo() == null) return false;
		return getStationsTravelledTo().size() == 2 ? true : false ;
	}

	
	/**
	 * Moved van from.
	 * 
	 * @param origin the origin
	 * @param destination the destination
	 * @param bicyclesTransported the bicycles transported
	 */
	public void movedVanFrom(BicingStation origin, BicingStation destination, int bicyclesTransported)
	{
			origin.removeVanFromThisStation(getVanID());
			destination.addVanToThisStation(this);
			
			setCurrentStation(destination);
			getStationsTravelledTo().add(destination);
			setBicyclesToTransport(getBicyclesToTransport()-bicyclesTransported);
	}


	/**
	 * Move van from.
	 * 
	 * @param origin the origin
	 * @param destination the destination
	 * @param bicyclesTransported the bicycles transported
	 * 
	 * @return the int
	 */
	public int moveVanFrom(BicingStation origin, BicingStation destination, int bicyclesTransported)
	{
			//origin.removeVanFromThisStation(getVanID());
			//origin.setVanForThisStation(null);
			destination.addVanToThisStation(this);			
			setCurrentStation(destination);
			getStationsTravelledTo().add(destination);
			setDistanceTravelled(getDistanceTravelled()+origin.getDistanceFrom(destination));
			
			int bicyclesLeftInThisVan = getBicyclesToTransport() - bicyclesTransported;
			setBicyclesToTransport(bicyclesLeftInThisVan);
			
			return bicyclesLeftInThisVan;
	}

	/**
	 * Sets the current station.
	 * 
	 * @param currentStation the new current station
	 */
	public void setCurrentStation(BicingStation currentStation) {
		this.currentStation = currentStation;
	}

	/**
	 * Gets the current station.
	 * 
	 * @return the current station
	 */
	public BicingStation getCurrentStation() {
		return currentStation;
	}


	/**
	 * Checks if is empty.
	 * 
	 * @return true, if is empty
	 */
	public boolean isEmpty()
	{
		return getBicyclesToTransport() == 0 ? true : false;
	}




	/**
	 * Sets the distance travelled.
	 * 
	 * @param distanceTravelled the new distance travelled
	 */
	public void setDistanceTravelled(double distanceTravelled) {
		this.distanceTravelled = distanceTravelled;
	}




	/**
	 * Gets the distance travelled.
	 * 
	 * @return the distance travelled
	 */
	public double getDistanceTravelled() {
		return distanceTravelled;
	}
	
	
	public String toString()
	{
		StringBuffer strBuff = new StringBuffer();
		strBuff.append("Van[ID="+getVanID());
		strBuff.append("[OS="+getOriginStation());
		strBuff.append("bic="+getBicyclesToTransport());
		strBuff.append("[dist="+getDistanceTravelled());
		
		return strBuff.toString();
	}
	
}
