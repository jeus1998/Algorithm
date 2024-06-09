package boj.BarkingDog_Collection.String;

/**
 * 비밀 이메일
 * 브론즈1
 */
import java.util.*;
import java.io.*;
public class BOJ2999 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int end = input.length();
        int max = 1;
        int start = 1;
        while (start <= end / start){
            if(end % start == 0){
                max = start;
            }
            start++;
        }
        char [][] memo = new char[max][end / max];
        int cnt = 0;
        for (int i = 0; i < end/max; i++) {
            for (int j = 0; j < max; j++) {
                memo[j][i] = input.charAt(cnt++);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < max; i++) {
            for (int j = 0; j < end/max; j++) {
                sb.append(memo[i][j]);
            }
        }
        System.out.println(sb);
    }
}
