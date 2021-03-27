package comparators;

import java.util.*;

public class ExemploComparators {
    public static void main(String[] args) {

        List<Estudante> estudantes = new ArrayList<>();

        estudantes.add(new Estudante("Pedro", 19));
        estudantes.add(new Estudante("Carlos", 23));
        estudantes.add(new Estudante("Mariana", 21));
        estudantes.add(new Estudante("Joao", 18));
        estudantes.add(new Estudante("Thiago", 20));

        System.out.println("-----Ordem de Inserçao-----");
        System.out.println(estudantes);

        estudantes.sort((o1, o2) -> o2.getIdade() - o1.getIdade());

        System.out.println("Ordem Reversa dos Numeros Idade");
        System.out.println(estudantes);

        estudantes.sort(Comparator.comparingInt(Estudante::getIdade));
        System.out.println("Ordem Comparator ");
        System.out.println(estudantes);

        estudantes.sort(Comparator.comparingInt(Estudante::getIdade ).reversed());
        System.out.println("Ordem Comparator reversed() ");
        System.out.println(estudantes);

        Collections.sort(estudantes);
        System.out.println("Ordem natural Comparable ");
        System.out.println(estudantes);

        Collections.sort(estudantes, new EstudanteOrdeIdadeReversaComparator());
        System.out.println("Ordem natural interface Comparator");
        System.out.println(estudantes);

    }
}
