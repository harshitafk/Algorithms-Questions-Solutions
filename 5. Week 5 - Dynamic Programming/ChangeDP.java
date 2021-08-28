import java.util.Scanner;

public class ChangeDP {
   private static int getChange(int m) {
		// write your code here
		int[] coins = { 1, 3, 4 };
		int[] minNumOfCoins = new int[m + 1];
		
		for (int i = 1; i <= m; i++) {
			int numOfCoins = 0;
			minNumOfCoins[i] = Integer.MAX_VALUE;
			for (int j = 0; j < coins.length; j++) {
				if (i >= coins[j]) {
					numOfCoins = minNumOfCoins[i - coins[j]] + 1;
				}
				if (numOfCoins < minNumOfCoins[i]) {
					minNumOfCoins[i] = numOfCoins;
				}
			}
		}

		return minNumOfCoins[m];
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int m = scanner.nextInt();
		System.out.println(getChange(m));

	}
}

