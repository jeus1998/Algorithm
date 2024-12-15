package boj.DP;

import java.util.*;
public class BOJ11057 {
    static final int INF = 10007;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [][] dp = new int [n][10];
        Arrays.fill(dp[0], 1);
        for(int i = 1; i < n; i++){
            int temp = 0;
            for(int j = 0; j <= 9; j++){
                temp += dp[i-1][j];
                temp %= INF;
                dp[i][j] = temp;
                dp[i][j] %= INF;
            }
        }
        int answer = 0;
        for(int i = 0; i <= 9; i++){
            answer += dp[n-1][i];
            answer %= INF;
        }
        System.out.println(Arrays.deepToString(dp));
        System.out.println(answer);
    }
}
/**
 오르막 수
 오르막 수는 수의 자리가 오름차순을 이루는 수를 말한다

 2234와 3678, 11119는 오르막 수
 2232, 3676, 91111은 오르막 수

 수의 길이 N이 주어졌을 때, 오르막 수의 개수를 구하는 프로그램을 작성하시오. 수는 0으로 시작할 수 있다
 1 <= N <= 1000

 N = 1
 0, 1, 2, ... 9, 10 -> 10개

 점화식 정의
 dp[x][y] = x: N y: 0 ~ 9

 dp[x][y] += for(int i = 0; i <= y; i++) dp[x-1][i]
 dp[x][y] %= 10007

 answer = (dp[N][0] ~ dp[N][9]) sum
 */