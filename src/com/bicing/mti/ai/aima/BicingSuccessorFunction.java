package com.bicing.mti.ai.aima;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import com.bicing.mti.ai.actors.BicingStation;
import com.bicing.mti.ai.actors.Move;
import com.bicing.mti.ai.actors.MoveString;
import com.bicing.mti.ai.actors.Van;
import com.bicing.mti.ai.utility.StatsCollector;

import aima.search.framework.Successor;
import aima.search.framework.SuccessorFunction;

// TODO: Auto-generated Javadoc
/**
 * The Class BicingSuccessorFunction.
 *@author      Anshuman Mehta
 * @author 		<a href="mailto:mehta.anshuman@gmail.com">mehta.anshuman@gmail.com</a>
 * @since       1.0
 */
public class BicingSuccessorFunction implements SuccessorFunction {

	/** The give up for simulate annealing. */
	static int giveUpForSimulateAnnealing = 0;

	/* (non-Javadoc)
	 * @see aima.search.framework.SuccessorFunction#getSuccessors(java.lang.Object)
	 */
	@Override
	public List getSuccessors(Object arg0) {
//		System.out.println("in function getSuccessors, the " + ++inSuccessor + " time");
		// TODO Auto-generated method stub
		BicingState currentState = (BicingState) arg0;
		BicingState clonedState = BicingState.getClonedBicingState(currentState);
		
	if(System.getProperty("EXECUTE_TEST")!=null)
			StatsCollector.parseAndWriteInfo(currentState);
		
		List<MoveString> listOfMovements = getTheListOfVanMovementsOneStationAtATime(clonedState);
		if(listOfMovements.isEmpty())
			System.out.println("No more one movements ~!");
		
		List<MoveString> listOfDoubleMovements = getTheListOfVanMovementsTwoStationsAtATime(clonedState);
		if(listOfDoubleMovements.isEmpty())
			System.out.println("No more 2-movements ~1!");
		
	
		
		List<MoveString> allPossibleMovesList = new ArrayList<MoveString>();
		if(!listOfMovements.isEmpty())
			allPossibleMovesList.addAll(listOfMovements);
		if(!listOfDoubleMovements.isEmpty())
			allPossibleMovesList.addAll(listOfDoubleMovements);
		
		List<Successor> successors = new ArrayList<Successor>();
		if(!allPossibleMovesList.isEmpty())		
			successors = getSuccessorsByPerformingMovementsOnCurrentState(clonedState,allPossibleMovesList);
		//else
			//++giveUpForSimulateAnnealing;
		
		//Check The case if A demandStation has Become a SupplyStation	
		//List<Move> listIfDemandHasBecomeSupply = getTheListOfVanMovementsIfDemandHasBecomeSupply(currentState);
		
		
		
		return successors;
		
	}

	/**
	 * Gets the successors by performing movements on current state.
	 * 
	 * @param clonedState the cloned state
	 * @param allPossibleMovesList the all possible moves list
	 * 
	 * @return the successors by performing movements on current state
	 */
	private List<Successor> getSuccessorsByPerformingMovementsOnCurrentState(
			BicingState clonedState, List<MoveString> allPossibleMovesList) {

//		for(MoveString move : allPossibleMovesList)
//			System.out.println(move);
		
		
		List<Successor> successorStates = new ArrayList<Successor>();
		
		for(MoveString moveString : allPossibleMovesList)
		{
			BicingState successorState = BicingState.getClonedBicingState(clonedState);
			Move move = Move.generateMoveFromMoveString(successorState,moveString);
			
				successorState.performThisMove(move);
//				//in per move only one demand can become a supply so check here
//				if(successorState.isHasDemandBecomeSupply())
//				{
//					//there is a demandStation that has become a supplystation
//					//get a van from the available vans list (if any) first check
//					if(!successorState.getAvailableVans().isEmpty())
//					{
//						//assign a van to each of the demandStation
//						for(Van v : successorState.getAvailableVans())
//						{
//							
//						}
//					}
//				}
				successorState.getMovesForThisState().add(moveString);
				successorStates.add(new Successor(moveString.toString(),successorState));
				
			
		
			//check if move is feasible 
			// check if van can move 2 stations at a time 
			// chec
		}
			
		
		
		return successorStates;
	}

	/**
	 * Gets the the list of van movements by considering that a van
	 * moves two stations at a time.
	 * 
	 * @param currentState the current state
	 * 
	 * @return the the list of van movements two stations at a time
	 */
	private List<MoveString> getTheListOfVanMovementsTwoStationsAtATime(BicingState currentState) {
		List<MoveString> listOfDoubleMovements = new ArrayList<MoveString>();
		
		for(Van van : currentState.getAssignedVans()) // for all supplyVans get (2) of all the demandStations
		{
		for(BicingStation demandStation1 : currentState.getDemandStations())
			for(BicingStation demandStation2 : currentState.getDemandStations())
				if(demandStation1.getStationID() != demandStation2.getStationID())
				{
					MoveString move = new MoveString(van.getOriginStation().getStationID(),demandStation1.getStationID(), demandStation2.getStationID(), van.getVanID());
					listOfDoubleMovements.add(move);
				}
		}
		return listOfDoubleMovements;
	}

	/**
	 * Gets the the list of van movements one station at a time.
	 * 
	 * @param currentState the current state
	 * 
	 * @return the the list of van movements one station at a time
	 */
	private List<MoveString> getTheListOfVanMovementsOneStationAtATime(BicingState currentState) {
	
		List<MoveString> listOfMovements = new ArrayList<MoveString>();
		for(Van van : currentState.getAssignedVans())  // for all supplyVans get (1) of all the demandStations
		{
					
			for(BicingStation demandStation : currentState.getDemandStations())
				{
					//Move move = new Move(van.getOriginStation(),demandStation,van);
				    if(!van.getStationsTravelledTo().contains(demandStation))
				    {
				    	MoveString sMove = new MoveString(van.getOriginStation().getStationID(),demandStation.getStationID(),van.getVanID());
						listOfMovements.add(sMove);
				    }
				}
		}

		return listOfMovements;
	}

	}
