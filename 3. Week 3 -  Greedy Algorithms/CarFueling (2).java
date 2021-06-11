import java.util.*;
import java.io.*;

public class CarFueling {
  static int computeMinRefills(int dist, int tank, int[] stops) {
	int numRefill = 0;
		int currentPosition = 0;
		int currentDistance = 0;
		int i =0;
		int[] totalStops = new int[stops.length+1];
		
		for(int stop : stops) {
			totalStops[i] = stop;
			i++;
		}
		totalStops[totalStops.length-1] = dist;
		
		if(tank > dist) {
			return 0;
		}else {
			while(currentDistance + tank < dist) {
				int lastPosition = currentPosition;
				
				while(totalStops[currentPosition] - currentDistance <= tank) {
					if(currentPosition < totalStops.length-1) {
					currentPosition++;
					}else {
						break;
					}
				}
				
				if(lastPosition == currentPosition) {
					return -1;
				}
				
				currentDistance = totalStops[currentPosition-1];
				if(currentDistance < dist) {
					numRefill++;
				}
			}
		}
		
		
		return numRefill;
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
