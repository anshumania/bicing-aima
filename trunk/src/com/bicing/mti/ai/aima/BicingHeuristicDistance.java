package com.bicing.mti.ai.aima;



import java.util.Random;

import IA.Electrica.Demanda;
import aima.search.framework.HeuristicFunction;

// TODO: Auto-generated Javadoc
/**
 * The Class BicingHeuristic.
 * @author      Anshuman Mehta
 * @author 		<a href="mailto:mehta.anshuman@gmail.com">mehta.anshuman@gmail.com</a>
 * @since       1.0
 */
public class BicingHeuristicDistance implements HeuristicFunction {

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

//		double heuristicValue = -1;
//		if(state.getCurrentDemandSatisfied() ==  0)
//			heuristicValue = 100;
//		else 
//			state.getCurrentDemandSatisfied();
//			
			System.out.println("initial demand - demand satisfied" + (state.getGlobalDemand()-state.getCurrentDemandSatisfied()));
			double heuristic1 = state.getGlobalDemand()-state.getCurrentDemandSatisfied();
			double heuristic2pt1 = state.getCurrentDistanceTravelled() == 0 ?  -Double.MAX_VALUE: -state.getCurrentDistanceTravelled();
			double heuristic2pt2 = state.getCurrentDemandSatisfied();
			double heuristic2pt3 = state.getAvailableVans().size()-state.getFinishedAssignmentVans().size();
			double val = (heuristic2pt3+Math.pow(heuristic2pt2,2)/heuristic2pt1);
			System.out.println(" ------------------" +heuristic2pt3 + "-------------------------- " + val);
		
		//	heuristic1*heuristic1/heuristc2;
			
		return val; 
		//heuristic2*heuristic2/heuristic1;
		
		//return count-10;
	}

}
