package programmers2.level2;

/**
 * 두 큐 합 같게 만들기
 */
import java.util.*;
public class PR_118667 {
    public int solution(int[] queue1, int[] queue2) {
        long s1  = 0;
        long s2  = 0;
        ArrayDeque<int[]> q1 = new ArrayDeque<>();
        ArrayDeque<int[]> q2 = new ArrayDeque<>();
        for(int i = 0; i < queue1.length; i++){
            q1.add(new int[]{i, queue1[i], 1});
            q2.add(new int[]{i, queue2[i], 2});
            s1 += queue1[i];
            s2 += queue2[i];
        }
        int answer = 0;
        int cnt1 = 0;
        int cnt2 = 0;

        while(true){
            if(s1 == s2) return answer;
            answer++;
            if(s1 > s2){
               int [] temp = q1.poll();
               if(temp[0] == 0 && temp[2] == 1){
                  cnt1++;
                  if(cnt1 == 2) return -1;
               }
               s1 -= temp[1];
               s2 += temp[1];
               q2.add(temp);
            }
            else{ // s1 < s2
               int [] temp = q2.poll();
               if(temp[0] == 0 && temp[2] == 2){
                  cnt2++;
                  if(cnt2 == 2)   return -1;
               }
               s2 -= temp[1];
               s1 += temp[1];
               q1.add(temp);
            }
        }
    }
}
