// https://codeforces.com/problemset/problem/1788/A
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0) {
            int n = sc.nextInt(), count=0, left=0;
            int[] arr = new int[n];
            for(int i=0;i<n;i++) {
                arr[i]=sc.nextInt();
                if(arr[i]%2==0)
                    count++;
            }
            if(count==0)
                System.out.println(1);
            else if(count%2==1)
                System.out.println(-1);
            else {
                int req=count/2, curr=0;
                while(curr!=req && left<n) {
                    if(arr[left]==2)
                        curr++;
                    left++;
                }
                System.out.println(left);
            }
        }
    }
}
