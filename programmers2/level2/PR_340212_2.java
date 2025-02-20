package programmers2.level2;

/**
 * [PCCP 기출문제] 2번 / 퍼즐 게임 챌린지
 */
public class PR_340212_2 {
    public static void main(String[] args) {
        int[][] diffsList = {
                {1, 5, 3},
                {1, 4, 4, 2},
                {1, 328, 467, 209, 54},
                {1, 99999, 100000, 99995}
        };
        int[][] timesList = {
                {2, 4, 7},
                {6, 3, 8, 2},
                {2, 7, 1, 4, 3},
                {9999, 9001, 9999, 9001}
        };

        long[] limitsList = {30, 59, 1723, 3456789012L};

        int[] expectedResults = {3, 2, 294, 39354};

        for (int i = 0; i < 4; i++) {
            int result = solution(diffsList[i], timesList[i], limitsList[i]);
            System.out.println(result == expectedResults[i]);
        }
    }
    static int size;
    static int [] diff, time;
    static long limits;
    public static int solution(int[] diffs, int[] times, long limit) {
        size = diffs.length;
        diff = diffs; time = times; limits = limit;
        int start = 1;
        int end = 100000; // diffs[i] <= 100,000
        while (start < end){
            int mid = (start + end) / 2;
            if(!check(mid)){
                start = mid + 1;
            }
            else end = mid;
        }
        return start;
    }
    public static boolean check(int level) {
        long sum = 0;
        sum += time[0];
        for (int i = 1; i < size; i++) {
            if(sum > limits) return false;
            if(diff[i] <= level){
                sum += time[i];
                continue;
            }
            long temp = 0;
            // (이번 문제 푸는데 걸리는 시간 + 이전 풀이 시간) * 틀린 횟수
            temp += (time[i] + time[i - 1]) * (diff[i] - level);
            // 이번 문제 푸는데 걸리는 시간
            temp += time[i];
            sum += temp;
        }
        if(sum > limits) return false;
        return true;
    }
}
/*
현재 퍼즐의 난이도를 diff, 현재 퍼즐의 소요 시간을 time_cur, 이전 퍼즐의 소요 시간을 time_prev, 당신의 숙련도를 level

diff ≤ level
퍼즐을 틀리지 않고 time_cur 시간을 사용하여 해결

diff > level
퍼즐을 총 diff - level 번 틀립니다.
퍼즐을 틀릴 때마다, time_cur 시간을 사용하며, 추가로 time_prev 시간을 사용해 이전 퍼즐을 다시 풀고 와야 합니다.
이전 퍼즐을 다시 풀 때는 이전 퍼즐의 난이도에 상관없이 틀리지 않습니다.
diff - level 번 틀린 이후에 다시 퍼즐을 풀면 time_cur 시간을 사용하여 퍼즐을 해결

(diff - level) * time_cur + time_prev + time_cur


ex)

diff = 3, time_cur = 2, time_prev = 4인 경우, level 따라 퍼즐을 푸는데 걸리는 시간은 다음과 같다.

level1
3 - 1 = 2  (time_cur + time_prev) * 2 + time_cur = 14
level2
3 - 2 = 1  6 + 2 = 8
level3
2

제한 시간 내에 퍼즐을 해결하기 위한 숙련도의 최솟값을 구하시오

 */