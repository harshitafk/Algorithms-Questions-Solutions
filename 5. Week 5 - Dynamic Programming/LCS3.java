import java.util.*;

public class LCS3 {

    private static int lcs3(int[] a, int[] b, int[] c) {
                    int m = a.length;
	    int n = b.length;
	    int l = c.length;

	    int[][][] table = new int[m + 1][n + 1][l + 1];

	    for (int i = 0; i <= m; i++) {
	        for (int j = 0; j <= n; j++) {
	            for (int k = 0; k <= l; k++) {
	                if (i == 0 || j == 0 || k == 0)
	                    table[i][j][k] = 0;
	                else if (a[i - 1] == b[j - 1] && b[j - 1] == c[k - 1])
	                    table[i][j][k] = table[i - 1][j - 1][k - 1] + 1;
	                else
	                    table[i][j][k] =    Math.max(table[i - 1][j][k], 
	                                        Math.max(table[i][j - 1][k], table[i][j][k - 1]));
	            }
	        }
	    }
	    return table[m][n][l];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int an = scanner.nextInt();
        int[] a = new int[an];
        for (int i = 0; i < an; i++) {
            a[i] = scanner.nextInt();
        }
        int bn = scanner.nextInt();
        int[] b = new int[bn];
        for (int i = 0; i < bn; i++) {
            b[i] = scanner.nextInt();
        }
        int cn = scanner.nextInt();
        int[] c = new int[cn];
        for (int i = 0; i < cn; i++) {
            c[i] = scanner.nextInt();
        }
        System.out.println(lcs3(a, b, c));
    }
}

