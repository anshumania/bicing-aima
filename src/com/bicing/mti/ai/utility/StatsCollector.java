package com.bicing.mti.ai.utility;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import com.bicing.mti.ai.aima.BicingState;

public class StatsCollector {

	private static final String DIR = "C:/all.things.google/test/stats/";
	
	private static final String DELIMITER ="|";

	 public static void writeToFileForStats(String stateInformation)
	 {
		 String FILENAME = System.getProperty("TEST_FILENAME");
	 try {
	        BufferedWriter out = new BufferedWriter(new FileWriter(DIR+FILENAME, true));
	        out.write(stateInformation);
	        out.close();
	    } catch (IOException e) {
	    	e.printStackTrace();
	    }
	 }

	public static void parseAndWriteInfo(BicingState state) {
		
		StringBuffer strBuff = new StringBuffer();
		strBuff.append(state.getBID());
		strBuff.append(DELIMITER);
		strBuff.append(state.getGlobalDemand());
		strBuff.append(DELIMITER);
		strBuff.append(state.getGlobalSupply());
		strBuff.append(DELIMITER);
		strBuff.append(state.getCurrentDemandSatisfied());
		strBuff.append(DELIMITER);
		strBuff.append(state.getCurrentSupply());
		strBuff.append(DELIMITER);
		strBuff.append(state.getCurrentDistanceTravelled());
		strBuff.append(DELIMITER);
		strBuff.append(state.getAvailableVans().size());
		strBuff.append(DELIMITER);
		strBuff.append(state.getAssignedVans().size());
		strBuff.append(DELIMITER);
		strBuff.append(state.getFinishedAssignmentVans().size());
		strBuff.append("\n");
		
		writeToFileForStats(strBuff.toString());
		
		
	}
}
