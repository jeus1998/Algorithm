package boj.workbook_8708;

/**
 * 가희와 키워드 - 실버3
 */
import java.io.*;
import java.util.*;
public class BOJ_22233 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 키워드 개수
        int m = Integer.parseInt(st.nextToken()); // 블로그 글의 개수
        Set<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(br.readLine());
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
           String [] split =  br.readLine().split(",");
            for (String s : split) {
                set.remove(s);
            }
            sb.append(set.size()).append("\n");
        }
        System.out.println(sb);
    }
}
/**

 지금까지 메모장에 써진 키워드는 모두 서로 다르며, 총 N개가 존재합니다.
 가희는 새로운 글을 작성할 때, 최대 10개의 키워드에 대해서 글을 작성합니다.
 이 키워드들 중에 메모장에 있었던 키워드는 가희가 글을 쓴 이후, 메모장에서 지워지게 됩니다.

 5 2
 map
 set
 dijkstra
 floyd
 os
 map,dijkstra
 map,floyd

 set, floyd, os -> 3

 set, os -> 2

 */