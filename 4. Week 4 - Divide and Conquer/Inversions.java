import java.util.*;

public class Inversions {
private static long getNumberOfInversions(int[] a, int[] b, int left, int right) 
	{ 
		long numberOfInversions = 0;
		if (right > left) { 
			
			int ave = (right + left) / 2; 			
			numberOfInversions = getNumberOfInversions(a, b, left, ave); 
			numberOfInversions += getNumberOfInversions(a, b, ave + 1, right); 
			numberOfInversions += merge(a, b, left, ave + 1, right); 
		} 
		return numberOfInversions; 
	} 

    
	static long merge(int a[], int temp[], int left, int mid, int right) 
	{ 
		int i, j, k; 
		long numberOfInversions = 0; 

		i = left; 
		j = mid; 
		k = left; 
		while ((i <= mid - 1) && (j <= right)) { 
			
			if (a[i] <= a[j]) { 
				temp[k++] = a[i++]; 
			} 
			else { 
				
				temp[k++] = a[j++]; 
				numberOfInversions = numberOfInversions + (mid - i); 
			} 
		} 

        
		while (i <= mid - 1) 
			temp[k++] = a[i++]; 

	    
		while (j <= right) 
			temp[k++] = a[j++]; 

		for (i = left; i <= right; i++) 
			a[i] = temp[i]; 

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
        System.out.println(getNumberOfInversions(a, b, 0, a.length-1));
    }
}

