package com.labyrinthtech.factsofmath;

import junit.framework.TestCase;

public class FactGeneratorTest extends TestCase {

	FactGenerator factGen;
	protected void setUp() throws Exception {
		//super.setUp();
		factGen = new FactGenerator();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testGenerateNewFact() {
		MathFact fact;
		for(int i=0; i<100; i++) {
			fact = factGen.generateNewFact();
			assert(solutionValid(fact));
		}
		
	}

	public boolean solutionValid(MathFact fact) {
		if(fact.operator.equals(Constants.ADDITON)) {
			return(Integer.parseInt(fact.solution) == (Integer.parseInt(fact.firstOperand) + Integer.parseInt(fact.secondOperand)));
		} else if(fact.operator.equals(Constants.SUBTRACTION)) {
			return(Integer.parseInt(fact.solution) == (Integer.parseInt(fact.firstOperand) - Integer.parseInt(fact.secondOperand)));
		} else if (fact.operator.equals(Constants.MULTIPLICATION)) {
			return(Integer.parseInt(fact.solution) == (Integer.parseInt(fact.firstOperand) * Integer.parseInt(fact.secondOperand)));
		} else {
			return(Integer.parseInt(fact.solution) == (Integer.parseInt(fact.firstOperand) / Integer.parseInt(fact.secondOperand)));
		}
	}
}
