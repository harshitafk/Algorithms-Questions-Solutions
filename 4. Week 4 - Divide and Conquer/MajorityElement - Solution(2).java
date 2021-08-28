import java.util.*;
import java.io.*;

public class MajorityElement {
    private static int getMajorityElement(int[] a,int right) {
	        
	        if(right == 1)
	        	return -1;
	        
	        
	        int i=0,count = 0, num = a[i];
	        i++;
	        
	        while(i < a.length) {
	        	int numComp = a[i];
	        	
	        	if(num == numComp) {		
	        		count++;
	        		 if(count + 1 > (a.length/2)) {
	     	        	return 1;
	     	        }
	        	}else {
	        		num = numComp;
	        		count = 0;
	        	}
	        	i++;
	        }
	        return -1;
	  }
	  

	    public static void main(String[] args) {
	        FastScanner scanner = new FastScanner(System.in);
	        int n = scanner.nextInt();
	        int[] a = new int[n];
	        for (int i = 0; i < n; i++) {
	            a[i] = scanner.nextInt();
	        }
	        Arrays.sort(a);
	        if (getMajorityElement(a,a.length) != -1) {
	            System.out.println(1);
	        } else {
	            System.out.println(0);
	        }
	    }
	    static class FastScanner {
	        BufferedReader br;
	        StringTokenizer st;

	        FastScanner(InputStream stream) {
	            try {
	                br = new BufferedReader(new InputStreamReader(stream));
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }

	        String next() {
	            while (st == null || !st.hasMoreTokens()) {
	                try {
	                    st = new StringTokenizer(br.readLine());
	                } catch (IOException e) {
	                    e.printStackTrace();
	                }
	            }
	            return st.nextToken();
	        }

	        int nextInt() {
	            return Integer.parseInt(next());
	        }
	    }
}

