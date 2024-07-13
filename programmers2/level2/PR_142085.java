package programmers2.level2;

/**
 * 디펜스 게임
 */
import java.util.*;
public class PR_142085 {
    public int solution(int n, int k, int[] enemy) {
       int answer = 0;
       PriorityQueue<Integer> pq = new PriorityQueue<>();
       for(int i = 0; i < enemy.length; i++){
           pq.add(enemy[i]);
           if(pq.size() <= k){
               answer++;
               continue;
           }
           n -= pq.poll();
           if(n < 0) break;
           answer++;
       }
       return answer;
    }
}
