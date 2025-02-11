package boj.workbook_8708;

/**
 * 겹치는 건 싫어 - 실버1
 */
import java.io.*;
import java.util.*;
public class BOJ_20922 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 수열의 길이
        int k = Integer.parseInt(st.nextToken()); // 같은 정수 최대 개수

        int over = 0;
        int max = 0;  // 최대 수열의 길이
        int start = 0;
        int [] arr = new int[100001];
        int [] memo = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int cur = Integer.parseInt(st.nextToken());
            memo[i] = cur;
            arr[cur]++;
            if(arr[cur] <= k && over == 0){
                max = Math.max(max, (i - start) + 1);
                continue;
            }
            over++;

            while (over != 0){
                int target = memo[start++];
                arr[target]--;
                if(arr[target] == k) over--;
            }
        }
        System.out.println(max);
    }
}
