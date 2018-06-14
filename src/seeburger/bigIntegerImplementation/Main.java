package seeburger.bigIntegerImplementation;

public class Main {
	
    public static void main(String[] args) {
    	 
//
//      String[] testsFirst = {"99", "20", "-10", "-20", "20", "10", "20", "-9", "-9", "-19","0"};
//      String[] testsSecond = {"-1", "10", "120", "9", "-9", "-19", "-11", "-9", "-20", "-1","0"};

        String[] testsFirst = {"99"};
        String[] testsSecond = {"-1"};
     
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
    }

}