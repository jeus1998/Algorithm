package programmers.level3;
/**
 * 이중우선순위큐
 * heap
 * level3
 */

import java.util.*;
public class DoublePriorityQueue {
    public int[] solution(String[] operations) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(String action : operations){
            String [] split = action.split(" ");
            if(split[0].equals("I")){
                int input = Integer.parseInt(split[1]);
                map.put(input, map.getOrDefault(input ,0) + 1);
            }
            else{
                if(map.isEmpty()) continue;

                if(split[1].equals("1")){
                    int target = map.lastKey();
                    if(map.get(target) == 1){
                        map.remove(Integer.valueOf(target));
                    }
                    else map.put(target, map.get(target) - 1);
                }
                else{
                    int target = map.firstKey();
                    if(map.get(target) == 1){
                        map.remove(Integer.valueOf(target));
                    }
                    else map.put(target, map.get(target) - 1);
                }
            }
        }
        if(map.isEmpty())
            return new int []{0,0};

        return new int []{map.lastKey(), map.firstKey()};

    }
}
