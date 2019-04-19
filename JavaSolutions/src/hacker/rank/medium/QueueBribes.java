package hacker.rank.medium;

import java.util.Scanner;

public class QueueBribes {

	static final String TOO_CHAOTIC = "Too chaotic";
    // Complete the minimumBribes function below.
    static void minimumBribes(int[] q) {
//    	int numberOfBribes = 0;
//    	int numbersMoved = 0;
//    	for (int i = 0; i < q.length; i++) {
//			int possibleBribes = q[i] - (i +1);
//    		if (possibleBribes > 2) {
//    			System.out.println(TOO_CHAOTIC);
//    			return;
//    		}
//    		if (possibleBribes > 0) {
//    			numberOfBribes += possibleBribes;
//    			numbersMoved++;
//    		} else if (numbersMoved != 0){
//    			possibleBribes = Math.abs(possibleBribes);
//    			int maxBribes = (numbersMoved * 2);
//    			if (possibleBribes > numbersMoved && (numberOfBribes/maxBribes) >= 1) {
//    				int remainder = (possibleBribes % numbersMoved);
////    				System.out.println(remainder);
//    				numberOfBribes = numberOfBribes + remainder;
//    			}
//    		}
//		}
//    	System.out.println(numberOfBribes);
    	
    	int ans = 0;
        for (int i = q.length - 1; i >= 0; i--) {
            if (q[i] - (i + 1) > 2) {
            	System.out.println(TOO_CHAOTIC);
                return;
            }
            for (int j = Math.max(0, q[i] - 2); j < i; j++)
                if (q[j] > q[i]) ans++;
        }
        System.out.println(ans);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
//        int t = scanner.nextInt();
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//        for (int tItr = 0; tItr < t; tItr++) {
//            int n = scanner.nextInt();
//            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//            int[] q = new int[n];
//
//            String[] qItems = scanner.nextLine().split(" ");
//            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//            for (int i = 0; i < n; i++) {
//                int qItem = Integer.parseInt(qItems[i]);
//                q[i] = qItem;
//            }
        	
//        }
//        int[] q = {2, 1, 5, 3, 4};
//        minimumBribes(q);
//        int[] r = {2, 5, 1, 3, 4};
//        minimumBribes(r);
        int[] s = {1, 2, 5, 3, 7, 8, 6, 4};
        minimumBribes(s);

        scanner.close();
    }
}
