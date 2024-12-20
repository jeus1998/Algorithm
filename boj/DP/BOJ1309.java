package boj.DP;
import java.util.*;
public class BOJ1309 {
    static final int INF = 9901;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int [] dp = new int [Math.max(n, 2) + 1];
        dp[1] = 3;
        dp[2] = 7;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i-1] * 2 + dp[i-2];
            dp[i] %= INF;
        }
        System.out.println(dp[n]);
    }
}
/** 동물원

 N * 2 배열
 이 동물원에는 사자들이 살고 있는데 사자들을 우리에 가둘 때, 가로로도 세로로도 붙어 있게 배치할 수는 없다
 동물원 조련사의 머리가 아프지 않도록 우리가 2*N 배열에 사자를 배치하는 경우의 수가 몇 가지인지를 알아내는 프로그램을 작성해 주도록 하자
 사자를 한 마리도 배치하지 않는 경우도 하나의 경우의 수로 친다고 가정

 N(1≤N≤100,000)

 첫째 줄에 사자를 배치하는 경우의 수를 9901로 나눈 나머지를 출력

 1 * 2 = 1 + 2 = 3
 2 * 2 = 1 + 4 + 2 = 7
 3 * 2 = 1 + 6 + 8 + 2 = 17

 dp[n] = dp[n-2] + dp[n-1] * 2?

 */