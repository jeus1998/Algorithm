package programmers2.level2;

/**
 * 순위 검색
 */
import java.util.*;
public class PR_72412 {
    static HashMap<String, String> map = new HashMap<>();
    static HashMap<String, ArrayList<Integer>> record = new HashMap<>();
    static int sum;
    static String [] split1; // 0: 언어 1: 직군 2: 경력 3: 음식
    static String [] split2; // 1: 점수
    public int[] solution(String[] info, String[] query) {

        int [] answer = new int [query.length];

        init();      // map 초기화
        func1(info); // info 값 키로 정리
        func2();     // 이분탐색을 위해서 record value인 리스트 정렬

        for(int i=0; i < query.length; i++){
            sum = 0;
            split1 = query[i].split(" and ");
            split2 = split1[3].split(" ");
            split1[3] = split2[0];
            func3(0, ""); // 백트래킹을 활용해서 여러가지 경우의 쿼리 만들기
            answer[i] = sum; // 정답 기록
        }
        return answer;
    }
    public static void init(){
        map.put("java", "0");
        map.put("cpp", "1");
        map.put("python", "2");
        map.put("backend", "0");
        map.put("frontend", "1");
        map.put("junior", "0");
        map.put("senior", "1");
        map.put("chicken", "0");
        map.put("pizza", "1");
    }
    public static void func1(String[] info){
        for(String temp : info){
            String [] split = temp.split(" ");
            String key = "";
            for(int i = 0 ; i < 4; i++){
                key += map.get(split[i]);
            }
            if(!record.containsKey(key)){
                ArrayList<Integer> list = new ArrayList<>();
                list.add(Integer.parseInt(split[4]));
                record.put(key, list);
            }
            else record.get(key).add(Integer.parseInt(split[4]));
        }
    }
    public static void func2(){  // 정렬
        Set<String> set = record.keySet();
        for(String key : set){
            Collections.sort(record.get(key));
        }
    }
    public static void func3(int depth, String key){
        if(depth == 4){
            if(!record.containsKey(key)) return;

            ArrayList<Integer> temp = record.get(key);
            // 이분 탐색 시작

            int start  = 0;
            int end    = temp.size();
            int target = Integer.parseInt(split2[1]);

            while(start < end){
                int mid = (start + end) / 2;
                if(temp.get(mid) >= target){
                    end = mid;
                }
                else start = mid + 1;
            }

            sum += temp.size() - start;

            return;
        }

        if(!split1[depth].equals("-")){
            func3(depth + 1, key + map.get(split1[depth]));
        }
        else{ // "-" 인 케이스
            func3(depth + 1, key + "0");
            func3(depth + 1, key + "1");
            if(depth == 0) func3(depth + 1, key + "2");
        }
    }
}
