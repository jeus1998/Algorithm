package boj.DP;

import java.util.*;
public class BOJ10844 {
    static final int INF = 1000000000;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [][] dp = new int [n][10];
        Arrays.fill(dp[0], 1);
        dp[0][0] = 0; // 0으로는 시작 불가능
        for(int i = 1; i < n; i++){
            for(int j = 0; j < 10; j++){
                if(j == 0){
                    dp[i][j] = dp[i-1][j+1];
                }
                else if(j == 9){
                    dp[i][j] += dp[i-1][j-1];
                }
                else{
                    dp[i][j] = dp[i-1][j-1];
                    dp[i][j] += dp[i-1][j+1];
                }
                dp[i][j] %= INF;
            }
        }
        int answer = 0;
        for(int next : dp[n - 1]){
            answer += next;
            answer %= INF;
        }
        System.out.println(answer);
    }
}

/**

 45656
 이 수는 인접한 모든 자리의 차이가 1이다. 이런 수를 계단 수라고 한다
 N이 주어질 때, 길이가 N인 계단 수가 총 몇 개 있는지 구해보자. 0으로 시작하는 수는 계단수가 아니다

 N = 1
 1, 2, 3, 4, 5, 6, 7, 8, 9


 */