package programmers2.HighScoreKit.greedy;

/**
 * 탐욕법/단속 카메라
 * LEVEL 3
 * https://school.programmers.co.kr/learn/courses/30/lessons/42884
 */
import java.util.*;
public class Greedy6 {
	public int solution(int[][] routes) {
		Arrays.sort(routes, Comparator.comparingInt(o -> o[1]));
		int camera = 0;
		int max = -30001;
		for(int [] target : routes) {
			if(target[0] > max){
				camera++;
				max = target[1];
			}
		}
		return camera;
	}
}
