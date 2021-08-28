import java.util.*;

public class Inversions {
	private static long getNumberOfInversions(int[] a, int[] b, int left, int right) {
		long numberOfInversions = 0;
		if (right <= left) {
			return numberOfInversions;
		}
		int mid = left + (right - left) / 2;
		numberOfInversions += getNumberOfInversions(a, b, left, mid);
		numberOfInversions += getNumberOfInversions(a, b, mid + 1, right);
		// write your code here
		numberOfInversions += count(a, b, left, mid, right);
		return numberOfInversions;
	}

	private static long count(int[] a, int[] b, int left, int mid, int right) {
		long numberOfInversions = 0;

		for (int k = left; k <= right; k++) {
			b[k] = a[k];
		}
			
		int i = left, j = mid + 1;
		for (int k = left; k <= right; k++) {
			if (i > mid) {
				a[k] = b[j++];
			} else if (j > right) {
				a[k] = b[i++];
			} else if (b[i] <= b[j]) {
				a[k] = b[i++];
			} else {
				a[k] = b[j++];
				numberOfInversions += (mid - i + 1);
			}
		}
		return numberOfInversions;

	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = scanner.nextInt();
		}
		int[] b = new int[n];
		System.out.println(getNumberOfInversions(a, b, 0, a.length - 1));
	}
}

