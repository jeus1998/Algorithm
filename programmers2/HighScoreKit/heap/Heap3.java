package programmers2.HighScoreKit.heap;

/**
 * 힙/이중우선순위큐
 * LEVEL 3
 * https://school.programmers.co.kr/learn/courses/30/lessons/42628
 */
import java.util.*;
public class Heap3 {
	private static final String INSERT = "I";
	private static final String MAX_DELETE = "1";
	public int[] solution(String[] operations) {

		// 최대값, 최소값을 빠르게 찾기 위해 TreeMap 사용
		TreeMap<Integer, Integer> map = new TreeMap<>();

		for (String operation : operations) {
			String [] op = operation.split(" ");
			// 삽입
			if (op[0].equals(INSERT)) {
				int num = Integer.parseInt(op[1]);
				map.put(num, map.getOrDefault(num, 0) + 1);
				continue;
			}
			// 삭제 연산 시 큐가 비어있으면 무시
			if(map.isEmpty()) continue;
			// 최댓값 삭제
			if(op[1].equals(MAX_DELETE)) {
				var entry = map.lastEntry();
				if(entry.getValue() == 1) map.remove(entry.getKey());
				else map.put(entry.getKey(), entry.getValue() - 1);
				continue;
			}
			// 최솟값 삭제
			var entry = map.firstEntry();
			if(entry.getValue() == 1) map.remove(entry.getKey());
			else map.put(entry.getKey(), entry.getValue() - 1);
		}
		if(map.isEmpty()) return new int [] {0, 0};
		return new int [] {map.lastKey(), map.firstKey()};
 	}
}
/*
operations
| 숫자 -> 큐에 주어진 숫자 삽입
D 1 -> 큐에서 최댓값 삭제
D -1 -> 큐에서 최솟값 삭제

제한 사항
- 최댓값 최솟값 삭제 연산에서 값이 둘 이상인 경우, 하나만 삭제
- 빈 큐에 데이터를 삭제하라는 연산이 주어질 경우 해당 연산은 무시

return
모든 연산 처리한 후 큐가 비어있으면 [0,0] 리턴
비어있지 않으면 [최댓값, 최솟값] 리턴
 */
