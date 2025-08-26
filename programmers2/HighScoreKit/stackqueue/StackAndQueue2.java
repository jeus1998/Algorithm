package programmers2.HighScoreKit.stackqueue;

/**
 * 스택/큐 / 기능개발
 * https://school.programmers.co.kr/learn/courses/30/lessons/42586
 * LEVEL 2
 */
import java.util.*;
public class StackAndQueue2 {
	public int[] solution(int[] progresses, int[] speeds) {
		Queue<int []> q = new LinkedList<>();
		for (int i = 0; i < progresses.length; i++) {
			q.add(new int [] {progresses[i], speeds[i]});
		}
		List<Integer> list = new ArrayList<>();
		int day = 0;
		while (!q.isEmpty()) {
			int [] task = q.poll();
			int left = 100 - (task[0] + (day * task[1]));
			if(left > 0) {
				day += (left / task[1]) + (left % task[1] == 0 ? 0 : 1);
			}
			int count = 1;
			while (!q.isEmpty()) {
				if((q.peek()[0] + (day * q.peek()[1])) >= 100){
					q.poll();
					count++;
					continue;
				}
				break;
			}
			list.add(count);
		}
		return list.stream().mapToInt(Integer::intValue).toArray();
	}
}
