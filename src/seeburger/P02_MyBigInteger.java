package seeburger;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class P02_MyBigInteger {
	public static void main(String[] args) {

		String[] testsFirst = { "20", "20", "-10", "-20", "20", "10", "20", "-9", "-9", "-19", "10008", "0", "0" };
		String[] testsSecond = { "-40", "10", "120", "9", "-9", "-19", "-11", "-9", "-20", "-1", "-9", "0", "-0" };

		for (int i = 0; i < testsSecond.length; i++) {
			String input = testsFirst[i];

			String secondInput = testsSecond[i];
			BigIntegerImplementation b1 = new BigIntegerImplementation(testsFirst[i]);
			BigIntegerImplementation b2 = new BigIntegerImplementation(testsSecond[i]);

			String debug = "";
			System.out.print(debug);

			BigIntegerImplementation sumResult = b1.add(b2);
			System.out.println(input + " + (" + secondInput + ") = " + sumResult.toString());
			System.out.println(input + " - (" + secondInput + ") = " + b1.subtract(b2));

		}

		//
		// for (int i = 0; i < testsSecond.length; i++) {
		// input = testsFirst[i];
		//
		// secondInput = testsSecond[i];
		// BigIntegerAngel_SecondTake b1 = new BigIntegerAngel_SecondTake(input);
		// BigIntegerAngel_SecondTake b2 = new BigIntegerAngel_SecondTake(secondInput);
		//
		// BigIntegerAngel_SecondTake sumResult = new
		// BigIntegerAngel_SecondTake(b1.sumTwoBigInts(b2));
		// System.out.println(input + " + (" + secondInput + ") = " + sumResult);
		// System.out.println(input + " - (" + secondInput + ") = " +
		// b1.substractPublic(b2));
		// System.out.println("===================");
		// }
	}
}

// testing with sumTwoBigInts
// + + => OK
// - + =>
// + - =>
// - - =>

// teting with substract
// + + => OK
// - + =>
// + - => ne e ok
// - - =>

/*
 * boolean isPositive ; List<Integers> listOfDigits; //all positive
 *
 * PUBLIC BigInt sum 1) sums two positive => privateSum 2) sums two negatives =>
 * "-"+ privateSum
 *
 * 3) sums positive and negative
 *
 * 3.1) positive longer than negative =>"+"+ privateSubtract #1 - #2 3.2)
 * positive == negative => "0"; 3.3) positive longer < negative => "-"
 * privateSubtract #2 - #1;
 *
 * 4) sums negative and positive => privateSubtract 4.1) negative length >
 * positive length => 3.3 4.2) "==" => 3.2 4.3) negative length < positive
 * length => 3.1
 *
 *
 * PUBLIC BigInt subtract 1)
 *
 *
 * private BigInt privateSum (2 List<Integers>) 1) sum of two positives return
 * String
 *
 * private BigInt privateSubtract (2 List<Integers>) 1) returns longer - shorter
 *
 * private int which is bigger -1 1 0
 *
 * private List<Integers> remove leadingZeroes //@overwrite toString
 */
