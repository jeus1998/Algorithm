package boj.workbook_8708;

/**
 * 컨베이어 벨트 위의 로봇 - 골드5
 */
import java.io.*;
import java.util.*;
public class BOJ_20055 {
    static int n, k, count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken()); // 내구도 0 종료 조건

        // 로봇은 올리는 위치(1)에만 올릴 수 있다. 언제든지 로봇이 내리는 위치(n)에 도달하면 그 즉시 내린다.
        // 로봇을 올리거나 이동하면 내구도 즉시 1만큼 감소(이동한 칸, 올리는 위치 0)

        int [] belt = new int[2 * n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n * 2; i++) {
            belt[i] = Integer.parseInt(st.nextToken());
        }
        // 로봇 존재 여부 체크
        boolean [] robot = new boolean[n];
        // 로봇 순서, 위치
        Queue<Integer> queue = new LinkedList<>();
        int level = 0; // 단계
        count = 0; // 내구도가 0인 벨트 개수
        while (true){
            level++;
            move1(belt, queue, robot);
            move2(belt, queue, robot);

            if(belt[0] > 0){
                if(--belt[0] == 0) count++;
                queue.add(0);
            }

            if(count >= k) break;
        }
        System.out.println(level);
    }
    public static void move2(int [] belt, Queue<Integer> queue, boolean[] robot) {
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            int cur = queue.poll();
            robot[cur] = false;
            // 이동하려는 칸에 로봇 x, 내구도 1이상
            if(!robot[cur + 1] && belt[cur + 1] >=1){
                // 내구도 줄이면서 0인지 확인
                if(--belt[cur+1] == 0) count++;
                // 내리는 위치인지 확인
                if(cur + 1 != n - 1){
                    robot[cur + 1] = true;
                    queue.add(cur + 1);
                }
            }
            else{
                robot[cur] = true;
                queue.add(cur);
            }
        }
    }
    public static void move1(int [] belt, Queue<Integer> queue, boolean[] robot) {
        // 벨트 내구도 이동
        int temp = belt[n * 2 - 1];
        for(int i = 0; i < belt.length; i++) {
             int temp2 = belt[i];
             belt[i] = temp;
             temp = temp2;
        }

        // 로봇 위치 기록 초기화
        Arrays.fill(robot, false);

        // 로봇 이동
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            int cur = queue.poll();
            // 내리는 위치면 나가기
            if(cur + 1 == n - 1){
                continue;
            }
            robot[cur + 1] = true;
            queue.add(cur + 1);
        }
    }
}
