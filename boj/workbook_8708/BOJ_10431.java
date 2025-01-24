package boj.workbook_8708;

/**
 * 줄세우기 - 실버5
 */
import java.io.*;
import java.util.*;
public class BOJ_10431  {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            int [] input = new int [20];
            StringTokenizer st = new StringTokenizer(br.readLine());
            st.nextToken();
            for (int j = 0; j < 20; j++) {
                input[j] = Integer.parseInt(st.nextToken());
            }
            int answer = 0;
            int [] array = new int[20];

            for (int j = 0; j < 20; j++) {
                int idx = -1;
                int target = input[j];
                for (int k = 0; k < j; k++) {
                    if(target < array[k]){
                        idx = k;
                        break;
                    }
                }
                if(idx == -1){
                    array[j] = target;
                    continue;
                }
                answer += j - idx;
                int temp = target;
                for (int k = idx; k <= j; k++) {
                    int tmp = array[k];
                    array[k] = temp;
                    temp = tmp;
                }
            }
            sb.append(i).append(" ").append(answer).append("\n");
        }

        System.out.println(sb);
    }
}
