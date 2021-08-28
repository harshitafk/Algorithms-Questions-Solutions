import java.util.*;
import java.io.*;

public class MajorityElement {
   private static int getMajorityElement(int[] a,int left,int right) {
		  if (right <= left)
	    		return a[left];
	    	int mid = left + (right - left) / 2;
	    	int lElement = getMajorityElement(a, left, mid);
	    	int rElement = getMajorityElement(a, mid + 1, right);

	    	if (lElement == rElement)
	    		return lElement;

	    	int lcount = frequency(a, lElement, left, right);
	    	int rcount = frequency(a, rElement, left, right);

	    	if (lcount > Math.ceil((right - left + 1) / 2))
	    		return lElement;
	    	if (rcount > Math.ceil((right - left + 1) / 2))
	    		return rElement;

	    	return -1;	
	  }
	  
	  private static int frequency(int[] a, int element, int lo, int hi) {
	    	int cnt = 0;
	    	for (int i = lo; i <= hi; i++) {
	    		if (a[i] == element)
	    			cnt++;
	    	}
	    	return cnt;
	    }
	  

	    public static void main(String[] args) {
	        FastScanner scanner = new FastScanner(System.in);
	        int n = scanner.nextInt();
	        int[] a = new int[n];
	        for (int i = 0; i < n; i++) {
	            a[i] = scanner.nextInt();
	        }
	        
	        if (getMajorityElement(a,0,a.length-1) != -1) {
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

