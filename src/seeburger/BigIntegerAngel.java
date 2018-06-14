package seeburger;

import java.util.Arrays;

public class BigIntegerAngel {
	private char[] myBigInt;
	private boolean isNegative;

	public BigIntegerAngel(String input) {
		this.setNegative(input);
		this.setmyBigInt(input);
	}

	private void setNegative(String input) {
		if (input.charAt(0) == '-') {
			isNegative = true;
		} else {
			isNegative = false;
		}
	}

	private void setmyBigInt(String input) {
		if (this.isNegative) {
			input = input.substring(1, input.length());
			myBigInt = input.toCharArray();
		}
		myBigInt = input.toCharArray();
	}

	
	
	public void add(BigIntegerAngel b2) {
		int b2Length = b2.getMyBigInt().length;
		int thisLength = this.getMyBigInt().length;
		char[] initialBI = this.getMyBigInt();
		char[] toAddBI = b2.getMyBigInt();
		char[] tempBigInt;
		if (b2Length > thisLength) {
			tempBigInt = new char[b2Length + 1];
			myBigInt = calculateSum(toAddBI, initialBI, tempBigInt);
		} else {
			tempBigInt = new char[thisLength + 1];
			myBigInt = calculateSum(initialBI, toAddBI, tempBigInt);
		}
	}

	
	
	private static char[] calculateSum(char[] first, char[] second, char[] temp) {
		int toBeAdded = 0;
		int i = temp.length - 1;
		int step = 1;

		while (i >= temp.length - second.length) {
			int sum = Character.getNumericValue(first[first.length - step])
					+ Character.getNumericValue(second[second.length - step]) + toBeAdded;
			toBeAdded = sum / 10;
			temp[i] = (char) (sum % 10 + '0');
			i--;
			step++;
		}				

		while (i >= temp.length - first.length) {
			int sum = Character.getNumericValue(first[first.length - step]) + toBeAdded;
			toBeAdded = sum / 10;
			temp[i] = (char) (sum % 10 + '0');
			i--;
			step++;
		}
		if (toBeAdded == 1) {
			temp[i] = (char) (toBeAdded + '0');
			return temp;
		} else {
			char[] smallerArray = new char[temp.length - 1];
			for (int j = 0; j < smallerArray.length; j++) {
				smallerArray[j] = temp[j + 1];
			}
			return smallerArray;
		}
	}

	
	// Subtract
	public void subtract(BigIntegerAngel b2) {
		int b2Length = b2.getMyBigInt().length;
		int thisLength = this.getMyBigInt().length;
		char[] initialBI = this.getMyBigInt();
		char[] toAddBI = b2.getMyBigInt();
		if (b2Length > thisLength) {
			myBigInt = subtractValue(toAddBI, initialBI);
		} else {
			myBigInt = subtractValue(initialBI, toAddBI);
		}
	}

	private static char[] subtractValue(char[] first, char[] second) {
		char[] result = new char[first.length];
		int index = 1;
		int ednoNaUm = 0;
		int resultOfSubstraction;

		// subtract second part
		while (index <= second.length) {
			resultOfSubstraction = Character.getNumericValue(first[first.length - index])
					- Character.getNumericValue(second[second.length - index]) - ednoNaUm;
			ednoNaUm = resultOfSubstraction < 0 ? 1 : 0;
			resultOfSubstraction = resultOfSubstraction + (ednoNaUm == 1 ? 10 : 0);

			result[first.length - index] = (char) (resultOfSubstraction + '0');
			index++;
		}

		while (index <= first.length) {
			resultOfSubstraction = Character.getNumericValue(first[first.length - index]) - ednoNaUm;
			ednoNaUm = resultOfSubstraction < 0 ? 1 : 0;
			resultOfSubstraction = resultOfSubstraction + (ednoNaUm == 1 ? 10 : 0);
			result[first.length - index] = (char) (resultOfSubstraction + '0');
			index++;
		}

		// remove the initial zeroes
		while (result[0] == '0') {
			result = Arrays.copyOfRange(result, 1, result.length);
		}

		return result;
	}

	private void printResult(char[] result) {
		
	}
	
	public char[] getMyBigInt() {
		return myBigInt;
	}

	public boolean getNegative() {
		return this.isNegative;
	}
}
