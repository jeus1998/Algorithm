package boj.workbook_8708;

/**
 * 햄버거 분배 - 실버3
 */
import java.io.*;
import java.util.*;
public class BOJ_19941 {
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        String input = in.readLine();

        int [] memo = new int [n];
        for (int i = 0; i < n; i++) {
            if(input.charAt(i)=='P') {
                memo[i] = 2;
            }
            else memo[i] = 1;
        }
        int answer = 0;
        for (int i = 0; i < n; i++) {
            if(memo[i] != 2) continue;
            boolean flag = false;
            for (int j = k; j >= 1; j--) {
                if(i - j >= 0 && memo[i - j] == 1){
                    memo[i - j] = 0;
                    flag = true;
                    break;
                }
            }
            if(flag){
                answer++;
                continue;
            }
            for (int j = 1; j <= k; j++) {
                if(i + j < n && memo[i + j] == 1){
                    memo[i + j] = 0;
                    flag = true;
                    break;
                }
            }
            if(flag) answer++;
        }
        System.out.println(answer);
    }
}
