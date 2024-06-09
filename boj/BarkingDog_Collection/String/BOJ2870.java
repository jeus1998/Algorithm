package boj.BarkingDog_Collection.String;

/**
 * 수학 문제
 * 실버4
 */
import java.util.*;
import java.io.*;
public class BOJ2870 {
    static ArrayList<String> list;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        list = new ArrayList<>();
        while (n-->0){
            String input = br.readLine();
            StringBuilder temp = new StringBuilder();
            for (int i = 0; i < input.length(); i++) {
                if('a' <= input.charAt(i) && input.charAt(i) <= 'z'){ // 알파벳 소문자
                    if(temp.length() > 0){
                        converter(temp.toString());
                    }
                    temp.setLength(0);
                }
                else if(i == input.length() - 1){
                    if('a' > input.charAt(i) || input.charAt(i) > 'z'){
                        temp.append(input.charAt(i));
                    }
                    if(temp.length() > 0){
                        converter(temp.toString());
                    }
                }
                else temp.append(input.charAt(i));
            }
        }
        Collections.sort(list, (o1,o2)->{
            if(o1.length()!=o2.length()) return o1.length()-o2.length();
            else{
                for (int i = 0; i < o1.length(); i++) {
                    if(o1.charAt(i)!= o2.charAt(i)){
                        return o1.charAt(i) - o2.charAt(i);
                    }
                }
                return 0;
            }
        });

        StringBuilder sb = new StringBuilder();
        for (String s : list) {
            sb.append(s).append("\n");
        }
        System.out.println(sb);
    }
    public static void converter(String check){
        StringBuilder sb = new StringBuilder();
        boolean flag = true;
        for (int i = 0; i < check.length(); i++) {
            if(flag && check.charAt(i) == '0') continue;
            sb.append(check.charAt(i));
            flag = false;
        }

        if(flag) list.add("0");
        else list.add(sb.toString());
    }
}
