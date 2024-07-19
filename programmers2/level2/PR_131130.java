package programmers2.level2;

/**
 * 혼자 놀기의 달인
 */
import java.util.*;
public class PR_131130 {
    public int solution(int[] cards) {

        boolean [] visited = new boolean [cards.length + 1];
        ArrayList<ArrayList<Integer>> group = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < cards.length; i++){
            if(visited[i+1]) continue;
            visited[i+1] = true;
            ArrayList<Integer> temp = new ArrayList<>();
            q.add(i+1);
            temp.add(i+1);
            while(!q.isEmpty()){
                int cur = q.poll();
                int next = cards[cur-1];
                if(visited[next]) break;
                visited[next] = true;
                temp.add(next);
                q.add(next);
            }
            group.add(temp);
        }
        Collections.sort(group, (o1, o2)->{
           return o2.size() - o1.size();
        });

        if(group.size() == 1) return 0;
        else{
           return group.get(0).size() * group.get(1).size();
        }
    }
}
