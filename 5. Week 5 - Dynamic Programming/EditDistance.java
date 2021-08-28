import java.util.*;

class EditDistance {
  public static int EditDistance(String s, String t) {
      //write your code here
		int sLength = s.length();
		int tLength = t.length();
		
		int[][] dArray = new int[sLength + 1][tLength + 1];
		for(int i = 0; i <= sLength; i++) {
			dArray[i][0] = i;
		}
		
		for(int j = 0; j <= tLength; j++) {
			dArray[0][j] = j;
		}
		
		for(int i = 1; i <= sLength; i++) {
			for(int j = 1; j <= tLength; j++) {
				int insertion = dArray[i][j - 1] + 1;
				int deletion = dArray[i - 1][j] + 1;
				int mismatch = dArray[i - 1][j - 1] + 1;
				int match = dArray[i - 1][j - 1];
				
				if(s.charAt(i - 1) == t.charAt(j - 1)) {
					dArray[i][j] = Math.min(insertion,Math.min(deletion,match));
				}else {
					dArray[i][j] = Math.min(insertion,Math.min(deletion,mismatch));
				}
				
			}
		}
		
		return dArray[sLength][tLength];
  }
  public static void main(String args[]) {
    Scanner scan = new Scanner(System.in);

    String s = scan.next();
    String t = scan.next();

    System.out.println(EditDistance(s, t));
  }

}
