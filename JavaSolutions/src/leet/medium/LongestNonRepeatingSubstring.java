package leet.medium;

import java.util.HashSet;
import java.util.Set;

public class LongestNonRepeatingSubstring {

    public int lengthOfLongestSubstring(String s) {
        int longestSubstring = 0;
        Set<Character> currentSubsrting = new HashSet<Character>(s.length());
        for (int i = 0; i < s.length();){
            if (!currentSubsrting.add(s.charAt(i))) {
                if (currentSubsrting.size() > longestSubstring) {
                    longestSubstring = currentSubsrting.size();
                }
                i = i - currentSubsrting.size();
                currentSubsrting =  new HashSet<>();
            }
            i++;

        }
        if (currentSubsrting.size() > longestSubstring) {
            longestSubstring = currentSubsrting.size();
        }
        return longestSubstring;

    }

    public static void main(String[] args) {
        LongestNonRepeatingSubstring lnrs = new LongestNonRepeatingSubstring();
        System.out.println(lnrs.lengthOfLongestSubstring("bbbb"));
        System.out.println(lnrs.lengthOfLongestSubstring("vibha"));
        System.out.println(lnrs.lengthOfLongestSubstring("vihaan"));

    }
}
