import java.util.*;

public class CoveringSegments {
    private static List<Integer> optimalPoints(Segment[] segments) {
	        //write your code here
	        List<Integer> points = new ArrayList<Integer>();
	        Arrays.sort(segments, new Comparator<Segment>() {

				@Override
	        	public int compare(Segment o1, Segment o2) {
					// TODO Auto-generated method stub
					return o1.end.compareTo(o2.end);
				}
	        	
	        });
	        
	        int s = 0;
	        int n = segments.length;
	        while(s < n) {
	        	Segment segment = segments[s];
	        	int p=s;
	        	while(p < n && segments[p].start <= segment.end) {
	        		p++;
	        	}
	        	
	        	points.add(segment.end);
	        	s=p;
	        }
	        return points;
	    }

	    private static class Segment {
	        Integer start, end;

	        Segment(Integer start, Integer end) {
	            this.start = start;
	            this.end = end;
	        }
	    }
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        int n = scanner.nextInt();
	        Segment[] segments = new Segment[n];
	        for (int i = 0; i < n; i++) {
	            int start, end;
	            start = scanner.nextInt();
	            end = scanner.nextInt();
	            segments[i] = new Segment(start, end);
	        }
	       List<Integer> points = optimalPoints(segments);
	        System.out.println(points.size());
	        for (int point : points) {
	            System.out.print(point + " ");
	        }
	    }
}
 
