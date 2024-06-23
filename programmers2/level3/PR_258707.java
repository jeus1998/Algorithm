package programmers2.level3;

/**
 * n+1 카드게임
 */
import java.util.*;
import java.util.stream.*;
public class PR_258707 {
    public int solution(int coin, int[] cards) {
        int n = cards.length;
        int target = n + 1;

        // 0: 짝이 맞춰지는데 필요한 동전 개수 1: 짝이 맞춰지는 라운드 2: 사용 여부
        int [][] memo = new int [n+1][3];
         for(int i = 0; i < n; i++){
             int cur = cards[i];
             if(i >= n/3){ // 동전 사용 여부 기록
                memo[cur][2] = 1;
                memo[cur][0]++;
                memo[target-cur][0]++;
             }
             for(int j = 0; j < n; j++){
                 if(i == j) continue;
                 if(cur + cards[j] == target){
                     if(i >= j){
                         if(i >= n/3){
                             memo[cur][1] = (i - n/3)/2 + 1;
                         }
                     }
                     else{
                         if(j >= n/3){
                             memo[cur][1] = (j - n/3)/2 + 1;
                         }
                     }
                     break;
                 }
             }
        }
        Set<Integer> set = new HashSet<>();

        for(int i = 0; i < n/3; i++){
            set.add(cards[i]);
        }

        PriorityQueue<int[]> pair = new PriorityQueue<>((o1,o2)->{
            return memo[o1[0]][0] - memo[o2[0]][0];
        });

        boolean global = true;

        Set<Integer> delete = new HashSet<>();

        int round = 0;
        for(int i = n/3; i < n; i++){
            round++;
            if(!delete.contains(target - cards[i])){
                set.add(cards[i]);
                coin--;
            }
            if(!delete.contains(target - cards[i+1])){
                set.add(cards[i+1]);
                coin--;
            }

            // pair 찾기
            Iterator<Integer> it = set.iterator();

            while(it.hasNext()){
                int next = it.next();
                if(set.contains(target - next) && target - next < next){
                    pair.add(new int[]{target - next, next});
                }
            }

            boolean flag = false;
            while(!pair.isEmpty()){
                int [] tmp = pair.poll();
                if(delete.contains(tmp[0])) continue;

                set.remove(tmp[0]);
                set.remove(tmp[1]);

                delete.add(tmp[0]);
                delete.add(tmp[1]);

                flag = true;
                break;
            }

            if(!flag){
                global = false;
                break;
            }

            if(coin < 0){

                List<Integer> list = set.stream().sorted((o1,o2) -> {
                    if(memo[o1][0] != memo[o2][0]) return memo[o2][0] - memo[o1][0]; // 사용 coin
                    return memo[o2][1] - memo[o1][1]; // 라운드
                }).collect(Collectors.toList());

                int size = list.size();
                for(int j = 0; j < size; j++){
                    if(coin >= 0) break;
                    int cur = list.get(j);
                    if(set.contains(target - cur)){
                        if(!delete.contains(cur)){
                            delete.add(cur);
                            if(memo[cur][2] == 1) coin++;
                        }

                        if(!delete.contains(target - cur)){
                            delete.add(target - cur);
                            if(memo[target - cur][2] == 1) coin++;
                        }
                    }
                    else{
                         delete.add(cur);
                         if(memo[cur][2] == 1) coin++;
                    }
                }
            }

            it = delete.iterator();
            while(it.hasNext()){
                int next = it.next();
                if(set.contains(next)){
                     set.remove(next);
                }
            }
            if(coin < 0){
                global = false;
                break;
            }
            i++;
        }
        return round + (global == true ? 1 : 0);
    }
}
