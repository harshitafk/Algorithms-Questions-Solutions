import java.util.*;
import java.io.*;

public class CarFueling {
  static int computeMinRefills(int dist, int tank, int[] stops) {
		int numRefills = 0;
		int currentRefills = 0;
		int currentDistance = 0;

		while (currentRefills <= stops.length && currentDistance + tank < dist) {
			int lastRefill = currentDistance;
			
			if(dist > tank) {
				while((stops[currentRefills] - lastRefill) <= tank && (lastRefill + tank) <= dist) {
					currentDistance = stops[currentRefills];
					if(currentRefills + 1 <= stops.length -1) {
						currentRefills = currentRefills + 1;
					}else
						break;
				}
				if(lastRefill == currentDistance) {
					return -1;
				}else if(currentDistance <= dist) {
					numRefills = numRefills + 1;
				}
			}
			else {
				return 0;
			}
		}
		return numRefills;
	}

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dist = scanner.nextInt();
        int tank = scanner.nextInt();
        int n = scanner.nextInt();
        int stops[] = new int[n];
        for (int i = 0; i < n; i++) {
            stops[i] = scanner.nextInt();
        }

        System.out.println(computeMinRefills(dist, tank, stops));
    }
}
