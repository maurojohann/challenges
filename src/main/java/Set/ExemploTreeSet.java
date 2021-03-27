package Set;

import java.util.TreeSet;

public class ExemploTreeSet {
    public static void main(String[] args) {
        TreeSet<String> cidades = new TreeSet<>();

        cidades.add("São Paulo");
        cidades.add("Curitiba");
        cidades.add("Florianopolis");
        cidades.add("Rio de Janeiro");
        cidades.add("Belo Horizonte");
        cidades.add("Porto Alegre");

        System.out.println(cidades);
    }
}
