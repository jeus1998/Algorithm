package boj.BarkingDog_Collection.String;

/**
 * 문서 검색
 * 실버5
 */
import java.util.*;
import java.io.*;
public class BOJ1543 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String check = br.readLine();
        int cnt = 0;
        int size = check.length();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append("*");
        }
        String replace = sb.toString();

        sb = new StringBuilder(input);

        while (sb.indexOf(check) >= 0){
            cnt++;
            int idx = sb.indexOf(check);
            sb.replace(idx, idx + size, replace);
        }
        System.out.println(cnt);
    }
}
// cba
// csssccbaba