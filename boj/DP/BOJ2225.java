package boj.DP;

import java.util.*;
import java.io.*;
public class BOJ2225 {
    static final int INF = 1000000000;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        int [][] dp = new int [k][n+1];
        Arrays.fill(dp[0], 1);
        for (int i = 1; i < k; i++) {
            for (int j = 0; j <= n; j++) {
                for (int l = 0; l <= j; l++) {
                    dp[i][j] += dp[i-1][l];
                    dp[i][j] %= INF;
                }
            }
        }
        System.out.println(dp[k-1][n]);
    }
}

/** 합분해

 0부터 N까지의 정수 K개를 더해서 그 합이 N이 되는 경우의 수를 구하는 프로그램을 작성
 덧셈의 순서가 바뀐 경우는 다른 경우로 센다
 또한 한 개의 수를 여러 번 쓸 수도 있다.

 첫째 줄에 두 정수 N(1 ≤ N ≤ 200), K(1 ≤ K ≤ 200)가 주어진다.

 점화식?
 
 
 
 */
