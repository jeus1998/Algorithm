package boj.DP;

import java.util.*;
import java.io.*;
public class BOJ2293 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int [] coins = new int [n];
        int [] dp = new int [k+1];
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(coins);
        for (int i = 0; i < n; i++) {
            if(coins[i] > k) break; // 동전의 가치가 주어진 target 보다 크거나 같은 경우
            dp[coins[i]]++;
            for (int j = 1; j <= k; j++) {
                if(j - coins[i] >= 0){
                    dp[j] += dp[j - coins[i]];
                }
            }
        }
        System.out.println(dp[k]);
    }
}
/** 동전1
 n가지 종류의 동전이 있다. 각각의 동전이 나타내는 가치는 다르다.
 이 동전을 적당히 사용해서, 그 가치의 합이 k원이 되도록 하고 싶다.
 그 경우의 수를 구하시오. 각각의 동전은 몇 개라도 사용할 수 있다.
 사용한 동전의 구성이 같은데, 순서만 다른 것은 같은 경우이다.

 첫째 줄에 n, k가 주어진다. n = 동전의 수 k = target

 coins = 1,2,5

 (1 ≤ n ≤ 100, 1 ≤ k ≤ 10,000)

 동전 순서대로 dp[k]에 대한 값을 누적시킨다.

 coin = 1

 1: 1
 2: 1 + 1
 3: 1 + 1 + 1
 4: 1 + 1 + 1 + 1
 5: 1 + 1 + 1 + 1 + 1

 coin = 2

 1: 1
 2: 1 + 1, 2
 3: 1 + 1 + 1, 1 + 2
 4: 1 + 1 + 1 + 1, 1 + 1 + 2, 2 + 2
 5: 1 + 1 + 1 + 1 + 1, 1 + 1 + 1 + 2, 1 + 2 + 2, 5

 */