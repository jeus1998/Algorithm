package programmers2.HighScoreKit.sort;

/**
 * 정렬/가장 큰 수
 * LEVEL 2
 * https://school.programmers.co.kr/learn/courses/30/lessons/42746
 */
import java.util.*;
import java.util.stream.*;
public class Sort2 {
	public static void main(String[] args) {
		Sort2 sort2 = new Sort2();
		sort2.solution(new int [] {});
	}
	public String solution(int[] numbers) {
		var temp = Arrays.stream(numbers)
			.boxed()
			.map(String::valueOf)
			.collect(Collectors.toList());

		var list = new ArrayList<>(temp);
		list.sort((o1, o2) -> (o2 + o1).compareTo(o1 + o2));
		var sb = new StringBuilder();
		for (String s : list) {
			sb.append(s);
		}
		// 0으로만 이루어진 경우
		if(sb.charAt(0) == '0') return "0";
		return sb.toString();
	}
}
/*
정수를 이어 붙여 만들 수 있는 가장 큰 수를 알아내 주세요.
예를 들어, 주어진 정수가 [6, 10, 2]라면, 만들 수 있는 가장 큰 수는 6210입니다.

[3, 30, 34, 5, 9]	"9534330"


 */
