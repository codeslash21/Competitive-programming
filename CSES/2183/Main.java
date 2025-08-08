// https://cses.fi/problemset/task/2183/
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long req=1;
        int[] arr = new int[n];
        for(int i=0;i<n;i++)
            arr[i] = sc.nextInt();
        Arrays.sort(arr);
        for(int i=0;i<n && req>=arr[i];i++)
            req+=arr[i];
        System.out.println(req);
    }
}
