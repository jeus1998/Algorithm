package boj.workbook_8708;

/**
 * 지름길 - 실버1
 */
import java.io.*;
import java.util.*;
public class BOJ_1446_2 {
    static int n, d;
    static ArrayList<int []> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 지름길의 개수
        d = Integer.parseInt(st.nextToken()); // 고속도로의 길이

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int length = Integer.parseInt(st.nextToken());
            if(v2 > d || v2 - v1 <= length) continue;
            list.add(new int[]{v1, v2, length});
        }
        solveDP();
        solveDFS();
        solveDijkstra();
    }
    public static void solveDP(){
        int [] dp = new int[d + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        int size = list.size();
        for (int i = 1; i <= d; i++) {
            dp[i] = dp[i - 1] + 1;
            for (int j = 0; j < size; j++) {
                int [] arr = list.get(j);
                if(arr[1] == i){
                    dp[i] = Math.min(dp[i], dp[arr[0]] + arr[2]);
                }
            }
        }
        System.out.println(dp[d]);
    }
    public static void solveDFS() {
        int [] dp = new int[d + 1];
        for (int i = 1; i <= d; i++) {
            dp[i] = i;
        }
        int size = list.size();
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        while (!stack.isEmpty()) {
            int v = stack.pop();
            dp[d] = Math.min(dp[d], dp[v] + d - v);
            for (int i = 0; i < size; i++) {
                int [] arr = list.get(i);
                if(arr[0] >= v && dp[arr[1]] > arr[2] + arr[0] - v + dp[v]){
                    dp[arr[1]] = arr[2] + arr[0] - v + dp[v];
                    stack.push(arr[1]);
                }
            }
        }
        System.out.println(dp[d]);
    }
    public static void solveDijkstra(){
        int [] dp = new int[d + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        PriorityQueue<int []> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
        pq.add(new int[]{0,0});
        dp[0] = 0;
        int size = list.size();
        while (!pq.isEmpty()) {
            int [] cur = pq.poll();
            if(dp[cur[0]] != cur[1]) continue;
            dp[d] = Math.min(dp[d], cur[1] + d - cur[0]);
            for (int i = 0; i < size; i++) {
                int [] arr = list.get(i);
                if(arr[0] >= cur[0] && dp[arr[1]] > arr[2] + arr[0] - cur[0] + cur[1]){
                    dp[arr[1]] = arr[2] + arr[0] - cur[0] + cur[1];
                    pq.add(new int[]{arr[1], dp[arr[1]]});
                }
            }
        }
        System.out.println(dp[d]);
    }
}
