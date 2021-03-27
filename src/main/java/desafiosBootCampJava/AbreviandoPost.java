package desafiosBootCampJava;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class AbreviandoPost {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 10000);

        while (true) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            List<String> textPost = new ArrayList<>();
            List<Optional<String>> textabrev2 = new ArrayList<>();
            Map<String, List<String>> textAbrev = new HashMap<String, List<String>>();
            Map<String, String> textAbrev3 = new HashMap<String, String>();
            Map<String, Long> textAbrev4 = new HashMap<String, Long>();
            Map<String, Long> textAbrev5 = new HashMap<String, Long>();

            while (st.hasMoreTokens()) {
                textPost.add(st.nextToken());
            }

            if (textPost.size() <= 0 || textPost.isEmpty())
                continue;
            if (textPost.get(0).equals("."))
                break;

            // textAbrev3.putAll(textPost.stream().filter(s -> (s.length() > 2 && !s.matches(".")))
            //         .sorted((p1, p2) -> p1.compareTo(p2)).collect(Collectors.groupingByConcurrent(String::toString,
            //                 ConcurrentSkipListMap::new, Collectors.joining("|"))));
            textAbrev4.putAll(textPost.stream().filter(s -> (s.length() > 2 && !s.matches(".")))
                    .sorted((p1, p2) -> p1.compareTo(p2)).collect(Collectors.groupingByConcurrent(String::toString,
                         Collectors.counting())));

                        textAbrev4.entrySet().stream().forEach(e ->  textAbrev5.put(e.getKey(), (e.getKey().length() * e.getValue())));

            System.out.println("TextAbrev5 " + textAbrev5);

            textAbrev.putAll(textAbrev3.values().stream().filter(s -> (s.length() > 2 && !s.matches(".")))
                    .collect(Collectors.groupingBy(o -> o.substring(0, 1))));

            System.out.println("TextAbrev " + textAbrev);        

            textAbrev.forEach((s, strings) -> textabrev2
                    .add(strings.stream().reduce((s1, s2) -> s1.length() > s2.length() ? s1 : s2)));


                    System.out.println("TextAbrev2 " + textabrev2);                    

            List<String> listWithoutNull = textabrev2.stream().flatMap(Optional::stream).collect(Collectors.toList());
            List<String> listWithoutNull2 = listWithoutNull.stream()
                    .map(mapper -> mapper.substring(0, mapper.indexOf("|"))).collect(Collectors.toList());


                    System.out.println("listWithoutNull " + listWithoutNull);       

                    System.out.println("listWithoutNull2 " + listWithoutNull2);                    
                  

            AtomicInteger finalCountAbrev = new AtomicInteger();

            Optional<String> finals = textPost.stream().map(s -> {
                if (listWithoutNull2.contains(s)) {
                    finalCountAbrev.getAndIncrement();
                    return s.substring(0, 1).concat(".");
                } else {
                    return s;
                }
            }).reduce((s, s2) -> s.concat(" ").concat(s2));

            System.out.println(finals.get());
            if (finalCountAbrev.intValue() >= 0) {
                System.out.println(textAbrev.size());
            }
            listWithoutNull2.forEach(s -> System.out.println(s.substring(0, 1).concat(". = ").concat(s)));

        }

    }

}
