package boj.workbook_8708;

/**
 * 삼각형과 세 변 - 브론즈 3
 *
 */
import java.util.*;
import java.io.*;
public class BOJ_5073 {
    public static final String INVALID = "Invalid";
    public static final String EQUILATERAL = "Equilateral";
    public static final String ISOSCELES = "Isosceles";
    public static final String SCALENE = "Scalene";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int [] memo = new int [3];
        StringBuilder sb = new StringBuilder();
        while (true){
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 3; i++) {
                memo[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(memo);
            if(memo[2] == 0) break;
            if(memo[2] >= memo[0] + memo[1]) sb.append(INVALID);
            else if(memo[0] == memo[2]) sb.append(EQUILATERAL);
            else if(memo[0] != memo[1] && memo[0] != memo[2] && memo[1] != memo[2]) sb.append(SCALENE);
            else sb.append(ISOSCELES);
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
/*
Equilateral :  세 변의 길이가 모두 같은 경우
Isosceles : 두 변의 길이만 같은 경우
Scalene : 세 변의 길이가 모두 다른 경우
가장 긴 변의 길이 >= 나머지 두 변의 길이의 합 -> Invalid
 */