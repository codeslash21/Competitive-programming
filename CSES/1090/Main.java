// https://cses.fi/problemset/task/1090/

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), x=sc.nextInt(), left=0, right=n-1, rem=n, count=0;
        int[] p = new int[n];
        for(int i=0;i<n;i++)
            p[i] = sc.nextInt();
        Arrays.sort(p);
        while(left<right) {
            if(p[left]+p[right]<=x) {
                left++;
                right--;
                rem-=2;
                count++;
            } else
                right--;
        }
        count+=rem;
        System.out.println(count);
    }
}
