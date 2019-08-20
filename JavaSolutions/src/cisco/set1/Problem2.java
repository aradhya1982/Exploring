package cisco.set1;

import java.util.ArrayList;
import java.util.List;

public class Problem2 {


    /*
     * Complete the 'maxSubstring' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String maxSubstring(String s) {
        String maxSubstring = "";

        List<String> substrings = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            for (int j = i+1; j <= s.length(); j++) {
//                System.out.println(s.substring(i,j));
                substrings.add(s.substring(i,j));

            }
        }

        for (String sub : substrings) {
            if(maxSubstring.compareTo(sub) < 0) {
                maxSubstring = sub;
            }
        }
        return maxSubstring;
    }


    public static void main(String[] args) {
        Problem2 prob = new Problem2();
        System.out.println("max substring is: ");

        System.out.println(maxSubstring("baca"));
    }
}
