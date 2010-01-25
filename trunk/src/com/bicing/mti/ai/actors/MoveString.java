package com.bicing.mti.ai.actors;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * The Class MoveString is a text representation of a Move to save
 * space during successor generation.
 * @author      Anshuman Mehta
 * @author 		<a href="mailto:mehta.anshuman@gmail.com">mehta.anshuman@gmail.com</a>
 * @since       1.0
 */
public class MoveString implements Serializable{

	/** The supply station id. */
	int supplyStationId;
	
	/**
	 * Gets the supply station id.
	 * 
	 * @return the supply station id
	 */
	public int getSupplyStationId() {
		return supplyStationId;
	}
	
	/**
	 * Gets the demand station id.
	 * 
	 * @return the demand station id
	 */
	public int getDemandStationId() {
		return demandStationId;
	}
	
	/**
	 * Gets the demand station2 id.
	 * 
	 * @return the demand station2 id
	 */
	public int getDemandStation2Id() {
		return demandStation2Id;
	}
	
	/**
	 * Gets the van id.
	 * 
	 * @return the van id
	 */
	public int getVanId() {
		return vanId;
	}
	
	/** The demand station id. */
	int demandStationId;
	
	/** The demand station2 id. */
	int demandStation2Id;
	
	/** The van id. */
	int vanId;
	
	/**
	 * Instantiates a new move string.
	 * 
	 * @param s1 the s1
	 * @param d1 the d1
	 * @param v1 the v1
	 */
	public MoveString(int s1, int d1, int v1)
	{
		this.supplyStationId = s1;
		this.demandStationId = d1;
		this.demandStation2Id = -1;
		this.vanId = v1;
	}
	
	/**
	 * Instantiates a new move string.
	 * 
	 * @param s1 the s1
	 * @param d1 the d1
	 * @param d2 the d2
	 * @param v1 the v1
	 */
	public MoveString(int s1, int d1, int d2, int v1)
	{
		this.supplyStationId = s1;
		this.demandStationId = d1;
		this.demandStation2Id = d2;
		this.vanId = v1;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString()
	{
		StringBuffer buff = new StringBuffer();
		buff.append("Move[Van="+getVanId()+"]");
		buff.append("from[Sup="+getSupplyStationId()+"]");
		buff.append("to[Dem="+getDemandStationId()+"]");
		if(getDemandStation2Id()!=-1)
			buff.append("and[Dem2="+getDemandStation2Id()+"]");
		return buff.toString();
	}
	
	
	
}
