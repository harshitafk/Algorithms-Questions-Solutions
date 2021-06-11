import java.util.Scanner;

public class Change {
    private static int getChange(int m) {
       final int denoOne = 1,denoFive = 5,denoTen = 10;
		int sum = 0,count = 0;
		int n = m;
		
		while (n >= denoOne) {
			count++;
			if (n >= denoTen) {
				sum = sum + denoTen; 
			} else if (n >= denoFive) {
				sum = sum + denoFive;
			} else {
				sum = sum + denoOne;
			}
			n = m - sum; 
							
		}
		return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }
}

