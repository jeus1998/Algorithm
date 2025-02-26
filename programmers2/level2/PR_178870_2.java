package programmers2.level2;

/**
 * 연속된 부분 수열의 합
 */
public class PR_178870_2 {
    public static void main(String[] args) {
        int[][] sequences = {
                {1, 2, 3, 4, 5},
                {1, 1, 1, 2, 3, 4, 5},
                {2, 2, 2, 2, 2}
        };
        int[] ks = {7, 5, 6};

        for (int i = 0; i < sequences.length; i++) {
            int[] result = solution(sequences[i], ks[i]);
            System.out.println(result[0] + " " + result[1]);
        }
    }
    public static int[] solution(int[] sequence, int k) {
        int s_index = 0; // 시작 인덱스
        int e_index = 0; // 끝 인덱스
        int sum = 0; // 현재 수열의 합
        int min = Integer.MAX_VALUE; // 합이 k인 가장 짧은 수열의 길이
        int [] answer = new int[2];  // 정답: 시작 인덱스, 끝 인덱스 기록

        int size = sequence.length;
        while (s_index <= e_index && e_index < size){
            sum += sequence[e_index++];

            while (sum > k && s_index < e_index){
                sum -= sequence[s_index++];
            }

            if(sum == k && min > e_index - s_index){
                min = e_index - s_index;
                answer[0] = s_index;
                answer[1] = e_index - 1;
            }
        }
        return answer;
    }
}
/*
연속된 부분 수열 찾기 문제

1. 두 인덱스의 원소와 그 사이의 원소를 모두 포함하는 부분 수열의 합 = k
2. 가장 길이가 짧은 수열 찾도록
3. 길이가 짧은 수열이 여러 개인 경우 앞쪽(시작 인덱스가 작은)에 나오는 수열을 찾는다

two pointer 문제

 */