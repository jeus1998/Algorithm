package boj.workbook_8708;

/**
 * 주유소 - 실버3
 */
import java.util.*;
import java.io.*;
public class BOJ_13305 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());

        int [] city = new int[n+1];   // city[x] = 해당 도시 주유소의 리터당 가격
        int [] distance = new int[n]; // distance[x] = x -> x + 1 거리

        StringTokenizer st;
        st = new StringTokenizer(in.readLine());
        for (int i = 1; i < n; i++) {
            distance[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(in.readLine());
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            city[i] = Integer.parseInt(st.nextToken());
            if(city[i] > min) city[i] = min;
            if(city[i] < min) min = city[i];
        }
        long sum = 0;
        for (int i = 1; i < n; i++) {
            sum += distance[i] * (long) city[i];
        }
        System.out.println(sum);
    }
}
/**

왼쪽 -> 오른쪽 이동하면서 최솟값 기록하기


 */