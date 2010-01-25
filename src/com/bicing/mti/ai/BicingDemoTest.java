package com.bicing.mti.ai;

import java.util.Properties;

import com.bicing.mti.ai.generator.Bicing;

import junit.framework.TestCase;

public class BicingDemoTest extends TestCase {

	public static String TEST_FILENAME ="TEST_FILENAME";
	public static String EXECUTE_TEST="EXECUTE_TEST";
	public static String EXT = ".csv";
	public static String TEST = "Test";
	
	/*
	 * test for the difference in scenarios
	 */

    // numberOfVans = 5;
	// numberOfStations = 5;
    // ratioToCycles = 50;
	
	public void testBicingHillClimbingSearch1() {
		
		 String testFileName = TEST+"-5-5-50-eq";
		 System.setProperty(EXECUTE_TEST,"TRUE");
		 System.setProperty(TEST_FILENAME, testFileName+EXT);
		 
		 
		 BicingDemo.BicingHillClimbingSearch(5,5,50,Bicing.EQUILIBRIUM);
	}
	
    // numberOfVans = 5;
	// numberOfStations = 5;
    // ratioToCycles = 50;	
	public void testBicingHillClimbingSearch2() {
		
		 String testFileName = TEST+"-5-5-50-rsh";
		 System.setProperty(EXECUTE_TEST,"TRUE");
		 System.setProperty(TEST_FILENAME, testFileName+EXT);
		 
		 BicingDemo.BicingHillClimbingSearch(5,5,50,Bicing.RUSH_HOUR);
	}
	
	 // test to check the threshold of vans & difference in scenario
	 
	
    // numberOfVans = 5;
	// numberOfStations = 15;
    // ratioToCycles = 50;	
	public void testBicingHillClimbingSearch3() {
		
		 String testFileName = TEST+"-5-15-50-eq";
		 System.setProperty(EXECUTE_TEST,"TRUE");
		 System.setProperty(TEST_FILENAME, testFileName+EXT);
		 
		 BicingDemo.BicingHillClimbingSearch(5,15,50,Bicing.EQUILIBRIUM);
	}
	// numberOfVans = 5;
	// numberOfStations = 15;
    // ratioToCycles = 50;	
	public void testBicingHillClimbingSearch4() {
		
		 String testFileName = TEST+"-5-15-50-rsh";
		 System.setProperty(EXECUTE_TEST,"TRUE");
		 System.setProperty(TEST_FILENAME, testFileName+EXT);
		 
		 BicingDemo.BicingHillClimbingSearch(5,15,50,Bicing.RUSH_HOUR);
	}
	// numberOfVans = 7;
	// numberOfStations = 15;
    // ratioToCycles = 50;	
	public void testBicingHillClimbingSearch5() {
		
		 String testFileName = TEST+"-7-15-50-eq";
		 System.setProperty(EXECUTE_TEST,"TRUE");
		 System.setProperty(TEST_FILENAME, testFileName+EXT);
		 
		 BicingDemo.BicingHillClimbingSearch(7,15,50,Bicing.EQUILIBRIUM);
	}
	// numberOfVans = 7;
	// numberOfStations = 15;
    // ratioToCycles = 50;	
	public void testBicingHillClimbingSearch6() {
		
		 String testFileName = TEST+"-7-15-50-rsh";
		 System.setProperty(EXECUTE_TEST,"TRUE");
		 System.setProperty(TEST_FILENAME, testFileName+EXT);
		 
		 BicingDemo.BicingHillClimbingSearch(7,15,50,Bicing.RUSH_HOUR);
	}
	// numberOfVans = 10;
	// numberOfStations = 15;
    // ratioToCycles = 50;	
	public void testBicingHillClimbingSearch7() {
		
		 String testFileName = TEST+"-10-15-50-eq";
		 System.setProperty(EXECUTE_TEST,"TRUE");
		 System.setProperty(TEST_FILENAME, testFileName+EXT);
		 
		 BicingDemo.BicingHillClimbingSearch(10,15,50,Bicing.EQUILIBRIUM);
	}
	// numberOfVans = 10;
	// numberOfStations = 15;
    // ratioToCycles = 50;	
	public void testBicingHillClimbingSearch8() {
		
		 String testFileName = TEST+"-10-15-50-rsh";
		 System.setProperty(EXECUTE_TEST,"TRUE");
		 System.setProperty(TEST_FILENAME, testFileName+EXT);
		 
		 BicingDemo.BicingHillClimbingSearch(10,15,50,Bicing.RUSH_HOUR);
	}
	// numberOfVans = 15;
	// numberOfStations = 15;
    // ratioToCycles = 50;	
	public void testBicingHillClimbingSearch9() {
		
		 String testFileName = TEST+"-15-15-50-eq";
		 System.setProperty(EXECUTE_TEST,"TRUE");
		 System.setProperty(TEST_FILENAME, testFileName+EXT);
		 
		 BicingDemo.BicingHillClimbingSearch(15,15,50,Bicing.EQUILIBRIUM);
	}
	// numberOfVans = 15;
	// numberOfStations = 15;
    // ratioToCycles = 50;	
	public void testBicingHillClimbingSearch10() {
		
		 String testFileName = TEST+"-15-15-50-rsh";
		 System.setProperty(EXECUTE_TEST,"TRUE");
		 System.setProperty(TEST_FILENAME, testFileName+EXT);
		 
		 BicingDemo.BicingHillClimbingSearch(15,15,50,Bicing.RUSH_HOUR);
	}
	
		// numberOfVans = 10;
	// numberOfStations = 20;
    // ratioToCycles = 50;	
	public void testBicingHillClimbingSearch11() {
		
		 String testFileName = TEST+"-10-20-50-eq";
		 System.setProperty(EXECUTE_TEST,"TRUE");
		 System.setProperty(TEST_FILENAME, testFileName+EXT);
		 
		 BicingDemo.BicingHillClimbingSearch(10,20,50,Bicing.EQUILIBRIUM);
	}
	// numberOfVans = 10;
	// numberOfStations = 20;
    // ratioToCycles = 50;	
	public void testBicingHillClimbingSearch12() {
		
		 String testFileName = TEST+"-10-20-50-rsh";
		 System.setProperty(EXECUTE_TEST,"TRUE");
		 System.setProperty(TEST_FILENAME, testFileName+EXT);
		 
		 BicingDemo.BicingHillClimbingSearch(15,15,50,Bicing.RUSH_HOUR);
	}
	// numberOfVans = 15;
	// numberOfStations = 25;
    // ratioToCycles = 50;	
	public void testBicingHillClimbingSearch13() {
		
		 String testFileName = TEST+"-15-25-50-eq";
		 System.setProperty(EXECUTE_TEST,"TRUE");
		 System.setProperty(TEST_FILENAME, testFileName+EXT);
		 
		 BicingDemo.BicingHillClimbingSearch(15,25,50,Bicing.EQUILIBRIUM);
	}
	// numberOfVans = 15;
	// numberOfStations = 25;
    // ratioToCycles = 50;	
	public void testBicingHillClimbingSearch14() {
		
		 String testFileName = TEST+"-15-25-50-rsh";
		 System.setProperty(EXECUTE_TEST,"TRUE");
		 System.setProperty(TEST_FILENAME, testFileName+EXT);
		 
		 BicingDemo.BicingHillClimbingSearch(15,25,50,Bicing.RUSH_HOUR);
	}
		// numberOfVans = 15;
	// numberOfStations = 10;
    // ratioToCycles = 50;	
	public void testBicingHillClimbingSearch15() {
		
		 String testFileName = TEST+"-15-10-50-eq";
		 System.setProperty(EXECUTE_TEST,"TRUE");
		 System.setProperty(TEST_FILENAME, testFileName+EXT);
		 
		 BicingDemo.BicingHillClimbingSearch(15,10,50,Bicing.EQUILIBRIUM);
	}
	// numberOfVans = 15;
	// numberOfStations = 10;
    // ratioToCycles = 50;	
	public void testBicingHillClimbingSearch16() {
		
		 String testFileName = TEST+"-15-10-50-rsh";
		 System.setProperty(EXECUTE_TEST,"TRUE");
		 System.setProperty(TEST_FILENAME, testFileName+EXT);
		 
		 BicingDemo.BicingHillClimbingSearch(15,10,50,Bicing.RUSH_HOUR);
	}
	
			// numberOfVans = 7;
	// numberOfStations = 20;
    // ratioToCycles = 50;	
	public void testBicingHillClimbingSearch17() {
		
		 String testFileName = TEST+"-7-20-50-eq";
		 System.setProperty(EXECUTE_TEST,"TRUE");
		 System.setProperty(TEST_FILENAME, testFileName+EXT);
		 
		 BicingDemo.BicingHillClimbingSearch(7,20,50,Bicing.EQUILIBRIUM);
	}
	// numberOfVans = 7;
	// numberOfStations = 20;
    // ratioToCycles = 50;	
	public void testBicingHillClimbingSearch18() {
		
		 String testFileName = TEST+"-7-20-50-rsh";
		 System.setProperty(EXECUTE_TEST,"TRUE");
		 System.setProperty(TEST_FILENAME, testFileName+EXT);
		 
		 BicingDemo.BicingHillClimbingSearch(7,20,50,Bicing.RUSH_HOUR);
	}
	
			// numberOfVans = 8;
	// numberOfStations = 20;
    // ratioToCycles = 50;	
	public void testBicingHillClimbingSearch20() {
		
		 String testFileName = TEST+"-8-20-50-eq";
		 System.setProperty(EXECUTE_TEST,"TRUE");
		 System.setProperty(TEST_FILENAME, testFileName+EXT);
		 
		 BicingDemo.BicingHillClimbingSearch(8,20,50,Bicing.EQUILIBRIUM);
	}
	// numberOfVans = 8;
	// numberOfStations = 20;
    // ratioToCycles = 50;	
	public void testBicingHillClimbingSearch21() {
		
		 String testFileName = TEST+"-8-20-50-rsh";
		 System.setProperty(EXECUTE_TEST,"TRUE");
		 System.setProperty(TEST_FILENAME, testFileName+EXT);
		 
		 BicingDemo.BicingHillClimbingSearch(8,20,50,Bicing.RUSH_HOUR);
	}
	
				// numberOfVans = 9;
	// numberOfStations = 20;
    // ratioToCycles = 50;	
	public void testBicingHillClimbingSearch22() {
		
		 String testFileName = TEST+"-9-20-50-eq";
		 System.setProperty(EXECUTE_TEST,"TRUE");
		 System.setProperty(TEST_FILENAME, testFileName+EXT);
		 
		 BicingDemo.BicingHillClimbingSearch(9,20,50,Bicing.EQUILIBRIUM);
	}
	// numberOfVans = 9;
	// numberOfStations = 20;
    // ratioToCycles = 50;	
	public void testBicingHillClimbingSearch23() {
		
		 String testFileName = TEST+"-9-20-50-rsh";
		 System.setProperty(EXECUTE_TEST,"TRUE");
		 System.setProperty(TEST_FILENAME, testFileName+EXT);
		 
		 BicingDemo.BicingHillClimbingSearch(9,20,50,Bicing.RUSH_HOUR);
	}
	// numberOfVans = 11;
	// numberOfStations = 20;
    // ratioToCycles = 50;	
	public void testBicingHillClimbingSearch24() {
		
		 String testFileName = TEST+"-11-20-50-eq";
		 System.setProperty(EXECUTE_TEST,"TRUE");
		 System.setProperty(TEST_FILENAME, testFileName+EXT);
		 
		 BicingDemo.BicingHillClimbingSearch(11,20,50,Bicing.EQUILIBRIUM);
	}
	// numberOfVans = 11;
	// numberOfStations = 20;
    // ratioToCycles = 50;	
	public void testBicingHillClimbingSearch25() {
		
		 String testFileName = TEST+"-11-20-50-rsh";
		 System.setProperty(EXECUTE_TEST,"TRUE");
		 System.setProperty(TEST_FILENAME, testFileName+EXT);
		 
		 BicingDemo.BicingHillClimbingSearch(11,20,50,Bicing.RUSH_HOUR);
	}
	

}
