package programmers2.level2;

/**
 * 귤 고르기
 */
import java.util.*;
import java.util.stream.*;
public class PR_138476 {
    public int solution(int k, int[] tangerine) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < tangerine.length; i++){
            map.put(tangerine[i], map.getOrDefault(tangerine[i], 0) + 1);
        }

        // 귤의 개수가 많은 순서대로 map 정렬
        // map -> Map.Entry<Integer, Integer> -> stream -> 정렬 ->
        // List<Map.Entry<Integer, Integer> -> iterator
        Iterator<Map.Entry<Integer, Integer>> it = map.entrySet().stream().sorted((o1,o2)->{
            return o2.getValue() - o1.getValue();
        }).collect(Collectors.toList()).iterator();

        int answer = 0; // 선택한 귤 종류 count
        int cnt    = 0; // 선택한 귤 누적 count
        while(cnt < k && it.hasNext()){
            Map.Entry<Integer, Integer> entry = it.next();
            answer++; // 귤 종류 up
            cnt += entry.getValue();
        }

        return answer++;
    }
}
