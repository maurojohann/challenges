package stremsAPI;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class ExempleStream {
    public static void main(String[] args) {
        List<String> nomes = new ArrayList<>();

        nomes.add("Mauro");
        nomes.add("Joeli");
        nomes.add("Roque");
        nomes.add("Cecilia");
        nomes.add("Daniane");
        nomes.add("Fernando");

        System.out.println("Contage: " + nomes.stream().count());
        System.out.println("Maior Numero De Letras" + nomes.stream().max(Comparator.comparingInt(String::length)).toString());
        System.out.println("Nomes que contem a letra R " + nomes.stream().filter((nome)->
                nome.toLowerCase().contains("r")).collect(Collectors.toList()));

        System.out.println("Uma nova coleção com a quantidade de letras" + nomes.stream().map(nome -> nome.concat("---").concat(String.valueOf(
                nome.length()))).collect(Collectors.toList()));

        System.out.println("Reorna os tres primeiros items da coleção: " + nomes.stream().limit(3).collect(Collectors.toList()));

        System.out.println("Retornar os elementos: " + nomes.stream().peek(System.out::println).collect(Collectors.toList()));
        System.out.println("Retorna os elementos com ForEach");
        nomes.stream().forEach(System.out::println);

        System.out.println("Retorna True se todos os elementos conter a: " + nomes.stream().allMatch(s -> s.contains("a")) );

        System.out.println("Retorna true se algum elemento com a minusculo no nome: " + nomes.stream().anyMatch(s -> s.contains("a")));

        System.out.print("Retorna o primeiro elemento da coleção: ");
        nomes.stream().findFirst().ifPresent(System.out::println);


    }
}
