package leet.medium;


import javafx.beans.binding.StringBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/zigzag-conversion/
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 *
 * Write the code that will take a string and make this conversion given a number of rows:
 *
 * string convert(string s, int numRows);
 * Example 1:
 *
 * Input: s = "PAYPALISHIRING", numRows = 3
 * Output: "PAHNAPLSIIGYIR"
 * Example 2:
 *
 * Input: s = "PAYPALISHIRING", numRows = 4
 * Output: "PINALSIGYAHRPI"
 *          PINALSRGYAHIPI
 * Explanation:
 *
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 *
 * p       h
 * a     s i
 * y   i   r
 * p l     i g
 * a       n
 */
public class ZigZagConversion {
    public String convert(String s, int numRows) {
        String zigZag = "";
        if (numRows < 2) {
            return s;
        }
        int n = s.length(), i = 0;
        int currColumn = 0;
        List<String> columns = new ArrayList<>();
        while (true) {
            if (i >= n) { break; }

            String currColString;
            currColumn = (i % (numRows - 1));
            if (currColumn == 0) {
                int end = (i + numRows);
                if (end > n) { end = n; }
                currColString = s.substring(i, end);
                i = i + numRows;
                System.out.println(currColString);
            } else {
                currColString = "";
                for (int j = numRows - 1; j >= 0 ; j--) {
                    char nextChar = j == currColumn ? s.charAt(i) : ' ';
                    currColString = currColString + nextChar;
                }
                i++;
                System.out.println(currColString.replaceAll(" ", "_"));
            }
            columns.add(currColString);
        }

        System.out.println(columns);

        for (i = 0; i < numRows; i++) {
            for (String col: columns) {
                if (i < col.length() && col.charAt(i) != ' ') {
                    zigZag = zigZag + (col.charAt(i));
                }
            }
        }
        return zigZag;

    }

    public static void main(String[] args) {
        ZigZagConversion z = new ZigZagConversion();
//        System.out.println(z.convert("PAYPALISHIRING", 3));
        System.out.println(z.convert("PAYPALISHIRING", 4));
        System.out.println("PINALSIGYAHRPI");
//        System.out.println(z.convert("PAYPALISHIRING", 5));

    }
}
