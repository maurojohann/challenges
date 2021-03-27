package Set;

import java.util.Iterator;
import java.util.LinkedHashSet;

;

public class ExemploLinkedHasSet {
    public static void main(String[] args) {


        LinkedHashSet<Integer> sequenciiaNumerica = new LinkedHashSet<>();

        sequenciiaNumerica.add(1);
        sequenciiaNumerica.add(2);
        sequenciiaNumerica.add(3);
        sequenciiaNumerica.add(4);
        sequenciiaNumerica.add(5);
        sequenciiaNumerica.add(6);
        sequenciiaNumerica.add(7);

        System.out.println(sequenciiaNumerica);

        for (Integer numero: sequenciiaNumerica
             ) {
            System.out.print("--->"+numero);
        }

        Iterator iterator = sequenciiaNumerica.iterator();

        while(iterator.hasNext()){
            System.out.print("-->" + iterator.next());
        }



    }
}
