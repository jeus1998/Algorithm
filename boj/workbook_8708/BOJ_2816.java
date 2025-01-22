package boj.workbook_8708;

/**
 * 디지털 티비 - 브론즈1
 * 최적의해를 찾아야 하는가?
 */
import java.io.*;
public class BOJ_2816 {
    private static final String KBS1 = "KBS1";
    private static final String KBS2 = "KBS2";
    private static StringBuilder sb = new StringBuilder(); // 리모컨 기록
    private static String [] ch;  // 채널 리스트
    private static int cur = 0;   // 커서
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ch = new String [n];
        for (int i = 0; i < n; i++) {
            ch[i] = br.readLine();
        }
        // System.out.println(Arrays.toString(ch));
        move(KBS1, 0);
        // System.out.println(Arrays.toString(ch));
        move(KBS2, 1);
        // System.out.println(Arrays.toString(ch));

        System.out.println(sb);
    }
    public static void move(String target, int destination){
        int current = find(target);
        while (true){
            if(current == destination) return;
            if(cur < current){
                fun1();
            }
            else{
                fun4();
                current--;
            }
        }
    }
    public static int find(String target){
        for (int i = 0; i < ch.length; i++) {
            if(ch[i].equals(target)) return i;
        }
        return -1;
    }
    public static void fun1(){
        cur++;
        sb.append(1);
    }
    public static void fun2(){
        cur--;
        sb.append(2);
    }
    public static void fun3(){
        String memo = ch[cur];
        ch[cur] = ch[cur + 1];
        ch[cur + 1] = memo;
        cur++;
        sb.append(3);
    }
    public static void fun4(){
        String memo = ch[cur];
        ch[cur] = ch[cur - 1];
        ch[cur - 1] = memo;
        cur--;
        sb.append(4);
    }
}