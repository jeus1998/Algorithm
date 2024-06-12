package boj.BarkingDog_Collection.String;

/**
 * 시그널
 * 실버1
 */
import java.io.*;
import java.util.*;
public class BOJ16113_2 {
    static String [] memo;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = n / 5;

        String input = br.readLine();

        char[][] signal = new char[5][m];

        int cnt = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < m; j++) {
                signal[i][j] = input.charAt(cnt++);
            }
        }
        init();
        StringBuilder sb = new StringBuilder();
        StringBuilder tp = new StringBuilder();
        boolean [] visited = new boolean[m];
        for (int i = 0; i < m; i++) {
            if(visited[i] || signal[0][i] == '.') continue;
            int answer = -1;
            boolean check = true;
            if(i + 2 < m){
                for (int j = 0; j < 5; j++) {
                    for (int k = i; k < i + 3; k++) {
                        tp.append(signal[j][k]);
                    }
                }
                String result = tp.toString();
                tp.setLength(0);
                for (int j = 0; j < 10; j++) {
                    if(memo[j].equals(result)){
                        answer = j;
                        break;
                    }
                }
                if(answer!= -1){
                    sb.append(answer);
                    if(answer != 1){
                        visited[i+1] = true;
                        visited[i+2] = true;
                    }
                    check = false;
                }
            }
            // 1 검사하기
            if(check){
                for (int j = 0; j < 5; j++) {
                    tp.append(signal[j][i]);
                }
                if(tp.toString().equals(memo[1])){
                    sb.append(1);
                }
            }
            tp.setLength(0);
        }
        System.out.println(sb);
    }
    public static void init(){
        memo = new String[]{
                "####.##.##.####",
                "#####",
                "###..#####..###",
                "###..####..####",
                "#.##.####..#..#",
                "####..###..####",
                "####..####.####",
                "###..#..#..#..#",
                "####.#####.####",
                "####.####..####"
        };
    }
}
