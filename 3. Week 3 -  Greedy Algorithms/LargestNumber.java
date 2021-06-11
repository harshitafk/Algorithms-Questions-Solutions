import java.util.*;

public class LargestNumber {
      private static String largestNumber(String[] a) {
	        //write your code here
		   
	        Arrays.sort(a, new Comparator<String>() {

				@Override
				public int compare(String o1, String o2) {
					o1 += o2;
					o2 += o1;
					
					for(int i=0; i < o1.length(); i++) {
						if(o1.charAt(i) > o2.charAt(i))
							return -1;
						
						else if(o1.charAt(i) < o2.charAt(i))
							return 1;
					}
					return 0;
				}
	        	
	        });
	        
	        StringBuilder result = new StringBuilder();
	        
	        for(String m : a) {
	        	result.append(m);
	        }

	        return result.toString();
	    }
	   

	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        int n = scanner.nextInt();
	        String[] a = new String[n];
	        for (int i = 0; i < n; i++) {
	            a[i] = scanner.next();
	        }
	        System.out.println(largestNumber(a));
	        scanner.close();
	    }
	    
}

