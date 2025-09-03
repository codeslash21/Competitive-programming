// https://codeforces.com/problemset/problem/831/A
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(), left = 0, right = t-1, prev=0;
        boolean res = true;
        int[] arr = new int[t];
        for(int i=0;i<t;i++)
            arr[i] = sc.nextInt();
        while(left+1<t && arr[left]<arr[left+1])
            left++;
        while(right-1>=0 && arr[right]<arr[right-1])
            right--;
        prev=arr[left];
        for(int i=left;i<=right;i++) {
            if(arr[i]!=prev) {
                res = false;
                break;
            }
        }
        System.out.println(res?"YES":"NO");
    }
}
