package programmers2.level2;

/**
 * 연속 부분 수열 합의 개수
 */
import java.util.*;
public class PR_131701 {
    static int[] circularElements;
    static Set<Integer> set = new HashSet<>();
    static int max;
    public int solution(int[] elements) {
        max = elements.length;
        circularElements = new int[max * 2];
        for(int i = 0; i < max; i++){
            circularElements[i] = elements[i];
        }
        // 원형 수열 만들기
        for(int i = max; i < max * 2; i++){
            circularElements[i] = elements[i - max];
        }

        // 누적합
        int [] prefixSum = new int [max * 2 + 1];
        for(int i = 1; i <= max * 2; i++){
            prefixSum[i] = prefixSum[i-1] + circularElements[i-1];
        }

        for(int i = 0; i <= max * 2; i++){
            for(int j = i+1; j <= max *2; j++){
                if(j - i > max) break; // 수열의 최대 길이
                set.add(prefixSum[j] - prefixSum[i]);
            }
        }
        return set.size();
    }
}
