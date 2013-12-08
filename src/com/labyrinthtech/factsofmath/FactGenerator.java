package com.labyrinthtech.factsofmath;

import java.util.Random;

public class FactGenerator {
	private int firstOperand;
	private int secondOperand;
	private int solution;
	private Operator operator;
	private Random random;
	
	FactGenerator() {
		firstOperand = 5;
		secondOperand = 10;
		solution = 15;
		operator = Operator.ADDITION;
		random = new Random();
	}
	
	public MathFact generateNewFact() {
		generateOperator();
		generateOperands();
		calculateSolution();
		MathFact returnResult = new MathFact();
		returnResult.firstOperand = getFirstOperand();;
		returnResult.secondOperand = getSecondOperand();
		returnResult.operator = getOperator();
		returnResult.solution = getSolution();
		return returnResult;
		
	}

	private void calculateSolution() {
		switch(operator) {
			case ADDITION:
				solution = firstOperand + secondOperand;
				break;
			case SUBTRACTION:
				solution = firstOperand - secondOperand;
				break;
			case MULTIPLICATION:
				solution = firstOperand * secondOperand;
				break;
			case DIVISION:
				solution = firstOperand / secondOperand;
				break;
		}
		
	}

	
	private void generateOperands() {
		firstOperand = random.nextInt(Constants.UPPER_FACT_LIMIT) + 1;
		if(operator == Operator.ADDITION || operator == Operator.MULTIPLICATION) {
			secondOperand = random.nextInt(Constants.UPPER_FACT_LIMIT) + 1;
		} else if(operator == Operator.SUBTRACTION) {
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
				operator = Operator.ADDITION;
				break;
			case 1:
				operator = Operator.SUBTRACTION;
				break;
			case 2:
				operator = Operator.MULTIPLICATION;
				break;
			case 3:
				operator = Operator.DIVISION;
				break;
		}
		
	}

	private String getFirstOperand() {
		return Integer.toString(firstOperand);
	}

	private String getSecondOperand() {
		return Integer.toString(secondOperand);
	}

	private String getSolution() {
		return Integer.toString(solution);
	}
	
	private String getOperator() {
		String returnResult = "+";
		switch(operator) {
			case ADDITION:
				returnResult = "+";
				break;
			case SUBTRACTION:
				returnResult = "-";
				break;
			case MULTIPLICATION:
				returnResult = "*";
				break;
			case DIVISION:
				returnResult = "\u00F7";
				break;
				
		
		}
		return returnResult;
		
	}

	
	
	

}
