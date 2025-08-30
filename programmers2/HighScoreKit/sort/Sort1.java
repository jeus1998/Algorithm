package programmers2.HighScoreKit.sort;

/**
 * 정렬/K번째수
 * LEVEL 1
 * https://school.programmers.co.kr/learn/courses/30/lessons/42748
 */
import java.util.*;
public class Sort1 {
	public int[] solution(int[] array, int[][] commands) {
		int size = commands.length;
		int[] answer = new int [size];
		for (int i = 0; i < size; i++) {
			ArrayList<Integer> temp = new ArrayList<>();
			for (int j = commands[i][0] - 1; j < commands[i][1]; j++) {
				temp.add(array[j]);
			}
			Collections.sort(temp);
			answer[i] = temp.get(commands[i][2] - 1);
		}
		return answer;
	}
}
