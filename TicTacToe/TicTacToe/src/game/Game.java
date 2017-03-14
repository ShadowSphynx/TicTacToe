package game;

import java.util.Arrays;

public class Game {
	
	int cross[], zero[], data[][];
	public int count;
	int crossVal;
	int zeroVal;
	
	public Game() {
		cross = new int[]{99, 99, 99, 99, 99};
		zero = new int[]{99, 99, 99, 99, 99};
		data = new int[][]{{1, 2, 3}, {1, 4, 7}, {1, 5, 9}, {7, 8, 9}, {4, 5, 6}, {2, 5, 8}, {3, 5, 7}, {3, 6, 9}};
		count = 0;
		crossVal = 0;
		zeroVal = 0;
	}
	
	public int setMove(int val) {
		count++;
		
		if(count%2!=0) {
			cross[crossVal++] = val;
			Arrays.sort(cross);
		}
		else {
			zero[zeroVal++] = val;
			Arrays.sort(zero);
		}
		return count%2;
	}
	
	public boolean checkGame() {
		int a[];
		
		if(count%2 != 0)
			a=cross;
		else
			a=zero;
		
		for(int i=0; i<8; i++)
			if(isSubset(a, data[i], 5, 3))
				return true;
		return false;
	}
	
	boolean isSubset(int arr1[], int arr2[], int m, int n) {
	    int i = 0;
	    int j = 0;
	    for (i=0; i<n; i++) {
	    	for (j = 0; j<m; j++)
	    		if(arr2[i] == arr1[j])
	    			break;
	        
	        if (j == m)
	        	return false;
	    }
	    return true;
	}
}