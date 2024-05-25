package boj.BarkingDog_Collection.TopologicalSorting;

/**
 * 줄 세우기 골드 3
 * Topological Sorting
 */
import java.util.*;
import java.io.*;
public class BOJ2252 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 학생의 수 1 ~ n
        int m = Integer.parseInt(st.nextToken()); // 간선

        // 그래프 초기화
        ArrayList<Integer> [] graph = new ArrayList[n+1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        // indegree
        int [] indegree = new int[n+1];

        // 그래프 입력
        while (m-->0){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            graph[start].add(end);

            // indegree up
            indegree[end]++;
        }

        // StringBuilder 결과 출력용
        StringBuilder sb = new StringBuilder();

        // indegree 0인 정점 추가
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if(indegree[i] == 0) q.add(i);
        }

        // 위상 정렬 알고리즘
        while (!q.isEmpty()){
            int cur = q.poll();
            sb.append(cur).append(" ");
            for (int i = 0; i < graph[cur].size(); i++) {
                int next = graph[cur].get(i);
                indegree[next]--;
                if(indegree[next] == 0) q.add(next);
            }
        }

        System.out.println(sb);

    }
}
