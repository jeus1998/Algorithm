package programmers2.level2;

/**
 * 프로그래머스
 * 도넛과 막대 그래프
 */
import java.util.*;
public class PR_258711 {
    class Solution {
        public int[] solution(int[][] edges) {
            int [] answer = new int [4];
            int max_v = 0;
            for(int i = 0; i < edges.length; i++){
                max_v = Math.max(max_v, Math.max(edges[i][0],  edges[i][1]));
            }
            ArrayList<Integer>[] graph = new ArrayList[max_v+1];

            for(int i = 0; i <= max_v; i++){
                graph[i] = new ArrayList<>();
            }
            int [] indegree = new int [max_v+1];
            for(int i = 0; i < edges.length; i++){
                graph[edges[i][0]].add(edges[i][1]);
                indegree[edges[i][1]]++;
            }

            int v = 0;
            int max = 0;
            for(int i = 1; i<= max_v; i++){
                if(indegree[i] != 0) continue;
                // 간선이 가장 많으면서 들어오는 간선이 없는 정점 찾기
                // 해당 정점이 추가된 정점
                if(graph[i].size() > max){
                    v = i;
                    max = graph[i].size();
                }
            }
            answer[0] = v; // 추가된 정점 answer 기록

            // ArrayDeque는 시작과 끝의 삽입 삭제가 많은 경우
            // 시간복잡도 상에서 링크드 리스트 보다 유리하다.
            ArrayDeque<Integer> ad = new ArrayDeque<>();

            // 그래프의 개수는 추가된 정점의 간선의 개수와 동일하다.
            boolean [] visited = new boolean[max_v+1];
            for(int i = 0; i < graph[v].size(); i++){
                // start는 각 그래프의 리프 노드
                // 모든 간선을 돌면서 정점의 개수와 간선의 개수를 기록하자
                int start = graph[v].get(i);
                int n = 1; // 정점의 개수
                int c = 0; // 간선의 개수
                visited[start] = true;
                ad.addLast(start);
                while(!ad.isEmpty()){
                    int cur = ad.pollFirst();
                    int size = graph[cur].size();
                    c += size; // 간선의 개수 추가
                    for(int j = 0; j < size; j++){
                        int next = graph[cur].get(j);
                        if(visited[next]) continue;
                        visited[next] = true;
                        n++; // 정점의 개수 추가
                        ad.addLast(next);
                    }
                }
                if(n == c) answer[1]++; // 도넛 모양
                else if(n - 1 == c) answer[2]++; // 막대 모양
                else answer[3]++; // 8자 모양
            }
            return answer;
        }
    }
}
/*
문제 풀이 방법
1. indegree가 0이고 간선의 개수가 가장 많은 정점이
   추가된 정점이다.
2. 그래프를 찾는다.
   각 그래프는 추가된 정점에서 다음 간선에 있는 노드가 리프노드이다.
   밑에 조건을 통해서 그래프의 모양을 찾는다.

생성한 정점의 번호 index = 0
방문한 정점의 개수가 n 간선이 n 이면 도넛 모양 index = 1
방문한 점정의 개수가 n 간선이 n-1 이면 막대 모양 index = 2
방문한 정점의 개수가 n 간선이 n+1 이면 8자 모양 index = 3
*/