import java.util.*;

public class FibonacciHuge {
private static long getFibonacciHugeNaive(long n,long m) {
		 long div = pisano(m);
		 long rem = n % div; 
		
		 long a=0,b=1,c = 0;
		 
		 if (rem == 0) {
		        return 0;
		 }
		    else if (rem == 1) {
		        return 1;
		    }
		 for(int i=0; i < rem - 1; i++) {
			 c = (a+b)%m;
			 a = b;
			 b=c;
		 }
		 
		 return c % m;
	    }
	  
	  private static long pisano(long m) {
		  long prev = 0;
		    long curr = 1;
		    long res = 0;
		     
		    for(int i = 0; i < m * m; i++)
		    {
		        long temp = 0;
		        temp = curr;
		        curr = (prev + curr) % m;
		        prev = temp;
		         
		        if (prev == 0 && curr == 1)
		            res= i + 1;
		    }
		    return res;
	  }
	    
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long m = scanner.nextLong();
        System.out.println(getFibonacciHugeNaive(n, m));
    }
}

