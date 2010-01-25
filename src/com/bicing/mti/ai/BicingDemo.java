package com.bicing.mti.ai;


import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import com.bicing.mti.ai.aima.BicingGoalTest;
import com.bicing.mti.ai.aima.BicingHeuristic;
import com.bicing.mti.ai.aima.BicingHeuristicDistance;
import com.bicing.mti.ai.aima.BicingState;
import com.bicing.mti.ai.aima.BicingSuccessorFunction;
import com.bicing.mti.ai.generator.Bicing;

import aima.search.framework.Problem;
import aima.search.framework.SearchAgent;
import aima.search.informed.HillClimbingSearch;
import aima.search.informed.Scheduler;
import aima.search.informed.SimulatedAnnealingSearch;

// TODO: Auto-generated Javadoc
/**
 * The Class BicingDemo.
 * @author      Anshuman Mehta
 * @author 		<a href="mailto:mehta.anshuman@gmail.com">mehta.anshuman@gmail.com</a>
 * @since       1.0
 */
public class BicingDemo {
	

//    private static Logger logger =
//            Logger.getLogger("global");

//	/** The number of vans. */
//	static int numberOfVans = 10;
//	
//	/** The number of stations. */
//	static int numberOfStations = 20;
//	
//	/** The ratio to cycles. */
//	static int ratioToCycles = 1;
	
	//demand became supply for 40,30,50
	/**
	 * The main method.
	 * 
	 * @param args the args
	 */
	
	public static String TEST_FILENAME ="TEST_FILENAME";
	public static String EXECUTE_TEST="EXECUTE_TEST";
	public static String EXT = ".csv";
	public static String TEST = "Test";
	public static void main (String[] args)
	{
		
		
		
		 String testFileName = TEST+"-7-20-50-moreWt2dist";
		 System.setProperty(EXECUTE_TEST,"TRUE");
		 System.setProperty(TEST_FILENAME, testFileName+EXT);
		 
		
		BicingHillClimbingSearch(11,20,50,Bicing.RUSH_HOUR);
//		BicingSimulatedAnnealingSearch(5,5,50,Bicing.RUSH_HOUR);
	}
	
	/**
	 * Bicing hill climbing search.
	 */
	public static void BicingHillClimbingSearch(int numberOfVans, int numberOfStations, int ratioToCycles,int scenario) {
		try {
			
			boolean append = true;
//			FileHandler handler = new FileHandler("myLog.log",append);
//			handler.setFormatter(new SimpleFormatter());
//			logger.addHandler(handler);
//			logger.log(java.util.logging.Level.INFO,"hello");
//		System.out.println("---BicingHillClimbingSearch----");
//		logger.log(java.util.logging.Level.INFO,"BicingHillClimbingSearch");
		Bicing generatedState = new Bicing(numberOfVans,numberOfStations*ratioToCycles,scenario,2);
//		Bicing generatedState = new Bicing(numberOfVans,numberOfStations*ratioToCycles,Bicing.EQUILIBRIUM,2);
	
		BicingState initialBicingState = new BicingState(generatedState,numberOfVans);
		System.out.println("------------InitialBicingState-----------");
		System.out.println(initialBicingState);
		initialBicingState.printBicingStationsList();
		System.out.println("-----------------------------------------");
//	
//		Problem problem = new Problem(initialBicingState,
//				new BicingSuccessorFunction(), new BicingGoalTest(), new BicingHeuristic());
		Problem problem = new Problem(initialBicingState,
				new BicingSuccessorFunction(), new BicingGoalTest(), new BicingHeuristicDistance());
		
		
		HillClimbingSearch search = new HillClimbingSearch();
		SearchAgent agent = new SearchAgent(problem, search);

		System.out.println();
		printActions(agent.getActions());
		System.out.println("Search Outcome=" + search.getOutcome());
		System.out.println("Final State=\n" + search.getLastSearchState());
		printInstrumentation(agent.getInstrumentation());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	/**
	 * Bicing simulated annealing search.
	 */
	public static void BicingSimulatedAnnealingSearch(int numberOfVans, int numberOfStations, int ratioToCycles, int scenario) {
		System.out.println("------BicingSimulatedAnnealingSearch-----------");
		try {

			Bicing generatedState = new Bicing(numberOfVans,numberOfStations*ratioToCycles,scenario,2);
			
			BicingState initialBicingState = new BicingState(generatedState,numberOfVans);
			System.out.println("------------InitialBicingState-----------");
			System.out.println(initialBicingState);
			System.out.println("-----------------------------------------");
			Problem problem = new Problem(initialBicingState,
					new BicingSuccessorFunction(), new BicingGoalTest(), new BicingHeuristic());
			
			int k = 20;
			double lam = 0.045;
			int limit = 20;
			//Scheduler scheduler = new Scheduler(5,0.040,20);
			
			SimulatedAnnealingSearch search = new SimulatedAnnealingSearch(100,k,limit,lam);
			SearchAgent agent = new SearchAgent(problem, search);

			System.out.println();
			printActions(agent.getActions());
			System.out.println("Search Outcome=" + search.getOutcome());
			System.out.println("Final State=\n" + search.getLastSearchState());
			printInstrumentation(agent.getInstrumentation());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Prints the instrumentation.
	 * 
	 * @param properties the properties
	 */
	private static void printInstrumentation(Properties properties) {
		Iterator keys = properties.keySet().iterator();
		while (keys.hasNext()) {
			String key = (String) keys.next();
			String property = properties.getProperty(key);
			System.out.println(key + " : " + property);
		}

	}

	/**
	 * Prints the actions.
	 * 
	 * @param actions the actions
	 */
	private static void printActions(List actions) {
		for (int i = 0; i < actions.size(); i++) {
			String action = (String) actions.get(i);
			System.out.println(action);
		}
	}

}
