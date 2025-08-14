// https://codeforces.com/problemset/problem/1783/A
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        l: while(t-->0) {
            int n = sc.nextInt(), right=n-1, left=0;
            int[] arr = new int[n];
            for(int i=0;i<n;i++)
                arr[i]=sc.nextInt();
            if(arr[0]==arr[n-1]) {
                System.out.println("NO");
                continue l;
            }
            System.out.println("YES");
            while(left<right) {
                System.out.print(arr[left++] + " ");
                System.out.print(arr[right--] + " ");
            }
            if(left==right)
                System.out.println(arr[left]);
            else
                System.out.println();
        }
    }
}
