// https://codeforces.com/problemset/problem/1666/D
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        l: while(t-->0) {
            char[] str = sc.next().toCharArray(), target = sc.next().toCharArray();
            List<Character> deletedChars = new ArrayList<>();
            int targetIdx=target.length - 1;
            for(int strIdx=str.length-1;strIdx>=0 && targetIdx>=0;strIdx--) {
                if(str[strIdx]==target[targetIdx]) {
                    if(deletedChars.contains(str[strIdx])) {
                        System.out.println("NO");
                        continue l;
                    }
                    targetIdx--;
                } else 
                    deletedChars.add(str[strIdx]);
            }
            System.out.println(targetIdx>-1?"NO":"YES");
        }
    }
}
