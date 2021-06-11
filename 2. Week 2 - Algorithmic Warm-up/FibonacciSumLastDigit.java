import java.util.*;

public class FibonacciSumLastDigit {
 private static int getFibonacciSumFast(long n) {
	    if (n <= 1)
	        return (int) n;

	    int limit = (int) (n % 60);

	    int previous = 0;
	    int current  = 1;
	    int sum      =-1;

	    for (int i = 0; i <= limit; ++i) {
	        int tmpPrevious = previous;
	        previous = current;
	        current = (tmpPrevious + current) % 10;
	    }
	    

	   if(current != 0)
		   sum = current - 1;
	   else
		   sum = 9;
	    return sum;
	}
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long s = getFibonacciSumFast(n);
        System.out.println(s);
    }
}

