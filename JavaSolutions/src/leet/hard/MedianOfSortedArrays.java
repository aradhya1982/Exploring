package leet.hard;

/**
 * https://leetcode.com/problems/median-of-two-sorted-arrays/
 *
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 *
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 *
 * You may assume nums1 and nums2 cannot be both empty.
 *
 * Example 1:
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * The median is 2.0
 * Example 2:
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * The median is (2 + 3)/2 = 2.5
 */
public class MedianOfSortedArrays {

    public double findMedianSortedArrays(int[] left, int[] right) {
        double median = 0;

        int m = left.length,
                n = right.length;
        int medianI = (m + n)/2 + 1;
        boolean isOdd = (m + n) % 2 == 1;
        int iLeft = 0, iRight = 0, currI = 0;
        int m1 = 0, m2 = 0;
        while (true){
            if (currI == medianI) {
                break;
            }
            if (iLeft >= m || iRight >= n) {
                break;
            }
            m1 = m2;
            if (left[iLeft] < right[iRight] ){
                m2 = left[iLeft];
                iLeft++;
            } else {
                m2 = right[iRight];
                iRight++;
            }
            currI++;
        }

        if (currI < medianI) {

            int[] overflowArray = iLeft == m ? right : left;
            int i = iLeft == m ? iRight : iLeft;

            for (; currI < medianI; i++, currI++) {
                m1 = m2;
                m2 = overflowArray[i];
            }
        }


        median = isOdd? m2 : (m1 + m2)/2.0;

        return median;

    }

    public static void main(String[] args) {
        MedianOfSortedArrays medianOfSortedArrays = new MedianOfSortedArrays();
        double median = medianOfSortedArrays.findMedianSortedArrays(new int[]{1, 2, 3}, new int[]{4, 5, 6});
        System.out.println(median);

        median = medianOfSortedArrays.findMedianSortedArrays(new int[]{1, 2}, new int[]{3});
        System.out.println(median);

        median = medianOfSortedArrays.findMedianSortedArrays(new int[]{1, 4, 5}, new int[]{2, 3});
        System.out.println(median);
    }
}
