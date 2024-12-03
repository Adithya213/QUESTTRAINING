package com.quest.StreamingPlatformPlaylistManager.QuestionsAfterNoon;
import java.util.*;

public class GroupByFrequency {
    public static Map<Integer, List<Integer>> groupByFrequency(List<Integer> numbers) {
        //key - frequency , value - list of integer appear with frequency

        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : numbers) {//loop through i/p list
            if (frequencyMap.containsKey(num)) {//if already present
                frequencyMap.put(num, frequencyMap.get(num) + 1);//increrment value by 1
            } else {
                frequencyMap.put(num, 1);
            }
        }

        //group numbers by their frequency
        Map<Integer, List<Integer>> result = new HashMap<>();
        for (int num : frequencyMap.keySet()) {//loop through freq map
            int frequency = frequencyMap.get(num);

            if (!result.containsKey(frequency)) {//if freq not in result map
                result.put(frequency, new ArrayList<>());
            }
            result.get(frequency).add(num);
        }

        return result;
    }

    public static void main(String[] args) {
        List<Integer> input = new ArrayList<>();
        input.add(1);
        input.add(2);
        input.add(2);
        input.add(3);
        input.add(3);
        input.add(3);

        Map<Integer, List<Integer>> output = groupByFrequency(input);// Call the method
        System.out.println(output);
    }
}



