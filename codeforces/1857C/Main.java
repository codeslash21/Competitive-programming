// https://codeforces.com/problemset/problem/1857/C
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0) {
            int n=sc.nextInt(), totalElement=n*(n-1)/2;
            int[] arr = new int[totalElement];
            for(int i=0;i<totalElement;i++) 
                arr[i] = sc.nextInt();
            Arrays.sort(arr);
            for(int i=0;i<totalElement;i+=--n)
                System.out.print(arr[i]+" ");
            System.out.println(1000000000);
        }
    }
}
