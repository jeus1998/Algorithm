package boj.workbook_8708;

/**
 * 덩치 - 실버5
 */
import java.io.*;
import java.util.*;
public class BOJ_7568 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [][] memo = new int[n][2];
        int [] answer = new int[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            memo[i][0] = Integer.parseInt(st.nextToken());
            memo[i][1] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if(i == j) continue;
                if(memo[i][0] < memo[j][0] && memo[i][1] < memo[j][1]){
                    count++;
                }
            }
            answer[i] = count + 1;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(answer[i]).append(" ");
        }
        System.out.println(sb);
    }
}
