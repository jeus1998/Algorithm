package programmers2.HighScoreKit.heap;

/**
 * 힙/디스크 컨트롤러
 * LEVEL 3
 * https://school.programmers.co.kr/learn/courses/30/lessons/42627
 */
import java.util.*;
public class Heap2 {
	public int solution(int[][] jobs) {
		// 0: 작업 소요 시간 1: 작업 요청 시각 2: 작업 번호
		ArrayList<int []> list = new ArrayList<>();
		for(int i = 0; i < jobs.length; i++) {
			list.add(new int[] {jobs[i][1], jobs[i][0], i});
		}

		// 작업 요청 시각 오름차순 정렬(작업 요청 시각 동일 시, 작업 소요 시간, 작업 번호 오름차순)
		// 동시에 요청이 들어오는 경우도 고려
		list.sort((o1, o2) -> {
			if(o1[1] != o2[1]) return o1[1] - o2[1];
			if(o1[0] != o2[0]) return o1[0] - o2[0];
			return o1[2] - o2[2];
		});

		// 작업 요청 시각 오름차순 큐
		Queue<int []> jobQ = new LinkedList<>(list);
		// 작업 소요 시간, 작업 요청 시각, 작업 번호 우선순위 큐
		PriorityQueue<int [] > readyQ = new PriorityQueue<>((o1, o2) -> {
			if(o1[0] != o2[0]) return o1[0] - o2[0];
			if(o1[1] != o2[1]) return o1[1] - o2[1];
			return o1[2] - o2[2];
		});

		// 작업에 걸린 누적 시간
		int answer = 0;
		// 현재 시간
		int time = 0;

		// 첫 번째 작업 처리
		int [] firstJob = jobQ.poll();
		answer += firstJob[0]; // 지연 없이 작업 소요 시간
		time += firstJob[1] + firstJob[0]; // 작업 요청 시각 + 작업 소요 시간

		// 0: 작업 소요 시간 1: 작업 요청 시각 2: 작업 번호
		while (!jobQ.isEmpty() || !readyQ.isEmpty()) {
			// case1: 작업 요청 시각이 현재 시간보다 이전인 작업들을 우선순위 큐에 넣기
			while (!jobQ.isEmpty() && jobQ.peek()[1] <= time) {
				readyQ.add(jobQ.poll());
			}
			// case2: 작업이 남아있고, 우선순위 큐에 작업이 없으니 시간 이동
			if(!jobQ.isEmpty() && readyQ.isEmpty()) {
				time = jobQ.peek()[1];
				continue;
			}
			// 작업 처리
			if(!readyQ.isEmpty()) {
				int [] job = readyQ.poll();
				time += job[0]; // 현재 시간 + 작업 소요 시간
				answer += time - job[1];  // (작업 완료 시각 - 작업 요청 시각)
			}
		}

		// 평균 시간 반환
		return answer/ jobs.length;
	}
}
/*
하드디스크는 한 번에 하나의 작업만 수행

대기 큐: 작업 번호, 작업 요청 시각, 작업 소요 시간
- 가장 우선순위가 높은 작업을 대기 큐에서 꺼내어 처리
- 우선순위: 소요 시간 > 작업 요청 시각 > 작업 번호
- 작업을 마치는 시점과 작업 요청이 들어오는 시간이 겹친다면 작업을 마치자마자 바로 바로 작업 처리 가능

example
- 0ms, 3ms, 0번
- 1ms, 9ms, 1번
- 3ms, 5ms, 2번

0: 0ms ~ 3ms -> 3ms(3ms - 0ms)
1: 1ms ~ 17ms -> 16ms(17ms - 1ms)
2: 3ms ~ 8ms -> 5ms(8ms - 3ms)

24 / 3 -> 8ms

반환 시간 평균을 구하시오
 */