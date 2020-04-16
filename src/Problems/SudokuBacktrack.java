package Problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class SudokuBacktrack {
	static char answer[][] = new char[9][9];
	static ArrayList<HashSet<Character>> rows = new ArrayList<>();
	static ArrayList<HashSet<Character>> cols = new ArrayList<>();
	static ArrayList<HashSet<Character>> cubes = new ArrayList<>();
	static HashMap<String,Integer> map = new HashMap<>();

	public SudokuBacktrack(){
		map.put("00", 0);
		map.put("03", 1);
		map.put("06", 2);
		map.put("30", 3);
		map.put("33", 4);
		map.put("36", 5);
		map.put("60", 6);
		map.put("63", 7);
		map.put("66", 8);
	}
	public static void main(String[] args) {
		SudokuBacktrack sBacktrack = new SudokuBacktrack();
		char[][] A ={{'5','3','.','.','7','.','.','.','.'},
					{'6','.','.','1','9','5','.','.','.'},
					{'.','9','8','.','.','.','.','6','.'},
					{'8','.','.','.','6','.','.','.','3'},
					{'4','.','.','8','.','3','.','.','1'},
					{'7','.','.','.','2','.','.','.','6'},
					{'.','6','.','.','.','.','2','8','.'},
					{'.','.','.','4','1','9','.','.','5'},
					{'.','.','.','.','8','.','.','7','9'}};
		for(int i=0;i<9;i++){
			HashSet<Character> tempr = new HashSet<>();
			HashSet<Character> tempc = new HashSet<>();
			HashSet<Character> tempb = new HashSet<>();
			rows.add(i,tempr);
			cols.add(i,tempc);
			cubes.add(i,tempb);
		}
		for(int i=0;i<A.length;i++){
			
			for(int j=0;j<A[i].length;j++){
				if(A[i][j]!='.'){
					int sqrt = 3; 
					int boxR = i - i % sqrt; 
					int boxC = j - j % sqrt;
					String key = ""+boxR+boxC; 
					rows.get(i).add(A[i][j]);
					cols.get(j).add(A[i][j]);
					cubes.get(map.get(key)).add(A[i][j]);
					
				}
			}
			
		}
		// System.out.println(rows);
		// System.out.println(cols);
		// System.out.println(cubes);
		new SudokuBacktrack().recurse(A);
		System.out.println(Arrays.deepToString(answer));
	}



	void recurse(char A[][]){
		int row = -1,col = -1;
		boolean isEmpty = false;
		for(int i=0;i<A.length;i++) {
			if(isEmpty)
				break;
			for(int j=0;j<A[i].length;j++) 
				if(A[i][j]=='.') {
					row = i;col = j;
					isEmpty= true;
					break;
				}	
		}
		if(!isEmpty) {
			for(int i=0;i<A.length;i++)
				for(int j=0;j<A[i].length;j++)
					answer[i][j] = A[i][j];
			return;
		}
		for(char i='1';i<='9';i++) {
			if(isSafe(A, row, col, i)) {
				A[row][col] = i;
				int sqrt = 3; 
				int boxR = row - row % sqrt; 
				int boxC = col - col % sqrt;
				String key = ""+boxR+boxC; 
				rows.get(row).add(A[row][col]);
				cols.get(col).add(A[row][col]);
				cubes.get(map.get(key)).add(A[row][col]);
				recurse(A);
				rows.get(row).remove(A[row][col]);
				cols.get(col).remove(A[row][col]);
				cubes.get(map.get(key)).remove(A[row][col]);
				A[row][col] = '.';
				
			}
		}
	}
	public boolean isSafe(char[][] board,int row,int col,char num){
		if(rows.get(row).contains(num))
			return false;
		if(cols.get(col).contains(num))
			return false;
		int sqrt = 3; 
		int boxR = row - row % sqrt; 
		int boxC = col - col % sqrt;
		String key = ""+boxR+boxC;
		if(cubes.get(map.get(key)).contains(num))
		return false; 
		
		return true;
	}

	// public boolean isSafe(char[][] board,  
    //         int row, int col,  
    //         char num)  
	// { 
	// for (int d = 0; d < board.length; d++)  
	// { 

	// if (board[row][d] == num)  
	// { 
	// return false; 
	// } 
	// } 
	
	// // column has the unique numbers (column-clash) 
	// for (int r = 0; r < board.length; r++) 
	// { 
	// // if the number we are trying to 
	// // place is already present in 
	// // that column, return false; 
	
	// if (board[r][col] == num) 
	// { 
	// return false; 
	// } 
	// } 
	
	// // corresponding square has 
	// // unique number (box-clash) 
	// int sqrt = (int) Math.sqrt(board.length); 
	// int boxRowStart = row - row % sqrt; 
	// int boxColStart = col - col % sqrt; 
	
	// for (int r = boxRowStart; r < boxRowStart + sqrt; r++)  
	// { 
	// for (int d = boxColStart; d < boxColStart + sqrt; d++)  
	// { 
	// if (board[r][d] == num)  
	// { 
	// return false; 
	// } 
	// } 
	// } 
	
	// // if there is no clash, it's safe 
	// return true; 
	// } 
}

