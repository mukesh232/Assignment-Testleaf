package javaTest;
import java.util.Scanner;
public class Factorialnum {

	public static void main(String[] args) {
		int num;
		System.out.println("Enter the number:");
		Scanner sc =new Scanner(System.in);
		num=sc.nextInt();
		
		int answer =factorial(num);
		System.out.println("Factorial of" + num + "is" +answer);
		
		
		
		

	}
	static int factorial(int n) {
		if(n==1)
			return 1;
		return n * factorial(n-1);
	}

}
