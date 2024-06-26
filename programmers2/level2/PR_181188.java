package programmers2.level2;

/**
 * 요격 시스템
 */
import java.util.*;
public class PR_181188 {
    public int solution(int[][] targets) {
        Arrays.sort(targets, (o1, o2)-> o1[1] - o2[1]);
        int cur = 0;
        int answer = 0;
        for(int i = 0; i < targets.length; i++){
            if(cur > targets[i][0]) continue;
            cur = targets[i][1];
            answer++;
        }
        return answer;
    }
}
