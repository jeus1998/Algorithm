package programmers2.level2;

/**
 * 할인 행사
 */
import java.util.*;
public class PR_131127 {
    static HashMap<String, Integer> wants = new HashMap<>();
    static HashMap<String, Integer> cur = new HashMap<>();
    static List<String> keys;
    public int solution(String[] want, int[] number, String[] discount) {

        int answer = 0;

        for(int i = 0; i < want.length; i++){
            wants.put(want[i], number[i]);
        }
        keys = new ArrayList<>(wants.keySet());

        for(int i = 0; i < 10; i++){
            cur.put(discount[i], cur.getOrDefault(discount[i], 0) + 1);
        }

        if(validation()) answer++;

        for(int i = 10; i < discount.length; i++) {
            cur.put(discount[i - 10], cur.get(discount[i - 10]) - 1);
            cur.put(discount[i], cur.getOrDefault(discount[i], 0) + 1);
            if(validation()) answer++;
        }

        return answer;
    }
    public static boolean validation() {
        for(String key : keys){
            if(cur.getOrDefault(key, 0) < wants.get(key)) return false;
        }
        return true;
    }
}
