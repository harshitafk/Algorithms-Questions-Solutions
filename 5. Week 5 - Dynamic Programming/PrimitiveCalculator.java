import java.util.*;

public class PrimitiveCalculator {
   private static List<Integer> optimal_sequence(int n) {
		 List<Integer> sequence = new ArrayList<Integer>();
	        int[] minOperation = new int[n + 1];
	        int[] path = new int[n + 1];

	        for (int i = 2; i <= n; i++) {
	            int min = Integer.MAX_VALUE;
	            if (i % 3 == 0 && min > minOperation[i / 3] + 1) {
	                min = minOperation[i / 3] + 1;
	                path[i] = i / 3;
	            } 
	            if (i % 2 == 0  && min > minOperation[i/ 2] + 1) {
	                min = minOperation[i / 2] + 1;
	                path[i] = i / 2;
	            } if (min > minOperation[i - 1] + 1) {
	                min = minOperation[i - 1] + 1;
	                path[i] = i - 1;
	            }
	            minOperation[i] = min;
	        }

	        while (n >= 1) {
	            sequence.add(n);
	            n = path[n];
	        }
	        Collections.reverse(sequence);

	        return sequence;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		List<Integer> sequence = optimal_sequence(n);
		System.out.println(sequence.size() - 1);
		for (Integer x : sequence) {
			System.out.print(x + " ");
		}
	}
}

