// https://cses.fi/problemset/task/1084/

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m=sc.nextInt(), k=sc.nextInt(), count=0, i=0, j=0;
        int[] a = new int[n], b = new int[m];
        for(i=0;i<n;i++)
            a[i] = sc.nextInt();
        for(i=0;i<m;i++)
            b[i] = sc.nextInt();
        Arrays.sort(a);
        Arrays.sort(b);
        i=0;
        while(i<n && j<m) {
            if(a[i]+k<b[j]) i++;
            else if(a[i]-k>b[j]) j++;
            else {
                i++;
                j++;
                count++;
            }
        }
        System.out.println(count);
    }
}
