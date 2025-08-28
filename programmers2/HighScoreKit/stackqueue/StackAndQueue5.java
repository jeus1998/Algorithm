package programmers2.HighScoreKit.stackqueue;

/**
 * 스택/큐 - 다리를 지나는 트럭
 * LEVEL 2
 * https://school.programmers.co.kr/learn/courses/30/lessons/42583
 */
import java.util.*;
import java.util.stream.*;
public class StackAndQueue5 {
	// bridge_length: 다리 길이, weight: 다리의 최대 하중, truck_weights: 트럭별 무게
	public int solution(int bridge_length, int weight, int[] truck_weights) {
		List<Integer> list = Arrays.stream(truck_weights).boxed().collect(Collectors.toList());
		Queue<Integer> trucks = new LinkedList<>(list);
		Queue<int []> bridge = new LinkedList<>();
		int time = 1;
		int currentWeight = 0;
		while (!trucks.isEmpty() || !bridge.isEmpty()) {
			if(!bridge.isEmpty() && bridge.peek()[0] == time) {
				currentWeight -= bridge.poll()[1];
			}
			if(!trucks.isEmpty() && currentWeight + trucks.peek() <= weight && bridge.size() < bridge_length) {
				int truck = trucks.poll();
				bridge.offer(new int[] {time + bridge_length, truck});
				currentWeight += truck;
			}
			time++;
		}
		return time - 1;
	}
}

