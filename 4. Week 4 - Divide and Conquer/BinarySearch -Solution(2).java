import java.io.*;
import java.util.*;

public class BinarySearch {
 static int binarySearch(int[] a,int left, int right,int size, int x) {
       if(left > right)
    	   return left-1;
       
       int mid = left + ( (right - left)/2);
       
       if(x == a[mid]) {
    	   return mid;
       }else if(x < a[mid] && left != right) {
    	   right = mid;
    	   return binarySearch(a,left,right,size,x);
       }else if(x > a[mid] && left != right) {
    	   right = size;
    	   left = mid+1;
    	   return binarySearch(a,left,right,size,x);
       }
	return -1;
    }

    static int linearSearch(int[] a, int x) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == x) return i;
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
        int m = scanner.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
          b[i] = scanner.nextInt();
        }
        for (int i = 0; i < m; i++) {
            //replace with the call to binarySearch when implemented
            System.out.print(binarySearch(a,0,a.length-1,a.length-1, b[i]) + " ");
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
