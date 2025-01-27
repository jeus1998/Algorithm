package boj.workbook_8708;

/**
 * 임스와 함께하는 미니게임 - 실버5
 */
import java.io.*;
import java.util.*;
public class BOJ_25757 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        String game = st.nextToken();

        Set<String> member = new HashSet<>();
        while (n-->0){
            member.add(br.readLine());
        }
        game(game, member.size());
    }
    public static void game(String game, int size){
        Map<String, Integer> map = Map.of("Y", 1, "F", 2, "O", 3);
        System.out.println(size / map.get(game));
    }
}