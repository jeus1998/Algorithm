package programmers2.HighScoreKit.ExhaustiveSearch;

/**
 * 완전탐색/소수찾기
 * LEVEL 2
 * https://school.programmers.co.kr/learn/courses/30/lessons/42839
 */
import java.util.*;
import java.util.stream.*;
public class ExhaustiveSearch3 {

	private static int MAX = 10000000;
	private static boolean [] isPrime;
	private static Set<Integer> set = new HashSet<>();
	private static boolean [] visited;
	private static int [] memo;
	private static int [] nums;

	public int solution(String numbers) {
		findPrime();
		init(numbers);
		function(0, numbers.length());
		return set.size();
	}
	// 에라토스테네스의 체
	public static void findPrime() {
		isPrime = new boolean[MAX];
		Arrays.fill(isPrime, true);
		isPrime[0] = false;
		isPrime[1] = false;
		for (int i = 2; i < MAX; i++) {
			if(!isPrime[i]) continue;
			for (int j = 2; j * i < MAX; j++) {
				isPrime[i * j] = false;
			}
		}
	}
	public static void init(String numbers) {
		int size = numbers.length();
		visited = new boolean[size];
		memo = new int[size];
		Arrays.fill(memo, -1);
		nums = IntStream.range(0, size)
			.map(i -> numbers.charAt(i) - '0')
			.toArray();
	}
	public static void function(int depth, int end) {
		if(depth == end + 1) {
			return;
		}
		var sb = new StringBuilder();
		for (int i = 0; i < depth; i++) {
			sb.append(memo[i]);
		}
		if(sb.length() > 0) {
			int num = Integer.parseInt(sb.toString());
			if(isPrime[num]) set.add(num);
		}

		for (int i = 0; i < end; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			memo[depth] = nums[i];
			function(depth + 1, end);
			visited[i] = false;
		}
	}
}

