package boj.workbook_8708;

/**
 * 단어 공부 - 브론즈1
 */
import java.util.*;
import java.util.stream.*;
public class BOJ_1157 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next().toUpperCase();

        if(input.length() == 1){
            System.out.println(input);
            return;
        }

        HashMap<Character, Integer> memo = new HashMap<>();
        for (Character next : input.toCharArray()){
            memo.put(next, memo.getOrDefault(next, 0) + 1);
        }
        List<Map.Entry<Character, Integer>> collect = memo
                .entrySet()
                .stream()
                .sorted((o1, o2) -> {
                        return o2.getValue() - o1.getValue();})
                .collect(Collectors.toList());

        if(collect.size() == 1){
            System.out.println(collect.get(0).getKey());
            return;
        }

        if(collect.get(0).getValue().compareTo(collect.get(1).getValue()) == 0){
            System.out.println("?");
            return;
        }
        System.out.println(collect.get(0).getKey());

        // System.out.println(Integer.valueOf(500) == Integer.valueOf(500));
    }
}
