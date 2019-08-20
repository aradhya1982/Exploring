package cisco.set1;

import java.util.List;

public class Problem1 {

    /*
     * Complete the 'getTriangleArea' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY x
     *  2. INTEGER_ARRAY y
     */

    public static int getTriangleArea(List<Integer> x, List<Integer> y) {

        Integer[] X = x.toArray(new Integer[3]);
        Integer[] Y = y.toArray(new Integer[3]);

        int area = Math.abs(X[0]*(Y[1]-Y[2]) + X[1]*(Y[2]-Y[0]) + X[2]*(Y[0]-Y[1]))/2;
        return area;

    }

    public static void main(String[] args) {
        Problem1 prob = new Problem1();
//        List<Integer> x = new List({0,3,0}) ;
//        List<Integer> y;
//        Problem1.getTriangleArea()
    }
}
