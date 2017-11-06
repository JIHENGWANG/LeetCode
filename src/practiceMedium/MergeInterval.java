package practiceMedium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Interval {
	int start;
	int end;
	Interval() {
		start = 0;
		end = 0;
	}
	Interval(int s, int e) {
		start = s;
		end = e;
	}
}

public class MergeInterval {
	/*
	 * merge intervals
	 * Assumptions: if intervals is null or empty, then return empty list
	 * 
	 * Steps: loop all intervals and save the start and end to two arrays
	 * 
	 * 
	 */
	public List<Interval> merge(List<Interval> intervals) {
		if(intervals == null || intervals.size() == 0){
			return intervals;
		}
		int[] start = new int[intervals.size()];
		int[] end = new int[intervals.size()];
		for(int i = 0; i < intervals.size(); i++){
			start[i] = intervals.get(i).start;
			end[i] = intervals.get(i).end;
		}
        Arrays.sort(start);
	    Arrays.sort(end);
		int s = 0;
		int e = 0;
		int n = intervals.size();
		List<Interval> sol = new ArrayList<> ();
		while(s < n && e < n){
			if(e + 1 < n && end[e] >= start[e + 1]){
				e++;
			} else {
				sol.add(new Interval(start[s], end[e]));
				s = e + 1;
                if(e < n){
                    e++;
                }
			}
		}
		return sol;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
