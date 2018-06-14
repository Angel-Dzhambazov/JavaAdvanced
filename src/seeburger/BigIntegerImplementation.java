package seeburger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BigIntegerImplementation {
	private List<Integer> digitsAsList;
	boolean isPositive;

	BigIntegerImplementation(String input) {
		if ("-".equals(input.substring(0, 1))) {
			if ("0".equalsIgnoreCase(input.substring(1, input.length()))) {
				this.isPositive = true;
				this.setmyBigInt(input.substring(1, input.length()));
			} else {
				this.isPositive = false;
				this.setmyBigInt(input.substring(1, input.length()));
			}
		} else {
			if ("+".equals(input.substring(0, 1))) {
				this.isPositive = true;
				this.setmyBigInt(input.substring(1, input.length()));
			} else {
				this.isPositive = true;
				this.setmyBigInt(input);
			}
		}
	}

	BigIntegerImplementation subtract(BigIntegerImplementation second) {
		List<Integer> firstList = this.getDigitsAsList();
		List<Integer> secondList = second.getDigitsAsList();
		boolean isFirstPositive = this.isPositive;
		boolean isSecondPositive = second.isPositive;

		if (isFirstPositive && isSecondPositive) {
			if (comapreTwoNumbers(firstList, secondList) == 1) {
				return new BigIntegerImplementation(subtract(firstList, secondList));
			} else {
				return new BigIntegerImplementation("-" + subtract(secondList, firstList));
			}
		}
		if (!isFirstPositive && !isSecondPositive) {
			if (comapreTwoNumbers(firstList, secondList) == 1) {
				// -20 ; -10
				// -20 - (-10) => - (20 - 10);
				return new BigIntegerImplementation("-" + subtract(firstList, secondList));
			} else {
				// -10 ; -50 => - 10 - (-50) => -10 + 50 => 50 - 10;
				return new BigIntegerImplementation(subtract(secondList, firstList));
			}
		}
		if (isFirstPositive && !isSecondPositive) {
			if (comapreTwoNumbers(firstList, secondList) == 1) {
				// 30 - (-10); => 30 + 10;
				return new BigIntegerImplementation(privateSum(firstList, secondList));
			} else {
				// 30 - (-50) => 30 + 50;
				return new BigIntegerImplementation(privateSum(secondList, firstList));
			}
		}

		if (!isFirstPositive && isSecondPositive) {
			if (comapreTwoNumbers(firstList, secondList) == 1) {
				// -50 - (20); =>-50 -20 => - (50 + 20);
				return new BigIntegerImplementation("-" + privateSum(firstList, secondList));
			} else {
				// - 50 - (150) => - (50 + 150) => - (150 + 50);
				return new BigIntegerImplementation("-" + privateSum(secondList, firstList));
			}
		}

		System.out.println("Imame greshka, vhodnite danni sa parviq int: " + this.toString());
		System.out.println("Imame greshka, vhodnite danni sa vtoriq int: " + second.toString());
		return null;
	}

	BigIntegerImplementation add(BigIntegerImplementation second) {
		List<Integer> firstList = this.getDigitsAsList();
		List<Integer> secondList = second.getDigitsAsList();
		boolean isFirstPositive = this.isPositive;
		boolean isSecondPositive = second.isPositive;

		if (isFirstPositive && isSecondPositive) {
			String result = "";
			if (comapreTwoNumbers(firstList, secondList) == -1) {
				result = privateSum(secondList, firstList);
			} else {
				result = privateSum(firstList, secondList);
			}
			return new BigIntegerImplementation(result);
		}
		if (!isFirstPositive && !isSecondPositive) {
			String result = "";
			if (comapreTwoNumbers(firstList, secondList) == -1) {
				result = privateSum(secondList, firstList);
			} else {
				result = privateSum(firstList, secondList);
			}
			return new BigIntegerImplementation("-" + result);
		}

		if (isFirstPositive && !isSecondPositive) {
			if (comapreTwoNumbers(firstList, secondList) == 1) {
				return new BigIntegerImplementation(subtract(firstList, secondList));
			} else {
				return new BigIntegerImplementation("-" + subtract(secondList, firstList));
			}
		}

		if (!isFirstPositive && isSecondPositive) {
			if (comapreTwoNumbers(firstList, secondList) == -1) {
				return new BigIntegerImplementation(subtract(secondList, firstList));
			} else {
				return new BigIntegerImplementation("-" + subtract(firstList, secondList));
			}
		}
		return null;
	}


    private static String subtract(List<Integer> firstNumber, List<Integer> secondNumber) {
        StringBuilder sb = new StringBuilder();
        int result = 0;
        int toRemember = 0;
        int first;
        int second = 0;

        for (int i = 0; i < firstNumber.size(); i++) {
            if (i >= secondNumber.size()) {
                first = firstNumber.get(firstNumber.size() - 1 - i);
            } else {
                second = secondNumber.get(secondNumber.size() - 1 - i);
                first = firstNumber.get(firstNumber.size() - 1 - i);
            }
            if (first - toRemember - second >= 0) {
                result = first - toRemember - second;
                toRemember = 0;
            } else {
                result = first + 10 - toRemember - second;
                toRemember = 1;
            }
            sb.append(String.valueOf(result));
            second = 0;
        }
        sb.reverse();


        while (sb.charAt(0) == '0' && sb.length() > 1) {
            sb.deleteCharAt(0);
        }
        if (sb.length() == 0) {
            sb.append("0");
        }
        return sb.toString();
    }
	private String privateSum(List<Integer> firstNumber, List<Integer> secondNumber) {
//		if (comapreTwoNumbers(firstNumber, secondNumber) == -1) {
//			List<Integer> temp = new ArrayList<>();
//			temp = secondNumber;
//			secondNumber = firstNumber;
//			firstNumber = temp;
//		}

		int toAdd = 0;
		StringBuilder sb = new StringBuilder();
		Integer difference = firstNumber.size() - secondNumber.size();

		for (int i = secondNumber.size() - 1; i >= 0; i--) {
			Integer firstEdinica = firstNumber.get(i + difference);
			Integer secondEdinica = secondNumber.get(i);
			int result = firstEdinica + secondEdinica + toAdd;
			sb.append(result % 10);
			toAdd = result / 10;
		}
		for (int i = difference - 1; i >= 0; i--) {
			Integer firstEdinica = firstNumber.get(i);
			int result = firstEdinica + toAdd;
			sb.append(result % 10);
			toAdd = result / 10;
		}
		if (toAdd == 1) {
			sb.append(toAdd);
		}
		return sb.reverse().toString();
	}

	private void setmyBigInt(String input) {
		List<Integer> inputAsList = new ArrayList<>();
		input = removeLeadingZeroes(input);
		for (int i = 0; i < input.length(); i++) {
			inputAsList.add(Integer.valueOf(input.substring(i, i + 1)));
		}
		this.digitsAsList = inputAsList;
	}

	private List<Integer> getDigitsAsList() {
		return Collections.unmodifiableList(this.digitsAsList);
	}

	private String removeLeadingZeroes(String input) {
		while ("0".equalsIgnoreCase(input.substring(0, 1)) && input.length() > 1) {
			input = input.substring(1, input.length());
		}
		return input;
	}

	private int comapreTwoNumbers(List<Integer> firstNumber, List<Integer> secondNumber) {
		if (firstNumber.size() > secondNumber.size()) {
			return 1;
		} else if (firstNumber.size() < secondNumber.size()) {
			return -1;
		} else {
			return compareTwoEqualyLongNumbers(firstNumber, secondNumber);
		}
	}

	private int compareTwoEqualyLongNumbers(List<Integer> firstNumber, List<Integer> secondNumber) {
		for (int i = 0; i < firstNumber.size(); i++) {
			int leadingFirst = firstNumber.get(i);
			int leadingSecond = secondNumber.get(i);
			if (leadingFirst > leadingSecond) {
				return 1;
			}
			if (leadingFirst < leadingSecond) {
				return -1;
			}
		}
		return 1;
	}


	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		if (!this.isPositive) {
			sb.append("-");
		}
		for (int i : this.digitsAsList) {
			sb.append(i);
		}
		return sb.toString();
	}
}