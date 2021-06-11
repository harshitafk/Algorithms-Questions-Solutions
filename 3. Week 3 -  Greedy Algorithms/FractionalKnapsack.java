import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapsack {
    private static double getOptimalValue(int capacity, int[] values, int[] weights) {
                                    double value = 0.0;
		 Item[] fraction = new Item[values.length];
		 
		 for(int i=0; i< values.length; i++) {
			 fraction[i] = new Item(values[i],weights[i]);
		 }
		 Arrays.sort(fraction, new Comparator<Item>() {

			@Override
			public int compare(Item o1, Item o2) {
				return o2.value.compareTo(o1.value);
			}
		 });
		 
		 for(int i=0; i < values.length; i++) {
			 if(capacity <= 0) {
				 return value;
			 }else {
				 int min = Math.min(capacity, fraction[i].weights);
				 value += min * ((fraction[i].values * 1.0)/fraction[i].weights);
				 capacity -= min;
			 }
		 }
		 return value;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }
        System.out.println(getOptimalValue(capacity, values, weights));
    }
                    static class Item{
	    	public int values;
	    	public int weights;
	    	Double value;
	    	
	    	public Item(int values, int weights) {
	    		this.values = values;
	    		this.weights = weights;
	    		this.value = ((values*1.0)/weights);
	    	}
	    }

} 
