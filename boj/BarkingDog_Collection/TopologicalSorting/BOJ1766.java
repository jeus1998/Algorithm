package boj.BarkingDog_Collection.TopologicalSorting;

/**
 * 문제집 골드2
 * Topological Sorting
 * Time: 10:53AM ~ 10:59AM
 */
import java.util.*;
import java.io.*;
public class BOJ1766 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 문제의 수
        int m = Integer.parseInt(st.nextToken()); // 문제 조건

        int [] indegree = new int[n+1];

        // 그래프 초기화
        ArrayList<Integer>[] graph = new ArrayList[n+1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        // 문제 조건 삽입
        while (m-->0){
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            indegree[v2]++;
            graph[v1].add(v2);
        }

        // 문제의 번호가 낮은 문제가 쉬운 문제이다.
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 1; i <= n; i++) {
            if(indegree[i] == 0) pq.add(i);
        }

        // 문제 푸는 순서 기록용
        StringBuilder sb = new StringBuilder();

        while (!pq.isEmpty()){
            int cur = pq.poll();
            sb.append(cur).append(" ");
            for (int i = 0; i < graph[cur].size(); i++) {
                int next = graph[cur].get(i);
                if(--indegree[next] == 0){
                    pq.add(next);
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            if(indegree[i] != 0) sb.append(i).append(" ");
        }

        System.out.println(sb);

    }
}
