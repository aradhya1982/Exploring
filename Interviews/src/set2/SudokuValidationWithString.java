package set2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class SudokuValidationWithString {

    // Complete the sudoku function below.
    public static String sudoku(String word, List<List<Character>> grid) {
        String result = "Valid";
        HashMap<Character, Integer> mappedChar = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {
            mappedChar.put(word.charAt(i), i + 1);
        }

        List<List<Integer>> numberGrid = new ArrayList<List<Integer>>();
        for (Iterator iterator = grid.iterator(); iterator.hasNext();) {
            List<Character> list = (List<Character>) iterator.next();
            List<Integer> rowNumbers = new ArrayList<Integer>();
            for (Iterator iterator2 = list.iterator(); iterator2.hasNext();) {
                Character character = (Character) iterator2.next();
                rowNumbers.add(mappedChar.get(character));
            }
            numberGrid.add(rowNumbers);
        }

        // validate rows

        for (Iterator iterator = numberGrid.iterator(); iterator.hasNext();) {
            List<Integer> list = (List<Integer>) iterator.next();
            int count = 0;
            for (Iterator iterator2 = list.iterator(); iterator2.hasNext();) {
                Integer integer = (Integer) iterator2.next();
                count = count + integer;
            }
            if (count != 45) {
                return "Invalid";
            }
        }

        // validate columns

        for (int i = 0; i < 9; i++) {
            int count = 0;
            for (Iterator iterator = numberGrid.iterator(); iterator.hasNext();) {
                List<Integer> list = (List<Integer>) iterator.next();
                count = count + list.get(i);
            }
            if (count != 45) {
                return "Invalid";
            }
        }


        return result;
    }



    public static void main(String[] args) {
        int num = 1;
        long startTime = System.nanoTime();

        System.out.printf("Time taken: " + (System.nanoTime() - startTime)/ 10e9);
    }
}
