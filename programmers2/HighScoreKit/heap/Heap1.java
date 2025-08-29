package programmers2.HighScoreKit.heap;

/**
 * 힙/ 더 맵게
 * LEVEL 2
 * https://school.programmers.co.kr/learn/courses/30/lessons/42626
 */
import java.util.*;
import java.util.stream.*;
public class Heap1 {
	public int solution(int[] scoville, int K) {
		PriorityQueue<Long> pq = new PriorityQueue<>(
			Arrays.stream(scoville).mapToLong(i -> i).boxed().collect(Collectors.toList()));
		int count = 0;
		while (pq.peek() < K) {
			if(pq.size() < 2) return -1;
			pq.add(pq.poll() + (pq.poll() * 2));
			count++;
		}
		return pq.peek() >= K ? count : -1;
	}
}
