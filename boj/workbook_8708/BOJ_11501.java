package boj.workbook_8708;

/**
 *  주식 - 실버2
 */
import java.io.*;
import java.util.*;
public class BOJ_11501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine()); // 테스트 케이스 개수
        StringBuilder sb = new StringBuilder();
        while (t --> 0){
            int day = Integer.parseInt(br.readLine());
            int [] memo = new int[day];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < day; i++) {
                memo[i] = Integer.parseInt(st.nextToken());
            }
            int max = 0;    // 1 <= 10000
            long profit = 0;
            for (int i = day - 1; i >= 0; i--) {
                max = Math.max(max, memo[i]);
                if(max > memo[i]){
                    profit += max - memo[i];
                }
            }
            sb.append(profit).append("\n");
        }
        System.out.println(sb);
    }
}
