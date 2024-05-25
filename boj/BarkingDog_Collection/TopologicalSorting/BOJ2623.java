package boj.BarkingDog_Collection.TopologicalSorting;

/**
 * 음악 프로그램 골드3
 * Topological Sorting
 */
import java.io.*;
import java.util.*;
public class BOJ2623 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 가수의 수 N
        int m = Integer.parseInt(st.nextToken()); // 보조 PD의 수

        // 그래프 초기화
        ArrayList<Integer> [] graph = new ArrayList[n+1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        // indegree
        int [] indegree = new int[n+1];

        // 그래프 연결 & indegree 작업
        while (m-->0){
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int before = Integer.parseInt(st.nextToken());
            for (int i = 0; i < k - 1; i++) {
                int cur = Integer.parseInt(st.nextToken());
                graph[before].add(cur);
                indegree[cur]++;
                before = cur;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if(indegree[i] == 0) q.add(i);
        }

        StringBuilder sb = new StringBuilder(); // 위상 정렬 기록용

        // 위상 정렬 알고리즘
        while (!q.isEmpty()){
            int cur = q.poll();
            sb.append(cur).append("\n");
            for (int i = 0; i < graph[cur].size(); i++) {
                int next = graph[cur].get(i);
                indegree[next]--;
                if(indegree[next] == 0) q.add(next);
            }
        }

        // 순서 정하기가 불가능한 경우
        for (int i = 1; i <= n; i++) {
            if(indegree[i] != 0){
                System.out.println(0);
                return;
            }
        }

        System.out.println(sb);

    }
}
