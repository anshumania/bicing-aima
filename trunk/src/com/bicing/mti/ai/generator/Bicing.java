/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bicing.mti.ai.generator;

import java.io.Serializable;
import java.util.Random;

/**
 *
 * This class generates the elements for the Bicing problem
 *
 *  - The number of bicycles of each station that will not be used this hour
 *  - The probable state of the stations the next hour (only accounting the users)
 *  - Probable demand for each station the next hour
 *  - Coordenates of the stations
 *
 * @author bejar
 */
public class Bicing implements Serializable{

    private int numberOfStations;
    private int numberOfBicycles;
    private int modoDem;
    private int[][] coordStations;
    private int[] stateOfStations;
    private int[] stateOfNextStations;
    private int[] newDemand;
    public final static int EQUILIBRIUM = 0;
    public final static int RUSH_HOUR = 1;
    private Random myRandom;
    private final static int VAR_DISTRIBUTION_STATE = 2;
    private final static double PERCENTAGE_USER_MOVS = .8;
    private final static double VAR_DEMAND_EQ = 0.5;
    private final static double VAR_DEMAND_RUSH = 0.9;
    
    private int goalSatisfied;

    /**
     * The constructor receives as parameters the number of stations,
     *  the number of bicycles and the type of the demand
     *
     */
    Bicing(int est, int bic, int dem) {
        myRandom = new Random(100);
        numberOfStations = est;
        numberOfBicycles = bic;
        modoDem = dem;

        generateCoordinates();
        generateActualState();
        generateMovementState();
        generateNextDemand();
    }


    /**
     *  The same constructor but the seed of the random number generator can be changed
     *
     * @param est
     * @param bic
     * @param dem
     * @param seed
     */
    public Bicing(int est, int bic, int dem, int seed) {
        myRandom = new Random(seed);
        numberOfStations = est;
        numberOfBicycles = bic;
        modoDem = dem;

        generateCoordinates();
        generateActualState();
        generateMovementState();
        generateNextDemand();
    }

    /**
     *  Generates the coordinates of the stations
     *  Half are generated uniformly inside a 100x100 square
     *  The rest are genrated inside the inner 50x50 square
     *
     */
    private void generateCoordinates() {
        coordStations = new int[numberOfStations][2];
        int estMitad = numberOfStations / 2;
        for (int i = 0; i < estMitad; i++) {
            coordStations[i][0] = myRandom.nextInt(100);
            coordStations[i][1] = myRandom.nextInt(100);
        }

        for (int i = estMitad; i < numberOfStations; i++) {
            coordStations[i][0] = myRandom.nextInt(50) + 25;
            coordStations[i][1] = myRandom.nextInt(50) + 25;
        }

    }

    /**
     * Generates the current number of bicycles in each station
     *
     * The the number of Bicycles are generated using a combination of VAR_DISTRIBUTION_STATE
     * uniform distributions and distributed uniformly among the stations
     *
     */
    private void generateActualState() {
        int numB;
        int numE;

        stateOfStations = new int[numberOfStations];
        for (int i = 0; i < numberOfStations; i++) {
            stateOfStations[i] = 0;
        }

        for (int i = numberOfBicycles; i > 0;) {
            numB = myRandom.nextInt(VAR_DISTRIBUTION_STATE);
            numE = myRandom.nextInt(numberOfStations);
            stateOfStations[numE] = stateOfStations[numE] + numB;
            i = i - numB;
        }
    }

    /**
     * This generates the state for the next hour and the number of
     * bicycles that will not be used (and that we can move to other stations)
     * 
     * The state is generated using PERCENTAGE_USER_MOVS * numBicicletas
     * random bicycle moves
     *
     */
    private void generateMovementState() {
        int numMovs = (int) (numberOfBicycles * PERCENTAGE_USER_MOVS);
        int in, out;

        stateOfNextStations = new int[numberOfStations];

        for (int i = 0; i < numberOfStations; i++) {
            stateOfNextStations[i] = 0;
        }

        for (int i = 0; i < numMovs; i++) {
            out = myRandom.nextInt(numberOfStations);
            in = myRandom.nextInt(numberOfStations);
            if (stateOfStations[out] > 0) {
                stateOfStations[out]--;
                stateOfNextStations[in]++;
            }
        }

           for (int i = 0; i < numberOfStations; i++) {
               stateOfNextStations[i]=stateOfNextStations[i]+stateOfStations[i];
           }
    }

    /**
     * Generates the demand of bicycles for the next hour
     *
     * The demand is generated using a perturbation of the mean number of bicycles
     *
     */
    private void generateNextDemand() {
        int numMB = (numberOfBicycles / numberOfStations);
        double var[] = new double[2];
        int nBvar[]=new int[2];
        int sign = 0;

        if (modoDem == EQUILIBRIUM) {
            var[0] = VAR_DEMAND_EQ;
            var[1] = 1- VAR_DEMAND_EQ;
        } else {
            var [0] = VAR_DEMAND_RUSH;
             var [1] = 1-VAR_DEMAND_RUSH;

        }

        newDemand = new int[numberOfStations];
        for (int i = 0; i < numberOfStations; i++) {
            if (myRandom.nextBoolean()) {
                sign = 1;
            } else {
                sign = -1;
            }
            newDemand[i] = numMB + (sign * myRandom.nextInt((int) (numMB * var[myRandom.nextInt(1)])));
        }

    }

    /**
     * Returns the coordinates of a station
     *
     * @param est Station number
     * @return
     */
    public int[] getStationCoord(int est) {
        int[] coord = new int[2];

        coord[0] = coordStations[est][0];
        coord[1] = coordStations[est][1];

        return coord;
    }

      /**
     * Retutns the distance between two stations
     *
       * @param est1 Station one number
       * @param est2 Station two number
       * @return 
       */
    public double getStationsDistance(int est1,int est2) {
        double dist;

        dist= Math.sqrt(Math.pow(coordStations[est1][0]- coordStations[est2][0],2)
                       +Math.pow(coordStations[est1][1]-coordStations[est2][1],2)) ;
      

        return dist;
    }

  /**
     *  Returns the number of bicycles that don not move from the station the current hour
     *
     * @param st Station number
     * @return
     */
    public int getStationDoNotMove(int st) {
        return stateOfStations[st];
    }

    /**
     *  Returns the number of bicycles of an station the next hour
     *  after the user moves
     *
     * @param st Station number
     * @return
     */
    public int getStationNextState(int st) {
        return stateOfNextStations[st];
    }

    /**
     *  Returns the demand of bicycles for the next hour
     *
     * @param st Station number
     * @return
     */
    public int getDemandNextHour(int st) {
        return newDemand[st];
    }

    /**
     * Returns the number of stations
     *
     * @return
     */
    public int getNumStations() {
        return numberOfStations;
    }


	public void setGoalSatisfied(int goalSatisfied) {
		this.goalSatisfied = goalSatisfied;
	}


	public int getGoalSatisfied() {
		return goalSatisfied;
	}
}
