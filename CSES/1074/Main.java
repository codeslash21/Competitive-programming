//  https://cses.fi/problemset/task/1074

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long res=0;
        int[] arr = new int[n];
        for(int i=0;i<n;i++)
            arr[i] = sc.nextInt();
        Arrays.sort(arr);
        int midEle = arr[n/2];
        for(int i=0;i<n;i++)
            res+=Math.abs(midEle-arr[i]);
        System.out.println(res);
    }
}
