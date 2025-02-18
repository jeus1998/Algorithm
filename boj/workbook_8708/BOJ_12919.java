package boj.workbook_8708;

/**
 * A와 B 2 - 골드5
 */
import java.io.*;
public class BOJ_12919 {
    static String s;
    static int size;
    static int answer  = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();
        size = s.length();
        String t = br.readLine();

        func(t);
        System.out.println(answer);
    }
    public static void func(String t){
        if(t.length() == size){
            if(t.equals(s)) answer = 1;
            return;
        }

        if(t.endsWith("A")){
            func(t.substring(0, t.length() - 1));
        }

        if(t.startsWith("B")){
            StringBuilder sb = new StringBuilder(t.substring(1));
            func(sb.reverse().toString());

        }
    }
}
/*

 */