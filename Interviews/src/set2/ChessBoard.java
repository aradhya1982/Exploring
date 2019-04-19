package set2;

import java.util.ArrayList;
import java.util.List;

public class ChessBoard {



    // Complete the chessBoard function below.
    public static List<List<Character>> chessBoard(int n) {
        List<List<Character>> result = new ArrayList<List<Character>>(n);
        for (int i = 0; i < n; i ++) {
        	List<Character> currentList = new ArrayList<Character>(n);
        	Character firstChar = i %2 == 0 ? 'W' : 'B';
        	Character secondChar = i %2 == 0 ? 'B' : 'W';
        	
        	for (int j = 0; j < n; j++) {
        		if(j%2 == 0) {
        			currentList.add(firstChar);
        		} else {
        			currentList.add(secondChar);
        		}
			}
        	result.add(currentList);
        }
        return result;

    }

	public static void main(String[] args) {
		chessBoard(5);
	}
    

}
