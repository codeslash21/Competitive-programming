// https://codeforces.com/problemset/problem/1472/D
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            boolean alice = true;
            long sum = 0;
            for(int i=0;i<n;i++)
                arr[i] = sc.nextInt();
            Arrays.sort(arr);
            for(int i=n-1;i>=0;i--) 
                if(alice) {
                    sum+=arr[i]%2==0?arr[i]:0;
                    alice = false;
                } else {
                    sum-=arr[i]%2==1?arr[i]:0;
                    alice = true;
                }
            System.out.println(sum<0?"Bob":sum>0?"Alice":"Tie");
        }
    }
}
