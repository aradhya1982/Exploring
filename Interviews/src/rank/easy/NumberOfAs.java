package rank.easy;

import java.io.IOException;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/repeated-string
 * Lilah has a string, s, of lowercase English letters that she repeated infinitely many times.
 *
 * Given an integer, , find and print the number of letter a's in the first  letters of Lilah's infinite string.
 *
 * For example, if the string  and , the substring we consider is , the first  characters of her infinite string. There are  occurrences of a in the substring.
 *
 * Function Description
 *
 * Complete the repeatedString function in the editor below. It should return an integer representing the number of occurrences of a in the prefix of length  in the infinitely repeating string.
 *
 * repeatedString has the following parameter(s):
 *
 * s: a string to repeat
 * n: the number of characters to consider
 * Input Format
 *
 * The first line contains a single string, .
 * The second line contains an integer, .
 *
 * Constraints
 *
 * For  of the test cases, .
 * Output Format
 *
 * Print a single integer denoting the number of letter a's in the first  letters of the infinite string created by repeating  infinitely many times.
 */
public class NumberOfAs {

    // Complete the repeatedString function below.
    static long repeatedString(String s, long n) {
    	long numOfAs = 0;
    	long aInS = numOfAs(s, s.length());
    	long maxRecurrance = n /s.length();
    	long remainder = n % s.length();
    	numOfAs = maxRecurrance * aInS + numOfAs(s, (int) remainder);
    	return numOfAs;

    }
    
    static long numOfAs(String s, int n) {
    	long as = 0;
    	for (int i = 0; i < n; i++) {
			if(s.charAt(i) == 'a') {
				as++;
			}
		}
    	
    	return as;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        String s = scanner.nextLine();
//
//        long n = scanner.nextLong();
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//        long result = repeatedString(s, n);
//
//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();
//
//        scanner.close();
    	System.out.println(repeatedString("aba", 10));
    	System.out.println(repeatedString("abcac", 10));
    	
    }
}
