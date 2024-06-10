package boj.BarkingDog_Collection.String;

/**
 * 여우는 어떻게 울지?
 * 실버3
 */
import java.io.*;
import java.util.*;
public class BOJ9536 {
    static final String END = "what does the fox say?";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // 테스트 케이스 개수
        StringBuilder sb = new StringBuilder();
        while (t-->0){
            String sound = br.readLine();
            Set<String> animal = new HashSet<>();
            while (true){
                String input = br.readLine();
                if(input.equals(END)) break;
                String [] split = input.split(" ");
                animal.add(split[2]);
            }
            String [] split = sound.split(" ");
            for (String s : split) {
                if(animal.contains(s)) continue;
                sb.append(s).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
