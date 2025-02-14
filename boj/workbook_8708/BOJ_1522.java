package boj.workbook_8708;

/**
 * 문자열 교환 - 실버1
 */
import java.io.*;
import java.util.*;
public class BOJ_1522 {
    static int min = Integer.MAX_VALUE;
    static int a_count, b_count;
    static int [] memo;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        memo = new int[input.length()];      // a = 0 b = 1
        for (int i = 0; i < input.length(); i++) {
            if(input.charAt(i) == 'a'){
                a_count++;
                continue;
            }
            b_count++;
            memo[i] = 1;
        }
        model4();
        if(min == 0){
            System.out.println(min);
            return;
        }
        model3();
        if(min == 0){
            System.out.println(min);
            return;
        }
        model2();
        if(min == 0){
            System.out.println(min);
            return;
        }
        model1();
        System.out.println(min);
    }
    public static void checkMemo(LinkedList<Integer> check){
        int cnt = 0;
        for (int i = 0; i < a_count + b_count; i++) {
            if(memo[i] != check.get(i)) cnt++;
        }
        min = Math.min(min, cnt / 2);
    }
    public static void model1(){
        LinkedList<Integer> check = new LinkedList<>();
        for (int i = 0; i < b_count; i++) {
            check.add(1);
        }
        check.addFirst(0);
        for (int i = 0; i < a_count - 1; i++) {
            check.addLast(0);
        }
        while (check.peekLast() != 1){
            checkMemo(check);
            check.addFirst(check.pollLast());
        }
    }
    public static void model2(){
        LinkedList<Integer> check = new LinkedList<>();
        for (int i = 0; i < a_count; i++) {
            check.add(0);
        }
        check.addFirst(1);
        for (int i = 0; i < b_count - 1; i++) {
            check.addLast(1);
        }
        while (check.peekLast() != 0){
            checkMemo(check);
            check.addFirst(check.pollLast());
        }

    }
    public static void model3(){
        int cnt = 0;
        for (int i = 0; i < a_count; i++) {
            if(memo[i] != 0) cnt++;
        }
        for (int i = a_count; i < b_count + a_count; i++) {
            if(memo[i] != 1) cnt++;
        }
        min = Math.min(min, cnt / 2);
    }
    public static void model4(){
        int cnt = 0;
        for (int i = 0; i < b_count; i++) {
            if(memo[i] != 1) cnt++;
        }
        for (int i = b_count; i < a_count + b_count; i++) {
            if(memo[i] != 0) cnt++;
        }
        min = Math.min(min, cnt / 2);
    }
}
/*
1) model abbbaa: a side b mid

2) model bbaabb: a mid b side

3) model aaabbb: a left b right

4) model bbbaaa: a right b left
 */