package programmers2.level3;

/**
 * 상담원 인원
 */

import java.util.*;
public class PR_214288 {
    static Queue<int[]>[] q;
    static int [][] memo;
    static int min = 10000000;
    static int K, N;
    static List<List<Integer>> list = new ArrayList<>();
    public int solution(int k, int n, int[][] reqs) {
        int max = n - k + 1;
        K = k;
        N = n;

        q = new LinkedList[k+1];
        for(int i = 0; i <= k; i++){
            q[i] = new LinkedList<>();
        }
        for(int i = 0; i < reqs.length; i++){
            q[reqs[i][2]].add(new int[]{reqs[i][0], reqs[i][1]});
        }

        memo = new int [k+1][max+1];
        for(int i = 1; i <= k; i++){
            for(int j = 1; j <= max; j++){
                memo[i][j] = func(i, j);
            }
        }

        find(max);
        return min;
    }
    public static void find(int max){
        comb(new ArrayList<>(), max, 0);

        for(List<Integer> temp : list){
            int sum = 0;
            for(int i = 1; i <= K; i++){
                sum += memo[i][temp.get(i-1)];
            }
            if(min > sum){
                min = sum;
            }
        }
    }
    public static void comb(ArrayList<Integer> temp, int max, int sum){
        if(temp.size() == K){
            if(sum == N){
                list.add(temp);
            }
            return;
        }
        for(int i = 1; i <= max; i++){
            ArrayList<Integer> next = new ArrayList<>(temp);
            next.add(i);
            comb(next, max, sum + i);
        }
    }

    // x = 유형 y = 멘토 숫자
    public static int func(int x, int y){
        int size = q[x].size();
        if(size == 0) return 0;

        int latency = 0; // 시간
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < y; i++){
            pq.add(0);
        }

        for(int i = 0; i < size; i++){
            int [] cur = q[x].poll();

            if(cur[0] >= pq.peek()){
                pq.poll();
                pq.add(cur[0] + cur[1]);
            }
            else{
                latency += pq.peek() - cur[0];
                pq.add(pq.poll() + cur[1]);
            }
            q[x].add(cur);
        }
        return latency;
    }
}
