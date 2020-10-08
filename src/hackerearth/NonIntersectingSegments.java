package hackerearth;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class NonIntersectingSegments {

	
	public static void main(String[] args) throws Exception {
		
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();                // Reading input from STDIN
        int N = Integer.parseInt(line);
        
        Segment[] segments = new Segment[N];
        for(int i = 0; i < N; i++) {
        	String[] str = br.readLine().split(" ");
        	Segment s = new Segment(i, Integer.parseInt(str[0]),
        			Integer.parseInt(str[1]),
        			Integer.parseInt(str[2]),
        			Integer.parseInt(str[3]));
        	segments[i] = s;
        }
        
        for(int i = 0; i < N - 1; i++) {
        	for(int j = i; j < N; j++) {
        		if(segments[i].isOverlapping(segments[j])) {
        			segments[i].addOverlappingSegment(segments[j]);
        			segments[j].addOverlappingSegment(segments[i]);
        		}
        	}
        }
        
        PriorityQueue<Segment> queue = new PriorityQueue<Segment>(new Comparator<Segment>() {

			@Override
			public int compare(Segment o1, Segment o2) {
				if(o1.overlappingCount() < o2.overlappingCount()) {
					return -1;
				} else if(o1.overlappingCount() > o2.overlappingCount()) {
					return 1;
				} else {
					return 0;
				}
			}
		});
        
        for(int i = 0; i < N; i++) {
        	queue.add(segments[i]);
        }
        
        int count = 0;
        Set<Integer> overlappingIndexes = new HashSet<>();
        while(!queue.isEmpty()) {
        	Segment s = queue.poll();
        	if(!overlappingIndexes.contains(s.index)) {
        		count++;
        		for(Segment overlappingSegment : s.overlappingSegments) {
        			overlappingIndexes.add(overlappingSegment.index);
        		}
        	}
        }
        
        System.out.println(count);
	}
	
	static class Segment {
		int index;
		int x1;
		int y1;
		int x2;
		int y2;
		
		ArrayList<Segment> overlappingSegments;
		
		public Segment(int index, int x1, int y1, int x2, int y2) {
			this.index = index;
			this.x1 = x1;
			this.y1 = y1;
			this.x2 = x2;
			this.y2 = y2;
			this.overlappingSegments = new ArrayList<>();
		}
		
		public void addOverlappingSegment(Segment segment) {
			this.overlappingSegments.add(segment);
		}
		
		public boolean isOverlapping(Segment other) {
			if(this.x1 < other.x1 && this.x2 < other.x2) 
				return false;
			
			if(this.x1 > other.x1 && this.x2 > other.x2)
				return false;
			
			if(this.x1 == other.x1 && this.x2 == other.x2) {
				if(this.y1 <= other.y1 && this.y2 <= other.y2) {
					return false;
				} 
				
				if(this.y1 >= other.y1 && this.y2 >= other.y2) {
					return false;
				}
			}
			
			return true;
		}
		
		public int overlappingCount() {
			return this.overlappingSegments.size();
		}
		
		public int getIndex() {
			return this.index;
		}
		
	}
}
