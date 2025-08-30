package programmers2.HighScoreKit.ExhaustiveSearch;

/**
 * 완전탐색/전력망을 둘로 나누기
 * LEVEL 2
 * https://school.programmers.co.kr/learn/courses/30/lessons/86971
 */
import java.util.*;
public class ExhaustiveSearch6 {
	public int solution(int n, int[][] wires) {
		int answer = Integer.MAX_VALUE;

		ArrayList<Integer>[] graph = new ArrayList[n+1];
		for (int i = 0; i <= n; i++) {
			graph[i] = new ArrayList<>();
		}
		for (int i = 0; i < wires.length; i++) {
			int x1 = wires[i][0];
			int x2 = wires[i][1];
			// 양방향 그래프
			graph[x1].add(x2);
			graph[x2].add(x1);
		}

		for (int i = 0; i < wires.length; i++) {
			// 간선 제거 타겟
			int x1 = wires[i][0];
			int x2 = wires[i][1];
			Queue<Integer> q = new LinkedList<>();
			q.add(1);
			int cnt = 1;
			boolean[] visited = new boolean[n+1];
			visited[1] = true;
			while (!q.isEmpty()) {
				int cur = q.poll();
				for (int j = 0; j < graph[cur].size(); j++) {
					int next = graph[cur].get(j);
					if(visited[next] || (cur == x1 && next == x2) || (cur == x2 && next == x1)) continue;
					visited[next] = true;
					q.add(next);
					cnt++;
				}
			}
			answer = Math.min(answer, Math.abs(n - 2 * cnt));
		}
		return answer;
	}
}
/*
하나의 트리 형태로 연결된 n개의 송전탑
전선 wires 중 하나를 끊어서 두 개의 트리로 나누었을 때,
각 트리가 포함하는 송전탑의 개수 차이의 최솟값을 return

 */
