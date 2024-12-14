package boj.DP;

import java.util.*;
public class BOJ1463 {
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] dp = new int [(n * 3) + 1];
        Arrays.fill(dp, n);
        dp[n] = 0;
        for(int i = n - 1; i >= 1; i--) {
            dp[i] = Math.min(dp[i * 3] + 1, dp[i]);
            dp[i] = Math.min(dp[i * 2] + 1, dp[i]);
            dp[i] = Math.min(dp[i + 1] + 1, dp[i]);
        }
        System.out.println(dp[1]);
    }
}
/**
 가능한 연산 3가지
 X가 3으로 나누어 떨어지면, 3으로 나눈다
 X가 2로 나누어 떨어지면, 2로 나눈다.
 1을 뺀다

 정수 N이 주어졌을 때, 위와 같은 연산 세 개를 적절히 사용해서 1을 만들려고 한다.
 연산을 사용하는 횟수의 최솟값을 출력
 1 <= n <= 10^6
*/

/* 풀이1
public class BOJ1463 {
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        check(sc.nextInt(), 0);
        System.out.println(min);
    }
    public static void check(int cur, int count){
        if(count >= min) return;
        if(cur == 1){
            min = count;
            return;
        }
        if(cur % 3 == 0) check(cur / 3, count + 1);
        if(cur % 2 == 0) check(cur / 2, count + 1);
        check(cur - 1, count + 1);
    }
}
 */