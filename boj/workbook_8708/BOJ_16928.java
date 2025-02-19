package boj.workbook_8708;

/**
 * 뱀과 사다리 게임 - 골드5
 * 사다리, 뱀은 무조건 타야한다!
 */
import java.io.*;
import java.util.*;
public class BOJ_16928 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 사다리의 수
        int m = Integer.parseInt(st.nextToken()); // 뱀의 수

        int [] graph = new int[101];
        for (int i = 0; i < n + m; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            graph[v1] = v2;
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        int [] memo = new int[101];
        Arrays.fill(memo, Integer.MAX_VALUE);
        memo[1] = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();
            // 사다리 or 뱀
            if(graph[cur] != 0) {
                if(memo[graph[cur]] > memo[cur]){
                    memo[graph[cur]] = memo[cur];
                    q.add(graph[cur]);
                }
                continue;
            }

            for (int i = 1; i <= 6; i++) {
                int nx = cur + i;
                if(validation(nx) && memo[cur] + 1 < memo[nx]){
                    memo[nx] = memo[cur] + 1;
                    q.add(nx);
                }
            }
        }
        System.out.println(memo[100]);
    }
    public static boolean validation(int nx){
        if(nx < 101) return true;
        return false;
    }
}
