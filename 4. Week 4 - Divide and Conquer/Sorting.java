import java.io.*;
import java.util.*;

public class Sorting {
    private static Random random = new Random();

    private static int[] partition3(int[] a, int l, int r) {
    	
    	if(a[l] > a[r]) {
    		int t = a[l];
            a[l] = a[r];
            a[r] = t;
    	}
        //write your code here
    	int m1 = a[l];
    	int m2 = a[r];
    	
        
        
        int j = l+1;
        int k = r-1;
        
        for(int i = l+1; i <= r-1; i++) {
        	if(a[i] < m1) {
        		
                int t = a[i];
                a[i] = a[j];
                a[j] = t; 
                j++;
        	}else if(a[i] >= m2) {
        		while(a[k] > m2 && i < k)
        			k--;
        		
        		int t = a[i];
                a[i] = a[k];
                a[k] = t;
                k--;
                
                if(a[i] < m1) {
                	t = a[i];
                    a[i] = a[j];
                    a[j] = t;
                    j++;
                }
        			
        	}
        }
        j--;
        k++;
        
        int t = a[l];
        a[l] = a[j];
        a[j] = t;
        
        int temp = a[r];
        a[r] = a[k];
        a[k] = temp;
        
        int[] m = {j, k};
        
        return m;
      }

    private static int partition2(int[] a, int l, int r) {
        int x = a[l];
        int j = l;
        for (int i = l + 1; i <= r; i++) {
            if (a[i] <= x) {
                j++;
                int t = a[i];
                a[i] = a[j];
                a[j] = t;
            }
        }
        int t = a[l];
        a[l] = a[j];
        a[j] = t;
        return j;
    }

    private static void randomizedQuickSort(int[] a, int l, int r) {
        if (l >= r) {
            return;
        }
        int k = random.nextInt(r - l + 1) + l;
        int t = a[l];
        a[l] = a[k];
        a[k] = t;
        //use partition3
        int[] p = partition3(a,l,r);
        randomizedQuickSort(a, l, p[0] -1);
        randomizedQuickSort(a, p[0]+1, p[1]-1);
        randomizedQuickSort(a, p[1]+1, r);
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        randomizedQuickSort(a, 0, n - 1);
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
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

