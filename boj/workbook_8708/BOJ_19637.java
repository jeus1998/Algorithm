package boj.workbook_8708;

/**
 * IF문 좀 대신 써줘 - 실버3
 */
import java.io.*;
import java.util.*;
public class BOJ_19637 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 칭호의 개수
        int m = Integer.parseInt(st.nextToken()); // 캐릭터의 개수
        HashMap<Integer, String> map = new HashMap<>();
        int [] marks = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String word = st.nextToken();
            int cost = Integer.parseInt(st.nextToken());
            if(!map.containsKey(cost)) {
                map.put(cost, word);
            }
            marks[i] = cost;
        }
        StringBuilder sb = new StringBuilder();
        while (m --> 0){
            int input = Integer.parseInt(br.readLine());
            int start = 0;
            int end   = n - 1;
            while (start < end){
                int mid = (start+end)/2;
                if(marks[mid] < input){
                    start = mid + 1;
                }
                else end = mid;
            }
            sb.append(map.get(marks[start])).append("\n");
        }
        System.out.println(sb);
    }
}