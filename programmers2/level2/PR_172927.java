package programmers2.level2;

/**
 * 광물 캐기
 */
import java.util.*;
public class PR_172927 {
    static int [] memo = new int [3];
    static int [] order;
    static int [] pick;
    static String [] mineral;
    static int size;
    static int count;
    static int min = Integer.MAX_VALUE;
    public int solution(int[] picks, String[] minerals) {
        pick = Arrays.copyOf(picks, 3);
        mineral = Arrays.copyOf(minerals, minerals.length);
        size = minerals.length;

        for(int cur : picks){
            count += cur;
        }
        order = new int [count];
        backTracking(0);

        return min;
    }
    public static void backTracking(int cnt){
         if(cnt == count){
             calculate();
             return;
         }
         for(int i = 0; i < 3; i++){
             if(memo[i] < pick[i]){
                 memo[i]++;
                 order[cnt] = i;
                 backTracking(cnt+1);
                 memo[i]--;
             }
         }
    }
    public static void calculate(){
        int sum = 0;

        for(int i = 0; i < count; i++){
            int cur = order[i]; // 현재 곡갱이
            // 곡갱이는 5번 사용 가능
            for(int j = i * 5; j < (i * 5) + 5; j++){
                if(j == size){
                    if(min > sum) min = sum;
                    return;
                }
                if(cur == 0) sum++;
                else if(cur == 1){
                    if(mineral[j].equals("diamond")){
                        sum += 5;
                    }
                    else sum++;
                }
                else{
                    if(mineral[j].equals("diamond")){
                        sum += 25;
                    }
                    else if(mineral[j].equals("iron")){
                        sum += 5;
                    }
                    else sum++;
                }
            }
        }
        if(min > sum) min = sum;
    }
}
