package programmers2.HighScoreKit.greedy;

/**
 * 탐욕법/큰 수 만들기
 * LEVEL 2
 * https://school.programmers.co.kr/learn/courses/30/lessons/42883
 */
import java.util.*;
public class Greedy3 {
	public String solution(String number, int k) {
		Deque<Integer> dq = new ArrayDeque<>();
		int cnt = 0;
		for (int i = 0; i < number.length(); i++) {
			int cur = number.charAt(i) - '0';
			while (!dq.isEmpty() && cnt < k && dq.peekLast() < cur) {
				dq.pollLast();
				cnt++;
			}
			dq.addLast(cur);
		}
		StringBuilder sb = new StringBuilder();
		while (!dq.isEmpty()) {
			sb.append(dq.pollFirst());
		}
		return sb.substring(0, sb.length() - 1 - (k - cnt));
	}
}
/*
어떤 숫자에서 k개의 수를 제거했을 때 얻을 수 있는 가장 큰 숫자를 구하려 합니다.
숫자 1924에서 두 개의 수를 제거하면 94가 남기 때문에 94가 가장 큰 숫자가 됩니다.

number = 2자리 이상, 1,000,000자리 이하인 숫자


1234
[1]
[2]
[3]
[3 4]

9876
[9]
[9 8]
[9 8 7]
[9 8 7 6]

[9 8 7]
[9 8]

 */