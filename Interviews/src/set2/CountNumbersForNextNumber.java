package set2;

import java.util.ArrayList;
import java.util.List;

public class CountNumbersForNextNumber {

    // Complete the nextNumber function below.
    public static int nextNumber(int num) {
        List<Integer> numbers = new ArrayList<Integer>();
        int tempN = num;
        int[] digitCount = {0,0,0,0,0,0,0,0,0,0,0};
        while (tempN != 0) {
            int lastNum = tempN%10;
            digitCount[lastNum] += 1;
            numbers.add(lastNum);
            tempN = tempN/10;
        }
        int nextNum = 0;

        for (int i = 0; i < digitCount.length; i++) {
            int currentCount = digitCount[i];
            if (digitCount[i] == 0) {
                continue;
            }

            nextNum = nextNum * 100;
            nextNum = (currentCount * 10 + i) + nextNum;
        }

        return nextNum;

    }

    public static void main(String[] args) {
        int num = 1;
        long startTime = System.nanoTime();
        for (int i = 0; i < 20; i++) {
            num = nextNumber(num);
            System.out.print(i + "th number is: " + num);
            System.out.println();
        }
        System.out.printf("Time taken: " + (System.nanoTime() - startTime)/ 10e9);
    }
}
