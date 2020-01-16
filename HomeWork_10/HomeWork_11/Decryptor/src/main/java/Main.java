
import one.util.streamex.*;
import one.util.*;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static one.util.streamex.IntStreamEx.of;

public class Main {
    public static void main(String[] args) {

        System.out.println(decipherWithStreams("taiaiaertkixquxjnfxxdh"));


    }

    static String decipherWithStreams(String message) {

        StringBuilder sb = new StringBuilder(message);
        int[] arr =  sb
                .reverse()
                .toString()
                .chars()
                .map(i -> i - 97)
                .toArray();

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
        }

        list =  StreamEx.of(list)
                .pairMap((current, next) -> (current + 26 - next) % 26)
                .append(arr[arr.length - 1])
                .collect(Collectors.toList());

        sb = new StringBuilder();
        for (Integer i: list){
            sb.append((char)(i + 49 + '0'));
        }
        return sb.reverse().toString();
    }
}
