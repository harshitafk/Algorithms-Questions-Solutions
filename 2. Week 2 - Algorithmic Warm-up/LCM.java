import java.util.*;

public class LCM { 
//product of numbers divided by their greatest common divisor
  private static long lcm_naive(long num1, long num2) {
       long multiply = num1*num2;
       long n = 0;		
       long best = 0;
	  if(num1 > num2) {
	     while(num2 != 0) {
		best = num1 % num2;
		num1 = num2;
		num2 = best;
	}
	n = num1;
             }else{
		while(num1 != 0) {
		best = num2 % num1;
		num2 = num1;
		num1 = best;
             }
		n = num2;
	}
			
	return multiply/n;
  }

  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    long a = scanner.nextInt();
    long b = scanner.nextInt();

    System.out.println(lcm_naive(a, b));
  }
}
