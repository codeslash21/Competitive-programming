// https://cses.fi/problemset/task/1643/

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long t = sc.nextInt(), maxSum=Long.MIN_VALUE, currSum=0;
        while(t-->0) {
            int ele = sc.nextInt();
            currSum+=ele;
            maxSum=Math.max(maxSum, ele);
            maxSum=Math.max(maxSum, currSum);
            if(currSum<0)
                currSum=0;
        }
        System.out.println(maxSum);
    }
}
