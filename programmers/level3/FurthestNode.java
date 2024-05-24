package programmers.level3;

/**
 * 가장 먼 노드
 * dijkstra
 * level3
 */
import java.util.*;
public class FurthestNode {
    static int INF = Integer.MAX_VALUE / 100;
    public int solution(int n, int[][] edge) {
        int answer = 0;

        // 그래프 초기화
        ArrayList<Integer>[] graph = new ArrayList[n+1];
        for(int i = 0; i <= n; i++){
            graph[i] = new ArrayList<>();
        }

        // 양방향 간선 연결
        for(int [] ints : edge){
            int v1 = ints[0];
            int v2 = ints[1];
            graph[v1].add(v2);
            graph[v2].add(v1);
        }

        // 다익스트라 시작
        int[] visited = new int[n+1];
        Arrays.fill(visited, INF);
        visited[1] = 0;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int []{1, 0});
        while(!q.isEmpty()){
            int [] cur = q.poll();
            if(cur[1] != visited[cur[0]]) continue;
            for(int i = 0; i < graph[cur[0]].size(); i++){
                int next = graph[cur[0]].get(i);
                if(visited[next] <= cur[1] + 1) continue;
                visited[next] = cur[1] + 1;
                q.add(new int []{next, visited[next]});
            }
        }
        // System.out.println(Arrays.toString(visited));
        int max = 0;
        int cnt = 0;
        for(int i = 2; i <= n; i++){
            if(visited[i] == INF) continue; // 접근 불가능한 노드
            if(visited[i] > max){
                max = visited[i];
                cnt = 1;
            }
            else if(visited[i] == max) cnt++;
        }

        return cnt;
    }
}
