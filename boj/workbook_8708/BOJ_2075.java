package boj.workbook_8708;

/**
 * N번째 큰 수 - 실버3
 */
import java.io.*;
import java.util.*;
public class BOJ_2075 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [][] memo = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                memo[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            pq.add(memo[n-1][i]);
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                if(memo[i][j] < pq.peek()) {
                    continue;
                }
                pq.poll();
                pq.add(memo[i][j]);
            }
        }
        System.out.println(pq.peek());
    }
}
