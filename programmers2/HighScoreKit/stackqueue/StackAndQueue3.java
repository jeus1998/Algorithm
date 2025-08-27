package programmers2.HighScoreKit.stackqueue;

/**
 * 스택/큐 - 올바른 괄호
 * LEVEL 2
 * https://school.programmers.co.kr/learn/courses/30/lessons/12909
 */
import java.util.*;
public class StackAndQueue3 {
	boolean solution(String s) {
		Stack<Character> stack = new Stack<>();
		for (char c : s.toCharArray()) {
			if(stack.isEmpty()) {
				stack.push(c);
				continue;
			}
			// '(' -> '((' & ')' -> '))'
			if(stack.peek() == c) {
				stack.push(c);
				continue;
			}
			// '()'
			if(stack.peek() == '(' && c == ')') {
				stack.pop();
				continue;
			}
			return false;
		}
		return stack.isEmpty();
	}
}
