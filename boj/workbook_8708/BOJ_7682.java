package boj.workbook_8708;

/**
 * 틱택토 - 골드5
 */
import java.io.*;
import java.util.*;
public class BOJ_7682 {
    static final String INVALID = "invalid";
    static final String VALID = "valid";
    static final String END = "end";
    static HashSet<String> list = new HashSet<>();
    static int [][] map = new int [3][3];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        fun(1, 0);
        while (true){
            String input = br.readLine();
            if(input.equals(END)) break;
            if(list.contains(input)){
                sb.append(VALID).append("\n");
                continue;
            }
            sb.append(INVALID).append("\n");
        }
        System.out.println(sb);
    }
    // turn: 1 = x, 2 = o
    public static void fun(int turn, int cnt){
        if(cnt == 9){
            make();
            return;
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(map[i][j] != 0) continue;
                map[i][j] = turn;
                if(check()) fun(turn == 1 ? 2 : 1, cnt + 1);
                map[i][j] = 0;
            }
        }
    }
    // 빙고가 나왔는지 체크
    public static boolean check(){
        boolean global = true;
        // 가로 체크
        for (int i = 0; i < 3; i++) {
            if(map[i][0] == 0) continue;
            boolean flag = true;
            for (int j = 1; j < 3; j++) {
                if(map[i][0] == map[i][j]) continue;
                flag = false;
            }
            if(flag) global = false;
        }
        // 세로 체크
        for (int i = 0; i < 3; i++) {
            if(map[0][i] == 0) continue;
            boolean flag = true;
            for (int j = 1; j < 3; j++) {
                if(map[0][i] == map[j][i]) continue;
                flag = false;
            }
            if(flag) global = false;
        }
        // 대각선 체크
        if(map[0][0] != 0){
            if(map[0][0] == map[1][1] && map[1][1] == map[2][2]) global = false;
        }
        if(map[0][2] != 0){
            if(map[0][2] == map[1][1] && map[1][1] == map[2][0]) global = false;
        }

        if(!global) make();
        return global;
    }
    public static void make(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(map[i][j] == 0){
                    sb.append(".");
                }
                else if(map[i][j] == 1){
                    sb.append("X");
                }
                else sb.append("O");
            }
        }
        list.add(sb.toString());
    }
}
/*
XXO
OOX
XOX
 */