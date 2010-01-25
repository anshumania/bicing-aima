package com.bicing.mti.ai;

import com.bicing.mti.ai.generator.Bicing;

public class BicingDemoSimAnnTest extends BicingDemoTest {
	
	public static String SIM = "Sim";
	  // numberOfVans = 5;
	// numberOfStations = 5;
    // ratioToCycles = 50;
	
	public void testSimulatedAnnealingSearch1() {
		
		 String testFileName = TEST+"-5-5-50-eq";
		 System.setProperty(EXECUTE_TEST,"TRUE");
		 System.setProperty(TEST_FILENAME, testFileName+EXT);
		 
		 
		 BicingDemo.BicingSimulatedAnnealingSearch(5,5,50,Bicing.EQUILIBRIUM);
	}
	
    // numberOfVans = 5;
	// numberOfStations = 5;
    // ratioToCycles = 50;	
	public void testSimulatedAnnealingSearch2() {
		
		 String testFileName = TEST+SIM+"-5-5-50-rsh";
		 System.setProperty(EXECUTE_TEST,"TRUE");
		 System.setProperty(TEST_FILENAME, testFileName+EXT);
		 
		 BicingDemo.BicingSimulatedAnnealingSearch(5,5,50,Bicing.RUSH_HOUR);
	}
	
	 // test to check the threshold of vans & difference in scenario
	 
	
    // numberOfVans = 5;
	// numberOfStations = 15;
    // ratioToCycles = 50;	
	public void testSimulatedAnnealingSearch3() {
		
		 String testFileName = TEST+SIM+"-5-15-50-eq";
		 System.setProperty(EXECUTE_TEST,"TRUE");
		 System.setProperty(TEST_FILENAME, testFileName+EXT);
		 
		 BicingDemo.BicingSimulatedAnnealingSearch(5,15,50,Bicing.EQUILIBRIUM);
	}
	// numberOfVans = 5;
	// numberOfStations = 15;
    // ratioToCycles = 50;	
	public void testSimulatedAnnealingSearch4() {
		
		 String testFileName = TEST+SIM+"-5-15-50-rsh";
		 System.setProperty(EXECUTE_TEST,"TRUE");
		 System.setProperty(TEST_FILENAME, testFileName+EXT);
		 
		 BicingDemo.BicingSimulatedAnnealingSearch(5,15,50,Bicing.RUSH_HOUR);
	}
	// numberOfVans = 7;
	// numberOfStations = 15;
    // ratioToCycles = 50;	
	public void testSimulatedAnnealingSearch5() {
		
		 String testFileName = TEST+SIM+"-7-15-50-eq";
		 System.setProperty(EXECUTE_TEST,"TRUE");
		 System.setProperty(TEST_FILENAME, testFileName+EXT);
		 
		 BicingDemo.BicingSimulatedAnnealingSearch(7,15,50,Bicing.EQUILIBRIUM);
	}
	// numberOfVans = 7;
	// numberOfStations = 15;
    // ratioToCycles = 50;	
	public void testSimulatedAnnealingSearch6() {
		
		 String testFileName = TEST+SIM+"-7-15-50-rsh";
		 System.setProperty(EXECUTE_TEST,"TRUE");
		 System.setProperty(TEST_FILENAME, testFileName+EXT);
		 
		 BicingDemo.BicingSimulatedAnnealingSearch(7,15,50,Bicing.RUSH_HOUR);
	}
	// numberOfVans = 10;
	// numberOfStations = 15;
    // ratioToCycles = 50;	
	public void testSimulatedAnnealingSearch7() {
		
		 String testFileName = TEST+SIM+"-10-15-50-eq";
		 System.setProperty(EXECUTE_TEST,"TRUE");
		 System.setProperty(TEST_FILENAME, testFileName+EXT);
		 
		 BicingDemo.BicingSimulatedAnnealingSearch(10,15,50,Bicing.EQUILIBRIUM);
	}
	// numberOfVans = 10;
	// numberOfStations = 15;
    // ratioToCycles = 50;	
	public void testSimulatedAnnealingSearch8() {
		
		 String testFileName = TEST+SIM+"-10-15-50-rsh";
		 System.setProperty(EXECUTE_TEST,"TRUE");
		 System.setProperty(TEST_FILENAME, testFileName+EXT);
		 
		 BicingDemo.BicingSimulatedAnnealingSearch(10,15,50,Bicing.RUSH_HOUR);
	}
	// numberOfVans = 15;
	// numberOfStations = 15;
    // ratioToCycles = 50;	
	public void testSimulatedAnnealingSearch9() {
		
		 String testFileName = TEST+SIM+"-15-15-50-eq";
		 System.setProperty(EXECUTE_TEST,"TRUE");
		 System.setProperty(TEST_FILENAME, testFileName+EXT);
		 
		 BicingDemo.BicingSimulatedAnnealingSearch(15,15,50,Bicing.EQUILIBRIUM);
	}
	// numberOfVans = 15;
	// numberOfStations = 15;
    // ratioToCycles = 50;	
	public void testSimulatedAnnealingSearch10() {
		
		 String testFileName = TEST+SIM+"-15-15-50-rsh";
		 System.setProperty(EXECUTE_TEST,"TRUE");
		 System.setProperty(TEST_FILENAME, testFileName+EXT);
		 
		 BicingDemo.BicingSimulatedAnnealingSearch(15,15,50,Bicing.RUSH_HOUR);
	}
	
		// numberOfVans = 10;
	// numberOfStations = 20;
    // ratioToCycles = 50;	
	public void testSimulatedAnnealingSearch11() {
		
		 String testFileName = TEST+SIM+"-10-20-50-eq";
		 System.setProperty(EXECUTE_TEST,"TRUE");
		 System.setProperty(TEST_FILENAME, testFileName+EXT);
		 
		 BicingDemo.BicingSimulatedAnnealingSearch(10,20,50,Bicing.EQUILIBRIUM);
	}
	// numberOfVans = 10;
	// numberOfStations = 20;
    // ratioToCycles = 50;	
	public void testSimulatedAnnealingSearch12() {
		
		 String testFileName = TEST+SIM+"-10-20-50-rsh";
		 System.setProperty(EXECUTE_TEST,"TRUE");
		 System.setProperty(TEST_FILENAME, testFileName+EXT);
		 
		 BicingDemo.BicingSimulatedAnnealingSearch(15,15,50,Bicing.RUSH_HOUR);
	}
	// numberOfVans = 15;
	// numberOfStations = 25;
    // ratioToCycles = 50;	
	public void testSimulatedAnnealingSearch13() {
		
		 String testFileName = TEST+SIM+"-15-25-50-eq";
		 System.setProperty(EXECUTE_TEST,"TRUE");
		 System.setProperty(TEST_FILENAME, testFileName+EXT);
		 
		 BicingDemo.BicingSimulatedAnnealingSearch(15,25,50,Bicing.EQUILIBRIUM);
	}
	// numberOfVans = 15;
	// numberOfStations = 25;
    // ratioToCycles = 50;	
	public void testSimulatedAnnealingSearch14() {
		
		 String testFileName = TEST+SIM+"-15-25-50-rsh";
		 System.setProperty(EXECUTE_TEST,"TRUE");
		 System.setProperty(TEST_FILENAME, testFileName+EXT);
		 
		 BicingDemo.BicingSimulatedAnnealingSearch(15,25,50,Bicing.RUSH_HOUR);
	}
		// numberOfVans = 15;
	// numberOfStations = 10;
    // ratioToCycles = 50;	
	public void testSimulatedAnnealingSearch15() {
		
		 String testFileName = TEST+SIM+"-15-10-50-eq";
		 System.setProperty(EXECUTE_TEST,"TRUE");
		 System.setProperty(TEST_FILENAME, testFileName+EXT);
		 
		 BicingDemo.BicingSimulatedAnnealingSearch(15,10,50,Bicing.EQUILIBRIUM);
	}
	// numberOfVans = 15;
	// numberOfStations = 10;
    // ratioToCycles = 50;	
	public void testSimulatedAnnealingSearch16() {
		
		 String testFileName = TEST+SIM+"-15-10-50-rsh";
		 System.setProperty(EXECUTE_TEST,"TRUE");
		 System.setProperty(TEST_FILENAME, testFileName+EXT);
		 
		 BicingDemo.BicingSimulatedAnnealingSearch(15,10,50,Bicing.RUSH_HOUR);
	}
	
			// numberOfVans = 7;
	// numberOfStations = 20;
    // ratioToCycles = 50;	
	public void testSimulatedAnnealingSearch17() {
		
		 String testFileName = TEST+SIM+"-7-20-50-eq";
		 System.setProperty(EXECUTE_TEST,"TRUE");
		 System.setProperty(TEST_FILENAME, testFileName+EXT);
		 
		 BicingDemo.BicingSimulatedAnnealingSearch(7,20,50,Bicing.EQUILIBRIUM);
	}
	// numberOfVans = 7;
	// numberOfStations = 20;
    // ratioToCycles = 50;	
	public void testSimulatedAnnealingSearch18() {
		
		 String testFileName = TEST+SIM+"-7-20-50-rsh";
		 System.setProperty(EXECUTE_TEST,"TRUE");
		 System.setProperty(TEST_FILENAME, testFileName+EXT);
		 
		 BicingDemo.BicingSimulatedAnnealingSearch(7,20,50,Bicing.RUSH_HOUR);
	}
	
			// numberOfVans = 8;
	// numberOfStations = 20;
    // ratioToCycles = 50;	
	public void testSimulatedAnnealingSearch20() {
		
		 String testFileName = TEST+SIM+"-8-20-50-eq";
		 System.setProperty(EXECUTE_TEST,"TRUE");
		 System.setProperty(TEST_FILENAME, testFileName+EXT);
		 
		 BicingDemo.BicingSimulatedAnnealingSearch(8,20,50,Bicing.EQUILIBRIUM);
	}
	// numberOfVans = 8;
	// numberOfStations = 20;
    // ratioToCycles = 50;	
	public void testSimulatedAnnealingSearch21() {
		
		 String testFileName = TEST+SIM+"-8-20-50-rsh";
		 System.setProperty(EXECUTE_TEST,"TRUE");
		 System.setProperty(TEST_FILENAME, testFileName+EXT);
		 
		 BicingDemo.BicingSimulatedAnnealingSearch(8,20,50,Bicing.RUSH_HOUR);
	}
	
				// numberOfVans = 9;
	// numberOfStations = 20;
    // ratioToCycles = 50;	
	public void testSimulatedAnnealingSearch22() {
		
		 String testFileName = TEST+SIM+"-9-20-50-eq";
		 System.setProperty(EXECUTE_TEST,"TRUE");
		 System.setProperty(TEST_FILENAME, testFileName+EXT);
		 
		 BicingDemo.BicingSimulatedAnnealingSearch(9,20,50,Bicing.EQUILIBRIUM);
	}
	// numberOfVans = 9;
	// numberOfStations = 20;
    // ratioToCycles = 50;	
	public void testSimulatedAnnealingSearch23() {
		
		 String testFileName = TEST+SIM+"-9-20-50-rsh";
		 System.setProperty(EXECUTE_TEST,"TRUE");
		 System.setProperty(TEST_FILENAME, testFileName+EXT);
		 
		 BicingDemo.BicingSimulatedAnnealingSearch(9,20,50,Bicing.RUSH_HOUR);
	}
	// numberOfVans = 11;
	// numberOfStations = 20;
    // ratioToCycles = 50;	
	public void testSimulatedAnnealingSearch24() {
		
		 String testFileName = TEST+SIM+"-11-20-50-eq";
		 System.setProperty(EXECUTE_TEST,"TRUE");
		 System.setProperty(TEST_FILENAME, testFileName+EXT);
		 
		 BicingDemo.BicingSimulatedAnnealingSearch(11,20,50,Bicing.EQUILIBRIUM);
	}
	// numberOfVans = 11;
	// numberOfStations = 20;
    // ratioToCycles = 50;	
	public void testSimulatedAnnealingSearch25() {
		
		 String testFileName = TEST+SIM+"-11-20-50-rsh";
		 System.setProperty(EXECUTE_TEST,"TRUE");
		 System.setProperty(TEST_FILENAME, testFileName+EXT);
		 
		 BicingDemo.BicingSimulatedAnnealingSearch(11,20,50,Bicing.RUSH_HOUR);
	}
}
