package seeburger;

public class BigIntegerAngel_SecondTake {
	private String myBigInt;
	private boolean isNegative;
//5674967584545464565
	public BigIntegerAngel_SecondTake(String input) {
		if ("-".equals(input.substring(0, 1))) {
			this.isNegative = true;
			this.setmyBigInt(input.substring(1, input.length()));
		} else {
			if ("+".equals(input.substring(0, 1))) {
				this.isNegative = false;
				this.setmyBigInt(input.substring(1, input.length()));
			} else {
				this.isNegative = false;
				this.setmyBigInt(input);
			}
		}
	}

	public String sumTwoBigInts(BigIntegerAngel_SecondTake secondBigInt) {
		StringBuilder sb = new StringBuilder();

		// Positive + Positive
		if (!this.isNegative && !secondBigInt.getIsNegative()) {
			return this.sum(secondBigInt);
		}

		// Positive + Negative i.e. subtraction
		if (!this.isNegative && secondBigInt.isNegative) {
			return subtract(secondBigInt.getMyBigInt(), this.getMyBigInt());
		}

		// Negative + Positive i.e. subtraction
		if (this.isNegative && !secondBigInt.isNegative) {
			return subtract(secondBigInt.getMyBigInt(), this.getMyBigInt());
		}
		if (this.isNegative && secondBigInt.getIsNegative()) {
			return this.sum(secondBigInt);
		}
		return "we have a case that is not implemented!";
	}

	public String substractPublic(BigIntegerAngel_SecondTake second) {
		String firstString = this.getMyBigInt();
		String secondString = second.getMyBigInt();
		boolean firstIsNegative = this.isNegative;
		boolean secondIsNegative = second.isNegative;

		if (firstIsNegative && !secondIsNegative) {
			return sum(second);
		}

		if (!firstIsNegative && secondIsNegative) {
			return sum(second);
		}

		if (firstIsNegative && secondIsNegative) {
			// TODO negative and negative on subtract
			// return sum(second);
			int whichIsBigger = compareBigIntegers(this, second);

			if (whichIsBigger == 1) {
				return "-" + subtract(firstString, secondString);
			}
			if (whichIsBigger == -1) {
				return "-" + subtract(secondString, firstString);
			}
			if (whichIsBigger == 0) {
				if (firstIsNegative && secondIsNegative) {
					return sum(second);
				} else {
					return "0";
				}
			}
		}

		// Positive minus Positive i.e. regular subtraction
		if (!firstIsNegative && !secondIsNegative) {
			int whichIsBigger = compareBigIntegers(this, second);
			if (whichIsBigger == 1) {
				return "-" + subtract(firstString, secondString);
			}
			if (whichIsBigger == -1) {
				return "-" + subtract(secondString, firstString);
			}
			if (whichIsBigger == 0) {
				if (firstIsNegative && secondIsNegative) {
					return sum(second);
				} else {
					return "0";
				}
			}
		}

		return "a case that we have not covered";
	}

	private static String subtract(String firstNum, String secondNum) {
		boolean didWeSwapThem = false;
		if (secondNum.length() > firstNum.length()) {
			String temp = secondNum;
			secondNum = firstNum;
			firstNum = temp;
			didWeSwapThem = true;
		}

		if (secondNum.length() == firstNum.length()) {
			int swapResult = compareTwoEqualStrings(firstNum, secondNum);
			if (swapResult == -1) {
				String temp = secondNum;
				secondNum = firstNum;
				firstNum = temp;
				didWeSwapThem = true;
			}
		}

		StringBuilder sb = new StringBuilder();
		int result = 0;
		int toRemember = 0;

		int first;
		int second;

		// Here we subtract the numbers` digits.
		for (int i = 0; i < firstNum.length(); i++) {
			if (i >= secondNum.length()) {
				first = Integer.parseInt(String.valueOf(firstNum.charAt(firstNum.length() - 1 - i)));
				sb.append(String.valueOf(first - toRemember));
				toRemember = 0;
				continue;
			} else {
				second = Integer.parseInt(String.valueOf(secondNum.charAt(secondNum.length() - 1 - i)));
				first = Integer.parseInt(String.valueOf(firstNum.charAt(firstNum.length() - 1 - i)));
			}

			// Here we subtract the digits
			if (first - toRemember - second >= 0) {
				result = first - toRemember - second;
				toRemember = 0;
			} else {
				result = first + 10 - toRemember - second;
				toRemember = 1;

			}

			sb.append(String.valueOf(result));
		}
		if (didWeSwapThem) {
			sb.append("-");
		}
		sb.reverse();

		// Here we remove the zeroes from the beginning in the result
		while (sb.charAt(0) == '0' && sb.length() > 1) {
			sb.deleteCharAt(0);
		}

		return sb.toString();
	}

	private String sum(BigIntegerAngel_SecondTake secondBigInt) {
		String bigger = this.getMyBigInt();
		String smaller = secondBigInt.getMyBigInt();

		if (bigger.length() < smaller.length()) {
			String temp = bigger;
			bigger = smaller;
			smaller = temp;
		}
		
		int toAdd = 0;
		StringBuilder sb = new StringBuilder();

		while (smaller.length() > 0) {
			String justOne = bigger.substring(bigger.length() - 1, bigger.length());
			String justTwo = smaller.substring(smaller.length() - 1, smaller.length());
			bigger = (bigger.substring(0, bigger.length() - 1));
			smaller = (smaller.substring(0, smaller.length() - 1));
			int a = Integer.parseInt(justOne);
			int b = Integer.parseInt(justTwo);
			int result = a + b + toAdd;
			sb.append(result % 10);
			toAdd = result / 10;
		}
		while (bigger.length() > 0) {
			String justOne = bigger.substring(bigger.length() - 1, bigger.length());
			int a = Integer.parseInt(justOne);
			int result = a + toAdd;
			sb.append(result % 10);
			toAdd = result / 10;
			bigger = bigger.substring(0, bigger.length() - 1);
		}
		if (toAdd == 1) {
			sb.append(toAdd);
		}
		if (this.isNegative) {
			sb.append("-");
		}
		return sb.reverse().toString();
	}

	private int compareBigIntegers(BigIntegerAngel_SecondTake firstInt, BigIntegerAngel_SecondTake secondInt) {
		String firstString = firstInt.getMyBigInt();
		String secondString = secondInt.getMyBigInt();
		boolean firstIsNegative = firstInt.isNegative;
		boolean secondIsNegative = secondInt.isNegative;

		if (!firstIsNegative && secondIsNegative) {
			// firstInt is bigger than secondInt
			return 1;
		}
		if (firstIsNegative && !secondIsNegative) {
			// secondInt is bigger than firstInt
			return -1;
		}

		// both BigInts are Positive
		if (!firstIsNegative && !secondIsNegative) {
			if (firstString.length() > secondString.length()) {
				return 1;
			}
			if (firstString.length() < secondString.length()) {
				return -1;
			}
			if (firstString.length() == secondString.length()) {
				return compareTwoEqualStrings(firstString, secondString);
			}
		}

		// both BigInts are negative
		if (firstIsNegative && secondIsNegative) {
			if (firstString.length() > secondString.length()) {
				return -1;
			}
			if (firstString.length() < secondString.length()) {
				return 1;
			}
			if (firstString.length() == secondString.length()) {
				return compareTwoEqualStrings(firstString, secondString);
			}
		}
		// both Integers are equal
		return 0;
	}

	private void setmyBigInt(String input) {
		while ("0".equalsIgnoreCase(input.substring(0, 1))) {
			input = input.substring(1, input.length());
		}
		this.myBigInt = input;
	}

	public String getMyBigInt() {
		return this.myBigInt;
	}

	public boolean getIsNegative() {
		return this.isNegative;
	}

	private static int compareTwoEqualStrings(String firstString, String secondString) {
		for (int i = 0; i < firstString.length(); i++) {
			int firstDigit = Integer.parseInt(firstString.substring(i, i + 1));
			int secondDigit = Integer.parseInt(secondString.substring(i, i + 1));
			if (firstDigit > secondDigit) {
				return 1;
			}
			if (firstDigit < secondDigit) {
				return -1;
			}
		}
		return 0;
	}

	private static BigIntegerAngel_SecondTake changeSign(BigIntegerAngel_SecondTake customBigInt) {
		BigIntegerAngel_SecondTake changedSign;
		if (customBigInt.getIsNegative()) {
			return new BigIntegerAngel_SecondTake(customBigInt.getMyBigInt());
		} else {
			return new BigIntegerAngel_SecondTake("-" + customBigInt.getMyBigInt());
		}
	}
}
