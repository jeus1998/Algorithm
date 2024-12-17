package boj.DP;

import java.util.*;
import java.io.*;
public class BOJ2294 {
    static final int MAX = 10001;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        // 같은 가치의 동전이 여러 번 주어질 수도 있다.
        Set<Integer> coin = new HashSet<>();
        for (int i = 0; i < n; i++) {
            coin.add(Integer.parseInt(br.readLine()));
        }
        int [] coins = new int [coin.size()];
        int cnt = 0;
        for(int next : coin){
            coins[cnt++] = next;
        }
        Arrays.sort(coins);
        int [] dp = new int [Math.max(k, coins[coins.length - 1]) + 1];
        Arrays.fill(dp, MAX);

        for(int i = 0; i < coins.length; i++){
            dp[coins[i]] = 1;
        }

        for(int i = 1; i <= k; i++) {
            if (dp[i] == 1) continue;
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] >= i) break;
                if (dp[i - coins[j]] != MAX) dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
            }
        }
        if(dp[k] == MAX) System.out.println(-1);
        else System.out.println(dp[k]);
    }
}
/**
 n가지 종류의 동전이 있다.
 이 동전들을 적당히 사용해서, 그 가치의 합이 k원이 되도록 하고 싶다.
 그러면서 동전의 개수가 최소가 되도록 하려고 한다.

 dp[k] = 가치
 dp[1] = 1원을 만드는데 필요한 최소한의 동전 수
 */