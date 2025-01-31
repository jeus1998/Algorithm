package boj.workbook_8708;

/**
 * 영단어 암기는 괴로워 - 실버3
 */
import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class BOJ_20920 {
    public static void main(String[] args) throws IOException {
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         StringTokenizer st = new StringTokenizer(in.readLine());
         int n = Integer.parseInt(st.nextToken()); // 단어의 개수
         int m = Integer.parseInt(st.nextToken()); // 단어장 기준 길이
         HashMap<String, Integer> map = new HashMap<>();
         while (n --> 0){
             String cur = in.readLine();
             if(cur.length() < m) continue;
             map.put(cur, map.getOrDefault(cur, 0) + 1);
         }

         List<Map.Entry<String, Integer>> list = map.entrySet().stream()
                 .sorted((o1, o2)-> {
                     if(o1.getValue().compareTo(o2.getValue()) != 0){
                         return o2.getValue() - o1.getValue();
                     }
                     if(o1.getKey().length() != o2.getKey().length()){
                         return o2.getKey().length() - o1.getKey().length();
                     }
                     return o1.getKey().compareTo(o2.getKey());

                 }).collect(Collectors.toList());

         StringBuilder sb = new StringBuilder();
         for (Map.Entry<String, Integer> entry : list) {
            sb.append(entry.getKey()).append("\n");
         }
        System.out.println(sb);
    }
}
