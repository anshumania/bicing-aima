package com.bicing.mti.ai.aima;


import java.util.Random;

import aima.search.framework.GoalTest;

public class BicingGoalTest implements GoalTest {

	@Override
	public boolean isGoalState(Object arg0) {
		BicingState state = (BicingState)arg0;
        return true;
	}

}
