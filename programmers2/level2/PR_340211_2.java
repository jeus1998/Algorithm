package programmers2.level2;

/**
 * [PCCP 기출문제] 3번 / 충돌위험 찾기
 */
import java.util.*;
public class PR_340211_2 {
    public static void main(String[] args) {

    }
    static Queue<int[]>[] memo;
    static int [][] points;
    static int answer = 0;
    public int solution(int[][] points, int[][] routes) {
        this.points = points;
        memo = new LinkedList[routes.length];
        for (int i = 0; i < routes.length; i++) {
            memo[i] = new LinkedList<>();
        }
        func1(routes);
        func2();
        return answer;
    }
    public static void func2(){
        while(true){
            int [][] map = new int [101][101];
            int cnt = 0;
            for (int j = 0; j < memo.length; j++) {
                if(memo[j].isEmpty()) continue;
                int[] cur = memo[j].poll();
                if(++map[cur[0]][cur[1]] == 2){
                    answer++;
                }
                cnt++;
            }
            if(cnt == 0) break;
        }
    }
    public static void func1(int [][] routes){
        int n = routes.length;
        int m = routes[0].length;
        for (int i = 0; i < n; i++) {
            int cur_x = points[routes[i][0] - 1][0];
            int cur_y = points[routes[i][0] - 1][1];
            memo[i].add(new int [] {cur_x, cur_y});
            for (int j = 1; j <= m - 1; j++) {
                int enx_x = points[routes[i][j] - 1][0];
                int enx_y = points[routes[i][j] - 1][1];
                while (cur_x != enx_x || cur_y != enx_y) {
                    if(cur_x != enx_x){
                        if(cur_x > enx_x){
                            cur_x--;
                        }
                        else{
                            cur_x++;
                        }
                        memo[i].add(new int [] {cur_x, cur_y});
                        continue;
                    }
                    if(cur_y > enx_y){
                        cur_y--;
                    }
                    else{
                        cur_y++;
                    }
                    memo[i].add(new int [] {cur_x, cur_y});
                }
            }
        }
    }
}
/*
물류 센터에는 (r, c)와 같이 2차원 좌표로 나타낼 수 있는 n개의 포인트가 존재합니다.
각 포인트는 1~n까지의 서로 다른 번호를 가집니다.

로봇마다 정해진 운송 경로가 존재합니다.
운송 경로는 m개의 포인트로 구성되고 로봇은 첫 포인트에서 시작해 할당된 포인트를 순서대로 방문합니다.

운송 시스템에 사용되는 로봇은 x대이고, 모든 로봇은 0초에 동시에 출발합니다.
로봇은 1초마다 r 좌표와 c 좌표 중 하나가 1만큼 감소하거나 증가한 좌표로 이동할 수 있습니다.

다음 포인트로 이동할 때는 항상 최단 경로로 이동하며 최단 경로가 여러 가지일 경우,
r 좌표가 변하는 이동을 c 좌표가 변하는 이동보다 먼저 합니다.

마지막 포인트에 도착한 로봇은 운송을 마치고 물류 센터를 벗어납니다.
로봇이 물류 센터를 벗어나는 경로는 고려하지 않습니다.

이동 중 같은 좌표에 로봇이 2대 이상 모인다면 충돌할 가능성이 있는 위험 상황으로 판단합니다.
관리자인 당신은 현재 설정대로 로봇이 움직일 때 위험한 상황이 총 몇 번 일어나는지 알고 싶습니다.
만약 어떤 시간에 여러 좌표에서 위험 상황이 발생한다면 그 횟수를 모두 더합니다.
 */