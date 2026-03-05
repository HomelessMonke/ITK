package Homeless.monkey.com.tasks.concurrency.collections;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Task2 {
    static void main(String[] args) {
        String[] textArr = {"Java", "C#", "PHP",
                            "Java", "C#", "C#"};

        Map<String, Integer> elementsMap = elementsCountToMap(textArr);
        Set<Map.Entry<String, Integer>> entries = elementsMap.entrySet();
        entries.forEach(System.out::println);
    }

    static <T> Map<T,Integer> elementsCountToMap(T[] arr){
        Map<T, Integer> map = new HashMap<>();
        for (T element : arr)
            map.put(element, map.getOrDefault(element, 0) + 1);

        return map;
    }
}
