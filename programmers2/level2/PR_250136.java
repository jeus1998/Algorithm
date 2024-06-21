package programmers2.level2;

/**
 * [PCCP 기출문제] 2번 / 석유 시추
 * level2
 */
import java.util.*;
public class PR_250136 {
    static int [] arx = {-1,1,0,0};
    static int [] ary = {0,0,-1,1};
    static int row, col;
    static int max = 0;
    static int [] memo;
    public int solution(int[][] land) {
        row = land.length; // 행
        col = land[0].length; // 열
        int [][] after = BFS(land);

        for(int i = 0; i < col; i++){
            Set<Integer> set = new HashSet<>();
            for(int j = 0; j < row; j++){
                set.add(after[j][i]);
            }

            int sum = 0;
            Iterator<Integer> it = set.iterator();
            while(it.hasNext()){
                int next = it.next();
                sum += memo[next];
            }

            if(max < sum) max = sum;
        }
        return max;
    }
    public static int [][] BFS(int[][] land){
        boolean [][] visited = new boolean [row][col];
        int cnt = 0;
        Queue<int[]> q = new LinkedList<>();
        ArrayList<int[]> list = new ArrayList<>();
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(visited[i][j] || land[i][j] == 0) continue;
                cnt++;
                int sum = 1;
                land[i][j] = cnt;
                visited[i][j] = true;
                q.add(new int[]{i,j});
                while(!q.isEmpty()){
                    int [] cur = q.poll();
                    for(int k = 0; k < 4; k++){
                        int nx = cur[0] + arx[k];
                        int ny = cur[1] + ary[k];
                        if(!validation(nx,ny) || visited[nx][ny] || land[nx][ny] == 0) continue;
                        visited[nx][ny] = true;
                        land[nx][ny] = cnt;
                        sum++;
                        q.add(new int[]{nx,ny});
                    }
                }
                list.add(new int[]{cnt, sum});
            }
        }
        memo = new int[cnt+1];

        Iterator<int[]> it = list.iterator();
        while(it.hasNext()){
            int [] next = it.next();
            memo[next[0]] = next[1];
        }
        return land;
    }
    public static boolean validation(int nx, int ny){
        if(0 <= nx && 0 <= ny && nx < row && ny < col) return true;
        return false;
    }
}
