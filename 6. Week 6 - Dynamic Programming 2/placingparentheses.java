import java.util.Scanner;

public class PlacingParentheses {
    private static long getMaximValue(String exp) {
		int expSize = exp.length();
		int digitSize = (expSize / 2) + 1;
		int symbolSize = ((expSize / 2) + 1) - 1;

		int l = 0;

		char[] op = new char[symbolSize];
		for (int i = 1; i < expSize;) {
			op[l] = exp.charAt(i);
			i = i + 2;
			l++;
		}

		int j = 0;
		int[] values = new int[digitSize];
		for (int i = 0; i < expSize;) {
			char c = exp.charAt(i);
			values[j] = Character.getNumericValue(c);
			i = i + 2;
			j++;
		}

		long[][] m = new long[digitSize][digitSize];
		long[][] M = new long[digitSize][digitSize];

		for (int i = 0; i < digitSize; i++) {
			m[i][i] = values[i];
			M[i][i] = values[i];
		}

		for (int s = 1; s < digitSize; s++) {
			for (int i = 0; i < digitSize - s; i++) {
				int k = i + s;
				long[] returnVal = minAndMax(i, k, m, M, op);
				m[i][k] = returnVal[0];
				M[i][k] = returnVal[1];
			}
		}
		return M[0][digitSize - 1];
	}

	private static long[] minAndMax(int i, int j, long[][] m, long[][] M, char[] op) {
		long min = Long.MAX_VALUE;
		long max = Long.MIN_VALUE;

		for (int k = i; k < j; k++) {
			long a = eval(M[i][k], m[k + 1][j], op[k]);
			long b = eval(m[i][k], m[k + 1][j], op[k]);
			long c = eval(M[i][k], M[k + 1][j], op[k]);
			long d = eval(m[i][k], M[k + 1][j], op[k]);

			min = Math.min(min, Math.min(Math.min(a, b), Math.min(c, d)));
			max = Math.max(max, Math.max(Math.max(a, b), Math.max(c, d)));
		}

		return new long[] { min, max };
	}

	private static long eval(long a, long b, char op) {
		if (op == '+') {
			return a + b;
		} else if (op == '-') {
			return a - b;
		} else if (op == '*') {
			return a * b;
		} else {
			assert false;
			return 0;
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String exp = scanner.next();
		System.out.println(getMaximValue(exp));
		scanner.close();
	}
}

