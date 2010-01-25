package com.bicing.mti.ai.aima;



import java.util.Random;

import com.bicing.mti.ai.utility.StatsCollector;

import IA.Electrica.Demanda;
import aima.search.framework.HeuristicFunction;

// TODO: Auto-generated Javadoc
/**
 * The Class BicingHeuristic.
 * @author      Anshuman Mehta
 * @author 		<a href="mailto:mehta.anshuman@gmail.com">mehta.anshuman@gmail.com</a>
 * @since       1.0
 */
public class BicingHeuristic implements HeuristicFunction {

	/** The count. */
	static int count;
	
	/* (non-Javadoc)
	 * @see aima.search.framework.HeuristicFunction#getHeuristicValue(java.lang.Object)
	 */
	@Override
	public double getHeuristicValue(Object arg0) {
				
		BicingState state = (BicingState)arg0;
		if(!(state == null))
			System.out.println(state);

//		StatsCollector.parseAndWriteInfo(state);
//		double heuristicValue = -1;
//		if(state.getCurrentDemandSatisfied() ==  0)
//			heuristicValue = 100;
//		else 
//			state.getCurrentDemandSatisfied();
//			
			//System.out.println("initial demand - demand satisfied" + (state.getGlobalDemand()-state.getCurrentDemandSatisfied()));
		//double x = state.getCurrentDemandSatisfied()== 0 ? 0 : state.getGlobalDemand()/state.getCurrentDemandSatisfied();
		double x = state.getGlobalDemand()-state.getCurrentDemandSatisfied();
		System.out.println("x-----------" + x);
		return state.getGlobalDemand()-state.getCurrentDemandSatisfied(); 
		//state.getCurrentDemandSatisfied()== 0 ? Double.MAX_VALUE : state.getGlobalDemand()/state.getCurrentDemandSatisfied(); 
		//state.getGlobalDemand()-state.getCurrentDemandSatisfied();
		
		//return count-10;
	}

}
