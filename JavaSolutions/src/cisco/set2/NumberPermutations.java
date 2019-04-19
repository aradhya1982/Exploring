package cisco.set2;

import java.util.ArrayList;
import java.util.List;

public class NumberPermutations {

    // Complete the numPermutation function below.
    /*public static List<Integer> numPermutation(int N) {
        List<Integer> result = new ArrayList<Integer>();

        List<Integer> numbers = new ArrayList<Integer>();
        int tempN = N;
        while (tempN != 0) {
            int lastNum = tempN%10;
            numbers.add(lastNum);
            tempN = tempN/10;
        }

        int numberOfDigits = numbers.size();
        int possiblePermutation = 1;
        for (int i = 2; i <= numberOfDigits; i++) {
            possiblePermutation = possiblePermutation * i;
        }

        for (int i = 0, c = 0; c < possiblePermutation; i = (i + 1) % numberOfDigits, c++) {
            int number = numbers.get(i);
            int offset = (c/numberOfDigits);
            for (int j = 1, k = i + offset + 1; j < numberOfDigits; j++, k = k + offset + 1) {
                int index = (k)  % numberOfDigits;
                number = numbers.get(index) + number * 10;
            }
            System.out.println(number);
            result.add(number);
        }
        return result;
    }*/

    public static List<Integer> numPermutation(int N) {
        List<Integer> result = new ArrayList<Integer>();

        List<Integer> numbers = new ArrayList<Integer>();
        int tempN = N;
        while (tempN != 0) {
            int lastNum = tempN%10;
            numbers.add(lastNum);
            tempN = tempN/10;
        }

        int numberOfDigits = numbers.size();
        permutate(numbers, 0, numberOfDigits, result);

        return result;

    }

    private static void permutate(List<Integer> numbers, int l, int r, List<Integer> result) {
        if (l == r) {
            int newNum = 0;
            for (Integer n: numbers) {
                newNum = n + newNum * 10;
            }
            System.out.println(newNum);
            result.add(newNum);
        }

        for (int i = l; i < r; i++) {
            swap(numbers, l, i);
            permutate(numbers, l + 1, r, result);
            swap(numbers, i, l);

        }
    }

    private static void swap(List<Integer> numbers, int i, int j) {
        int temp = numbers.get(i);
        numbers.set(i, numbers.get(j));
        numbers.set(j, temp);
    }

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        numPermutation(321);
        System.out.println();
        numPermutation(4321);


        System.out.printf("Time taken: " + (System.nanoTime() - startTime)/ 10e9);
    }
}
