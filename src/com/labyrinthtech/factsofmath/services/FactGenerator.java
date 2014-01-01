package com.labyrinthtech.factsofmath.services;

import java.util.Random;

import com.labyrinthtech.factsofmath.models.MathFact;
import com.labyrinthtech.factsofmath.utils.Constants;
// Test comment more more
public class FactGenerator {
	private int firstOperand;
	private int secondOperand;
	private int solution;
	private String operator;
	private Random random;
	
	public FactGenerator() {
		random = new Random();
	}
	
	public MathFact generateNewFact() {
		generateOperator();
		generateOperands();
		calculateSolution();
		return fillMathFact();
	}

	private MathFact fillMathFact() {
		MathFact returnResult = new MathFact();
		returnResult.firstOperand = Integer.toString(firstOperand);
		returnResult.secondOperand = Integer.toString(secondOperand);
		returnResult.operator = operator;
		returnResult.solution = Integer.toString(solution);
		return returnResult;
	}
	
	private void calculateSolution() {
		if(operator.equals(Constants.ADDITON)) {
			solution = firstOperand + secondOperand;
		} else if(operator.equals(Constants.SUBTRACTION)) {
			solution = firstOperand - secondOperand;
		} else if (operator.equals(Constants.MULTIPLICATION)) {
			solution = firstOperand * secondOperand;
		} else {
			solution = firstOperand / secondOperand;
		}
	}
	
	private void generateOperands() {
		firstOperand = random.nextInt(Constants.UPPER_FACT_LIMIT) + 1;
		if(operator.equals(Constants.ADDITON) || operator.equals(Constants.MULTIPLICATION)) {
			secondOperand = random.nextInt(Constants.UPPER_FACT_LIMIT) + 1;
		} else if(operator.equals(Constants.SUBTRACTION)) {
			secondOperand = random.nextInt(firstOperand) + 1;
		} else {
			secondOperand = random.nextInt(Constants.UPPER_FACT_LIMIT) + 1;
			firstOperand = firstOperand * secondOperand;
		}
	}

	private void generateOperator() {
		int op = random.nextInt(Constants.NUMBER_OF_OPERATORS);
		switch(op) {
			case 0:
				operator = Constants.ADDITON;
				break;
			case 1:
				operator = Constants.SUBTRACTION;
				break;
			case 2:
				operator = Constants.MULTIPLICATION;
				break;
			case 3:
				operator = Constants.DIVISION;
				break;
		}
	}
}
