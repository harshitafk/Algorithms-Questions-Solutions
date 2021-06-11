import java.util.*;

public class GCD {
  private static long gcd_naive(long num1, long num2) {
     long best = 0;
	if(num1 > num2) {
           while(num2 != 0) {
		best = num1 % num2;
		num1 = num2;
		num2 = best;
					
	}
	  return num1;
      }else{
	  while(num1 != 0) {
		best = num2 % num1;
		num2 = num1;
		num1 = best;
	}
	  return num2;
		}
  }

  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    long a = scanner.nextLong();
    long b = scanner.nextLong();

    System.out.println(gcd_naive(a, b));
  }
}
