package programmers2.HighScoreKit.stackqueue;

/**
 * 스택/큐 - 프로세스
 * LEVEL 2
 * https://school.programmers.co.kr/learn/courses/30/lessons/42587
 */
import java.util.*;
public class StackAndQueue4 {
	public int solution(int[] priorities, int location) {
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		for(int p : priorities) {
			pq.add(p);
		}
		Queue<int []> q = new LinkedList<>();
		for(int i = 0; i < priorities.length; i++) {
			q.add(new int[] {priorities[i], i});
		}
		while (!q.isEmpty()) {
			int [] cur = q.poll();
			if(pq.peek() == cur[0] && cur[1] != location) {
				pq.poll();
				continue;
			}
			if(pq.peek() == cur[0] && cur[1] == location) {
				pq.poll();
				return priorities.length - pq.size();
			}
			q.add(cur);
		}
		return 0;
	}
}
/*
특정 프로세스가 몇 번째로 실행되는지 알아내는 문제

1. 실행 대기 큐에서 대기중인 프로세스 하나를 꺼낸다.
2. 대기중인 프로세스 중 우선순위가 더 높은 프로세스가 있다면 방금 꺼낸 프로세스를 다시 큐에 넣는다.
3. 그런 프로세스가 없다면 방금 꺼낸 프로세스를 실행한다.

예를 들어 프로세스 4개 [A, B, C, D]가 순서대로 실행 대기 큐에 들어있고,
우선순위가 [2, 1, 3, 2]라면 [C, D, A, B] 순으로 실행하게 됩니다.
 */