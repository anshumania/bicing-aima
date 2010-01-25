package com.bicing.mti.ai.actors;

import java.io.Serializable;

import com.bicing.mti.ai.aima.BicingState;



// TODO: Auto-generated Javadoc
/**
 * The Class Move represents the move for a Van
 * @author      Anshuman Mehta
 * @author 		<a href="mailto:mehta.anshuman@gmail.com">mehta.anshuman@gmail.com</a>
 * @since       1.0
 */
public class Move implements Serializable{

	/**
	 * The Enum TYPE.
	 * A Move can be SINGLE or DOUBLE
	 */
	public enum TYPE { SINGLE, DOUBLE };
	
	/** The supply station. */
	BicingStation supplyStation;
	
	/** The demand station. */
	BicingStation demandStation;
	
	/** The demand station2. */
	private BicingStation demandStation2;
	
	/** The van assigned for this move. */
	private Van vanAssignedForThisMove;
	
	/** The bicycles moved in this move. */
	private int bicyclesMovedInThisMove;
	
	/** The type. */
	TYPE type;
	
	/**
	 * Gets the type.
	 * 
	 * @return the type
	 */
	public TYPE getType() {
		return type;
	}

	/**
	 * Gets the bicycles moved in this move.
	 * 
	 * @return the bicycles moved in this move
	 */
	public int getBicyclesMovedInThisMove() {
		return bicyclesMovedInThisMove;
	}

	/**
	 * Sets the bicycles moved in this move.
	 * 
	 * @param bicyclesMovedInThisMove the new bicycles moved in this move
	 */
	public void setBicyclesMovedInThisMove(int bicyclesMovedInThisMove) {
		this.bicyclesMovedInThisMove = bicyclesMovedInThisMove;
	}

	/**
	 * Instantiates a new move.
	 * 
	 * @param supplyStation the supply station
	 * @param demandStation the demand station
	 * @param van the van
	 */
	public Move(BicingStation supplyStation, BicingStation demandStation, Van van) {
		super();
		this.supplyStation = supplyStation;
		this.demandStation = demandStation;
		this.vanAssignedForThisMove = van;
		this.type = TYPE.SINGLE;
		
	}
	
	/**
	 * Instantiates a new move.
	 * 
	 * @param supplyStation the supply station
	 * @param demandStation the demand station
	 * @param demandStation2 the demand station2
	 * @param van the van
	 */
	public Move(BicingStation supplyStation, BicingStation demandStation, BicingStation demandStation2, Van van) {
		super();
		this.supplyStation = supplyStation;
		this.demandStation = demandStation;
		this.demandStation2= demandStation2;
		this.vanAssignedForThisMove = van;
		this.type = TYPE.DOUBLE;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString()
	{
		StringBuffer movString = new StringBuffer();
		movString.append("[Move=[S="+getSupplyStation().getStationID()+" to ");
		movString.append("D1="+getDemandStation().getStationID()+ ":");
		if(this.type!=TYPE.SINGLE)
			movString.append("D2="+getDemandStation2().getStationID()+ ":");
		movString.append("bics="+getBicyclesMovedInThisMove());
		return movString.toString();  
	}
	
	
	/**
	 * Gets the supply station.
	 * 
	 * @return the supply station
	 */
	public BicingStation getSupplyStation() {
		return supplyStation;
	}
	
	/**
	 * Sets the supply station.
	 * 
	 * @param supplyStation the new supply station
	 */
	public void setSupplyStation(BicingStation supplyStation) {
		this.supplyStation = supplyStation;
	}
	
	/**
	 * Gets the demand station.
	 * 
	 * @return the demand station
	 */
	public BicingStation getDemandStation() {
		return demandStation;
	}
	
	/**
	 * Sets the demand station.
	 * 
	 * @param demandStation the new demand station
	 */
	public void setDemandStation(BicingStation demandStation) {
		this.demandStation = demandStation;
	}

	/**
	 * Sets the van assigned for this move.
	 * 
	 * @param vanAssignedForThisMove the new van assigned for this move
	 */
	public void setVanAssignedForThisMove(Van vanAssignedForThisMove) {
		this.vanAssignedForThisMove = vanAssignedForThisMove;
	}

	/**
	 * Gets the van assigned for this move.
	 * 
	 * @return the van assigned for this move
	 */
	public Van getVanAssignedForThisMove() {
		return vanAssignedForThisMove;
	}

	/**
	 * Sets the demand station2.
	 * 
	 * @param demandStation2 the new demand station2
	 */
	public void setDemandStation2(BicingStation demandStation2) {
		this.demandStation2 = demandStation2;
	}

	/**
	 * Gets the demand station2.
	 * 
	 * @return the demand station2
	 */
	public BicingStation getDemandStation2() {
		return demandStation2;
	}

	/**
	 * Generate move from move string.
	 * 
	 * @param cState the c state
	 * @param moveString the move string
	 * 
	 * @return the move
	 */
	public static Move generateMoveFromMoveString(BicingState cState,
			MoveString moveString) {
		
		int s1 = moveString.getSupplyStationId();
		int d1 = moveString.getDemandStationId();
		int d2 = moveString.getDemandStation2Id();
		int v1 = moveString.getVanId();
		
		return (d2 == -1) ? new Move(cState.getBicingStationMap().get(s1),cState.getBicingStationMap().get(d1),cState.getVanMap().get(v1)) :
			new Move(cState.getBicingStationMap().get(s1),cState.getBicingStationMap().get(d1),cState.getBicingStationMap().get(d2),cState.getVanMap().get(v1));
		
		
	}
	
	
	

	

}
