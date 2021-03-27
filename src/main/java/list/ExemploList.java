package list;

import java.util.*;

public class ExemploList {
    public static <Interator> void main(String[] args) {
        List<String> nomes = new ArrayList<>();

        nomes.add("Carlos");
        nomes.add("Pedro");
        nomes.add("Maria");
        nomes.add("João");

        System.out.println(nomes.get(2));

        Collections.sort(nomes);

        System.out.println(nomes);
        nomes.set(2 , "Marinas");
        System.out.println(nomes);
        System.out.println(nomes.size());

        System.out.println(nomes.contains("Pedro"));

        for (String nome: nomes
             ) {
            System.out.println("--" + nome);
        }

        Iterator<String> iterator = nomes.iterator();
        while(iterator.hasNext()){
            System.out.println("----" + iterator.next());
        }
        nomes.addAll(nomes);
        nomes.indexOf("java");
        System.out.println(nomes.indexOf("java"));
    }
}
