package programmers2.level2;

import java.util.*;

/**
 * [PCCP 기출문제] 2번 / 석유 시추
 */
public class PR_250136_2 {
    public static void main(String[] args) {

        // answer 9
        int[][] test1 = {
                {0, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 1, 1, 0, 0},
                {1, 1, 0, 0, 0, 1, 1, 0},
                {1, 1, 1, 0, 0, 0, 0, 0},
                {1, 1, 1, 0, 0, 0, 1, 1}};

        // answer 16
        int[][] test2 = {
                {1, 0, 1, 0, 1, 1},
                {1, 0, 1, 0, 0, 0},
                {1, 0, 1, 0, 0, 1},
                {1, 0, 0, 1, 0, 0},
                {1, 0, 0, 1, 0, 1},
                {1, 0, 0, 0, 0, 0},
                {1, 1, 1, 1, 1, 1}};

        System.out.println(solution(test1) == 9);
        System.out.println(solution(test2) == 16);
    }

    static int [] arx = {-1,1,0,0};
    static int [] ary = {0,0,-1,1};

    static int n;
    static int m;

    public static int solution(int[][] land) {
        n = land.length;
        m = land[0].length;
        int [][] visited = new int[n][m];
        int count = 1; // 석유 번호
        ArrayList<Integer> check = new ArrayList<>(); // 석유 매장량
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 이미 방문 || 땅이면 pass
                if(visited[i][j] != 0 || land[i][j] == 0) continue;
                visited[i][j] = count;
                int size = 1;
                Queue<int[]> q = new LinkedList<>();
                q.add(new int[]{i, j});
                while(!q.isEmpty()) {
                    int[] cur = q.poll();
                    for (int k = 0; k < 4; k++) {
                        int nx = cur[0] + arx[k];
                        int ny = cur[1] + ary[k];
                        if(!validation(nx, ny) || land[nx][ny] == 0 || visited[nx][ny] != 0) continue;
                        visited[nx][ny] = count;
                        size++;
                        q.add(new int[]{nx, ny});
                    }
                }
                check.add(size);
                count++;
            }
        }
        int max = 0;
        for (int i = 0; i < m; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = 0; j < n; j++) {
                set.add(visited[j][i]);
            }
            int sum = 0;
            for (Integer integer : set) {
                if(integer == 0) continue;
                sum += check.get(integer - 1);
            }
            max = Math.max(max, sum);
        }

        return max;
    }
    public static boolean validation(int nx, int ny){
        if(0 <= nx && 0 <= ny && nx < n && ny < m) return true;
        return false;
    }

}
