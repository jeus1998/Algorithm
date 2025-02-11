package boj.workbook_8708;

/**
 * 한 줄로 서기 - 실버2
 */
import java.io.*;
import java.util.*;
public class BOJ_1138 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [] memo = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            memo[i] = Integer.parseInt(st.nextToken());
        }
        int [] answer = new int[n+1];
        for (int i = 1; i <= n; i++) {
            int count = 0;
            int index = 0;
            for (int j = 1; j <= n; j++) {
                if(answer[j] == 0 || answer[j] > i) {
                    count++;
                }
                if(count == memo[i]){
                    index = j;
                    break;
                }
            }
            for (int j = index + 1; j <= n; j++) {
                if (answer[j] == 0) {
                    answer[j] = i;
                    break;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(answer[i]).append(" ");
        }
        System.out.println(sb);
    }
}