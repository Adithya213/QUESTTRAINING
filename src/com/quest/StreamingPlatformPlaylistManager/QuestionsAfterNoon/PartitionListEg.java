package com.quest.StreamingPlatformPlaylistManager.QuestionsAfterNoon;
import java.util.ArrayList;
import java.util.List;

public class PartitionListEg {
    public static List<List<Integer>> partitionList(List<Integer> list, int n) {//list of integer and partition size
        List<List<Integer>> result = new ArrayList<>();//to store all sublist
        List<Integer> sublist = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {//loop through i/p list
            sublist.add(list.get(i));

            if (sublist.size() == n) {//when sublist reach partition
                result.add(sublist);
                sublist = new ArrayList<>();  // Create a new sublist for the next partition
            }
        }

        if (!sublist.isEmpty()) {//add remaining elements if sublist not empty
            result.add(sublist);
        }

        return result;
    }

    public static void main(String[] args) {
        List<Integer> input = new ArrayList<>();
        input.add(1);
        input.add(2);
        input.add(3);
        input.add(4);
        input.add(5);
        input.add(6);
        input.add(7);

        int partitionSize = 2;

        List<List<Integer>> output = partitionList(input, partitionSize);
        System.out.println(output);
    }
}




