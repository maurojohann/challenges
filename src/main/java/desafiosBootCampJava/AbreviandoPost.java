package desafiosBootCampJava;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class AbreviandoPost {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 10000);

        String key = "";
        Long num = null;

        while (true) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            List<String> textPost = new ArrayList<>();
            List<Optional<String>> textabrev2 = new ArrayList<>();

            List<Map<String, Long>> textabrev7 = new ArrayList<>();

            Map<String, List<String>> textAbrev = new HashMap<String, List<String>>();
            Map<String, Long> textAbrevs = new HashMap<String, Long>();
            Map<String, String> textAbrev3 = new HashMap<String, String>();
            Map<String, Long> textAbrev4 = new HashMap<String, Long>();
            Map<String, Long> textAbrev5 = new HashMap<String, Long>();
            Map<String, Long> textAbrev13 = new HashMap<String, Long>();
            Map<String, Map<String, Long>> textAbrev6 = new HashMap<String, Map<String, Long>>();
            Map<String, Long> textAbrev12 = new HashMap<String, Long>();
            Map<String, List<String>> textAbrev8 = new HashMap<String, List<String>>();
            Map<String, Optional<Map.Entry<String, Long>>> textAbrev9 = new HashMap<String, Optional<Map.Entry<String, Long>>>();
            Map<String, Optional<Object>> textAbrev10 = new HashMap<String, Optional<Object>>();

            while (st.hasMoreTokens()) {
                textPost.add(st.nextToken());
            }

            if (textPost.size() <= 0 || textPost.isEmpty())
                continue;
            if (textPost.get(0).equals("."))
                break;

            // textAbrev3.putAll(textPost.stream().filter(s -> (s.length() > 2 &&
            // !s.matches(".")))
            // .sorted((p1, p2) ->
            // p1.compareTo(p2)).collect(Collectors.groupingByConcurrent(String::toString,
            // ConcurrentSkipListMap::new, Collectors.joining("|"))));
            textAbrev4.putAll(textPost.stream().filter(s -> (s.length() > 2 && !s.matches(".")))
                    .sorted((p1, p2) -> p1.compareTo(p2))
                    .collect(Collectors.groupingByConcurrent(String::toString, Collectors.counting())));

            // System.out.println("TextAbrev4 " + textAbrev4);

            textAbrev4.entrySet().stream().forEach(
                    e -> textAbrev5.put(e.getKey(), (e.getKey().length() * e.getValue()) - (2 * e.getValue())));

            System.out.println("TextAbrev5 " + textAbrev5);

            List<String> kes = new ArrayList<>();
            while(textAbrev5.entrySet().iterator().hasNext()){

            
            kes.add(textAbrev5.entrySet().iterator().next().getKey());
            textAbrev5.entrySet().iterator().next();}

               System.out.print(kes);

            // textAbrev13.putAll((Map<? extends String, ? extends Long>)
            // textAbrev5.entrySet().stream().sorted((p1, p2) ->
            // p1.getKey().substring(0,1).compareTo(p2.getKey().substring(0,1))));

            //textAbrev5.entrySet().stream().filter()
            // textAbrev5.forEach((keys, longs) -> textAbrevs.put(keys.stream().reduce()));

            System.out.println("TextAbrevs13 " + textAbrev13);


            // Map<Object,List<Long>> asda =new HashMap<Object,List<Long>>();
            // asda.putAll(textAbrev5.entrySet().stream().filter(s -> (s.getKey()length() > 2 &&
            // !s.matches(".")))
            // .collect(Collectors.groupingBy(o -> o.substring(0, 1))));

            // textAbrev.putAll(textAbrev5.entrySet().stream().filter(s ->
            // s.getKey().substring(0 ,1). ).collect(Collectors.groupingBy(o ->
            // o.substring(0, 1))));

            // textAbrev5.entrySet().forEach(a-> System.out.println(a.getValue()));

            String tsextAbrev13 = Collections.max(textAbrev5.entrySet(), Map.Entry.comparingByValue()).getKey();

            System.out.println(tsextAbrev13);

            // textAbrev13 =

            System.out.println("TextAbrev " + textAbrev);

            // textAbrev.forEach((s, strings) -> textabrev2
            // .add(strings.stream().reduce((s1, s2) -> s1.length() > s2.length() ? s1 :
            // s2)));

            textAbrev6.forEach((s, strings) -> textAbrev10.put(s, strings.entrySet().stream()
                    .max((i, j) -> i.getValue().compareTo(j.getValue())).map(mapper -> mapper.getKey())));

            System.out.println("TextAbrev10 " + textAbrev10);

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
