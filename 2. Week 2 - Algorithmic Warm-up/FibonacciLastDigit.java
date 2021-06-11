import java.util.*;

public class FibonacciLastDigit {
    private static long getFibonacciLastDigitNaive(int n) {
        if(n<2)
		  return n;
	  long[] fibArray = new long[n];
    
      fibArray[0] = 1;
      fibArray[1] = 1;

    for(int i=2; i<n; i++) {
    	
    	fibArray[i]=(fibArray[i - 1] % 10) + (fibArray[i - 2]%10);
    }
   long rem = fibArray[n-1]%10;
    return rem;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(getFibonacciLastDigitNaive(n));
    }
}

