// https://codeforces.com/problemset/problem/1440/B
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0) {
            int n=sc.nextInt(), k=sc.nextInt(), diff=n/2+1, totalElement=n*k, endIdx=totalElement+1-diff;
            int[] arr = new int[totalElement+1];
            long sum=0;
            for(int i=1;i<=totalElement;i++)
                arr[i] = sc.nextInt();
            Arrays.sort(arr);
            while(k-->0) {
                sum+=arr[endIdx];
                endIdx-=diff;
            }
            System.out.println(sum);
        }
    }
}
