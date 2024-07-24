package programmers2.level2;

/**
 * 양궁대회
 */
import java.util.*;
public class PR_92342 {
    static int [] infor;
    static boolean win = false; // 라이언이 이기는 경우가 있는 경우 true
    static int [] memo;   // 백트래킹용 배열
    static int [] answer; // 정답 return
    static int max;
    public int[] solution(int n, int[] info) {

        // 매개변수 -> static
        infor = Arrays.copyOf(info, 11);

        memo   = new int [11];
        answer = new int [11];
        bt(0, 0, n, 10); // 우승 방법이 여러 가지 일 경우 가장 낮은 점수 많이

        if(win) return answer;

        return new int [] {-1};
    }
    // 백트래킹 sc1:라이언 sc2: 어피치 n: 화살개수 depth: 점수
    public static void bt(int sc1, int sc2, int n, int depth){
        if(depth == -1){
            if(n == 0 && sc1 - sc2 > max){
                win = true;
                max = sc1 - sc2;
                answer = Arrays.copyOf(memo, 11);
            }
            return;
        }

        for(int i = n; i >= 0; i--){ // 낮은 점수를 가장 많이
            if(i == 0){
                if(infor[depth] == 0){
                    bt(sc1, sc2, n, depth - 1);
                }
                else{
                    bt(sc1, sc2 + 10 - depth, n, depth - 1);
                }
            }
            else{
                if(infor[depth] >= i){ // 어피치가 점수 획득
                    memo[depth] = i;
                    bt(sc1, sc2 + 10 - depth, n - i, depth - 1);
                    memo[depth] = 0;
                }
                else{
                    memo[depth] = i;
                    bt(sc1 + 10 - depth, sc2, n - i, depth - 1);
                    memo[depth] = 0;
                }
            }
        }
    }
}
