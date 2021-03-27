package desafiosBootCampJava;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;
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

            while (st.hasMoreTokens()) {
                textPost.add(st.nextToken());
            }

            if (textPost.size() <= 0 || textPost.isEmpty())
                continue;
            if (textPost.get(0).equals("."))
                break;

            textAbrev.putAll(textPost.stream().filter(s -> (s.length() > 2 && !s.matches(".")))
                    .collect(Collectors.groupingBy(o -> o.substring(0, 1))));

            textAbrev.forEach((s, strings) -> textabrev2
                    .add(strings.stream().reduce((s1, s2) -> s1.length() > s2.length() ? s1 : s2)));
            List<String> listWithoutNull = textabrev2.stream().flatMap(Optional::stream).collect(Collectors.toList());

            AtomicInteger finalCountAbrev = new AtomicInteger();
            Optional<String> finals = textPost.stream().map(s -> {
                if (listWithoutNull.contains(s)) {
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
            listWithoutNull.forEach(s -> System.out.println(s.substring(0, 1).concat(". = ").concat(s)));

        }

    }

}
