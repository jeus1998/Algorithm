package boj.workbook_8708;

/**
 * 택배 배송 - 골드5
 */
import java.io.*;
import java.util.*;
public class BOJ_5972 {
    static final int INF = 50000 * 1000 + 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 헛간의 개수
        int m = Integer.parseInt(st.nextToken()); // 소들의 길 개수

        ArrayList<int[]>[] graph = new ArrayList[n+1];
        for (int i = 0; i <= n; i++) {  // 그래프 초기화
            graph[i] = new ArrayList<>();
        }
        while (m --> 0){
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[v1].add(new int[] {v2,cost});
            graph[v2].add(new int[] {v1,cost}); // 양방향
        }

        int [] min = new int[n+1]; // 최단거리 기록
        Arrays.fill(min, INF);
        min[1] = 0;
        PriorityQueue<int []> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
        pq.add(new int[] {1,0});
        while (!pq.isEmpty()) {    // 다익스트라 알고리즘
            int [] now = pq.poll();
            if(min[now[0]] != now[1]) continue;
            for (int i = 0; i < graph[now[0]].size(); i++) {
                int [] next = graph[now[0]].get(i);
                if(min[next[0]] > next[1] + now[1]) {
                    min[next[0]] = next[1] + now[1];
                    pq.add(new int[] {next[0], min[next[0]]});
                }
            }
        }
        System.out.println(min[n]);
    }
}
