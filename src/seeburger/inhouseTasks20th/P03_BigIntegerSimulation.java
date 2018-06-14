package seeburger.inhouseTasks20th;


import java.util.Scanner;

/*
 *  P03_BigIntegerSimulation implements the basic methods of BigInteger class.
 */

public class P03_BigIntegerSimulation {

	public static void main(String[] args) {
		
			Scanner scanner = new Scanner(System.in);
	        String result = "";

//	        String firstNum = scanner.nextLine();
//	        String secondNum = scanner.nextLine();
	        String firstNum = "534532985793457943795823523";
	        String secondNum =  "23432543425524432523";
	        
	        
	        
	//        result = MyBigInteger.sumBigNumbers(firstNum, secondNum);
	        result = MyBigInteger.subtractBigNumbers(firstNum, secondNum);
	        
	        System.out.println(result);
	        
	}

	

}