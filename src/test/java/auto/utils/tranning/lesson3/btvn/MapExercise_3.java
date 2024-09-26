package auto.utils.tranning.lesson3.btvn;

import java.util.Map;

public class MapExercise_3 {
    public static boolean containsKey(Map<String, Integer> map, String key) {
        return map.containsKey(key);
    }

    public static void main(String[] args) {
        Map<String, Integer> myMap = Map.of("A", 1, "B", 2, "C", 3);

        String searchKey = "B";
        System.out.println("Does key '" + searchKey + "' exist? " + containsKey(myMap, searchKey));
    }
}


