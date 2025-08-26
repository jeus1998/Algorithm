package programmers2.HighScoreKit.stackqueue;

/**
 * 스택/큐 /  같은 숫자는 싫어
 * https://school.programmers.co.kr/learn/courses/30/lessons/12906
 * LEVEL 1
 */
import java.util.*;
public class StackAndQueue1 {
	public int[] solution(int []arr) {
		Deque<Integer> dq = new LinkedList<>();
		dq.addLast(arr[0]);
		for(int i=1; i<arr.length; i++) {
			if(dq.peekLast() != arr[i]) {
				dq.addLast(arr[i]);
			}
		}
		return dq.stream().mapToInt(i -> i).toArray();
	}
}
