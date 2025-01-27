package boj.workbook_8708;

/**
 * 등수 구하기 - 실버4
 */
import java.io.*;
import java.util.*;
public class BOJ_1205 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        // 0 <= n <= p(10~50) 리스트에 있는 n개의 점수
        int n = Integer.parseInt(st.nextToken());
        int score = Integer.parseInt(st.nextToken()); // 태수 점수
        // 10 <= p <= 50 랭킹 리스트에 올라 갈 수 있는 점수의 개수
        int p = Integer.parseInt(st.nextToken());

        ArrayList<Integer> list = new ArrayList<>();
        if(n == 0){
            System.out.println(1);
            return;
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        // 랭킹 리스트에 올라갈 수 없을 정도로 낮다
        if(p == n && list.get(n - 1) >= score){
            System.out.println(-1);
            return;
        }

        list.add(score);
        Collections.sort(list, Collections.reverseOrder());

        int rank = 1;
        int before = list.get(0);

        if(before == score){
            System.out.println(1);
            return;
        }

        for (int i = 1; i < n + 1; i++) {
            if(before > list.get(i)){
                before = list.get(i);
                rank = i + 1;
            }
            if(list.get(i) == score){
                System.out.println(rank);
                return;
            }
        }
    }
}
