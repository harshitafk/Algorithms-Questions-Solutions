import java.util.*;

public class LCS2 {

   private static int lcs2(int[] a, int[] b) {
		// Write your code here
		int[][] dArray = new int[a.length + 1][b.length + 1];

		for (int i = 1; i <= a.length; i++) {
			for (int j = 1; j <= b.length; j++) {
				if (a[i - 1] == b[j - 1]) {
					dArray[i][j] = dArray[i - 1][j - 1] + 1;
				} else {
					dArray[i][j] = Math.max(dArray[i][j - 1],dArray[i-1][j]);
				}
			}
		}

		return dArray[a.length][b.length];
	}

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
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

        System.out.println(lcs2(a, b));
    }
}
