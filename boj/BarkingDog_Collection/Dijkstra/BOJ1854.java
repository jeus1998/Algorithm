package boj.BarkingDog_Collection.Dijkstra;

/**
 * k번째 최단경로 찾기 플레티넘4
 */
import java.io.*;
import java.util.*;
public class BOJ1854 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 도시 개수
        int m = Integer.parseInt(st.nextToken()); // 도로의 수
        int k = Integer.parseInt(st.nextToken()); // k번째 최단 경로

        ArrayList<int[]>[] graph = new ArrayList[n+1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        int sum = 0;
        while (m-->0){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            sum += c;
            graph[a].add(new int[]{b, c});
        }

        sum = 1000 * k;
        StringBuilder sb = new StringBuilder(); // 출력 기록용
        for (int i = 1; i <= n; i++) {

            int cnt = 0;
            PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
            pq.add(new int[]{1,0});
            while (!pq.isEmpty()){
                int [] cur = pq.poll();
                if(cur[0] == i){
                    cnt++;
                    if(cnt == k){
                        sb.append(cur[1]).append("\n");
                        break;
                    }
                }
                if(cur[1] >= sum){
                    sb.append(-1).append("\n");
                    break;
                }
                for (int j = 0; j < graph[cur[0]].size(); j++) {
                    int [] next = graph[cur[0]].get(j);
                    pq.add(new int[]{next[0], next[1] + cur[1]});
                }
            }
        }
        System.out.println(sb);
    }
}
