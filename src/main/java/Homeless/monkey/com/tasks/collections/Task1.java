package Homeless.monkey.com.tasks.collections;

import java.util.Arrays;

public class Task1 {
    public static void main(String[] args) {
        Integer[] arr = {2,3,4,5};

        Filter<Integer> doubleInteger = n -> n*2;
        Integer[] filteredArr = filter(arr, doubleInteger);
        for (Integer element : filteredArr) {
            System.out.println(element);
        }
    }

    static <T> T[] filter(T[] arr, Filter<T> filter){
        return Arrays.stream(arr)
                .map(filter::apply)
                .toArray(size -> Arrays.copyOf(arr, size));
    }
}
