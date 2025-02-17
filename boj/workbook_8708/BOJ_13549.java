package boj.workbook_8708;

/**
 * 숨바꼭질 3 - 골드5
 */
import java.io.*;
import java.util.*;
public class BOJ_13549 {
    static final int INF = 100001;
    static int n, k;
    static int [] memo;
    static Queue<Integer> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 수빈이 위치
        k = Integer.parseInt(st.nextToken()); // 동생 위치
        memo = new int[INF * 2];
        Arrays.fill(memo, INF);
        memo[n] = 0;
        q.add(n);
        while (!q.isEmpty()) {
            int now = q.poll();
            move(now - 1, now);
            move(now + 1, now);
            move(now * 2, now);
        }
        System.out.println(memo[k]);
    }
    public static void move(int nx, int now){
        if(validation(nx) && memo[nx] > memo[now] + (nx == now * 2 ? 0 : 1)){
            memo[nx] = memo[now] + (nx == now * 2 ? 0 : 1);
            q.add(nx);
        }
    }
    public static boolean validation(int nx){
        if(0 <= nx && nx < memo.length) return true;
        return false;
    }
}
