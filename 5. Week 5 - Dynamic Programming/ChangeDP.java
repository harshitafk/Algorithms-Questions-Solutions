import java.util.Scanner;

public class ChangeDP {
    private static int getChange(int m) {//write your code here
		//System.out.println("m "+m);
		int[] coins = {1,3,4};
		int nextTry = 0;
		int best = -1;
		
		if(m <= 0) {
			return 0;
		}
		
		if(m == 1) {
			return 1;
		}
		
		if(m > 0) {
		
		for(int coin : coins) {
			if(coin <= m)
				//System.out.println("Coin " +coin);
				nextTry = getChange(m - coin);
				//System.out.println("Nexttry "+nextTry);
			if(best < 0 || best > nextTry + 1) {
				//System.out.println("Inside Best");
				best = nextTry + 1;
			}
		}
	}
		
		//System.out.println("Best "+best);
		
        return best;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }
}

