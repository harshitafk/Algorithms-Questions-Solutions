import java.util.*;

public class FibonacciSumSquares {
    private static long getFibonacciSumSquaresNaive(long n) {
               if(n <= 1)
		return n;
         long nPis = n % 60;

if(nPis == 0) {
			 return 0;
		 }
	 long nMinusPis = (n-1)% 60;
		
		 long b=1,a=0;
		 long d =1,e=0;
		 
		 for(int i = 0; i < nPis - 1; i++) {
			 
			 long prev = a;
			 a = b;
			 b = (prev + a)%10;
		 }
		 
		 for(int i = 0; i < nMinusPis - 1; i++) {
			 long prev = e;
			 e = d;
			 d = (prev + e)%10;
		 }
		 
		 long sum = (b+d)%10;
		 
		 long mul = (b * sum)%10;
		 
		 return mul;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long s = getFibonacciSumSquaresNaive(n);
        System.out.println(s);
    }
}

