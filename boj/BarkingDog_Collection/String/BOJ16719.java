package boj.BarkingDog_Collection.String;

/**
 * ZOAC
 * 골드5
 */
import java.io.*;
import java.util.*;
public class BOJ16719 {
    static boolean [] visited;
    static char [] init;
    static int size;
    static Map<Integer, String> map = new HashMap<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        size = input.length();

        init = new char[size];
        for (int i = 0; i < size; i++) {
            init[i] = input.charAt(i);
        }

        visited = new boolean[size];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            BackTracking();
            Map.Entry<Integer, String> entry = map.entrySet().stream().min(
                    (o1,o2)->{
                        if(!o1.getValue().equals(o2.getValue())){
                            return o1.getValue().compareTo(o2.getValue());
                        }
                        return o1.getKey() - o2.getKey();
                    }
            ).get();
            map.clear();
            sb.append(entry.getValue()).append("\n");
            visited[entry.getKey()] = true;
        }
        System.out.println(sb);
    }
    public static void BackTracking(){
        for (int i = 0; i < size; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            String cur = "";
            for (int j = 0; j < size; j++) {
                if(visited[j]) cur += init[j];
            }
            map.put(i, cur);
            visited[i] = false;
        }
    }
}
