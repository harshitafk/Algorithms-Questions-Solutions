import java.util.*;

public class DifferentSummands {
    private static List<Integer> optimalSummands(int n) {
       List<Integer> summands = new ArrayList<Integer>();

		if (n == 0 || n == 1 || n == 2) {
			summands.add(n);
			return summands;
		}

		int sum = 0;
		int numbers = 1;

		while (true) {
			sum = sum + numbers;
			summands.add(numbers);
			numbers++;

			if (sum >= n) {
				break;
			}
		}
		if (sum == n) {
			return summands;
		} else {
			//int rem = sum - n;
			int remFromLast = summands.get(summands.size() - 1) - (sum - n);
			int toBeAdd = summands.get(summands.size() - 2) + remFromLast;
			summands.remove(summands.size() - 1);
			summands.remove(summands.get(summands.size() - 1));
			summands.add(toBeAdd);	
		}

		return summands;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> summands = optimalSummands(n);
        System.out.println(summands.size());
        for (Integer summand : summands) {
            System.out.print(summand + " ");
        }
    }
}

