package seeburger.inhouseTasks20th;

public class MyBigIntegerMain {
	public static void main(String[] args) {
		String one = "-10";
		String two = "-5";
		
		MyBigInteger bigIntTest = new MyBigInteger();
		

		String sum = bigIntTest.sumBigNumbers(one,  two);
		System.out.println(sum);
		
	}
}
