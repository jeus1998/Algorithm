package boj.workbook_8708;

/**
 * 진우의 달 여행 (Small) -
 */
import java.io.*;
import java.util.*;
public class BOJ_17484 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int [][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int [][][] dp = new int[n+1][m][3];
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < 3; k++) {
                    dp[i][j][k] = 1000;
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < m; j++) {
                // 왼쪽
                if(j + 1 < m){
                    dp[i][j][0] = Math.min(dp[i][j][0], dp[i-1][j + 1][1] + map[i-1][j]);
                    dp[i][j][0] = Math.min(dp[i][j][0], dp[i-1][j + 1][2] + map[i-1][j]);
                }
                // 가운데
                dp[i][j][1] = Math.min(dp[i][j][1], dp[i-1][j][0] + map[i-1][j]);
                dp[i][j][1] = Math.min(dp[i][j][1], dp[i-1][j][2] + map[i-1][j]);

                // 오른쪽
                if(j - 1 >= 0){
                    dp[i][j][2] = Math.min(dp[i][j][2], dp[i-1][j - 1][0] + map[i-1][j]);
                    dp[i][j][2] = Math.min(dp[i][j][2], dp[i-1][j - 1][1] + map[i-1][j]);
                }
            }
        }
        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < 3; j++) {
                answer = Math.min(answer, dp[n][i][j]);
            }
        }
        System.out.println(answer);
    }
}
