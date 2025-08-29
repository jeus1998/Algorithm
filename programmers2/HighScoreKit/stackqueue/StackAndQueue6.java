package programmers2.HighScoreKit.stackqueue;

/**
 * 스택/큐 - 주식가격
 * LEVEL 2
 * https://school.programmers.co.kr/learn/courses/30/lessons/42584
 * - 나중에 다시 풀어보기
 */
import java.util.*;
public class StackAndQueue6 {
	public int[] solution(int[] prices) {
		Stack<Integer> stack = new Stack<>();
		int size = prices.length;
		int [] answer = new int[size];
		for (int i = 0; i < size; i++) {
			while (!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
				int idx = stack.pop();
				answer[idx] = i - idx;
			}
			stack.push(i);
		}
		while (!stack.isEmpty()) {
			int idx = stack.pop();
			answer[idx] = size - 1 - idx;
		}
		return answer;
	}
}
