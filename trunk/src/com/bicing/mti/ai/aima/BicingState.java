
package com.bicing.mti.ai.aima;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.bicing.mti.ai.actors.BicingStation;
import com.bicing.mti.ai.actors.Move;
import com.bicing.mti.ai.actors.MoveString;
import com.bicing.mti.ai.actors.Position;
import com.bicing.mti.ai.actors.Van;
import com.bicing.mti.ai.generator.Bicing;
import com.bicing.mti.ai.utility.ObjectCloner;



// TODO: Auto-generated Javadoc
/**
 * BicingState represents the informatino of the 
 * state of Bicing.
 * This state information includes:
 * <ul>
 * <li>The total number of Vans, Available Vans, Assigned Vans, Finished Vans
 * <li>The total number of Stations, Demand Stations, Supply Stations 
 * <li>The initial demand, the current demand satisfied
 * <li>The initial supply, the current supply available
 * <li>The movements of the Vans to reach to this state
 * <li>The distance travelled by all the Vans to reach this state
 * 
 * @author      Anshuman Mehta
 * @author 		<a href="mailto:mehta.anshuman@gmail.com">mehta.anshuman@gmail.com</a>
 * @since       1.0
 */
public class BicingState implements Serializable {
	/** The total number bicing states generated. */
	static int s=0;
	/** The BID for this bicing state. */
	private int BID;
	/** The initial global demand. */
	private int globalDemand;
	/** The current demand satisfied. */ 
	private int currentDemandSatisfied;
	/** The global initial supply. */
	private int globalSupply;
	/** The current supply that can be given. Changes when a demand station becomes a supply station . */
	private int currentSupply;
	/** The current distance travelled by this bicing state. */
	private Double currentDistanceTravelled = new Double(0);
	/** The moves taken to reach this state. */
	private List<MoveString> movesForThisState;
	/** The bicing stations list. */
	private List<BicingStation> bicingStationsList;
	/** The list of assigned vans to a bicing station for performing a job . */
	private List<Van> assignedVans;
	/** The list of finished assignment vans assigned to a Station that have finished their job. */
	private List<Van> finishedAssignmentVans;
	/** The list of available vans that are free to be assigned to a station. */
	private List<Van> availableVans;
	/** The bicing station map of stationIDs and sation objects. Essential to pick up the right objects during deep cloning. */
	Map<Integer,BicingStation> bicingStationMap;
	/** The van map of the vanIDs and van objects. Essential to pick up the right objects during deep cloning. */
	private Map<Integer,Van> vanMap;
	/** The demand stations ; subset of the bicing stations list. */
	List<BicingStation> demandStations;
	/** The supply stations; subset of the bicing stations list. */
	List<BicingStation> supplyStations;
	/** The boolean for whether a bicing station has changed state from demand to supply. */
	private boolean hasDemandBecomeSupply;
	/** The total no of vans. */
    int noOfVans;
	/** The no of initial supply stations. */
	int noOfInitialSupplyStn;
	/** The no of initial demand stations. */
	int noOfInitialDemandStn;
	
	
	private transient static Logger logger  = Logger.getLogger("global");
	
	/**
	 * Instantiates a new bicing state
	 * 
	 * @param generated the generated Bicing object
	 * @param numberOfVans the number of vans
	 */
	public BicingState(Bicing generated, int numberOfVans)
	{
		this.noOfVans=numberOfVans;
		generateVans(numberOfVans);
		generateStations(generated);
		assignVansToStations();
		setBID(++s);
	}
	

	/**
 * Gets the cloned bicing state by performing a deep copy of the parent bicing state.
 * 
 * @param parentState the parent state
 * 
 * @return the cloned bicing state
 */
static BicingState getClonedBicingState(BicingState parentState)
	{
		BicingState clonedState= null;
		try {
			clonedState = (BicingState) ObjectCloner.deepCopy(parentState);
			BicingState.s++;
			clonedState.setBID(BicingState.s);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return clonedState;
	}
		

	/**
	 * Gets the bicing stations list.
	 * 
	 * @return the bicing stations list
	 */
	public List<BicingStation> getBicingStationsList() {
		return bicingStationsList;
	}

	/**
	 * Sets the bicing stations list.
	 * 
	 * @param bicingStationsList the new bicing stations list
	 */
	public void setBicingStationsList(List<BicingStation> bicingStationsList) {
		this.bicingStationsList = bicingStationsList;
	}

	/**
	 * Gets the available vans.
	 * 
	 * @return the available vans
	 */
	public List<Van> getAvailableVans() {
		return availableVans;
	}

	/**
	 * Sets the available vans.
	 * 
	 * @param availableVans the new available vans
	 */
	public void setAvailableVans(List<Van> availableVans) {
		this.availableVans = availableVans;
	}

	/**
	 * Gets the bicing station map.
	 * 
	 * @return the bicing station map
	 */
	public Map<Integer, BicingStation> getBicingStationMap() {
		return bicingStationMap;
	}

	/**
	 * Sets the bicing station map.
	 * 
	 * @param bicingStationMap the bicing station map
	 */
	public void setBicingStationMap(Map<Integer, BicingStation> bicingStationMap) {
		this.bicingStationMap = bicingStationMap;
	}

	/**
	 * Gets the demand stations.
	 * 
	 * @return the demand stations
	 */
	public List<BicingStation> getDemandStations() {
		return demandStations;
	}

	/**
	 * Sets the demand stations.
	 * 
	 * @param demandStations the new demand stations
	 */
	public void setDemandStations(List<BicingStation> demandStations) {
		this.demandStations = demandStations;
	}

	/**
	 * Gets the supply stations.
	 * 
	 * @return the supply stations
	 */
	public List<BicingStation> getSupplyStations() {
		return supplyStations;
	}

	/**
	 * Sets the supply stations.
	 * 
	 * @param supplyStations the new supply stations
	 */
	public void setSupplyStations(List<BicingStation> supplyStations) {
		this.supplyStations = supplyStations;
	}
	
	
	
	
	
	/**
	 * The main method.
	 * 
	 * @param args the arguments
	 */
	public static void main(String args[])
	{
		
		Bicing generated = new Bicing(10,500,Bicing.RUSH_HOUR,200);
		int numberOfVans = 4;
		BicingState bicingState = new BicingState(generated,numberOfVans);
		bicingState.printBicingStationsList();
		bicingState.printDemandStations();
		bicingState.printSupplyStations();
		
		
		//test for movements
		bicingState.assignVansToStations();
		
		List<Move> moveListForVanAtThisSupplyStation = new ArrayList<Move>();
		for(int k = 0 ; k < bicingState.getSupplyStations().size() ; k++)
		{
			BicingStation supplyStation = bicingState.getSupplyStations().get(k);
			if(supplyStation.getVanForThisStation()!=null) // there is a van for delivery here
			{
				Van van = supplyStation.getVanForThisStation();
				for(int i=0;i< bicingState.getDemandStations().size() ; i++)
					for( int j=0 ; j< bicingState.getDemandStations().size() ; j++)
					{
						if(i!=j)
						{
							Move move = new Move(supplyStation,bicingState.getDemandStations().get(i),bicingState.getDemandStations().get(j),van);
							moveListForVanAtThisSupplyStation.add(move);
						}
							
					}
			}
		}
		
		for(Move move : moveListForVanAtThisSupplyStation)
		{
			System.out.println(move);
		}
		
	}
	


	/**
	 * Prints the bicing stations list.
	 */
	public void printBicingStationsList()
	{
		  for(BicingStation bc: getBicingStationsList())
			  System.out.println(bc);
	  
		  System.out.println("DemandStations -");
	
		  
	}
	
	/**
	 * Prints the demand stations.
	 */
	public void printDemandStations()
	{
		  for(BicingStation bc: getDemandStations())
			  System.out.println(bc);	
	}
	
	/**
	 * Prints the supply stations.
	 */
	public void printSupplyStations()
	{
		System.out.println("SupplyStations -");
		  for(BicingStation bc : getSupplyStations())
			  System.out.println(bc);	
	}
	
	/**
	 * Generates the vans from the given number of vans.
	 * 
	 * @param numberOfVans the number of vans
	 */
	private void generateVans(int numberOfVans)
	{
		 setAvailableVans(new ArrayList<Van>());
		 setAssignedVans(new ArrayList<Van>());
		 setFinishedAssignmentVans(new ArrayList<Van>());
		 setVanMap(new HashMap<Integer,Van>());
		  for(int i=0 ; i< numberOfVans ; i++)
		  {
			  Van van = new Van(i);
			  getAvailableVans().add(van);
			  getVanMap().put(i, van);
		  }
	}
	
	
	/**
	 * Generates all the BicingStations from the given information in Bicing.
	 * 
	 * @param generated the generated
	 */
	private void generateStations(Bicing generated) {
		
	  
	  int numberOfStations = generated.getNumStations();
	  setBicingStationsList(new ArrayList<BicingStation>());
	  setBicingStationMap(new HashMap<Integer,BicingStation>());
	 
	  setDemandStations(new ArrayList<BicingStation>());
	  setSupplyStations(new ArrayList<BicingStation>());
	  
	  setMovesForThisState(new ArrayList<MoveString>());
	  
	  for(int i=0; i<numberOfStations ; i++)
	  {
		  BicingStation bs = new BicingStation(i);
		  int nxtHrDem = generated.getDemandNextHour(i);
		  int bicsThatDontMove = generated.getStationDoNotMove(i);
		  int bicsPresentAtNextHr = generated.getStationNextState(i);
		  int[] coords = generated.getStationCoord(i);
		  
		  Position pos = new Position(coords);
		  bs.setCoordinates(pos);
		  bs.setDemandOfBicycleNextHour(nxtHrDem);
		  bs.setNumberOfBicyclesAtBeginningOfNextHour(bicsPresentAtNextHr);
		  bs.setNumberOfBicyclesThatDontMoveFromThisStation(bicsThatDontMove);
		  
		  bs.evaluateStation();
		  
		  getBicingStationsList().add(bs);
		  getBicingStationMap().put(i,bs);
		  
		  
		  if(bs.isSupplyStation())
		  {
			  getSupplyStations().add(bs);
			  setGlobalSupply(getGlobalSupply() + bs.getExcess());
		  }
		  else
		  {
			  getDemandStations().add(bs);
			  setGlobalDemand(getGlobalDemand() + bs.getRequirement());
		  }	  
		  
    }
	  this.noOfInitialDemandStn = getDemandStations().size();
	  this.noOfInitialSupplyStn = getSupplyStations().size();
	  
	  
//	  Collections.sort(getDemandStations());
//	  Collections.sort(getSupplyStations());
//	  Collections.reverse(getDemandStations());
//	  Collections.reverse(getSupplyStations());
//	
	 
	}
	
	
	/**
	 * Gets the global demand.
	 * 
	 * @return the global demand
	 */
	public Integer getGlobalDemand() {
		return globalDemand;
	}

	/**
	 * Sets the global demand.
	 * 
	 * @param globalDemand the new global demand
	 */
	public void setGlobalDemand(int globalDemand) {
		this.globalDemand = globalDemand;
	}

	/**
	 * Gets the current demand.
	 * 
	 * @return the current demand
	 */
	public Integer getCurrentDemandSatisfied() {
		return currentDemandSatisfied;
	}

	/**
	 * Sets the current demand.
	 * 
	 * @param currentDemand the new current demand
	 */
	public void setCurrentDemandSatisfied(Integer currentDemandSatisfied) {
		this.currentDemandSatisfied = currentDemandSatisfied;
	}

	/**
	 * Gets the global supply.
	 * 
	 * @return the global supply
	 */
	public Integer getGlobalSupply() {
		return globalSupply;
	}

	/**
	 * Sets the global supply.
	 * 
	 * @param globalSupply the new global supply
	 */
	public void setGlobalSupply(Integer globalSupply) {
		this.globalSupply = globalSupply;
	}

	/**
	 * Gets the current supply.
	 * 
	 * @return the current supply
	 */
	public Integer getCurrentSupply() {
		return currentSupply;
	}

	/**
	 * Sets the current supply.
	 * 
	 * @param currentSupply the new current supply
	 */
	public void setCurrentSupply(Integer currentSupply) {
		this.currentSupply = currentSupply;
	}

	
	
    /**
     * Gets the stations distance.
     * 
     * @param supplyStation the supply station
     * @param demandStation the demand station
     * 
     * @return the stations distance
     */
    public double getStationsDistance(BicingStation supplyStation,BicingStation demandStation) {
        double dist;

        dist= Math.sqrt(Math.pow(supplyStation.getCoordinates().getXCoordinate()- demandStation.getCoordinates().getXCoordinate(),2)
                       +Math.pow(supplyStation.getCoordinates().getYCoordinate()-demandStation.getCoordinates().getYCoordinate(),2)) ;
      
        DecimalFormat d = new DecimalFormat("#.##");
        d.format(dist);
        return Double.valueOf(d.format(dist)).doubleValue();
    }
	
	

	/**
	 * Assigns all Available vans to all possible supply stations.
	 */
	private void assignVansToStations() {
		
		//assignVans to supplyStations
		for(BicingStation supplyStation : getSupplyStations())
		{
//			if(!getAvailableVans().isEmpty())
//			{
//				Van van = getAvailableVans().get(0);
//				van.setOriginStation(supplyStation);
//				supplyStation.setVanForThisStation(van);
//				supplyStation.addVanToThisStation(van);
//				getAssignedVans().add(van);
//				getAvailableVans().remove(van);
				assignVanToStation(supplyStation);
//			}
		}
		
	}

	/**
	 * Assign an available van to a station.
	 * 
	 * @param supplyStation the supply station
	 */
	public void assignVanToStation(BicingStation supplyStation) 
	{
		if(!getAvailableVans().isEmpty())
		{
		Van van = getAvailableVans().get(0);
		van.setOriginStation(supplyStation);
		supplyStation.setVanForThisStation(van);
		supplyStation.addVanToThisStation(van);
		getAssignedVans().add(van);
		getAvailableVans().remove(van);
		}
		else
			throw new UnsupportedOperationException("There are no Available Vans. Check van availability before assigning!");
		
		
	}
	
	/**
	 * Checks for vans available.
	 * 
	 * @return true, if successful
	 */
	public boolean hasVansAvailable()
	{
		return getAvailableVans().isEmpty() ? false : true;
	}

	/**
	 * Sets the assigned vans.
	 * 
	 * @param assignedVans the new assigned vans
	 */
	public void setAssignedVans(List<Van> assignedVans) {
		this.assignedVans = assignedVans;
	}

	/**
	 * Gets the assigned vans.
	 * 
	 * @return the assigned vans
	 */
	public List<Van> getAssignedVans() {
		return assignedVans;
	}

	

	/**
	 * Sets the finished assignment vans.
	 * 
	 * @param finishedAssignmentVans the new finished assignment vans
	 */
	public void setFinishedAssignmentVans(List<Van> finishedAssignmentVans) {
		this.finishedAssignmentVans = finishedAssignmentVans;
	}

	/**
	 * Gets the finished assignment vans.
	 * 
	 * @return the finished assignment vans
	 */
	public List<Van> getFinishedAssignmentVans() {
		return finishedAssignmentVans;
	}


	/**
	 * Perform a move on the current bicing state.
	 * 
	 * @param move the move
	 */
	public void performThisMove(Move move)
	{
		performThisMove(move,move.getDemandStation());
		if(move.getType().equals(Move.TYPE.DOUBLE))
			performThisMove(move,move.getDemandStation2());
	}
	
	/**
	 * Perform this move to a station. This is the main function which 
	 * performs the logic of transportation of vans from an origin
	 * station to a demand station.
	 * It takes into account
	 * The maximum number of bicycles that a van can  supply i.e. 30
	 * That after 2 movements a van simply dumps all its bicycles onto a station
	 * That it is possible for a demand station to become a supply station if there is a van available.
	 * It also updates all the variables for the current bicing state
	 * 
	 * @param moveInList the move in list
	 * @param nDemandStation the n demand station
	 */
	public void performThisMove(Move moveInList, BicingStation nDemandStation) {
		
		BicingStation supplyStation = moveInList.getSupplyStation();
		Van van = supplyStation.getVanForThisStation();
		//checks that van can limit to 30 and left over is surplus
		//bug check if the van is on its second trip ; it cannot refill !!
		int surplus = 0;
		if (van.getStationsTravelledTo().size()==0) 
			surplus = van.setBicyclesToTransport(supplyStation.getExcess());
		else
			surplus = ((supplyStation.getExcess() - van.getBicyclesToTransport()) > 0) ? supplyStation.getExcess() - van.getBicyclesToTransport() : 0;

		BicingStation demandStation = nDemandStation;
		int requirement = demandStation.getRequirement();
		int vanCanSupply = van.getBicyclesToTransport() - requirement;
		int bicyclesLeftInVan = -1;
		int bicyclesRecvd = 0;
		
		if(vanCanSupply > 0)
		{
			bicyclesLeftInVan = van.moveVanFrom(supplyStation,demandStation, requirement);
			//updateDemandStation
			bicyclesRecvd=requirement;
			demandStation.setRequirement(0);
		}
		else
		{
			//updateDemandStation
			bicyclesRecvd=van.getBicyclesToTransport();
			demandStation.setRequirement(requirement-bicyclesRecvd);//vanCanSupply is -ve
			//only update the coordinates of the van
			bicyclesLeftInVan = van.moveVanFrom(supplyStation,demandStation,van.getBicyclesToTransport());

		}
		
		assert bicyclesLeftInVan >=0 : "van did not move properly";
		
		//updateVan
		if(van.isSecondTrip())
		{
//			logger.log(Level.INFO,"secondtrip for van {0}", van.toString());
			    if(  van.getBicyclesToTransport() > 0 )
			    {
			    	int requirementAtCurrentStation = demandStation.getRequirement();
			    	if(!(requirementAtCurrentStation==0))
			    	if(van.getBicyclesToTransport()- requirementAtCurrentStation >0)
			    	{
			    		demandStation.setRequirement(0);
			    		demandStation.setExcess(van.getBicyclesToTransport() - requirementAtCurrentStation);
			    		logger.log(Level.INFO,"{0}has potentially changed state from demand to supply", van.toString());
			    		System.out.println("ALERT demand has potentially become supply *****************************");
			    	}
			    	else
			    		demandStation.setRequirement(demandStation.getRequirement() - van.getBicyclesToTransport());
			    	
			    }
				getFinishedAssignmentVans().add(van);
				getAvailableVans().remove(van);
		}
		else
			if(bicyclesLeftInVan == 0 )
			{
				getFinishedAssignmentVans().add(van);
				getAssignedVans().remove(van);
			}
//		else
//			getAvailableVans().add(van); // this looks like a useless check
			
		//updateSupplyStation
		supplyStation.setExcess(surplus);
		
		if(supplyStation.getExcess() == 0 ) getSupplyStations().remove(supplyStation);
		
		if(demandStation.getRequirement() <= 0) getDemandStations().remove(demandStation);
		if(demandStation.getExcess() > 0 && demandStation.getVanForThisStation()==null) 
			{
			//do only if u have more vans
			if(!getAvailableVans().isEmpty()) 
			{
				System.out.println("Handling ALERT demand has become supply *****************************");
				getSupplyStations().add(demandStation);
				getDemandStations().remove(demandStation);
				//setCurrentSupply((getGlobalSupply()+demandStation.getExcess()));
				setHasDemandBecomeSupply(true);
			    assignVanToStation(demandStation);
			    logger.log(Level.INFO,"Handled alert for van {0} that changed state", van.toString());
			}
			
			}
		
		setCurrentDistanceTravelled(getCurrentDistanceTravelled()+van.getDistanceTravelled());
		setCurrentDemandSatisfied(getCurrentDemandSatisfied()+bicyclesRecvd);
		setCurrentSupply(getCurrentSupply()+bicyclesRecvd);
		
		
		
	}

	/**
	 * Sets the van map.
	 * 
	 * @param vanMap the van map
	 */
	public void setVanMap(Map<Integer,Van> vanMap) {
		this.vanMap = vanMap;
	}

	/**
	 * Gets the van map.
	 * 
	 * @return the van map
	 */
	public Map<Integer,Van> getVanMap() {
		return vanMap;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString()
	{
		StringBuffer buff = new StringBuffer();
		buff.append("\nStateNo[="+getBID()+"]");
		buff.append("\nGlobalDemand="+getGlobalDemand()+"");
		buff.append("\nGlobalSupply="+getGlobalSupply());
		buff.append("\nCurrentDemandSatisfied="+getCurrentDemandSatisfied());
		buff.append("\nCurrentSupplyGiven="+getCurrentSupply());
		buff.append("\nAvailableVans=freeVans"+getAvailableVans().size());
		buff.append("\nFinishedVans=doneVans"+getFinishedAssignmentVans().size());
		buff.append("\nAssignedVans="+getAssignedVans().size());
		buff.append("\nMoves="+getMovesForThisState());
		buff.append("\nDistanceTravelled="+getCurrentDistanceTravelled());
		if(isHasDemandBecomeSupply())
		 buff.append("\nNoOfInitialSupplyAndDemandVsCurrent="+noOfInitialDemandStn+" & "+noOfInitialSupplyStn + " / " + getSupplyStations().size() + " & " + getDemandStations().size());
		return buff.toString();
	}

	/**
	 * Sets the moves for this state.
	 * 
	 * @param movesForThisState the new moves for this state
	 */
	public void setMovesForThisState(List<MoveString> movesForThisState) {
		this.movesForThisState = movesForThisState;
	}

	/**
	 * Gets the moves for this state.
	 * 
	 * @return the moves for this state
	 */
	public List<MoveString> getMovesForThisState() {
		return movesForThisState;
	}

	/**
	 * Sets the current distance travelled.
	 * 
	 * @param currentDistanceTravelled the new current distance travelled
	 */
	public void setCurrentDistanceTravelled(Double currentDistanceTravelled) {
		this.currentDistanceTravelled = currentDistanceTravelled;
	}

	/**
	 * Gets the current distance travelled.
	 * 
	 * @return the current distance travelled
	 */
	public Double getCurrentDistanceTravelled() {
		DecimalFormat d = new DecimalFormat("#.##");
        return Double.valueOf(d.format(currentDistanceTravelled)).doubleValue();
		
	}

	/**
	 * Sets the checks for demand become supply.
	 * 
	 * @param hasDemandBecomeSupply the new checks for demand become supply
	 */
	public void setHasDemandBecomeSupply(boolean hasDemandBecomeSupply) {
		this.hasDemandBecomeSupply = hasDemandBecomeSupply;
	}

	/**
	 * Checks if is checks for demand become supply.
	 * 
	 * @return true, if is checks for demand become supply
	 */
	public boolean isHasDemandBecomeSupply() {
		return hasDemandBecomeSupply;
	}

	/**
	 * Sets the bID.
	 * 
	 * @param bID the new bID
	 */
	public void setBID(int bID) {
		BID = bID;
	}

	/**
	 * Gets the bID.
	 * 
	 * @return the bID
	 */
	public int getBID() {
		return BID;
	}

	
}
