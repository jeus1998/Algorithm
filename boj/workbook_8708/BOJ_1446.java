package boj.workbook_8708;

/**
 * 지름길 - 실버1
 */
import java.io.*;
import java.util.*;
public class BOJ_1446 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 지름길의 개수    1 <= n <= 12
        int d = Integer.parseInt(st.nextToken()); // 고속도로의 길이   1 <= d <= 10000

        ArrayList<int []> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end   = Integer.parseInt(st.nextToken());
            int length  = Integer.parseInt(st.nextToken());
            if(end > d || end - start <= length) continue;
            list.add(new int[]{start, end, length});
        }

        int [] memo = new int[d + 1];
        for (int i = 1; i <= d; i++) {
            memo[i] = i;
        }
        Collections.sort(list, (o1, o2) -> o1[1] - o2[1]);
        for (int i = 0; i < list.size(); i++) {
            int [] cur = list.get(i);
            memo[cur[1]] = Math.min(memo[cur[1]], cur[2] + memo[cur[0]]);
            for (int j = i + 1; j < list.size(); j++) {
                int [] after = list.get(j);
                if(after[1] > cur[1])
                    memo[after[1]] = Math.min(memo[after[1]], memo[cur[1]] + (after[1] - cur[1]));
                if(after[0] > cur[1])
                    memo[after[0]] = Math.min(memo[after[0]], memo[cur[1]] + (after[0] - cur[1]));
            }
        }
        for (int i = 0; i <= d; i++) {
            memo[d] = Math.min(memo[d], memo[i] + (d - i));
        }
        System.out.println(memo[d]);

    }
}
/**


 */