package programmers2.level2;

/**
 * 2024 KAKAO WINTER INTERNSHIP
 * 도넛과 막대 그래프
 */
import java.util.*;
public class PR_258711_2 {
    public static void main(String[] args) {
        int[][] test1 = {
                {2, 3},
                {4, 3},
                {1, 1},
                {2, 1}};
        System.out.println(Arrays.toString(solution(test1)));
        int [] answer1 = {2, 1, 1, 0};

        int[][] test2 = {
                {4, 11}, {1, 12}, {8, 3}, {12, 7}, {4, 2},
                {7, 11}, {4, 8}, {9, 6}, {10, 11}, {6, 10},
                {3, 5}, {11, 1}, {5, 3}, {11, 9}, {3, 8}};

        System.out.println(Arrays.toString(solution(test2)));
        int [] answer2 = {4, 0, 1, 2};

    }
    static int n;
    static int max = 0;
    static ArrayList<Integer> [] graph;
    static boolean [] visited;
    // answer -> 생성 정점, 도넛 모양, 막대 모양, 8자 모양
    public static int[] solution(int[][] edges) {
        n = edges.length;
        init(edges);
        int start = findStart(edges);
        Queue<Integer> q = new LinkedList<>();
        int [] answer = new int[4];
        answer[0] = start;
        for (int i = 0; i < graph[start].size(); i++) {
            int st = graph[start].get(i);
            visited[st] = true;
            int cnt1 = 1; // 정점의 개수
            int cnt2 = 0; // 간선의 개수
            q.add(st);
            while (!q.isEmpty()) {
                int cur = q.poll();
                cnt2 += graph[cur].size();
                for (int j = 0; j < graph[cur].size(); j++) {
                    int next = graph[cur].get(j);
                    if(!visited[next]) {
                        visited[next] = true;
                        cnt1++;
                        q.add(next);
                    }
                }
            }
            if(cnt1 == cnt2) answer[1]++;     // 도넛 모양
            else if(cnt1 > cnt2) answer[2]++; // 막대 모양
            else answer[3]++;                 // 8자 모양
        }
        return answer;
    }
    public static void init(int [][] edges){
        for (int i = 0; i < n; i++) {
            max = Math.max(max, Math.max(edges[i][0],  edges[i][1]));
        }

        graph = new ArrayList[max + 1];
        for (int i = 0; i <= max; i++) {
            graph[i] = new ArrayList<>();
        }
        visited = new boolean[max + 1];
    }
    public static int findStart(int [][] edges){
        int [] input = new int[max + 1];
        for (int i = 0; i < n; i++) {
            graph[edges[i][0]].add(edges[i][1]);
            input[edges[i][1]]++;
        }
        int start = 0;
        int max_output = 0;
        for (int i = 0; i <= max; i++) {
            if(input[i] != 0) continue;
            if(graph[i].size() > max_output){
                start = i;
                max_output = graph[i].size();
            }
        }
        return start;
    }
}
/*
막대 모양 -> 정점 n: 간선: n - 1
도넛 모양 -> 정점 n: 간선: n
8자 모양 -> 정점 n: 간선: n + 1

출발 정점을 찾는 방법
1. 해당 정점으로 들어오는 간선이 0개
2. 1번 조건에 맞는 정점들중 나가는 간선이 가장 많은 정점

2번 조건이 필요한 이유

그래프와 동떨어진 정점이 테스트 케이스에 존재한다.
 */
