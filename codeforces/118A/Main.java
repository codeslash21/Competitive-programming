// https://codeforces.com/problemset/problem/118/A
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        StringBuilder sb = new StringBuilder();
        Set<Character> vowels = new HashSet<>(Set.of(
          'A', 'E', 'I', 'O', 'U', 'Y',
          'a', 'e', 'i', 'o', 'u', 'y'
        ));
        for(char ch:s.toCharArray()) {
          if(vowels.contains(ch))
            continue;
          sb.append('.');
          sb.append(Character.toLowerCase(ch));
        }
        System.out.println(sb.toString());
    }
}
