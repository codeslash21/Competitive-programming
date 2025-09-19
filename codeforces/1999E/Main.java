// https://codeforces.com/problemset/problem/1999/E
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[] pref = new int[200001];
        for(int i=1;i<=2e5;i++) {
            int ele=i, pow=0;
            while(ele>0) {
                ele/=3;
                pow++;
            }
            pref[i]=pref[i-1]+pow;
        }
        while(t-->0) {
            int l = sc.nextInt(), r = sc.nextInt();
            System.out.println(pref[r]+pref[l]-2*pref[l-1]);
        }
    }
}
