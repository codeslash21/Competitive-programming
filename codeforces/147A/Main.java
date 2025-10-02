// https://codeforces.com/problemset/problem/147/A
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine().trim();
        int strLen = str.length(), i=0;
        char[] chars = new char[strLen*2];
        for(char c:str.toCharArray()) {
            if(c>='a' && c<='z') 
                chars[i++]=c;
            else if(c==' ')
                if(chars[i-1]!=' ')
                    chars[i++]=' ';
                else
                    continue;
            else {
                if(i>0 && chars[i-1]==' ')
                    chars[i-1]=c;
                else
                    chars[i++]=c;
                chars[i++]=' ';
            }
        }
        System.out.println(new String(chars, 0, i).trim());
    }
}
