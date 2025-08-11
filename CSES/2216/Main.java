// https://cses.fi/problemset/task/2216/

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), res=1;
        int[] arr = new int[n+1];
        for(int i=1;i<=n;i++)
            arr[sc.nextInt()]=i;
        for(int i=2;i<=n;i++)
            if(arr[i-1]>arr[i])
                res++;
        System.out.println(res);
    }
}
