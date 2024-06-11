package boj.BarkingDog_Collection.String;

/**
 * 팰린드롬 만들기
 * 실버3
 */
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class BOJ1213 {
    static final String result = "I'm Sorry Hansoo";
    static StringBuilder prefix = new StringBuilder();
    static StringBuilder suffix = new StringBuilder();
    static Queue<Character> q;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        ArrayList<Character> list = new ArrayList<>();
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < input.length(); i++) {
            list.add(input.charAt(i));
            map.put(input.charAt(i), map.getOrDefault(input.charAt(i), 0) + 1);
        }

        int size = map.values().stream().filter(o -> o % 2 == 1).collect(Collectors.toList()).size();

        if(input.length() % 2 == 1){
            if(size > 1){
                System.out.println(result);
                return;
            }
        }
        else{
            if(size > 0){
                System.out.println(result);
                return;
            }
        }
        Collections.sort(list);
        q = new LinkedList<>(list);
        BackTracking();
        String answer = null;
        if(q.isEmpty()){
            answer = prefix.toString() + suffix.reverse().toString();
        }
        else{
            answer = prefix.toString() + q.poll() + suffix.reverse().toString();
        }
        System.out.println(answer);
    }
    public static void BackTracking(){
        if(q.size() < 2) return;

        char cur = q.poll();
        if(q.peek() != cur){
            q.add(cur);
            BackTracking();
        }
        else{
            prefix.append(cur);
            suffix.append(q.poll());
            BackTracking();
        }
    }
}
