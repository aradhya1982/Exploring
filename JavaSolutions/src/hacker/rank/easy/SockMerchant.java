package hacker.rank.easy;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/sock-merchant
 * John works at a clothing store. He has a large pile of socks that he must pair by color for sale. Given an array of integers representing the color of each sock, determine how many pairs of socks with matching colors there are.
 *
 * For example, there are  N = 7 socks with colors ar = [1,2,1,2,1,3,2]. There is one pair of color and one of color. There are three odd socks left, one of each color. The number of pairs is .
 *
 * Function Description
 *
 * Complete the sockMerchant function in the editor below. It must return an integer representing the number of matching pairs of socks that are available.
 *
 * sockMerchant has the following parameter(s):
 *
 * n: the number of socks in the pile
 * ar: the colors of each sock
 * Input Format
 *
 * The first line contains an integer , the number of socks represented in .
 * The second line contains  space-separated integers describing the colors  of the socks in the pile.
 *
 * Constraints
 *
 *  where
 * Output Format
 *
 * Return the total number of matching pairs of socks that John can sell.
 */
public class SockMerchant {

    // Complete the sockMerchant function below.
    static int sockMerchant(int n, int[] ar) {
    	HashMap<Integer, Integer> matchingSocks = new HashMap<>();
    	for (int i = 0; i < n; i++) {
			Integer sockColor = new Integer(ar[i]);
			if (matchingSocks.containsKey(sockColor)) {
				matchingSocks.put(sockColor, matchingSocks.get(sockColor) + 1);
			} else {
				matchingSocks.put(sockColor, 1);
			}
		}
    	int evenCount = 0;
    	for (Iterator<Entry<Integer, Integer>> iterator = matchingSocks.entrySet().iterator(); iterator.hasNext();) {
			Entry<Integer, Integer> sockCountEntry = iterator.next();
			evenCount += sockCountEntry.getValue().intValue()/2;
			
		}
    	return evenCount;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        int n = scanner.nextInt();
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//        int[] ar = new int[n];
//
//        String[] arItems = scanner.nextLine().split(" ");
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//        for (int i = 0; i < n; i++) {
//            int arItem = Integer.parseInt(arItems[i]);
//            ar[i] = arItem;
//        }
//
//        int result = sockMerchant(n, ar);
//
//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();
//
//        scanner.close();
    	
    	int[] ar = {1,1,2,2,1,1,2,2,1,2};
    	System.out.println(sockMerchant(10, ar));
    }
}
