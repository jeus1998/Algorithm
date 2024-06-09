package boj.BarkingDog_Collection.String;

/**
 * DNA
 * 실버4
 */
import java.io.*;
import java.util.*;
public class BOJ1969 {
    static String [] dna;
    static int n,m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        dna = new String[n];
        for (int i = 0; i < n; i++) {
            dna[i] = br.readLine();
        }

        HashMap<Character, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char cur = dna[j].charAt(i);
                map.put(cur, map.getOrDefault(cur, 0) + 1);
            }
            int max = map.values().stream()
                    .max((o1, o2) -> {
                        return o1 - o2;
                    }).get();

            Map.Entry<Character, Integer> entry = map.entrySet().stream().filter(o -> o.getValue() == max)
                    .min((o1, o2) -> {
                        return o1.getKey() - o2.getKey();
                    }).get();

            sb.append(entry.getKey());

            for (int j = 0; j < n; j++) {
                if(dna[j].charAt(i) != entry.getKey()){
                    cnt++;
                }
            }
            map.clear();
        }
        System.out.println(sb);
        System.out.println(cnt);
    }
}
