package boj.workbook_8708;

/**
 *  올림픽 - 실버5
 */
import java.io.*;
import java.util.*;
public class BOJ_8979 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 나라의 수
        int k = Integer.parseInt(st.nextToken()); // 알고싶은 나라

        ArrayList<int[]> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int [] input = new int[4];
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                input[j] = Integer.parseInt(st.nextToken());
            }
            list.add(input);
        }

        Collections.sort(list, (o1, o2) -> {
            if(o1[1] != o2[1]) return o2[1] - o1[1];
            else if(o1[2] != o2[2]) return o2[2] - o1[2];
            else if(o1[3] != o2[3]) return o2[3] - o1[3];
            return 0;
        });

        if(list.get(0)[0] == k){
            System.out.println(1);
            return;
        }

        int rank = 1;
        int temp = 1;
        for (int i = 1; i < list.size(); i++) {
            int [] before = list.get(i - 1);
            int [] cur = list.get(i);

            if(before[1] == cur[1] && before[2] == cur[2] && before[3] == cur[3]){
                temp++;
            }
            else{
                rank += temp;
                temp = 1;
            }

            if(cur[0] == k){
                System.out.println(rank);
                return;
            }
        }
    }
}
